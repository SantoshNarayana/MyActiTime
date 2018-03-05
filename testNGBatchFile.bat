set projectLocation=D:\Automation\ProjectManagement\ActiTime
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\jars\*
java org.testng.TestNG %projectLocation%\testng.xml
pause