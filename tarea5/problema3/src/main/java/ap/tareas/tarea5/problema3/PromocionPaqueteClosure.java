package ap.tareas.tarea5.problema3;

import java.util.ArrayList;

import org.apache.commons.collections.Closure;
import org.apache.commons.collections.Predicate;

public class PromocionPaqueteClosure implements Closure {

	private int paquete;
	private float precio;
	private Predicate detector;
	private int contador = 0;
	private ArrayList<Entry> temporal = new ArrayList<Entry>();
	private ArrayList<Entry> resultantes = new ArrayList<Entry>();
	private ArrayList<Entry> eliminados = new ArrayList<Entry>();
	private String nombre;
	private Promotion promocion;
	private Class<?> tipo;
	
	public PromocionPaqueteClosure(int paquete, float precio, Predicate detector, String nombre, Class<?> tipo) {
		this.paquete = paquete;
		this.precio = precio;
		this.detector = detector;
		this.nombre = nombre;
		this.tipo = tipo;
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
			if(contador == paquete) {
				temporal.add(entrada);
				promocion = new Promotion(nombre);
				for(Entry e : temporal) {
					e.getItem().setPrice(precio);
					promocion.addSubitem(e.getItem());
				}
				promocion.setPrice(promocion.getSubitemsPrice());
				resultantes.add(new Entry(promocion, entrada.getDate()));
				eliminados.addAll(temporal);
				temporal.clear();
				contador = 0;
			} else {
				temporal.add((Entry)arg0);
			}
		}
	}
}
