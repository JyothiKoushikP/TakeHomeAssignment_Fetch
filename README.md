# Take Home Assignment - Fetch (SRE)
* This repository contains all the detailed instructions on how to run and test the code with various required parameters. I kindly request you to follow each and every detail very carefully.  
* This repository also contains a working video of the code. I can confirm that there are no compilation errors arising within the execution of the code.

**The project details are as follows:**  
Operating System / Infrastructure used:
* MacOS Monterey (Version 12.6.3)
* Apple M2 chip (2022 Version)
* 8GB Unified Memory 
* 256GB SSD Flash Storage

Programming Languages and Software Tools used:
* Java JDK Version 21
* Maven
* IntelliJ IDE (Version 2023.3.2 - Latest)

The project code has been tested on the following Operating Systems:
* Windows 11 (IntelliJ IDE - 16 GB Unified Memory - JDK 21 (Maven))
* Ubuntu 20.04.6 LTS (IntelliJ IDE - 8 GB Unified Memory - JDK 21 (Maven))
* MacOS Monterey (Version 12.6.3) (IntelliJ IDE - 8 GB Unified Memory - JDK 21 (Maven))

**Project Code Structure**:  
The main files of this project folder include:
* 9 codebase files with file extension (.java) situated in **/src/main/java/org/example**
* 9 files with (.class) file extension situated in **/target/classes/org/example**

**The codebase files are the most important files of this project and they contain the entire program-logic**. **There are 9 codebase files which are as follows**:  
* **TestCycle.java**: This java file is the **Main file** used for the execution of the tests and all other codebase files contain methods, packages that support this execution. **The entire execution is being done from here.**

* **LoggerInfo.java**: This java file contains methods for logging results, important information and errors on to the console.

* **HttpRequests.java**: This java file contains a custom class whose structure similar to the **Request** Element provided in the input YAML file. **This class contains the following variables**:  
headers -> HashMap<String,String> (Optional: Default value : {})   
method  -> String (Optional: Default value: "GET")    
name    -> String (Required -> Will raise **Exception** if not provided)  
url     -> String (Required -> Will raise **Exception** if not provided)  
body    -> String (Optional: Default value: "")


* **MissingMetadataException.java**: This java class contains the exception that will be raised if the request is missing any required parameters.
* **ParseYamlFileInput.java**: This java class contains the methods to process the Input YAML file to **HttpRequests Objects**, and send them for testing. **SnakeYaml** from **Maven** is used.
* **ResponseResult.java**: This java class contains a blueprint for the response that we get back after the request is processed. **This class contains the following variables**:  
domain -> String (Stores the url domain to calculate availability)  
up -> Boolean (Stores a boolean value to check if response is **"UP"** or **"DOWN"**)  


* **ServerAvailability.java**: This java class contains the methods to calculate the **availability percentage** of each test cycle (every 15 seconds)
* **TestCycle.java**: This java class contains the code to run endpoints every 15 seconds, and calculate the **availability percentage** after every test cycle 
* **TestEndpoint.java**: This java class contains the code to initiate a HttpServer Request and collect the response, process it and store it for future work  
* **UserInputExit.java**: This java class contains the code for ending the program execution on user input in the console.

**Steps to Execute Code**:  
**Please follow these steps and screenshots to execute the code carefully. A working video has also been attached for reference**. 

* I strongly recommend the **IntelliJ IDE** for running this project. Other IDE's such as eclipse and Vs-Code are also suitable, but Intellij has the facility of downloading and setting up JDK which reduces effort.


* Please download the IntelliJ from the following links:
* **Windows**:  https://www.jetbrains.com/idea/download///?section=windows
* **MacOS**:    https://www.jetbrains.com/idea/download///?section=mac
* **Linux**:    https://www.jetbrains.com/idea/download///?section=linux  


* Install the IntelliJ IDE on your system. Use the following links for your reference:
* **Windows**:  https://www.youtube.com/watch?v=viNG3VVnzFE
* **MacOS**:    https://www.youtube.com/watch?v=lRTaK8tIsjM
* **Linux**:    https://www.youtube.com/watch?v=UVccSRU8jXA


* Download the Repository onto your local system. These can be done by cloning the repository via Git Commands (**git clone**) in your system. The best way would be **download the repository zip file manually as shown below**: 

