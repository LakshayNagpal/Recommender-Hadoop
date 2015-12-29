//Learning MapReduce

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class RecommenderReducer 
extends Reducer<Text, IntWritable, Text, IntWritable> {
	
@Override
public void reduce(Text Key, Iterable<IntWritable>values, Context context)
throws IOException, InterruptedException {
	
	int sum = 0;
	int flag=-1;
	int sum1=0;
	for(IntWritable value:values){
		sum1=value.get(); 
	    if(sum1==-1)
	    {
	    	flag=1;
	    	break;
	    }
	    sum+=sum1;
	}
	if(flag==-1)
	context.write(Key, new IntWritable(sum));
	 
		}
	
}
