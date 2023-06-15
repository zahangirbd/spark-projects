# Spark Projects
This contains some spark projects

## Spark installaion
1. Install Java from 
	http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html 
	
2. Install spark
	- Download spark from
	https://spark.apache.org/downloads.html
	e.g., spark-3.4.0-bin-hadoop3.tgz
	
	- Extract the file and store into a location, e.g., D:\installed-software\spark\spark-3.4.0-bin-hadoop3
	
3. Install winutils

	- Download winutils for hadoop-3 from
	https://github.com/steveloughran/winutils/blob/master/hadoop-3.0.0/bin/winutils.exe
	Winutils are different for each Hadoop version hence download the right version
	
	- Store into a location, e.g., D:\installed-software\spark\winutils\bin
	
3. Set `JAVA_HOME`, `SPARK_HOME`, `HADOOP_HOME` and `PATH` environment variables.
Example values: 
Variable name: `SPARK_HOME`
Variable value: `D:\installed-software\spark\spark-3.4.0-bin-hadoop3`

Variable name: `JAVA_HOME`
Variable value: `C:\Program Files\Java\jdk1.8.0_101`

Variable name: `HADOOP_HOME`
Variable value: `D:\installed-software\spark\winutils`

```
PATH=%PATH%;%SPARK_HOME%\bin;%HADOOP_HOME%\bin
```

4. Verfication of installations
	- **spark-shell**
		Spark binary comes with an interactive `spark-shell`
	
	```
	spark-shell
	```
	
	This command loads the Spark and displays what version of Spark you are using.
	
	- **spark** and **sc**
	By default, `spark-shell` provides with `spark` (SparkSession) and `sc` (SparkContext) object’s to use. Let’s see some examples.
		
	```
	scala>spark
	```

	```
	scala>sc
	```
	
	`Spark-shell` also creates a Spark context web UI and by default, it can access from http://localhost:4040.
	
5. Run an spark project
	- Go to the project under `spark-java-projects`
	- In command line, build the project for `eclipse` using the following command 
		
		```
		gradle eclipse
		```
	- Open the project is `eclipse` and run the program 
	

## Spark running
Ref: https://www.edureka.co/blog/spark-java-tutorial/

1. **Open** the command prompt and start Spark in command prompt as a **master**.
	
	```
	spark-class org.apache.spark.deploy.master.Master
	```
	
	It runs the master at 8080 port, e.g. from the console-output, a message is like: 
	
	```
	23/06/14 20:11:02 INFO MasterWebUI: Bound MasterWebUI to 0.0.0.0, and started at http://host.docker.internal:8080
	```
	
	Now you can open a browser, can hit http://localhost:8080
	
2. **Open a new** command prompt and start Spark **again** in the command prompt and this time as a **Worker** along with the **master’s IP Address**.
	
	For example, The IP Address is available at `localhost:8080`. 
	Open browser and hit http://localhost:8080, it will show spark URL. 
	For example, in browser, the **spark url** is **Spark Master at spark://192.168.1.152:7077** 
	
	```
	spark-class org.apache.spark.deploy.worker.Worker 192.168.1.152:7077
	```

	It will show message like following:
	
	```
	23/06/14 20:20:58 INFO Worker: Successfully registered with master spark://192.168.1.152:7077
	```

3. **Open a new** command prompt and now you can start up the **Spark shell** along with the **master’s IP Address**.
	It will show `scala>` in console 
	
4. 
	