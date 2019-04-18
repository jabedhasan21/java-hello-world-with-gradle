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

   public void newtestHBWGreeterPass()

   {

      g.setName("Hollie, YOU ARE AMAZING");

      assertEquals(g.getName(),"Hollie, YOU ARE AMAZING");

      assertEquals(g.sayHello(),"Hello Hollie, YOU ARE AMAZING!");

   }

   @Test 

   public void newtestHBWGreeterPass2()

   {

      g.setName("Hollie");

      assertEquals(g.getName(),"Hollie");

      assertEquals(g.sayHello(),"Hello Hollie!");

   }

   /*@Test 

   public void newtestHBWGreeterFail()

   {

      assertEquals(g.getName(),"kittens");

      assertEquals(g.sayHello(),"Hello puppies!");
      
   }*/

}