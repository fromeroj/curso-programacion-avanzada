package ap.tareas.tarea5.problema1;

import java.awt.Point;

import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.InstantiateTransformer;

public class Arena {
	
	protected Robot[] robots;
	protected Point dimensiones;
	protected int current_robot = 0;
	
	public Arena(int no_robots, int tam_arena) {
		robots = new Robot[no_robots];
		dimensiones = new Point(tam_arena, tam_arena);
		
		asignaPosicionesIniciales();
	}
	
	protected void asignaPosicionesIniciales() {
		Point[] posiciones = randomArray(dimensiones.x, dimensiones.y);
		for(int i=0; i< robots.length; i++)
			robots[i] = new Robot('r', this, posiciones[i]);
	}
	
	public static Point[] randomArray(int filas, int columnas) {
		int total = filas*columnas;
		Point[] arr = new Point[total];
		
		for(int i = 0, f = 0, c = 0; i < total; i++, c++) {
			arr[i] = new Point(f, c);
			if(c >= columnas) {
				f++;
				c = 0;
			}
		}
		for(int j = 0; j < total; j++) {
			int a = (int)Math.floor(Math.random()*total), b = (int)Math.floor(Math.random()*total);
			Point t = arr[a];
			arr[a] = arr[b];
			arr[b] = t;
		}
		return arr;
	}
	
	protected boolean robotEnCoordenada(int x, int y) {
		for(Robot bot : robots) {
			if(bot.getPosicion().x == x && bot.getPosicion().y == y)
				return true;
		}
		return false;
	}
	
	protected boolean coordenadaEnArena(int x, int y) {
		return x >= 0 && x < this.dimensiones.x && y >= 0 && y < this.dimensiones.y;
	}
	
	protected boolean robotsActivos() {
		for(int i=0; i<robots.length; i++)
			if(robots[i].estaActivo())
				return true;
		return false;
	}
	
	protected boolean robotEnFinal(Robot r) {
		return r.getPosicion().y == 0;
	}
	
	public boolean obstaculoEnCoordenada(int x, int y) {
		return robotEnCoordenada(x, y) || !coordenadaEnArena(x, y);
	}
	
	public void run() {
		RobotTransformer transformer = new RobotTransformer(this);
		
		while(robotsActivos()) {
			for(int i=0;  i<robots.length; i++) {
				Robot r = robots[i];
				r.mueveAleatorio();
				if(robotEnFinal(r)) {
					r.desactiva();
					robots[i] = (Robot)transformer.transform(r);
				}
			}
		}
	}
	
	public void step() {
		for(Robot r : robots) {
			r.mueveAleatorio();
		}
	}
	
	public void robotStep() {
		robots[current_robot].mueveAleatorio();
		current_robot = current_robot + 1 < robots.length ? current_robot + 1 : 0;
	}
	
	public String toString() {
		String arena = "";
		
		for (int j=0; j<dimensiones.y + 2; j++) {
			for (int i=0; i<dimensiones.x + 2; i++) {
				if(i == 0 || i == dimensiones.x + 1)
					arena += "|";
				else if(j == 0 || j == dimensiones.y + 1)
					arena += "-";
				else if(robotEnCoordenada(i-1, j-1))
					arena += "r";
				else
					arena += " ";
			}
			arena += "\n";
		}
		
		return arena;
	}
	
	// 
	
	class RobotTransformer implements Transformer {

		Arena a;
		
		public RobotTransformer(Arena a) {
			this.a = a;
		}
		
		public Object transform(Object arg0) {
			Robot r = (Robot)arg0;
			return new RobotEstatico(a, r.getPosicion());
		}
	
	}
}
