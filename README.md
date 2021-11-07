# PCM Report Generator
This is a PCM Report Card Generator which uses Springboot Framework and runs on Java Eclipse IDE.<br>
It displays Physics ,Chemistry and Maths marks along with the combined total, percentage and grade.<br>
The marks range for each subject is from 0 to 100.If any subject marks is less than 40 then the candidate has failed<br>
The Grading Table
<table>
    <tr>
        <th>Grade</th>
        <th>Percentage</th>
    </tr>
    <tr>
        <td>A</td>
        <td>80 and above</td>
    </tr>
    <tr>
        <td>B</td>
        <td>60 to 79</td>
    </tr>
    <tr>
        <td>C</td>
        <td>40 to 59</td>
    </tr>
</table>

<h3>Features</h3>
1. You can enter your marks in the section provided. <br>
2. Alternatively you can put marks in url <br>
eg.: http://localhost:8080/json?Physics=75&Chemistry=76&Math=75 or http://localhost:8080/?Physics=75&Chemistry=76&Math=75 <br>
3. Click on Reset to reset the system. <br>
4. Click on JSON view to view the json view <br>

<h3>Requirements</h3>
1. Java jdk-15<br>
2. Eclipse IDE for Java Developers 2021-06 <br>
3. Maven Dependencies from 2021-06 - https://download.eclipse.org/releases/2021-06/ (if it's not already installed)<br>
4. JSON Viewer (optional)<br>

<h3>Steps to Run</h3>
1. Right click on PCMApp.java <br>
2. Run it as Java Application <br>
3. Note the port number on which Tomcat server is started <br>
4. Enter the url as mentioned above with the appropriate port no. <br>

## Images of the Project
Main Page
![](images/Capture1.1.PNG)
Wrong URL and Character in Value of Parameter Occurence Error Page
![](images/Capture2.1.PNG)
Out of Range Value of Parameter Error Page
![](images/Capture3.1.PNG)
HTML View of Result
![](images/Capture4.1.PNG)
JSON View of Result
![](images/Capture5.1.PNG)