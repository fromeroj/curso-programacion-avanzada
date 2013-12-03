package ap.tareas.tarea5.problema3;

public class Yogur extends Item {
	public static final String FLAVOR_YOGUR_NATURAL = "Natural";
	public static final String FLAVOR_YOGUR_PINEAPPLE = "Piña";
	public static final String FLAVOR_YOGUR_STRAWBERRY = "Fresa";
	public static final String FLAVOR_YOGUR_MANGO = "Mango";
	
	private String flavor;
	
	public Yogur() {
		super("Yogur", (float) 3.3);
	}
	
	public Yogur(String flavor) {
		super("Yogur", (float) 3.3);
		this.flavor = flavor;
	}
	
	public String getFlavor() {
		return flavor;
	}
	
	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}
	
	@Override
	public String toString() {
		return getName() + " - " + flavor + " ($" + getPrice() + ")";
	}
}
