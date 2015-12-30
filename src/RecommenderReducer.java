//Learning MapReduce

import java.io.IOException;
//import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class RecommenderReducer 
extends Reducer<Text, IntWritable, Text, IntWritable> {
	
//private Text word = new Text();
	
@Override
public void reduce(Text Key, Iterable<IntWritable>values, Context context)
throws IOException, InterruptedException {
	
	int sum=0;
	boolean flag=false;
	int sum1=0;
	
	for(IntWritable value:values){
		sum1=value.get(); 
	    if(sum1==-1)
	    {
	    	flag=true;
	    	break;
	    }
	    sum+=sum1;
	}
	if(flag==false){
		String line = Key.toString();
		
		String b = line.substring(0, line.length()-1);
		String b1 = line.substring(1, line.length());
		String key1 = b + " has mutual friend " + b1;
		Text finalkey = new Text(key1);
		IntWritable sumi = new IntWritable(sum);
		context.write(finalkey, sumi);
		}
	}
	
}