![Alt text](/Users/jyothikoushikpaladugu/Desktop/s1.png)

* Unzip the zip file and you will find the following structure:

![Alt text](/Users/jyothikoushikpaladugu/Desktop/s2.png)

* As you can see, all the main codebase files are situated in **/src/main/java/org/example** directory. The .class files are situated in **target/classes/org/example**. There is also an **Input.YAML** file present which contains the requests. As this is a **Maven** project, there is a **pom.xml** file which automatically builds when you open this folder in Intellij IDE.


* Now, launch Intellij IDE, you will see a menu similar to the one below, Open our project folder by selecting the option and browsing for the directory "**TakeHomeAssignment_Fetch**" or the name you saved the file with :

![Alt text](/Users/jyothikoushikpaladugu/Desktop/s3.png)

![Alt text](/Users/jyothikoushikpaladugu/Desktop/s4.png)

* **Note: For some cases, the IDE might ask you with an alert whether to **Trust and open the project**, kindly confirm and open the project.**
* **Note: Sometimes, the IDE might give you an alert to open the project as a **Eclipse** Project (or) a **Maven** project. Kindly select **Maven**.


* After you open the project, the layout will be as follows with the project directory on the left side and the opened files to the right. Navigate to **/src/main/java/org/TestCycle.java** as shown below and open that file.

![Alt text](/Users/jyothikoushikpaladugu/Desktop/s5.png)

* **Note: This code is written and compiled using JDK 21 and Maven Dependencies. I strictly recommend installing JDK 21. Maven dependencies will automatically be updated when you load the project in the IDE as it contains the pom.xml file.** 

* It is possible you can encounter some errors as shown below such as **Project JDK is not defined** (or) **Project JDK is misconfigured**, it means that JDK 21 is not present or is not configured properly.

![Alt text](/Users/jyothikoushikpaladugu/Desktop/s6.png)
![Alt text](/Users/jyothikoushikpaladugu/Desktop/s7.png)

* In that case, select **Configure SDK** or **Setup JDK** option as shown above. It will give you the option to Download JDK, download JDK 21 for this project and the IDE will setup automatically.

![Alt text](/Users/jyothikoushikpaladugu/Desktop/s8.png)

* Sometimes, some unconventional errors might occur during execution such as **Version Compatibility error** or **Class file has wrong version 52.0, should be 50.0** or **Main Class not found error** . Please refer to https://www.youtube.com/watch?v=XJ5EjZmOwsk and https://www.youtube.com/watch?v=pmZsFR6wn18 that will help you to sort those problems.

**Running the code**:

* As provided in the assignment, the **TestCycle.java** which is the main file you need to run, will take Command Line Arguments for the Input file YAML Path.  

* In order to keep the execution simple, I have included a Input.YAML file in the project as shown above. 
* You can run the code and the **program will take the input Path that I have provided by default if no-command line arguments are provided**.
* Both the cases are discussed below and are also shown in the working video attached. Please refer them for any doubts.

**CASE 1: You do not have a YAML file and just want to run the code**:

* Click on the run button as shown below, the code execution will start.

![Alt text](/Users/jyothikoushikpaladugu/Desktop/s9.png)

* The test cycle runs until the user stops the program. You can enter input in the console (**as shown in Working Video 1**) or **click the stop button as shown below** to stop the program execution.  

![Alt text](/Users/jyothikoushikpaladugu/Desktop/s10.png)

**CASE 1: You do have a YAML file and just want to test those inputs with the code**:

* You can provide the input File Path (**Absolute**) as a command Line Argument by following the instructions below. You can also refer to **Working Video 2.**

* Select the option as shown below: It allows us to run **TestCycle.java** with parameters

![Alt text](/Users/jyothikoushikpaladugu/Desktop/s11.png)

* Copy the absolute filePath of your YAML file and paste it as shown below. 
* Click on **Apply** and then **Run**.

![Alt text](/Users/jyothikoushikpaladugu/Desktop/s12.png)

* In this way, you can run the code with custom command line arguments.

**Output:**
The endpoints are tested every 15 seconds and the availability percentage is calculated for each domain as shown below.

![Alt text](/Users/jyothikoushikpaladugu/Desktop/s13.png)