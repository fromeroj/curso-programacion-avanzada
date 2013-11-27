package org.iimas.unam.pa;

import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;


public class PuntosMapper
    extends Mapper<LongWritable, Text, Text, DoubleWritable> {
    protected void map(LongWritable key, Text linea, Context context)
        throws IOException, InterruptedException 
        {
            String[] datos = linea.toString().split (",");
            try{ 
                context.write(new Text (datos[1]),
                              new DoubleWritable(Double.parseDouble(datos[3])));
            }catch(NumberFormatException nfe){
            }
        }
}