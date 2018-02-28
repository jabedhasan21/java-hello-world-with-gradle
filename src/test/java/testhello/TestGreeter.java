package hello;

//import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

//import org.junit.Before;
//import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;



public class TestGreeter {

   private Greeter g;
	
   @BeforeAll
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
      g.setName("World War");
      assertEquals(g.getName(),"World War");
      assertEquals(g.sayHello(),"Hello New World War!");
   }
}