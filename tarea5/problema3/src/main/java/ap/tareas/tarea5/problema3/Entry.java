package ap.tareas.tarea5.problema3;

import java.util.GregorianCalendar;

public class Entry {
	Item item;
	GregorianCalendar date;
	
	public Entry(Item item, GregorianCalendar date) {
		this.item = item;
		this.date = date;
	}
	
	public Item getItem() { return this.item; }
	public GregorianCalendar getDate() { return this.date; }
	
	@Override
	public String toString(){
		return item.toString() + " --- " + date.get(GregorianCalendar.YEAR) + " / " + date.get(GregorianCalendar.MONTH) +" / " + date.get(GregorianCalendar.DAY_OF_MONTH);
	}
}