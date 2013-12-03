package ap.tareas.tarea5.problema3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.collections.Closure;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.comparators.ComparableComparator;
import org.apache.commons.collections.functors.EqualPredicate;
import org.apache.commons.collections.functors.IfClosure;
import org.apache.commons.collections.functors.InstanceofPredicate;
import org.apache.commons.collections.functors.OrPredicate;

public class Register {
	private ArrayList<Entry> items;
	private ArrayList<Entry> totales;
	private float tot;
	
	// Promociones
	
	PromocionMasXMenosClosure juevesDeLacteosClosure = new PromocionMasXMenosClosure(3, 2, new JuevesDeLacteosPredicate(), Milk.class);
	PromocionMasXMenosClosure yogurPiniaClosure = new PromocionMasXMenosClosure(5, 3, new YogurPiniaPredicate(), Yogur.class);
	PromocionDescuentoClosure descuentoLecheroClosure = new PromocionDescuentoClosure(11, (float) 0.75, "Descuento Lechero", new DescuentoLechePredicate());
	PromocionDescuentoClosure superDescuentoLecheroClosure = new PromocionDescuentoClosure(21, (float) 0.61, "Super Descuento Lechero", new DescuentoLechePredicate());
	PromocionPaqueteClosure yogurPaqueteClosure = new PromocionPaqueteClosure(4, (float)2.5, new EntryInstancePredicate(Yogur.class), "Paquete Yogur", Yogur.class);
	
	// Clases internas
	
	class EntryInstancePredicate implements Predicate {
		private InstanceofPredicate parentPredicate;
		private InstanceofPredicate entryInstancePredicate;
		
		EntryInstancePredicate(Class<?> clase){
			super();
			parentPredicate = new InstanceofPredicate(clase);
			entryInstancePredicate = new InstanceofPredicate(Entry.class);
		}
		
		public boolean evaluate(Object arg0) {
			if(entryInstancePredicate.evaluate(arg0)) {
				return parentPredicate.evaluate(((Entry)arg0).getItem());
			} else {
				return parentPredicate.evaluate(arg0);
			}
		}
	}
	
	class DescuentoLechePredicate implements Predicate {
		private InstanceofPredicate entryInstancePredicate = new InstanceofPredicate(Entry.class);
		private InstanceofPredicate lechePredicate = new InstanceofPredicate(Milk.class);
		private InstanceofPredicate promocionPredicate = new InstanceofPredicate(PromocionMasXMenos.class);
		private OrPredicate rule = new OrPredicate(lechePredicate, promocionPredicate);

		public boolean evaluate(Object arg0) {
			if(entryInstancePredicate.evaluate(arg0)) {
				Item i = ((Entry)arg0).item;
				if(lechePredicate.evaluate(i))
					return true;
				if(promocionPredicate.evaluate(i))
					return ((PromocionMasXMenos)i).getTipo() == Milk.class;
				return false;
			} else {
				return rule.evaluate(arg0);
			}
		}
	}
	
	class JuevesDeLacteosPredicate extends EntryInstancePredicate {
		private EqualPredicate juevesPredicate = new EqualPredicate(GregorianCalendar.THURSDAY);
		
		JuevesDeLacteosPredicate() {
			super(Milk.class);
		}

		@Override
		public boolean evaluate(Object arg0) {
			if(super.evaluate(arg0) && juevesPredicate.evaluate(((Entry)arg0).getDate().get(GregorianCalendar.DAY_OF_WEEK))) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	class YogurPiniaPredicate extends EntryInstancePredicate {
		private EqualPredicate mangoPredicate = new EqualPredicate(Yogur.FLAVOR_YOGUR_PINEAPPLE);
		
		YogurPiniaPredicate() {
			super(Yogur.class);
		}
		
		@Override
		public boolean evaluate(Object arg0) {
			if(super.evaluate(arg0) && mangoPredicate.evaluate(((Yogur)((Entry)arg0).getItem()).getFlavor()))
				return true;
			else
				return false;
		}
	}
	
	// -----
	
	public Register() {
		super();
		items = new ArrayList<Entry>();
		totales = new ArrayList<Entry>();
		
	}
	
	public void agrega_item(Item item, Date fecha) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(fecha);
		items.add(new Entry(item, cal));
	}
	
	public float total() {
		// Jueves De Lacteos
		
		CollectionUtils.forAllDo(items, juevesDeLacteosClosure);
		
		items.removeAll(juevesDeLacteosClosure.getEliminados());
		
		items.addAll(juevesDeLacteosClosure.getResultantes());
		
		// Descuento Lechero y Super Descuento Lechero
		
		int items_promocion = CollectionUtils.countMatches(items, new DescuentoLechePredicate());
		
		if(items_promocion > 10 && items_promocion <= 20) {
			System.out.println("Descuento lechero pendiente");
			CollectionUtils.forAllDo(items, descuentoLecheroClosure);
		} else if(items_promocion > 20 ) {
			System.out.println("Super descuento lechero pendiente");
			CollectionUtils.forAllDo(items, superDescuentoLecheroClosure);
		}
		
		// Yogur Piña
		
		CollectionUtils.forAllDo(items, yogurPiniaClosure);
		
		items.removeAll(yogurPiniaClosure.getEliminados());
		items.addAll(yogurPiniaClosure.getResultantes());
		
		// Promocion Yogur
		
		CollectionUtils.forAllDo(items, yogurPaqueteClosure);
		
		items.removeAll(yogurPaqueteClosure.getEliminados());
		items.addAll(yogurPaqueteClosure.getResultantes());
		
		// Totalizacion
		
		for(Object e : items) {
			tot += ((Entry)e).getItem().getPrice();
		}
		
		return tot;
	}
	
	@Override
	public String toString() {
		String r = "Cuenta:\n";
		
		for(Object e : items) {
			r += ((Entry)e).toString() + "\n";
		}
		
		r += "Total: " + tot;
		
		return r;
	}
}