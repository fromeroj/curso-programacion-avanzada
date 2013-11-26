package org.iimas.unam.pa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
extends TestCase
{
	MapDriver<LongWritable, Text, Text, Text> mapDriver;
	ReduceDriver<Text, Text, Text, Text> reduceDriver;
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public AppTest( String testName )
	{
		super( testName );
		FrecMapper mapper  = new FrecMapper();
		mapDriver = MapDriver.newMapDriver(mapper);

		FrecReducer reducer = new FrecReducer();
		reduceDriver = ReduceDriver.newReduceDriver(reducer);
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

	public void testMapper() throws IOException, InterruptedException {
		long llave = 1;
		double valor = 2.13;
		Text texto = new Text("uno");
		mapDriver.withInput(new LongWritable(llave), texto);
		mapDriver.withOutput(new Text("uno"), new Text("uno"));
		mapDriver.runTest();
	}


	public void testReducer () throws IOException,
	InterruptedException {
		Text llave = new Text("uno");
		List<Text> values = new ArrayList<Text>();
		values.add(new Text("uno"));
		values.add(new Text("uno"));
		values.add(new Text("uno"));
		// max Temperatura
		reduceDriver.withInput(llave, values);
		reduceDriver.withOutput(llave, new Text("3"));
		reduceDriver.runTest();
	}

	public void testConf () throws Exception {
		Configuration conf = new Configuration();
		conf.set("fs.default.name", "file:///");
		conf.set("mapred.job.tracker", "local");
		Path input = new Path("./datos_texto.csv");
		Path output = new Path("salida");

		FileSystem fs = FileSystem.getLocal(conf);
		fs.delete(output, true); // borra el directorio de salida

		Problema3 driver = new Problema3();
		driver.setConf(conf);
		int exitCode = driver.run(new String[] {
				input.toString(), output.toString() });
		assertEquals(exitCode, 0);
	}
}
