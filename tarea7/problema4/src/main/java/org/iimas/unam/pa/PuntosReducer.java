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

public class PuntosReducer
extends Reducer<Text, DoubleWritable, Text, DoubleWritable> {
	@Override
	public void reduce(Text key, Iterable<DoubleWritable> values, Context context)
			throws IOException, InterruptedException 
      {
          double avg = 0;
          double count=0;
          for (DoubleWritable value : values) {
              avg+=value.get();
              count++;
          }
          if(count>0)avg=avg/count;
          context.write(key, new DoubleWritable(avg));
      }
}
