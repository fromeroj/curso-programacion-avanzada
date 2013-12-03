package ap.tareas.tarea5.problema3;

import java.util.ArrayList;

import org.apache.commons.collections.Closure;
import org.apache.commons.collections.Predicate;

public class PromocionDescuentoClosure implements Closure {

	private int minimo;
	private float descuento;
	private Predicate detector;
	private int contador = 0;
	private ArrayList<Entry> temporal = new ArrayList<Entry>();
	private ArrayList<Entry> resultantes = new ArrayList<Entry>();
	private ArrayList<Entry> eliminados = new ArrayList<Entry>();
	private String nombre;
	private Promotion promocion;
	
	public PromocionDescuentoClosure(int minimo, float descuento, String nombre, Predicate detector) {
		this.minimo = minimo;
		this.descuento = descuento;
		this.detector = detector;
		this.nombre = nombre;
	}
	
	public ArrayList<Entry> getEliminados() {
		return eliminados;
	}
	
	public ArrayList<Entry> getResultantes() {
		return resultantes;
	}
	
	public void execute(Object arg0) {
		if(arg0 instanceof Entry && detector.evaluate(arg0)) {
			Entry entrada = (Entry)arg0;
			contador++;
			if(contador >= minimo) {
				if(contador == minimo) {
					promocion = new Promotion(nombre);
					for(Entry e : temporal) {
						e.getItem().setPrice(e.getItem().getPrice() * descuento);
						promocion.addSubitem(e.getItem());
					}
					resultantes.add(new Entry(promocion, entrada.getDate()));
					eliminados.addAll(temporal);
					temporal.clear();
				}
				entrada.getItem().setPrice(entrada.getItem().getPrice() * descuento);
				promocion.addSubitem(entrada.item);
				promocion.setPrice(promocion.getSubitemsPrice());
				eliminados.add(entrada);
			} else {
				temporal.add((Entry)arg0);
			}
		}
	}
}