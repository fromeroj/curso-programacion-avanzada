package ap.tareas.tarea5.problema2;

import org.apache.commons.collections.Closure;
import org.apache.commons.collections.functors.InstanceofPredicate;

public class SetLentesClosure implements Closure {

	private Paciente.Lentes lentes = Paciente.Lentes.Ninguno;
	private InstanceofPredicate esPaciente = new InstanceofPredicate(Paciente.class);
	
	public SetLentesClosure(Paciente.Lentes lentes) {
		this.lentes = lentes;
	}
	
	public void execute(Object arg0) {
		if(esPaciente.evaluate(arg0)) {
			((Paciente)arg0).setLentes(lentes);
		}
	}
}
