package org.iimas.unam.pa;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class Problema2 extends Configured implements Tool {

    private int problema2(Path in,Path out) throws Exception{
        Configuration conf = getConf();
        conf.set("mapred.textoutputformat.separator", ",");
        Job job = new Job(conf, "Problema2");
        job.setJarByClass(Problema2.class);
        FileInputFormat.setInputPaths(job, in);
        FileOutputFormat.setOutputPath(job, out);
        job.setMapperClass(IdMapper.class);
        job.setReducerClass(IdReducer.class);
        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(DoubleWritable.class);
        return job.waitForCompletion(true)?0:1;
    }
    
	@Override
	public int run(String[] args) throws Exception {
      return problema2(new Path(args[args.length - 2]),new Path(args[args.length - 1]));
	}

	public static void main(String[] args) throws Exception {
		long tIni = System.currentTimeMillis ();
		int res = ToolRunner.run(new Configuration(), new Problema2(), args);
		System.exit(res);
		long tFin = System.currentTimeMillis ();
		System.out.println ("Tiempo inicial = " + tIni);
		System.out.println ("Tiempo final = " + tFin);
		System.out.println ("Tiempo transcurrido = " + (tFin*1.0 - tIni)/1000.0);
	}
}
