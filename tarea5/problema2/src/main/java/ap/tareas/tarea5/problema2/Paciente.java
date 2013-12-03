package ap.tareas.tarea5.problema2;

public class Paciente {
	public static enum Edad {Joven, PrePresbiopico, Presbiopico};
	public static enum Prescripcion {Miope, Hipermetrope};
	public static enum VelocidadLagrima {Normal, Reducida};
	public static enum Lentes {Ninguno, Soft, Hard};
	
	private Edad edad;
	private Prescripcion prescripcion;
	private VelocidadLagrima velocidad;
	private boolean astigmatismo;
	private Lentes lentes;
	
	public Paciente() {
		super();
		this.edad = Edad.Joven;
		this.prescripcion = Prescripcion.Miope;
		this.velocidad = VelocidadLagrima.Normal;
		this.astigmatismo = false;
		this.lentes = Lentes.Ninguno;
	}
	
	public Paciente(Edad edad, Prescripcion prescripcion, VelocidadLagrima velocidad, boolean astigmatismo) {
		super();
		this.edad = edad;
		this.prescripcion = prescripcion;
		this.velocidad = velocidad;
		this.astigmatismo = astigmatismo;
		this.lentes = Lentes.Ninguno;
	}

	public Edad getEdad() {
		return edad;
	}
	public void setEdad(Edad edad) {
		this.edad = edad;
	}
	public Prescripcion getPrescripcion() {
		return prescripcion;
	}
	public void setPrescripcion(Prescripcion prescripcion) {
		this.prescripcion = prescripcion;
	}
	public VelocidadLagrima getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(VelocidadLagrima velocidad) {
		this.velocidad = velocidad;
	}
	public Lentes getLentes() {
		return lentes;
	}
	public void setLentes(Lentes lentes) {
		this.lentes = lentes;
	}
	public boolean getAstigmatismo() {
		return this.astigmatismo;
	}
	public void setAstigmatismo(boolean astigmatismo) {
		this.astigmatismo = astigmatismo;
	}
	
	@Override
	public String toString() {
		return "Paciente [" + edad + ", " + prescripcion
				+ ", " + velocidad + ", " + astigmatismo
				+ ", " + lentes + "]";
	}
}
