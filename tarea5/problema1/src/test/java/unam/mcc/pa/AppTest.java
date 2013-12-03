package ap.tareas.tarea5.problema1;

import ap.tareas.tarea5.problema1.Arena;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
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
    
    public void testCorridaAleatoria() {
    	Arena a = new Arena(2, 5);
    	
    	System.out.println("Inicio");
    	System.out.println(a.toString());
    	/*for(int i=0; i<10; i++ ) {
    		System.out.println("Step " + i);
        	a.step();
        	System.out.println(a.toString());
    	}*/
    	a.run();
    	System.out.println("Fin");
    	System.out.println(a.toString());
    	
    	assertTrue(true);
    }
}
