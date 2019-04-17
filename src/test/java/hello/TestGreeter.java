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

   public void newtestJGGreeterPass()

   {

      g.setName("Kobe");

      assertEquals(g.getName(),"Kobe");

      assertEquals(g.sayHello(),"Hello Kobe!");
   }



   @Test

   public void newtestJGGreeterFail()

   {

  		String obj1="racecar";
		String obj2="carrace";
		assertEquals(obj1,obj2);


   }


}