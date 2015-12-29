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
	int flag=0;
	String next="";
	String next1="";
	  while(itr.hasMoreTokens())
	  {
		 
		  word.set(itr.nextToken());
		  if(flag==0)
		  { next=word.toString();flag=1;}
		  else
		  {
			  next1=word.toString();
		  }
	            	    
	  }
	 String doit="";
	 doit=doit + next.charAt(0);
	 String doit1 = "";
	 doit1=doit1 + next1.charAt(0);
	 doit1 = doit1 + next.charAt(1);
     
	 Text one1 = new Text(doit);
	 Text one2 = new Text(doit1);
	 
	 context.write(one1,one2);

	}

}