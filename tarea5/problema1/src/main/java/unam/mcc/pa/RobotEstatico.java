package ap.tareas.tarea5.problema1;

import java.awt.Point;

public class RobotEstatico extends Robot {
	
	public RobotEstatico(Arena mundo, Point inicio) {
		super('E', mundo, inicio);
		this.desactiva();
	}
	
	@Override
	public void activa() {
		
	}
	
	@Override
	public void mueveAleatorio() {
		
	}

}
