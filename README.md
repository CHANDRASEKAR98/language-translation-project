# language-translation-project

# Language Translation Project

The aim of this project is to translate the given input into a desired language of our choice.


## Acknowledgements

 - [Google App Scripts](https://www.google.com/script/start/)
 - [URL & HttpURLConnection in Java](https://www.geeksforgeeks.org/java-net-httpurlconnection-class-java/)


## Roadmap

- Creating a script on Google App Scripts

- Integrating a Java project with the script using Macro URL.


## Demo

The Project demo is shown below.

![Language Translation Demo](https://media.giphy.com/media/wOLeWzEcziOYslYAfG/giphy.gif)

## Installation

Download and install Java 8 JDK on your system if not already done.
You can download Java 8 from the official [Oracle Website](https://www.oracle.com/in/java/technologies/javase/javase8-archive-downloads.html) 

Once downloaded, Install and setup your environemntal variables for Java 8 properly. If you don't know how to setup your environmental variables, kindly follow the steps given in this [link](https://www.javatpoint.com/how-to-set-path-in-java).

To check the version of Java installed in your system, kindly execute the following command on your CMD.

```bash
  java -version
```
The output will be displayed like the following.

```bash
  java version "1.8.0_101"
  Java(TM) SE Runtime Environment (build 1.8.0_101-b13)
  Java HotSpot(TM) 64-Bit Server VM (build 25.101-b13, mixed mode)
```



## Run Locally

#### Steps to follow on Google App Script
- Go to [Google App Scripts](https://script.google.com/home) Webpage and log in with your google account.
- Create a new Project by clicking Create New Project Button.
- In the Editor Window, Start Coding your Logic. For example, if you want to create a script for language translation, use `LanguageApp` API which is more convenient way to translate the input to any languages. Refer the below code for the langiuage translation.
```bash
  var mock = {
    parameter:{
      q:'hello',
      source:'en',
      target:'ja'
    }
  };

  function doGet(e) {
    e = e || mock;

    var sourceText = ''
    if (e.parameter.q){
      sourceText = e.parameter.q;
    }

    var sourceLang = '';
    if (e.parameter.source){
      sourceLang = e.parameter.source;
    }

    var targetLang = 'en';
    if (e.parameter.target){
      targetLang = e.parameter.target;
    }

    var translatedText = LanguageApp.translate(sourceText, sourceLang, targetLang, {contentType: 'html'});

    console.log(translatedText);

    return ContentService.createTextOutput(translatedText).setMimeType(ContentService.MimeType.JSON);
  }
```
- Rename your project to a specific name.
- Once you are done with coding, click on Run to execute your script.
- Once the execution is successfully completed, click on Deploy Button on top right corner of the page.
- Choose New Deployment as it is your first deployment on this Project.
![Run and Deploy App Script](https://miro.medium.com/max/1838/1*H0bnXd7zpMSoh9M_TlQgdQ.png)
- Choose WebApp and Enter a short description (Optional) to notify the changes on your project each time you deploy the project. Choose Access to this Script.
![Deploy Webapp](https://www.benlcollins.com/wp-content/uploads/2020/12/31_newDeployment.jpg)
- Finally click on Deploy and after the script is deployed, the Deployment URL and Web App Script URL will be generated.
![Webapp URL copy](http://technokarak.com/wp-content/uploads/2014/05/gs7.png)
- Copy the Script URL and close the window.

#### Cloning and importing into IDE
- Clone the project

```bash
  git clone https://link-to-project
```

- Go to the project directory

```bash
  cd my-project
```
- Import the Project into any IDE like intelij IDE, Eclipse and open `Translation.java`.

#### Code Explanation

- In the main method, the Input String `text` is converted into UTF8 encoding format.
```bash
  String text = "\\Chandrasekar\\Welcome India!";
  String[] arrStr = text.split("\\\\");
  String test = Arrays.toString(arrStr);
  byte[] bytes = test.getBytes(StandardCharsets.UTF_8);
  String utf8EncodedString = new String(bytes, StandardCharsets.UTF_8);
```
- Following the above conversion logic, a separate method `translates` is created for language translation.
```bash
  private static String translates(String langFrom, String langTo, String text) throws IOException {
    // INSERT YOU URL HERE
    String urlStr = <SCRIPT_URL> +
            "?q=" + URLEncoder.encode(text, "UTF-8") +
            "&target=" + langTo +
            "&source=" + langFrom;
    URL url = new URL(urlStr);
    StringBuilder response = new StringBuilder();
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    con.setRequestProperty("User-Agent", "Mozilla/5.0");
    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
    String inputLine;
    while ((inputLine = in.readLine()) != null) {
        response.append(inputLine);
    }
    in.close();
    return response.toString();
  }
```
- Now paste the Google App Script URL you just copied to the String named `urlStr`. For example, the Google App Script URL will be like `https://script.google.com/......`.
- Call the method from the main method.
```bash
  // Input String
  System.out.println("Your Input text = "+test);
  
  //Translated text
  System.out.println("Translated text: " + translates("en", "ja", utf8EncodedString));
```
- Kindly save the project and Click on the project and open Run Configuration.

- Open the tab named “Common” and choose encoding format as ‘UTF-8’ and apply the changes.
![Common Tab on Run Configuration](https://1.bp.blogspot.com/-MQRvUR_pGRE/WRHI4It_Z4I/AAAAAAAAAfA/SNqnBwpXBsMQs9aQWihWfjgQoPt61ZO0ACLcB/s1600/RunConfigurations-Common-Encoding-UTF8.png)
- Now run the project and the translated output is displayed on the console.
```bash
  Your Input text = [, Chandrasekar, Welcome India!]
  Translated text: [、チャンドラセカール、ようこそインド！]
```









## Authors

- [@Chandrasekar Balakumar](https://github.com/CHANDRASEKAR98)


## Feedback

If you have any feedback, please reach out to me [@Chandrasekar Balakumar](https://www.linkedin.com/in/chandrasekarbalakumar98/) on LinkedIn.

