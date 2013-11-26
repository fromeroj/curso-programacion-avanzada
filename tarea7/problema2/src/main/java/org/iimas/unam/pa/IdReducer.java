package org.iimas.unam.pa;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.*;

import com.google.common.base.Joiner;

public class IdReducer
extends Reducer<Text, DoubleWritable, Text, Text> {
	@Override
	public void reduce(Text key, Iterable<DoubleWritable> values, Context context)
			throws IOException, InterruptedException 
      {
          context.write(key, new Text(Joiner.on(",").join(values)));
      }
}
