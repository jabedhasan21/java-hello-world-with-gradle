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

   public void newtestJGGreeterFail()

   {

  		String obj1="racecar";
		String obj2="racecar";
		assertEquals(obj1,obj2);


   }


}