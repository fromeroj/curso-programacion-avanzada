package org.iimas.unam.pa;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Iterator;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.*;

import com.google.common.base.Joiner;

public class FrecReducer
extends Reducer<Text, Text, Text, Text> {
	@Override
	public void reduce(Text key, Iterable<Text> values, Context context)
			throws IOException, InterruptedException 
      {
          System.out.println(values.getClass());
          int c=0;
          Iterator itr=values.iterator();
          while(itr.hasNext()){
              c++;
              itr.next();
          }
          context.write(key, new Text(Integer.toString(c)));
      }
}
