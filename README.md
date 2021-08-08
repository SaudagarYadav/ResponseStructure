# ResponseStructure

**Requirement:**
Process the client request and upload the file in the file storage provided by the client which can be a local server in a data center or in the cloud. _**awscloud or azurecloud or googlecloud**_

_https://docs.microsoft.com/en-us/samples/azure-samples/sftp-creation-template/sftp-on-azure/_ - For creating file storage on Azure

Look like a huge development task. Actually not 
Let break down the task in steps (This is process is actually know as **microplanning**)

**Steps to follow:**
1. Read XML request and convert in bean object
2. Process request and get required data for response
3. Create XML from response bean object 
4. Create XML file on a provided location
5. Upload or move XML file on remote location using  **SFTP (Secure File Transfer Protocol)**

**Takeaways from this implementation**
1. How to create #XML to java bean object and java bean object to #XML?
2. Upload file at a remote location using **SFTP (Secure File Transfer Protocol)**
3. How to play with files in java?

What if instead of **XML** client ask for **JSON**? Next week solution for this will be posted.   

**Note:**
1. Java and Springboot are used. But, I have avoided using the most feature of spring-boot so that this code can be used with different **frameworks**
2. Static data is used for this demo just to avoid database complexity   

**I upload new implementation related to Java every week. Let me know if you need any specific implementation.**
_**Hope this is helpful to you. See you next week. Happy coding🙂**_
