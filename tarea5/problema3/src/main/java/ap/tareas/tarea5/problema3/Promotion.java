package ap.tareas.tarea5.problema3;

import java.util.ArrayList;

public class Promotion extends Item {

	protected ArrayList<Item> subitems;
	
	public Promotion(String name) {
		super(name, 0);
		subitems = new ArrayList<Item>();
	}

	public void addSubitem(Item item) {
		subitems.add(item);
	}
	
	public ArrayList<Item> getSubitems() {
		return subitems;
	}
	
	public float getSubitemsPrice() {
		float t = 0;
		for(Item i : subitems)
			t += i.getPrice();
		return t;
	}
	
	@Override
	public String toString() {
		return getName() + "[" + subitems.size() + "] ($" + getPrice() + ")";
	}
}