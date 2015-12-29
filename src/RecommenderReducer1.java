//Learning MapReduce

import java.io.IOException;

//import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class RecommenderReducer1 
extends Reducer<Text, Text , Text, Text> {
	
@Override
public void reduce(Text Key, Iterable<Text>values, Context context)
throws IOException, InterruptedException {
	
	String arr[] = new String[50];
	String arr1 [] = new String [50];
	String arr2 [] = new String [50];
	String final1="";
    
	 int size=0;
	for(Text value:values){
		String h1 = value.toString(); 
	    arr[size++]= h1;
	}
	
	for(int i=0;i<size;i++)
	{
		int l1 = arr[i].length();
		// 
		arr1[i]="";
		arr1[i] = arr[i].substring(0,l1-1);
		arr2[i]="";
	    arr2[i] = arr2[i] + arr[i].charAt(1);
	}
	
	for(int i=0;i<size-1;i++)
	{
		
		for(int j=0;j<size-i-1;j++)
		{
			String h2 = "";
			h2=h2 + arr1[j];
			String h1 = "";
			 h1 = h1 + arr1[j+1];
			int foo = Integer.parseInt(h2);
			int foo1 = Integer.parseInt(h1);
			if(foo < foo1)
			{
		     	String temp="";
		     	temp=arr1[j];
		     	arr1[j]=arr1[j+1];
		     	arr1[j+1]=temp;
		     	temp="";
		     	temp=arr2[j];
		     	arr2[j]=arr2[j+1];
		     	arr2[j+1]=temp;
			}
		}
		
	}
	
	String g1="";
	for(int i=0;i<Math.min(10,size);i++)
	{
	    g1 = arr2[i];
		
		final1 = final1 + " " + g1 ;
	}
	
	Text doit = new Text(final1);
	context.write(Key,doit);
	 
		}
	
}
