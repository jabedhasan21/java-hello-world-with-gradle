# Building Java Projects with Gradle


##### This guide walks you through using Gradle to build a simple Java project.

### What you’ll need
+ A favorite text editor or IDE
+ JDK 6 or later
+ Install Gradle

### Install Gradle
+ **On Unix**

  ```
  $ sudo add-apt-repository ppa:cwchien/gradle
  $ sudo apt-get update
  $ sudo apt-get install gradle
  ```


+ **On Mac OS X**

    `brew install gradle`

    + [Install Homebrew](http://brew.sh/).


+ **On Windows**

  + [Download from Gradle site](https://docs.gradle.org/current/userguide/installation.html).
  + Unzip the Gradle download to the folder to which you would like to install Gradle, eg. “C:\Program Files”. The subdirectory gradle-x.x will be created from the archive, where x.x is the version.
  + Add location of your Gradle “bin” folder to your path. Open the system properties (WinKey + Pause), select the “Advanced” tab, and the “Environment Variables” button, then add “C:\Program Files\gradle-x.x\bin” (or wherever you unzipped Gradle) to the end of your “Path” variable under System Properties. Be sure to omit any quotation marks around the path even if it contains spaces. Also make sure you separated from previous PATH entries with a semicolon “;”.
  + In the same dialog, make sure that JAVA_HOME exists in your user variables or in the system variables and it is set to the location of your JDK, e.g. C:\Program Files\Java\jdk1.7.0_06 and that %JAVA_HOME%\bin is in your Path environment variable.
 + Open a new command prompt (type cmd in Start menu) and run gradle –version to verify that it is correctly installed.


+ **To test the Gradle installation, run Gradle from the command-line:**

  `gradle`

  + If all goes well, you see a welcome message:
    ```
    :help

    Welcome to Gradle 2.8.

    To run a build, run gradle <task> ...

    To see a list of available tasks, run gradle tasks

    To see a list of command-line options, run gradle --help

    To see more detail about a task, run gradle help --task <task>

    BUILD SUCCESSFUL

    Total time: 6.317 secs
    ```
    You now have Gradle installed.

  #### Find out what Gradle can do
  ---
  Now that Gradle is installed, see what it can do. Before you even create a build.gradle file for the project.

   + You can ask it what tasks are available:
   `gradle tasks`

    + If you run `gradle tasks` this command out side your project directory then you can see the output.

    ```
    :tasks
    ------------------------------------------------------------
    All tasks runnable from root project
    ------------------------------------------------------------

    Build Setup tasks
    -----------------
    init - Initializes a new Gradle build. [incubating]
    wrapper - Generates Gradle wrapper files. [incubating]

    Help tasks
    ----------
    components - Displays the components produced by root project 'jabed'. [incubating]
    dependencies - Displays all dependencies declared in root project 'jabed'.
    dependencyInsight - Displays the insight into a specific dependency in root project 'jabed'.
    help - Displays a help message.
    model - Displays the configuration model of root project 'jabed'. [incubating]
    projects - Displays the sub-projects of root project 'jabed'.
    properties - Displays the properties of root project 'jabed'.
    tasks - Displays the tasks runnable from root project 'jabed'.

    To see all tasks and more detail, run gradle tasks --all

    To see more detail about a task, run gradle help --task <task>

    BUILD SUCCESSFUL

    Total time: 2.435 secs

    ```

### Set up the project
---
  First you set up a Java project for Gradle to build. To keep the focus on Gradle, make the project as simple as possible for now.

##### Create the directory structure
+ Create a root project directory named `HelloWorld` and `cd HelloWorld` .
+ In a project directory of your choosing, create the following subdirectory structure;

+ For example, with `mkdir -p src/main/java/hello` on *nix systems:

+ on Windows you can create this directory manually.

```
└── src
    └── main
        └── java
            └── hello
```
Within the `src/main/java/hello` directory, you can create any Java classes you want. For simplicity’s sake and for consistency with the rest of this guide, Spring recommends that you create two classes: `HelloWorld.java` and `Greeter.java`.

`src/main/java/hello/HelloWorld.java`

```
package hello;

public class HelloWorld {
  public static void main(String[] args) {
    Greeter greeter = new Greeter();
    System.out.println(greeter.sayHello());
  }
}
```

`src/main/java/hello/Greeter.java`

```
package hello;

public class Greeter {
  public String sayHello() {
    return "Hello world!";
  }
}
```
Our project setup is done. :)

### Build Java code
---
Now we are behind few step.

+ `cd HelloWorld` and run `gradle init`.

  After finished init you can see new file and directory are created.
+ Open `build.gradle` file and add this line `apply plugin: 'java'`.

+ Now Run this command `gradle build`.

    To see the results of the build effort, take a look in the build folder. Therein you’ll find several directories, including these three notable folders:

    + classes. The project’s compiled .class files.
    + libs. Assembled project libraries (usually JAR and/or WAR files).


+ Now Open `build.gradle` file and add this two line
  ```
  apply plugin: 'application'
  mainClassName = 'hello.HelloWorld'
```

+ We are almost done just run this command `gradle run`.

  Now you can see the output
  ```
  :compileJava UP-TO-DATE
  :processResources UP-TO-DATE
  :classes UP-TO-DATE
  :run

  Hello world!

  BUILD SUCCESSFUL
  Total time: 4.009 secs
  ```
 Yes we have done .... :).
