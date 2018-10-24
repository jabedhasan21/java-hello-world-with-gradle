package hello;



public class Greeter {

<<<<<<< HEAD
  private String name = "";

  public String getName() 
  {
    return name;
  }

  public void setName(String name) 
  {
      this.name = name;
  }

  public String sayHello() 
  {
  	if (name == "") 
    {
       return "Hello!";
    }
    else 
    {
       return "Hello " + name + "!";
    }
=======


  private String name = "";



  public String getName() 

  {

    return name;

>>>>>>> jabedhasan21/master
  }



  public void setName(String name) 

  {

      this.name = name;

  }



  public String sayHello() 

  {

  	if (name == "") 

    {

       return "Hello!";

    }

    else 

    {

       return "Hello " + name + "!";

    }

  }

}