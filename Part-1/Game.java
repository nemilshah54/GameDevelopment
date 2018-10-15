
// Name: Nemil R Shah
// netID: nshah213
// UIN: 670897116

//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Scanner;


public class Game 
{
	private ArrayList<Place> Places= new ArrayList <Place> (15);  // Vector of places ( an array of places object).
	private Place Current_place;     // Object for Current place in game.
		
	public Game( String game)    	// Default constructor.
	{
		//Places = new ArrayList<Place>();
		System.out.println ("  WELCOME TO THE GAME CALLED "  + game);
	}
	
	//public void addPlace (ArrayList <Place> makePlace) // Might need this for later.
	public void addPlace ( Place addPlace) 
	{
		Places.add(addPlace);	 	 
	}
	
	public void print()
	{
		// Print out the game information.
		
		System.out.println (" THERE ARE SIX PLACES IN THIS GAME \n" );
		System.out.println (" FIRST PLACE: \n" );
		Places.get(0).print();
		
		System.out.println (" SECOND PLACE: \n" );
		Places.get(1).print();    
		 
		
		System.out.println (" THIRD PLACE: \n" );
		Places.get(2).print(); 
		
		System.out.println (" FOURTH  PLACE: \n" );
		Places.get(3).print();  
		
		System.out.println (" FIFTH PLACE: \n" );
		Places.get(4).print();
		
		System.out.println (" SIXTH PLACE: \n" );
		Places.get(5).print();	
	}
	
	public void play()
	{
		// Displays the current place. 
		Current_place= Places.get(0);     // Initially the current place is Entrance hall.
		display();
	}
	
	public String correct_userInput( String userInput)
	{
		if( userInput.equalsIgnoreCase("north") || userInput.equalsIgnoreCase("n") || userInput.equalsIgnoreCase("NORTH")  || userInput.equalsIgnoreCase("N") || userInput.equalsIgnoreCase("GO N") || userInput.equalsIgnoreCase("GO NORTH"))
			return "NORTH";
		
		if( userInput.equalsIgnoreCase("west") || userInput.equalsIgnoreCase("w") || userInput.equalsIgnoreCase("WEST")  || userInput.equalsIgnoreCase("W") || userInput.equalsIgnoreCase("GO W") || userInput.equalsIgnoreCase("GO WEST"))
			return "WEST";
		
    	if( userInput.equalsIgnoreCase("east") || userInput.equalsIgnoreCase("e") || userInput.equalsIgnoreCase("EAST")  || userInput.equalsIgnoreCase("E") || userInput.equalsIgnoreCase("GO E") || userInput.equalsIgnoreCase("GO EAST"))
			return "EAST";
		
    	if( userInput.equalsIgnoreCase("south") || userInput.equalsIgnoreCase("s") || userInput.equalsIgnoreCase("SOUTH")  || userInput.equalsIgnoreCase("S") || userInput.equalsIgnoreCase("GO S") || userInput.equalsIgnoreCase("GO SOUTH"))
			return "SOUTH";
    	if( userInput.equalsIgnoreCase("upper") || userInput.equalsIgnoreCase("u") || userInput.equalsIgnoreCase("UPPER")  || userInput.equalsIgnoreCase("U") || userInput.equalsIgnoreCase("GO U") || userInput.equalsIgnoreCase("GO UPPER"))
			return "UPPER";
		
    	if( userInput.equalsIgnoreCase("down") || userInput.equalsIgnoreCase("d") || userInput.equalsIgnoreCase("DOWN")  || userInput.equalsIgnoreCase("D") || userInput.equalsIgnoreCase("GO D") || userInput.equalsIgnoreCase("GO DOWN"))
			return "DOWN";
		else
			return userInput;
		
	}
	
	public void display()
	{	
		// Iterate through all direction objects for current place.	
		while( !Current_place.name().equals( "EXIT") )
		{
			System.out.println (" CURRENT PLACE:  "  + Current_place.name() + " \n");
			
		//	Current_place.iter_dirObjects();
			
			
			System.out.println (" ENTER THE COMMAND FOR PROCEEDING THE GAME: ");
			@SuppressWarnings("resource")
			//Scanner input = new Scanner(System.in);
			Scanner input = new Scanner(System.in);
			String userInput = " ";
			userInput = input.nextLine();
		//	System.out.println ( "\n The command is " +userInput);  DEBUG
			
			userInput= correct_userInput( userInput);
			
			// IF CONDITIONS FOR DIFFERENT COMMANDS FOR THE USERINPUT.
			
			/*if (Current_place.name().equals( "EXIT"))
			{
				System.out.println ("WOW, YOU FOUND THE DESIRED EXIT PLACE AND WON THE GAME....!!!!!");
				return;
			}  */
			if(userInput.equalsIgnoreCase("QUIT") || userInput.equalsIgnoreCase("EXIT") )
			{
			// Quit the game
			System.out.println (" Game is quit \n");	
			return ;
			}	
			else if (userInput.equalsIgnoreCase("LOOK") )
			{
			// Redisplay the current place.
			display();
			
			}
			else 
			{
				// Upadation of Current Place if it has valid unlocked direction.
				//System.out.println ("Updating the Current Place.");
				Current_place = Current_place.followDirection (userInput);
			}
			
		}	
		
		System.out.println ("WOW, YOU FOUND THE DESIRED EXIT PLACE AND WON THE GAME....!!!!!");
		
		
	}	
}
