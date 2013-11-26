package org.iimas.unam.pa;

import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;

public class FrecMapper
    extends Mapper<LongWritable, Text, Text, Text> {
    protected void map(LongWritable key, Text linea, Context context)
        throws IOException, InterruptedException 
        {
            String[] datos = linea.toString().split (",");
            for(int i=0;i<datos.length;i++){
                context.write(new Text (datos[i]),
                              new Text (datos[i]));
            }
        }
}
