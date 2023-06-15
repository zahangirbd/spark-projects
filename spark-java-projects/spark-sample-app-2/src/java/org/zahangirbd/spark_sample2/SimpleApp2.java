package org.zahangirbd.spark_sample2;

/* SimpleApp.java */
import org.apache.spark.sql.SparkSession;
import org.apache.spark.api.java.function.FilterFunction;
import org.apache.spark.sql.Dataset;

public class SimpleApp2 {
  public static void main(String[] args) {
    // String logFile = "YOUR_SPARK_HOME/README.md"; // Should be some file on your system
	String logFile = "D:/installed-software/spark/spark-3.4.0-bin-hadoop3/README.md";
    SparkSession spark = SparkSession
    						.builder()
    						.appName("Simple Application2")
    						.config("spark.master", "local[*]")
    						.getOrCreate();
    Dataset<String> logData = spark.read().textFile(logFile).cache();

    long numAs = logData.filter((FilterFunction<String>) s -> s.contains("a")).count();
    long numBs = logData.filter((FilterFunction<String>) s -> s.contains("b")).count();

    System.out.println("Lines with a: " + numAs + ", lines with b: " + numBs);

    spark.stop();
  }
}