package ap.tareas.tarea5.problema3;

public class PromocionMasXMenos extends Promotion {

	private Class<?> tipo;
	private int mas;
	private int menos;
	
	public PromocionMasXMenos(Class<?> tipo, int mas, int menos) {
		super("PromocionMasXMenos");
		this.tipo = tipo;
		this.mas = mas;
		this.menos = menos;
	}
	
	public Class<?> getTipo() {
		return tipo;
	}

	public void setTipo(Class<?> tipo) {
		this.tipo = tipo;
	}

	public int getMas() {
		return mas;
	}

	public void setMas(int mas) {
		this.mas = mas;
	}

	public int getMenos() {
		return menos;
	}

	public void setMenos(int menos) {
		this.menos = menos;
	}
	
	@Override
	public String toString() {
		return "Promocion " + mas + " x " + menos + " en " + tipo.getSimpleName() + "[" + this.subitems.size() + "]($" + getPrice() + ")";
	}
}
