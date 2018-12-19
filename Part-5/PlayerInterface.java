import java.util.Scanner;

/*
 *  THIS IS TO IMPLEMENT THE USER INTERACE.
 *  
 *  Methods: 
 *  
 *  public Move getMove(Character me, Place Curr_Place)
 *  
 */

public class PlayerInterface implements DecisionMaker
{
	public Move getMove(Character c, Place p) 
	{

		String userInput =  c.io.getLine();
		
		c.io.display( "*********** RESULT AFTER OUTPUT *************** ");
		c.io.display( "\n\n");
		
		System.out.println("UserInput is "   +  userInput);

		
		if ( userInput.contains("GO"))
		{
			Move temp = new Move ("GO", userInput.substring(3));  // Initilialize move object.
			
			return temp;
		}
		
		else if ( userInput.contains("GET"))
		{
			Move temp = new Move ("GET", userInput.substring(3));  // Initilialize move object.
			
			return temp;
		}
		
		else if ( userInput.contains("USE") )
		{
			Move temp = new Move ("USE", userInput.substring(4) );
			
			return temp;
		}

		
		else if ( userInput.contains("DROP") )
		{
			Move temp = new Move ("DROP", userInput.substring(5) );
			
			return temp;
		}
		
		else if ( userInput.contains("INVENTORY") )
		{
			Move temp = new Move ("INVENTORY", userInput.substring(5) );
			
			return temp;
		}
		
		else if ( userInput.contains("LOOK"))
		{
			Move temp = new Move ("LOOK",  userInput.substring(4));  // Initilialize move object.
			
			return temp;
		}
		
		else if ( userInput.contains("EXIT"))
		{
			Move temp = new Move ("EXIT",  userInput.substring(4));  // Initilialize move object.
			
			return temp;
		}
		
		else
		{
			return null;
		}
	
	}


}
