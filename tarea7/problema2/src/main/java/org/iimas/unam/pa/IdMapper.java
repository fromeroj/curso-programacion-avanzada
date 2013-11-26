package org.iimas.unam.pa;

import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;

public class IdMapper
    extends Mapper<LongWritable, Text, Text, DoubleWritable> {
    protected void map(LongWritable key, Text linea, Context context)
        throws IOException, InterruptedException 
        {
            String[] datos = linea.toString().split (",");
            try{
                double x=Double.parseDouble(datos[1]);     
                context.write(new Text (datos[0]),
                              new DoubleWritable(x));
            }catch(NumberFormatException nfe){
            }
        }
}
