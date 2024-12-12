package org.zahangirbd.spark_sample2;

/* SimpleApp.java */
import org.apache.spark.sql.SparkSession;
import org.apache.spark.api.java.function.FilterFunction;
import org.apache.spark.sql.Dataset;

public class SimpleApp2 {
  public static void main(String[] args) {
    // String logFile = "YOUR_SPARK_HOME/README.md"; // Should be some file on your system
	String logFile = "D:/installed-software/spark/spark-3.4.0-bin-hadoop3/README.md";
	
	// setting master, spark master are created as stand alone mode 
	// and then computing task is submitted there
    SparkSession spark = SparkSession
    						.builder()
    						.appName("Simple Java Application-2")
    						.master("local[*]")
    						// .config("spark.master", "local[*]") // it is an alternative of .master()
    						.getOrCreate();
  
    /*
	// the following code is used while we submit the job using spark-submit command
	// spark-submit --class "org.zahangirbd.spark_sample1.SimpleApp2" --master spark://172.27.160.1:7077 spark-sample-app-2.jars
	SparkSession spark = SparkSession
			.builder()
			.appName("Simple Java Application-2")
			.getOrCreate();
 	*/
    Dataset<String> logData = spark.read().textFile(logFile).cache();

    long numAs = logData.filter((FilterFunction<String>) s -> s.contains("a")).count();
    long numBs = logData.filter((FilterFunction<String>) s -> s.contains("b")).count();

    System.out.println("Lines with a: " + numAs + ", lines with b: " + numBs);

    spark.stop();
  }
}