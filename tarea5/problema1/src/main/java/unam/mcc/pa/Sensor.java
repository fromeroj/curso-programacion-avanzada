package ap.tareas.tarea5.problema1;

import java.awt.Point;


public class Sensor {
	private Robot robot;
	private float distance = 9999;
	private Arena mundo;
	private Point delta;
	
	public Sensor(Robot robot, Arena mundo, int dx, int dy) {
		this.robot = robot;
		this.distance = 9999;
		this.mundo = mundo;
		this.delta = new Point(dx, dy);
	}

	public float getDistance() {
		return this.distance;
	}
	
	public void setDistance(float distance) {
		this.distance  = distance;
	}
	
	public boolean isObstacle() {
		Point toCheck = add(robot.getPosicion(), delta);
		return mundo.obstaculoEnCoordenada(toCheck.x, toCheck.y);
	}
	
	public Point add(Point a, Point b) {
		return new Point(a.x + b.x, a.y + b.y);
	}
}