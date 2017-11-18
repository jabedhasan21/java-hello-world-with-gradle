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
    + `brew install gradle`

    + [Install Homebrew](http://brew.sh/).


+ **On Windows**

  + [Download from Gradle site](https://docs.gradle.org/current/userguide/installation.html).

  + Unzip the Gradle download to the folder to which you would like to install Gradle, eg. “C:\Program Files”. The subdirectory gradle-x.x will be created from the archive, where x.x is the version.

  + Add location of your Gradle “bin” folder to your path. Open the system properties (WinKey + Pause), select the “Advanced” tab, and the “Environment Variables” button, then add “C:\Program Files\gradle-x.x\bin” (or wherever you unzipped Gradle) to the end of your “Path” variable under System Properties. Be sure to omit any quotation marks around the path even if it contains spaces. Also make sure you separated from previous PATH entries with a semicolon “;”.

  + In the same dialog, make sure that JAVA_HOME exists in your user variables or in the system variables and it is set to the location of your JDK, e.g. C:\Program Files\Java\jdk1.7.0_06 and that %JAVA_HOME%\bin is in your Path environment variable.

  + Open a new command prompt (type cmd in Start menu) and run gradle –version to verify that it is correctly installed.
  
### To test the Gradle installation, run Gradle from the command-line: `gradle`
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

+  You now have Gradle installed.

#### Find out what Gradle can do
Now that Gradle is installed, see what it can do. Before you even create a build.gradle file for the project.

   + You can ask it what tasks are available: `gradle tasks`

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
  First you set up a Java project for Gradle to build. To keep the focus on Gradle, make the project as simple as possible for now.

##### Create the directory structure
+ Create a root project directory named `HelloWorld` and `cd HelloWorld` .

+ In a project directory of your choosing, create the following subdirectory structure;

+ For example, with `mkdir -p src/main/java/hello` on nix systems:

+ on Windows you can create this directory manually.
```
  └── src
      └── main
          └── java
              └── hello
```
  
+ Within the `src/main/java/hello` directory, you can create any Java classes you want. For simplicity’s sake and for consistency with the rest of this guide, Spring recommends that you create two classes: `HelloWorld.java` and `Greeter.java`.


+ src/main/java/hello/HelloWorld.java
```
package hello;

public class HelloWorld {
  public static void main(String[] args) {
    Greeter greeter = new Greeter();
     System.out.println(greeter.sayHello());
  }
}
```

+ src/main/java/hello/Greeter.java
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

Now we are behind few step.

+ `cd HelloWorld` and run `gradle init`.

+ After finished init you can see new file and directory are created.

+ Open `build.gradle` file and add this line `apply plugin: 'java'`.

+ Now Run this command `gradle build`.

    To see the results of the build effort, take a look in the build folder. Therein you’ll find several directories, including these three notable folders:

    + classes. The project’s compiled .class files.
    + libs. Assembled project libraries (usually JAR and/or WAR files).


+ To make this code runnable, we can use gradle’s application plugin. Add this to your `build.gradle` file.Now Open `build.gradle` file and add this two line
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

Yes we have done .... :)

### Declare dependencies

The simple Hello World sample is completely self-contained and does not depend on any additional libraries. Most applications, however, depend on external libraries to handle common and/or complex functionality.

For example, suppose that in addition to saying "Hello World!", you want the application to print the current date and time. You could use the date and time facilities in the native Java libraries, but you can make things more interesting by using the Joda Time libraries.

+ First, change `HelloWorld.java` to look like this:
```
  package hello;

  import org.joda.time.LocalTime;

  public class HelloWorld {
    public static void main(String[] args) {
      LocalTime currentTime = new LocalTime();
      System.out.println("The current local time is: " + currentTime);

      Greeter greeter = new Greeter();
      System.out.println(greeter.sayHello());
    }
  }
```

+ Here `HelloWorld` uses Joda Time’s `LocalTime` class to get and print the current time.

+ If you ran `gradle build` to build the project now, the build would fail because you have not declared Joda Time as a compile dependency in the build.

+ For starters, you need to add a source for 3rd party libraries in your `build.gradle` file.
```
    repositories {
      mavenCentral()
    }
```
  
+ The `repositories` block indicates that the build should resolve its dependencies from the Maven Central repository.

+ Now that we’re ready for 3rd party libraries, let’s declare some in your `build.gradle` file.
```
  sourceCompatibility = 1.8
  targetCompatibility = 1.8

  dependencies {
      compile "joda-time:joda-time:2.2"
  }
```

  With the `dependencies` block, you declare a single dependency for Joda Time. Specifically, you’re asking for (reading right to left) version 2.2 of the joda-time library, in the joda-time group.

  Another thing to note about this dependency is that it is a `compile` dependency, indicating that it should be available during compile-time (and if you were building a WAR file, included in the /WEB-INF/libs folder of the WAR). Other notable types of dependencies include:
    + `providedCompile`. Required dependencies for compiling the project code, but that will be provided at runtime by a container running the code (for example, the Java Servlet API).
    + `testCompile`. Dependencies used for compiling and running tests, but not required for building or running the project’s runtime code.


+ Finally, let’s specify the name for our JAR artifact ( optional).
```
  jar {
      baseName = 'hello-world-gradle'
      version =  '0.1.0'
    }
```
  
The `jar` block specifies how the JAR file will be named. In this case, it will render `jb-hello-world-gradle-0.1.0.jar`.

Now if you run `gradle build`, Gradle should resolve the Joda Time dependency from the Maven Central repository and the build will succeed.

### Build your project with Gradle Wrapper

+ The Gradle Wrapper is the preferred way of starting a Gradle build.
    - It consists of a batch script for Windows.
    - and a shell script for OS X and Linux.

+ These scripts allow you to run a Gradle build without requiring that Gradle be installed on your system.

+ To make this possible, add the following block to the bottom of your `build.gradle`.

```
  task wrapper(type: Wrapper) {
      gradleVersion = '2.8'
  }
```

+ Run the following command to download and initialize the wrapper scripts: `gradle wrapper`.

+ After this task completes, you will notice a few new files. The two scripts are in the root of the folder, while the wrapper jar and properties files have been added to a new `gradle/wrapper` folder.

```
    └── HelloWorld
    └── gradlew
    └── gradlew.bat
    └── gradle
        └── wrapper
            └── gradle-wrapper.jar
            └── gradle-wrapper.properties
```
    
+ The Gradle Wrapper is now available for building your project.

+ Add it to your version control system, and everyone that clones your project can build it just the same. It can be used in the exact same way as an installed version of Gradle. Run the wrapper script to perform the build task, just like you did previously: `./gradlew build`

+ The first time you run the wrapper for a specified version of Gradle, it downloads and caches the Gradle binaries for that version. The Gradle Wrapper files are designed to be committed to source control so that anyone can build the project without having to first install and configure a specific version of Gradle.

+ At this stage, you will have built your code. You can see the results here:

```
  build
  ├── classes
  │   └── main
  │       └── hello
  │           ├── Greeter.class
  │           └── HelloWorld.class
  ├── dependency-cache
  ├── libs
  │   └── hello-world-gradle-0.1.0.jar
  └── tmp
      └── jar
          └── MANIFEST.MF
```

+ Included are the two expected class files for Greeter and HelloWorld, as well as a JAR file. Take a quick peek:

```
  $ jar tvf build/libs/hello-world-gradle-0.1.0.jar
  0 Mon Nov 16 13:41:22 BDT 2015 META-INF/
    25 Mon Nov 16 13:41:22 BDT 2015 META-INF/MANIFEST.MF
     0 Mon Nov 16 13:41:22 BDT 2015 hello/
   988 Mon Nov 16 13:41:22 BDT 2015 hello/HelloWorld.class
   369 Mon Nov 16 13:41:22 BDT 2015 hello/Greeter.class
```

+ To wrap things up for this guide, here is the completed `build.gradle` file: `build.gradle`

```
  apply plugin: 'java'
  apply plugin: 'eclipse'
  apply plugin: 'application'

  mainClassName = 'hello.HelloWorld'

  // tag::repositories[]
  repositories {
      mavenCentral()
  }
  // end::repositories[]

  // tag::jar[]
  jar {
      baseName = 'hello-world-gradle'
      version =  '0.1.0'
  }
  // end::jar[]

  // tag::dependencies[]
  sourceCompatibility = 1.8
  targetCompatibility = 1.8

  dependencies {
      compile "joda-time:joda-time:2.2"
  }
  // end::dependencies[]

  // tag::wrapper[]
  task wrapper(type: Wrapper) {
      gradleVersion = '2.3'
  }
  // end::wrapper[]
```
