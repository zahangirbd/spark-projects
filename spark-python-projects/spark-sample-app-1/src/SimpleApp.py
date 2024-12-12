"""
SimpleApp.py
ref: https://spark.apache.org/docs/latest/quick-start.html
"""
from pyspark.sql import SparkSession

# logFile = "YOUR_SPARK_HOME/README.md"  # Should be some file on your system
logFile = "D:/installed-software/spark/spark-3.4.0-bin-hadoop3/README.md"

# the following code is used while we submit the job using spark-submit command
# 	spark-submit --master spark://172.27.160.1:7077 src/SimpleApp.py
spark = SparkSession.builder.appName("SimpleApp").getOrCreate()

# setting master, spark master is created as an stand alone mode 
# and then computing task is submitted there
# spark = SparkSession.builder.appName("SimpleApp").master("local[*]").getOrCreate()

logData = spark.read.text(logFile).cache()

numAs = logData.filter(logData.value.contains('a')).count()
numBs = logData.filter(logData.value.contains('b')).count()

print("Lines with a: %i, lines with b: %i" % (numAs, numBs))

spark.stop()
