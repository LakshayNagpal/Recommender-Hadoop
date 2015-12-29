import org.apache.hadoop.fs.Path;
//import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class RecommenderDriver1 {

public static void main(String [] args) throws Exception {
	
if(args.length!=2){
	
	System.err.println("Usage: WordCount <input path> <output path>");
	System.exit(-1);
}

Job job = new Job();
job.setJarByClass(RecommenderDriver1.class);
job.setJobName("Word Count");

FileInputFormat.addInputPath(job, new Path(args[0]));
FileOutputFormat.setOutputPath(job, new Path(args[1]));

job.setMapperClass(RecommenderMap1.class);
job.setReducerClass(RecommenderReducer1.class);

job.setOutputKeyClass(Text.class);
job.setOutputValueClass(Text.class);

System.exit(job.waitForCompletion(true)?0:1);
		}	
	}
