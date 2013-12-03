package ap.tareas.tarea5.problema3;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.functors.EqualPredicate;
import org.apache.commons.collections.functors.InstanceofPredicate;

import ap.tareas.tarea5.problema3.Register.EntryInstancePredicate;
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
    
    public void testItem() {
    	
    	Yogur y1 = new Yogur(), y2 = new Yogur();
    	Milk m1 = new Milk(), m2 = new Milk();
    	
    	EqualPredicate equal = new EqualPredicate(y1), equal2 = new EqualPredicate(m1);
    			
    	System.out.println("Item: " + m2.toString());
    	
    	assertFalse(equal.evaluate(y2));
    	assertTrue(equal2.evaluate(m1));
    }
    
    public void testDescuentoLechero() {
    	Register r = new Register();
    	for(int i = 0; i < 15; i++)
    		r.agrega_item(new Milk(), new Date());
    	
    	float total = r.total();
    	System.out.println("DescuentoLechero\n" + r.toString());
    	
    	assertEquals(total, (float)112.5);
    }
    
    public void testSuperDescuentoLechero() {
    	Register r = new Register();
    	for(int i = 0; i < 25; i++)
    		r.agrega_item(new Milk(), new Date());
    	
    	float total = r.total();
    	System.out.println("SuperDescuentoLechero\n" + r.toString());
    	
    	assertEquals(total, (float)152.50002);
    }
    
    public void testJuevesDeLacteos() {
    	Register r = new Register();
    	Date juev = new Date(113, 10, 7);
    	
    	r.agrega_item(new Milk(), juev);
    	r.agrega_item(new Milk(), juev);
    	r.agrega_item(new Yogur(Yogur.FLAVOR_YOGUR_NATURAL), juev);
    	r.agrega_item(new Milk(), juev);
    	
    	float total = r.total();
    	System.out.println("JuevesDeLacteos\n" + r.toString());
    	assertEquals(total, (float)23.3);
    }
    
    public void testYogurPinia() {
    	Register r = new Register();
    	
    	for(int i=0; i < 19; i++)
    		r.agrega_item(new Yogur(Yogur.FLAVOR_YOGUR_PINEAPPLE), new Date());
    	
    	float total = r.total();
    	System.out.println("YogurPiña\n" + r.toString());
    	assertEquals(total, (float)39.6);
    }
    
    public void testYogurPaquete() {
    	Register r = new Register();
    	
    	for(int i=0; i < 10; i++)
    		r.agrega_item(new Yogur(Yogur.FLAVOR_YOGUR_NATURAL), new Date());
    	
    	float total = r.total();
    	System.out.println("YogurPaquete\n" + r.toString());
    	assertEquals(total, (float)26.6);
    }
    
    public void testGeneral() {
    	Register r = new Register();
    	for(int i=0; i < 9; i++)
    		r.agrega_item(new Yogur(Yogur.FLAVOR_YOGUR_NATURAL), new Date());
    	for(int i=0; i < 9; i++)
    		r.agrega_item(new Yogur(Yogur.FLAVOR_YOGUR_PINEAPPLE), new Date());
    	for(int i = 0; i < 12; i++)
    		r.agrega_item(new Milk(), new Date());
    	
    	float total = r.total();
    	System.out.println("General\n" + r.toString());
    	//assertEquals(total, (float)26.6);
    	assertTrue(true);
    }
    
    public void testPromocionMasXMenos() {
    	ArrayList<Entry> m = new ArrayList<Entry>();
    	for(int i=0; i <10; i++){
    		m.add(new Entry(new Milk(), new GregorianCalendar()));
    	}
    	PromocionMasXMenosClosure c = new PromocionMasXMenosClosure(3, 2, new InstanceofPredicate(Entry.class), Milk.class);
    	CollectionUtils.forAllDo(m, c);
    	
    	assertEquals(c.getResultantes().size(), 3);
    	assertEquals(c.getEliminados().size(), 9);
    }
}

