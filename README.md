# PCM Report Generator
This is a report card generator that displays Physics ,Chemistry and Maths marks.<br>
Framework: Spring Boot <br>

<h3>Features</h3>
1. You can enter your marks in the section provided. <br>
2. Alternatively you can put marks in url <br>
eg.: http://localhost:8080/json?Physics=75&Chemistry=76&Math=75 or http://localhost:8080/?Physics=75&Chemistry=76&Math=75 <br>
3. Click on Reset to reset the system. <br>
4. Click on JSON view to view the json view <br>

<h3>Requirements</h3>
1. Eclipse IDE for Java Developers 2021-06 <br>
2. Maven Dependencies from 2021-06 - https://download.eclipse.org/releases/2021-06/ (if it's not already installed)<br>
3. JSON Viewer (optional)<br>

<h3>Steps to Run</h3>
1. Right click on PCMApp.java <br>
2. Run it as Java Application <br>
3. Note the port number on which Tomcat server is started <br>
4. Enter the url as mentioned above with the appropriate port no. <br>

## Output
Main Page
![](images/Capture.PNG)
Wrong URL and Character in Value of Parameter Occurence Error Page
![](images/Capture2.PNG)
Out of Range Value of Parameter Error Page
![](images/Capture3.PNG)
HTML View of Result
![](images/Capture4.PNG)
JSON View of Result
![](images/Capture5.PNG)
