package ap.tareas.tarea5.problema2;

import java.util.ArrayList;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.functors.IfClosure;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	protected ArrayList<Paciente> pacientes;
	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    public void testSoft() {
    	SetLentesClosure lentesSoftClosure = new SetLentesClosure(Paciente.Lentes.Soft);
    	LentesSoft lentesSoftPredicate = new LentesSoft();
    	IfClosure condicion = new IfClosure(lentesSoftPredicate, lentesSoftClosure);
    	CollectionUtils.forAllDo(pacientes, condicion);
    	
    	System.out.println("--Soft--");
    	for(Paciente p : pacientes)
    		System.out.println(p);
    	assertTrue(true);
    }
    
    public void testHard() {
    	SetLentesClosure lentesHardClosure = new SetLentesClosure(Paciente.Lentes.Hard);
    	LentesHard lentesHardPredicate = new LentesHard();
    	IfClosure condicion = new IfClosure(lentesHardPredicate, lentesHardClosure);
    	CollectionUtils.forAllDo(pacientes, condicion);
    	
    	System.out.println("--Hard--");
    	for(Paciente p : pacientes)
    		System.out.println(p);
    	assertTrue(true);
    }
    
    public void testGlobal() {
    	SetLentesClosure lentesHardClosure = new SetLentesClosure(Paciente.Lentes.Hard);
    	SetLentesClosure lentesSoftClosure = new SetLentesClosure(Paciente.Lentes.Soft);
    	
    	LentesHard lentesHardPredicate = new LentesHard();
    	LentesSoft lentesSoftPredicate = new LentesSoft();
    	
    	IfClosure condicionHard = new IfClosure(lentesHardPredicate, lentesHardClosure);
    	IfClosure condicionSoft = new IfClosure(lentesSoftPredicate, lentesSoftClosure);
    	
    	CollectionUtils.forAllDo(pacientes, condicionHard);
    	CollectionUtils.forAllDo(pacientes, condicionSoft);
    	
    	System.out.println("--Global--");
    	for(Paciente p : pacientes)
    		System.out.println(p);
    	
    	assertTrue(true);
    }
    
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		pacientes = new ArrayList<Paciente>();
		
		pacientes.add(new Paciente(Paciente.Edad.Joven, Paciente.Prescripcion.Miope, Paciente.VelocidadLagrima.Reducida, false));
		pacientes.add(new Paciente(Paciente.Edad.Joven, Paciente.Prescripcion.Miope, Paciente.VelocidadLagrima.Normal, false));
		pacientes.add(new Paciente(Paciente.Edad.Joven, Paciente.Prescripcion.Miope, Paciente.VelocidadLagrima.Reducida, true));
		pacientes.add(new Paciente(Paciente.Edad.Joven, Paciente.Prescripcion.Miope, Paciente.VelocidadLagrima.Normal, true));
		pacientes.add(new Paciente(Paciente.Edad.Joven, Paciente.Prescripcion.Hipermetrope, Paciente.VelocidadLagrima.Reducida, false));
		pacientes.add(new Paciente(Paciente.Edad.Joven, Paciente.Prescripcion.Hipermetrope, Paciente.VelocidadLagrima.Normal, false));
		pacientes.add(new Paciente(Paciente.Edad.Joven, Paciente.Prescripcion.Hipermetrope, Paciente.VelocidadLagrima.Reducida, true));
		pacientes.add(new Paciente(Paciente.Edad.Joven, Paciente.Prescripcion.Hipermetrope, Paciente.VelocidadLagrima.Normal, true));
		pacientes.add(new Paciente(Paciente.Edad.PrePresbiopico, Paciente.Prescripcion.Miope, Paciente.VelocidadLagrima.Reducida, false));
		pacientes.add(new Paciente(Paciente.Edad.PrePresbiopico, Paciente.Prescripcion.Miope, Paciente.VelocidadLagrima.Normal, false));
		pacientes.add(new Paciente(Paciente.Edad.PrePresbiopico, Paciente.Prescripcion.Miope, Paciente.VelocidadLagrima.Reducida, true));
		pacientes.add(new Paciente(Paciente.Edad.PrePresbiopico, Paciente.Prescripcion.Miope, Paciente.VelocidadLagrima.Normal, true));
		pacientes.add(new Paciente(Paciente.Edad.PrePresbiopico, Paciente.Prescripcion.Hipermetrope, Paciente.VelocidadLagrima.Reducida, false));
		pacientes.add(new Paciente(Paciente.Edad.PrePresbiopico, Paciente.Prescripcion.Hipermetrope, Paciente.VelocidadLagrima.Normal, false));
		pacientes.add(new Paciente(Paciente.Edad.PrePresbiopico, Paciente.Prescripcion.Hipermetrope, Paciente.VelocidadLagrima.Reducida, true));
		pacientes.add(new Paciente(Paciente.Edad.PrePresbiopico, Paciente.Prescripcion.Hipermetrope, Paciente.VelocidadLagrima.Normal, true));
		pacientes.add(new Paciente(Paciente.Edad.Presbiopico, Paciente.Prescripcion.Miope, Paciente.VelocidadLagrima.Reducida, false));
		pacientes.add(new Paciente(Paciente.Edad.Presbiopico, Paciente.Prescripcion.Miope, Paciente.VelocidadLagrima.Normal, false));
		pacientes.add(new Paciente(Paciente.Edad.Presbiopico, Paciente.Prescripcion.Miope, Paciente.VelocidadLagrima.Reducida, true));
		pacientes.add(new Paciente(Paciente.Edad.Presbiopico, Paciente.Prescripcion.Miope, Paciente.VelocidadLagrima.Normal, true));
		pacientes.add(new Paciente(Paciente.Edad.Presbiopico, Paciente.Prescripcion.Hipermetrope, Paciente.VelocidadLagrima.Reducida, false));
		pacientes.add(new Paciente(Paciente.Edad.Presbiopico, Paciente.Prescripcion.Hipermetrope, Paciente.VelocidadLagrima.Normal, false));
		pacientes.add(new Paciente(Paciente.Edad.Presbiopico, Paciente.Prescripcion.Hipermetrope, Paciente.VelocidadLagrima.Reducida, true));
		pacientes.add(new Paciente(Paciente.Edad.Presbiopico, Paciente.Prescripcion.Hipermetrope, Paciente.VelocidadLagrima.Normal, true));
	}
}
