package ap.tareas.tarea5.problema2;

import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.functors.InstanceofPredicate;

public class LentesHard implements Predicate {

	private InstanceofPredicate esPaciente = new InstanceofPredicate(Paciente.class);
	
	public boolean evaluate(Object arg0) {
		if(esPaciente.evaluate(arg0)) {
			Paciente p = ((Paciente)arg0);
			if(p.getVelocidad() == Paciente.VelocidadLagrima.Normal && 
					p.getAstigmatismo() &&
					(p.getEdad() == Paciente.Edad.Joven || p.getPrescripcion() == Paciente.Prescripcion.Miope))
				return true;
		}
		return false;
	}
}
