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
    
    public void newtestJPGreeterFail()
    
    {
        
        g.setName("SomeCrappyName");
        
        assertEquals(g.getName(),"SomeCrappyName");
        
        assertEquals(g.sayHello(),"Hello John!");
        
    }
    
    
   @Test

   public void testGreeterEmpty() 

   {

      assertEquals(g.getName(),"AnotherCrappyName");

      assertEquals(g.sayHello(),"Hello!");

   }

	

   @Test

   public void testGreeter() 

   {

      g.setName("TheLastCrappyName");

      assertEquals(g.getName(),"TheLastCrappyName");

      assertEquals(g.sayHello(),"Hello World!");

   }

}
