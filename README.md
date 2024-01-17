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


* Steps to Execute Code:
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
* 
* Download the Github Repository onto your local system. These can be done by cloning the repository via Git Commands (**git clone**) in your system. The best way would be **download the repository zip file manually as shown below**: [IMAGE]
* Unzip the zip file and you will find the directory (NAME) with the following structure:  [IMAGE]

* As you can see this is the project folder structure and the files [FILL] are our codebase files.

* Now, open Intellij IDE 

