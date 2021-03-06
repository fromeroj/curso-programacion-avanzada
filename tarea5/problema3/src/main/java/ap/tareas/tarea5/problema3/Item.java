package ap.tareas.tarea5.problema3;

public class Item {	
	private String name;
	private float price;

	public Item(String name, float price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return name + " ($" + price + ")";
	}
}
