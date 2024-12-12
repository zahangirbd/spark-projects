1. create a project folder 'spark-sample-app-1'
2. go to 'spark-sample-app-1' folder
	D:\spark-python-projects\spark-sample-app-1>

3. create an virtual environment like following
	D:\spark-python-projects\spark-sample-app-1>"C:/Users/Zahangir Alam/AppData/Local/Microsoft/WindowsApps/python3.7.exe" -m venv ./venv

5. Activate the virtual environment: 
	D:\spark-python-projects\spark-sample-app-1>.\venv\Scripts\activate

   It will show following
	(venv) D:\spark-python-projects\spark-sample-app-1>

	And to exit virtualenv later:
	(venv) D:\spark-python-projects\spark-sample-app-1> deactivate

6. Install packages within a virtual environment without affecting the host system setup. Start by upgrading pip: 
		
	(venv) D:\spark-python-projects\spark-sample-app-1>python -m pip install --upgrade pip

	To list 
	(venv) D:\spark-python-projects\spark-sample-app-1>pip list  # show packages installed within the virtual environment

7. install following packages

	(venv) D:\spark-python-projects\cnn-example>pip install pyspark==3.5.3
