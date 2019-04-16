package hello;



import static org.junit.Assert.*;



import org.junit.Before;

import org.junit.Test;





public class TestGreeter {



   private Greeter g;



   @Before

   public void setUp() throws Exception

   {

      g = new Greeter();

   }



   @Test

   public void testGreeterEmpty()

   {

      assertEquals(g.getName(),"");

      assertEquals(g.sayHello(),"Hello!");

   }



   @Test

   public void testGreeter()

   {

      g.setName("World");

      assertEquals(g.getName(),"World");

      assertEquals(g.sayHello(),"Hello World!");

   }

 @Test

 public void passTestCVGreeterPass()
 {

    g.setName("Dave");

    assertEquals(g.getName(),"Dave");

    assertEquals(g.sayHello(),"Hello Dave!");

 }

 @Test

 public void passTestCVGreeterFail()
 {

    g.setName("Kirk");

    assertEquals(g.getName(),"Kirk");

    assertEquals(g.sayHello(),"Hello Dave!");

 }



}
