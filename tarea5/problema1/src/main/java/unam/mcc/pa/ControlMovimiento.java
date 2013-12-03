package ap.tareas.tarea5.problema1;

import org.apache.commons.collections.Closure;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.functors.IfClosure;

import ap.tareas.tarea5.problema1.Robot.Direccion;


public class ControlMovimiento {
	private Sensor[] sensores;
	private Robot robot;
	
	public ControlMovimiento(Robot robot, Arena mundo) {
		// Inicializa sensores
		this.robot = robot;
		this.sensores = new Sensor[4];
		this.sensores[Direccion.Arriba.ordinal()] =  new Sensor(this.robot, mundo, 0, -1);
		this.sensores[Direccion.Abajo.ordinal()] = new Sensor(this.robot, mundo, 0, 1);
		this.sensores[Direccion.Derecha.ordinal()] = new Sensor(this.robot, mundo, 1, 0);
		this.sensores[Direccion.Izquierda.ordinal()] = new Sensor(this.robot, mundo, -1, 0);
	}
	
	public ControlMovimiento() {
		sensores = new Sensor[4];
	}
	
	public void arriba() {
		IfClosure move = new IfClosure(new VerificaSensorPredicate(sensores[Direccion.Arriba.ordinal()]), new TranslateClosure(0, -1));
		move.execute(this.robot);
	}
	
	public void abajo() {
		
		IfClosure move = new IfClosure(new VerificaSensorPredicate(sensores[Direccion.Abajo.ordinal()]), new TranslateClosure(0, 1));
		move.execute(this.robot);
		
		/*if(verificaSensor(Robot.Direccion.Abajo))
			robot.getPosicion().translate(0, 1);*/
	}
	
	public void izquierda() {
		
		IfClosure move = new IfClosure(new VerificaSensorPredicate(sensores[Direccion.Izquierda.ordinal()]), new TranslateClosure(-1, 0));
		move.execute(this.robot);
		
		/*if(verificaSensor(Robot.Direccion.Izquierda))
			robot.getPosicion().translate(-1, 0);*/
	}
	
	public void derecha() {
		
		IfClosure move = new IfClosure(new VerificaSensorPredicate(sensores[Direccion.Derecha.ordinal()]), new TranslateClosure(1, 0));
		move.execute(this.robot);
		
		/*if(verificaSensor(Robot.Direccion.Derecha))
			robot.getPosicion().translate(1, 0);*/
	}
	
	public void setSensor(Robot.Direccion dir, Sensor sensor) {
		sensores[dir.ordinal()] = sensor;
	}
	
	/*
	private boolean verificaSensor(Robot.Direccion dir) {
		return !sensores[dir.ordinal()].isObstacle();
	}*/
	
	// -- Clases Internas
	
	class VerificaSensorPredicate implements Predicate {
		Sensor s;
		public VerificaSensorPredicate(Sensor s) {
			this.s = s;
		}
		
		public boolean evaluate(Object arg0) {
			return !s.isObstacle();
		}
	}
	
	
	class TranslateClosure implements Closure {
		int dx, dy;
		
		public TranslateClosure(int dx, int dy) {
			this.dx = dx;
			this.dy = dy;
		}
		
		public void execute(Object arg0) {
			if(arg0 instanceof Robot) {
				((Robot)arg0).getPosicion().translate(dx, dy);
			}
		}
	}
}
