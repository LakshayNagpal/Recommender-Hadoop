//Learning MapReduce

import java.io.IOException;
import java.util.StringTokenizer;

//import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class RecommenderMap1
extends Mapper<LongWritable, Text, Text, Text> {
	
//private final static IntWritable one = new IntWritable(1);
private Text word = new Text();

@Override
public void map(LongWritable Key, Text value, Context context)
throws IOException, InterruptedException{
	
	
	String line = value.toString();
	StringTokenizer itr = new StringTokenizer(line);
	String array[] = new String[50];
	int size = 0;
	  while(itr.hasMoreTokens()){
		  word.set(itr.nextToken());
		  String next = word.toString();
		  array[size++] = next;
	  	}
	  String out = array[0];
	  String out1 = array[2] + array[1];
	  context.write(new Text(out), new Text(out1));
	}
}
