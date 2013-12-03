package ap.tareas.tarea5.problema1;

import java.awt.Point;

public class Robot {
	public static enum Direccion {Arriba, Derecha, Izquierda, Abajo};
	
	private char id;
	private ControlMovimiento controlMovimiento;
	private Arena mundo;
	private Point posicion;
	private boolean activo = true;
	
	public Robot(char id, Arena mundo, Point inicio) {
		this.id = id;
		this.mundo = mundo;
		this.posicion = inicio;
		
		// Inicializa control de movimiento
		this.controlMovimiento = new ControlMovimiento(this, mundo);
	}
	
	public Point getPosicion() {
		return this.posicion;
	}
	
	public void activa() {
		activo = true;
	}
	
	public void desactiva() {
		activo = false;
	}
	
	public boolean estaActivo() {
		return activo;
	}
	
	public void mueveAleatorio() {
		if(activo)
			mueve(getDireccionAleatoria());
	}
	
	private Robot.Direccion getDireccionAleatoria() {
		int idx = (int)Math.floor(Math.random() * 4);
		return Robot.Direccion.values()[idx];
	}
	
	protected void mueve(Robot.Direccion dir) {
		switch(dir) {
		case Arriba:
			controlMovimiento.arriba();
			break;
		case Abajo:
			controlMovimiento.abajo();
			break;
		case Derecha:
			controlMovimiento.derecha();
			break;
		case Izquierda:
			controlMovimiento.izquierda();
			break;
		}
	}
}
