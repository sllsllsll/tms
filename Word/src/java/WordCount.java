/**
 * Created by linlin on 2017/11/13.
 */

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.mapreduce.lib.partition.HashPartitioner;

public class WordCount {
    static final String INPUT_PATH = "hdfs://master:9000/input/HelloWorld.txt";
    static final String OUTPUT_PATH = "hdfs://master:9000/output4";
    // KEYIN 偏移量 代表读取几个字符 起始位置
    // VALUEIN 文本内容
    // KEYOUT 单词
    // VALUEOUT 出现的次数
    static class MyMapper extends
            //四个泛型
            //No.1 代表行的偏移量   Map 方法执行之前   0行到字符(字节的数量)
            //No.2 行的内容   Hello World
            //No.3 map方法执行结束之后，要转交给Reducer的键值对类型  Hello 1  World 1
            Mapper<LongWritable, Text, Text, LongWritable> {
        @Override
        //Key行的偏移量
        //Value的值  Hello World
        protected void map(LongWritable key, Text value,
                           Mapper<LongWritable, Text, Text, LongWritable>.Context context)
                throws IOException, InterruptedException {
            // 转为String类型
            String str = value.toString();
            // 根据文件内容将字符串拆分为String数组 按空格拆分
            String[] split = str.split(" ");
            for (String string : split) {
				/*
				 * Hello 1
				 * World 1
				 * Me 1
				 * Hello 1
				 */
                context.write(new Text(string), new LongWritable(1));
            }
        }
    }

    // KEYIN 行中单词
    // VALUEIN 行中的单词数量
    // KEYOUT 不同单词
    // VALUEOUT 总次数

    /*
     * Hello 1
     * World 1
     * Me 1
     * Hello 1
     */
    static class MyReducer extends
            Reducer<Text, LongWritable, Text, LongWritable> {
        @Override
        protected void reduce(Text t1, Iterable<LongWritable> arg1,
                              Reducer<Text, LongWritable, Text, LongWritable>.Context ctx)
                throws IOException, InterruptedException {
            long t = 0;
            for (LongWritable longWritable : arg1) {
                t += longWritable.get();
            }
            ctx.write(t1, new LongWritable(t));
        }
    }

    public static void main(String[] args) throws Exception {

        System.setProperty("hadoop.home.dir", "D:\\Code\\BigData\\hadoop\\hadoop-2.8.0");
        Configuration conf = new Configuration();
        final FileSystem fileSystem = FileSystem.get(new URI(INPUT_PATH), conf);
        final Path outPath = new Path(OUTPUT_PATH);
        if(fileSystem.exists(outPath)){
            fileSystem.delete(outPath, true);
        }
        final Job job = new Job(conf , WordCount.class.getSimpleName());
        FileInputFormat.setInputPaths(job, new Path(INPUT_PATH));

        job.setInputFormatClass(TextInputFormat.class);//指定如何对输入文件进行格式化，把输入文件每一行解析成键值对
        job.setMapperClass(MyMapper.class);//1.2 指定自定义的map类
        job.setMapOutputKeyClass(Text.class);//map输出的<k,v>类型。如果<k3,v3>的类型与<k2,v2>类型一致，则可以省略
        job.setMapOutputValueClass(LongWritable.class);

        job.setPartitionerClass(HashPartitioner.class);//1.3 分区
        job.setNumReduceTasks(1);//有一个reduce任务运行
        //1.4 TODO 排序、分组
        //1.5 TODO 规约
        job.setReducerClass(MyReducer.class);//2.2 指定自定义reduce类
        job.setOutputKeyClass(Text.class);//指定reduce的输出类型
        job.setOutputValueClass(LongWritable.class);//2.3 指定写出到哪里
        FileOutputFormat.setOutputPath(job, outPath);//指定输出文件的格式化类

        job.setOutputFormatClass(TextOutputFormat.class);

        job.waitForCompletion(true);//把job提交给JobTracker运行
    }
}
