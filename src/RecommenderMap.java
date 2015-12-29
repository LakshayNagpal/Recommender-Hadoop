//Learning MapReduce

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class RecommenderMap
extends Mapper<LongWritable, Text, Text, IntWritable> {
	
private final static IntWritable one = new IntWritable(1);
private Text word = new Text();

@Override
public void map(LongWritable Key, Text value, Context context)
throws IOException, InterruptedException{
	
	String line = value.toString();
	StringTokenizer itr = new StringTokenizer(line);
	String arr[]=new String[50];
	 int size=0;
	  while(itr.hasMoreTokens()){
		  word.set(itr.nextToken());
		 // context.write(word, one);
		     String next=word.toString();
		    arr[size++]=next;
		  }
	  for(int i=1;i<size;i++)
	  {
		  
		  String h = arr[0];
		  h=h+arr[i];
		  Text doit=new Text(h);
		  IntWritable minusone = new IntWritable(-1);
		  String h1=arr[i];
	
		  h1=h1+arr[0];
		  Text doit2 = new Text(h1);
		context.write(doit,minusone);
		context.write(doit2, minusone);
	  }
	  for(int i=1;i<size;i++)
		  for(int j=i+1;j<size;j++)
		  {
			  
			  String h=arr[i];
			  h=h+arr[j];
			  String h1=arr[j];
			  h1=h1+arr[i];
			  Text doit=new Text(h);
			  Text doit2 = new Text(h1);
		    context.write(doit,one);
		    context.write( doit2 , one);
		  }
		  
		}


}
