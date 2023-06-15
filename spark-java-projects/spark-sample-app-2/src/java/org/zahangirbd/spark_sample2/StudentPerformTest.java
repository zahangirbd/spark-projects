package org.zahangirbd.spark_sample2;

import java.util.ArrayList;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.sql.*;
import org.apache.spark.sql.types.*;


public class StudentPerformTest {
	
	public static void main(String[] args) {
		SparkConf conf = new SparkConf().setAppName("Student Performance Test").setMaster("local[*]");
		SparkContext sc = new SparkContext(conf);
		SQLContext sqlContext = new SQLContext(sc);
		SparkSession spark = SparkSession.builder().appName("Student Performance Test").getOrCreate();
        
	    List<StructField> fields = new ArrayList<StructField>();
	    fields.add(new StructField("gender", DataTypes.StringType, true, Metadata.empty()));
	    fields.add(new StructField("race", DataTypes.StringType, true, Metadata.empty()));
	    fields.add(new StructField("parentalLevelOfEducation", DataTypes.StringType, true, Metadata.empty()));
	    fields.add(new StructField("lunch", DataTypes.StringType, true, Metadata.empty()));
	    fields.add(new StructField("testPreparationCourse", DataTypes.StringType, true, Metadata.empty()));
	    fields.add(new StructField("mathScore", DataTypes.IntegerType, true, Metadata.empty()));
	    fields.add(new StructField("readingScore", DataTypes.IntegerType, true, Metadata.empty()));
	    fields.add(new StructField("writingScore", DataTypes.IntegerType, true, Metadata.empty()));
	    StructType customizedSchema = new StructType(fields.toArray(new StructField[0]));
	    
	    String pathToFile = "D:/spark-projects/data/StudentsPerformance.csv";
	    
	    // https://github.com/databricks/spark-csv
	    Dataset<Row> df = sqlContext.read()
	    	    .format("com.databricks.spark.csv")
	    	    .schema(customizedSchema)
	    	    .option("header", "true")
	    	    .load(pathToFile);
	    System.out.println("We are starting from here...!");
	    df.rdd().cache();
	    df.registerTempTable("Student");
        sqlContext.sql("SELECT * FROM Student").show();
        sqlContext.sql("SELECT gender, race, parentalLevelOfEducation, mathScore FROM Student WHERE mathScore > 75").show();
        sqlContext.sql("SELECT race, count(race) FROM Student GROUP BY race").show();
        sqlContext.sql("SELECT gender, race, parentalLevelOfEducation, mathScore, readingScore FROM Student").filter("readingScore>90").show();
        sqlContext.sql("SELECT race, parentalLevelOfEducation FROM Student").distinct().show();
        sqlContext.sql("SELECT gender, race, parentalLevelOfEducation, mathScore, readingScore FROM Student WHERE mathScore> 75 and readingScore>90").show();
        // sqlContext.sql("SELECT gender, race, parentalLevelOfEducation, mathScore, readingScore").dropDuplicates().show();
        System.out.println("We have finished here...!");	    
        spark.stop();
	}
}

// Scala code - ref: https://www.edureka.co/blog/spark-java-tutorial/
/*
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql._
import org.apache.spark.sql.types.{StructType, StructField, StringType, IntegerType};
 
object EdurekaApp {
         def main(args: Array[String]) {
              val conf = new SparkConf().setAppName("EdurekaApp3").setMaster("local[*]")
              val sc = new SparkContext(conf)</pre>
 
              val sqlContext = new SQLContext(sc)
              val spark = SparkSession.builder.appName("Simple Application").getOrCreate()
              val customizedSchema = StructType(Array(StructField("gender", StringType, true),StructField("race", StringType, true),StructField("parentalLevelOfEducation", StringType, true),StructField("lunch", StringType, true),StructField("testPreparationCourse", StringType, true),StructField("mathScore", IntegerType, true),StructField("readingScore", IntegerType, true),StructField("writingScore", IntegerType, true)))
              val pathToFile = "C:/Users/Ravikiran/Downloads/students-performance-in-exams/StudentsPerformance.csv"
              val DF = sqlContext.read.format("com.databricks.spark.csv").option("header", "true").schema(customizedSchema).load(pathToFile)
              print("We are starting from here...!")
              DF.rdd.cache()
              DF.rdd.foreach(println)
              println(DF.printSchema)
              DF.registerTempTable("Student")
              sqlContext.sql("SELECT * FROM Student").show()
              sqlContext.sql("SELECT gender, race, parentalLevelOfEducation, mathScore FROM Student WHERE mathScore > 75").show()
              sqlContext.sql("SELECT race, count(race) FROM Student GROUP BY race").show()
              sqlContext.sql("SELECT gender, race, parentalLevelOfEducation, mathScore, readingScore FROM Student").filter("readingScore>90").show()
              sqlContext.sql("SELECT race, parentalLevelOfEducation FROM Student").distinct.show()
              sqlContext.sql("SELECT gender, race, parentalLevelOfEducation, mathScore, readingScore FROM Student WHERE mathScore> 75 and readingScore>90").show()
              sqlContext<span>("SELECT gender, race, parentalLevelOfEducation, mathScore, readingScore").dropDuplicates().show()</span>
              println("We have finished here...!")
       spark.stop()
    }
}
*/
