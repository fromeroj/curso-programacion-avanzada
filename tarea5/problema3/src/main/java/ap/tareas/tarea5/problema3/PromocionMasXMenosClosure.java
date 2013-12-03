package ap.tareas.tarea5.problema3;

import java.util.ArrayList;
import org.apache.commons.collections.Closure;
import org.apache.commons.collections.Predicate;

import ap.tareas.tarea5.problema3.Entry;

public class PromocionMasXMenosClosure implements Closure {

	private Predicate detector;
	private int menos;
	private int mas;
	private Class<?> tipo;
	
	private int contador;
	
	private ArrayList<Entry> eliminados;
	private ArrayList<Entry> resultantes;
	private ArrayList<Entry> temporal;
	
	private PromocionMasXMenos currentPromocion;
	
	public PromocionMasXMenosClosure(int mas, int menos, Predicate detector, Class<?> tipo) {
		super();
		this.menos = menos;
		this.mas = mas;
		this.detector = detector;
		this.contador = 0;
		this.eliminados = new ArrayList<Entry>();
		this.resultantes = new ArrayList<Entry>();
		this.temporal = new ArrayList<Entry>();
		this.tipo = tipo;
	}
	
	public ArrayList<Entry> getEliminados() {
		return this.eliminados;
	}
	
	public ArrayList<Entry> getResultantes() {
		return this.resultantes;
	}
	
	public void execute(Object element) {
		if(element instanceof Entry) {
			Entry entry = (Entry)element;
			if(detector.evaluate(element)) {
				contador++;
				if(contador == menos) {
					
					//System.out.println("Conta="+ contador + " temp=" + temporal.size());
					
					temporal.add(entry);
					currentPromocion = new PromocionMasXMenos(tipo, mas, menos);
					eliminados.addAll(temporal);
					
					//System.out.println("Elim="+eliminados.size());
					
					for(int i=0; i<temporal.size(); i++) {
						currentPromocion.addSubitem(temporal.get(i).getItem());
					}
					currentPromocion.setPrice(currentPromocion.getSubitemsPrice());
					temporal.clear();
					resultantes.add(new Entry(currentPromocion, entry.date));
					//contador = 0;
				} else if(contador > menos && contador <= mas) {
					if(contador==mas) 
						contador = 0;
					entry.getItem().setPrice(0);
					//System.out.println(currentPromocion + "conta" + contador);
					currentPromocion.addSubitem(entry.getItem());
					currentPromocion.setPrice(currentPromocion.getSubitemsPrice());
					eliminados.add(entry);
				} else {
					temporal.add(entry);
				}
			}
		}
	}

}
