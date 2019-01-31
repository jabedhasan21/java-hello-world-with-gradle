package hello;

/* a simple junit test */
/* Add more and more comments */

import org.joda.time.LocalTime;

public class HelloWorld {
	/* this the development branch and one more comment */
  public static void main(String[] args) 
  {
  	
    LocalTime currentTime = new LocalTime();
    System.out.println("Who will say the local time is: " + currentTime);
    
    Greeter greeter = new Greeter();
    System.out.println(greeter.sayHello());
  }
}

