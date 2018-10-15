
// Name: Nemil R Shah
// netID: nshah213
// UIN: 670897116

//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class Game 
{
	private ArrayList<Place> Places= new ArrayList <Place> (15);  // Vector of places ( an array of places object).
	private TreeMap < String, Artifact> artPlayer = new TreeMap < String, Artifact> ();     // Map container to store all player's possessions.
	private int totalArtifacts;    // Total number of artifacts.
	private int art_totalSize;   // Total mobility of player's possesion.
	private int art_totalValue;   // Total value of player's possesion.
	private static Place Current_place;     // Object for Current place in game. Current_Place changes as game progresses.
	public boolean flag = true;     // Helpful somewhere 
	
	// Getter function. 
	public static Place getCurrentPlace()
	{
		return Current_place;
	}
	
	// This method will also parse the file inside the construtor.
	public Game( Scanner game)    	// Default constructor.
	{
		
		//Places = new ArrayList<Place>();
		String line = null;             // stores the clean line from the file.
		String gameName = null;        // Initialize the name of the game.
		String firstToken = null;       // Helpful token to parse the files.
		
		// LOOP THATS PARSES THE ENTIRE DATA FILE UNTIL THE LAST LINE.
		while ( game.hasNextLine())
		{	
		    line = getCleanLine(game);             // call the function to get a clean line.
		    Scanner input = new Scanner (line);   // Extend scanner to input from line.    
		    firstToken = input.next();        // Parse the first token and according passing Scanner to "Game,place or artifact " class.
		  
		    if ( "GDF".equalsIgnoreCase( firstToken))
		    {
		    	if ( input.hasNextDouble())
				{
		    		input.nextDouble();
					gameName = input.nextLine();            // need to fix.
					System.out.println ( "Name of the game: " + gameName + "\n\n");		
				}
		    }
		    
		    else if ( "PLACES".equalsIgnoreCase( firstToken))
		    {
		    	int number = input.nextInt();   // Parse number to loop and create that no of places.
		    	
		    	Place Exit = new Place (game);     // might need change
		    	Place nowWhere = new Place ( game);  // psuedo places.
		    	
		    	for ( int i=0; i < number ; i++)
		    	{
		    		Place P1 = new Place (game);
		    		Places.add (P1);             // Pushing in the place container.
		    		//Places.get(i).print();    // debugg...*
   				}    	
		    }
		    
		    else if ( "DIRECTIONS".equalsIgnoreCase( firstToken))
		    {
		    	int number = input.nextInt();    // Parse number to loop and create that no of directions.
		    	 	
		    	for ( int i=0;  i < number ; i++)
		    	{
		        	Direction D1 = new Direction (game);	
		        	//System.out.println ( " \n\n" );
   				}     	
		    }   
		    else if ( "ARTIFACTS".equalsIgnoreCase( firstToken))
		    {
		    	
		    	int number = input.nextInt();     // Parse number to loop and create that no of artifacts.
		    	for ( int i=0; i < number ; i++)
		    	{
		    		Artifact A1 = new Artifact (game);
		        //	System.out.println ( " \n\n" );  	
   				}  
		    	
		    	break;   // fix later on for thrown exception.
		    }   
		}
		// Initilizae Players total artifacts, value and size.
		totalArtifacts=0;
		art_totalSize=0;
		art_totalValue=0;
	}	
	// Method to get a clean line free of comments and spaces.
	public static String getCleanLine( Scanner game)
	{
		if ( game.hasNextLine()) 
		{
		String line = null;
		
		LOOP:
			while(true)
			{
				line =  game.nextLine();          // Get a imperfect "LINE".
				String ex = null;                 // Variable string to extract the comments from line.    
				String tm= null;                  //  Variable string to trim leading and trailing spaces from line.
				if( line.contains("//"))
				{
					ex = line.substring( 0,  line.indexOf("//"));    // Extract  the comment.
					tm = ex.trim();	   // trim leading and trailing spaces.
				}
				else
				{
					tm = line.trim ();
				}
				if ( tm.length() > 0)    // If greater then zero, use tokens or get new line.
				{
					return tm;
				}
				else
				{
					continue LOOP;
				}
			}
		}	
		else
		{
			return null;
		}	
	}
	
	//public void addPlace (ArrayList <Place> makePlace) // Might need this for later.
	public void addPlace ( Place addPlace) 
	{
		Places.add(addPlace);	 	 
	}
	
	public void print()
	{
		// Print out the game information.
		System.out.println ("THERE ARE FOURTEEN PLACES IN THIS GAME \n" );
		
		for ( int i=0; i <14; i++)
		{
			Places.get(i).print();
		}
		
		inventory();   // Prints out the player's inventory.
	}
	
	// Implements the entire game.
	public void play()
	{
		// Displays the current place. 
		Current_place= Places.get(0);     // Initially the Current Place is first place read from file.
		display();
	}
	
	// Enhances the different kind of userinput.
	public String correct_userInput( String userInput, boolean flagg)
	{
		if( userInput.equalsIgnoreCase("north") || userInput.equalsIgnoreCase("n") ||userInput.equalsIgnoreCase("GO N") || userInput.equalsIgnoreCase("GO NORTH"))
			return "N";
		
		if( userInput.equalsIgnoreCase("south") || userInput.equalsIgnoreCase("s") ||userInput.equalsIgnoreCase("GO S") || userInput.equalsIgnoreCase("GO SOUTH"))
			return "S";
		
		if( userInput.equalsIgnoreCase("west") || userInput.equalsIgnoreCase("w") ||userInput.equalsIgnoreCase("GO W") || userInput.equalsIgnoreCase("GO WEST"))
			return "W";
		
		if( userInput.equalsIgnoreCase("east") || userInput.equalsIgnoreCase("e") ||userInput.equalsIgnoreCase("GO E") || userInput.equalsIgnoreCase("GO EAST"))
			return "E";
		
		if( userInput.equalsIgnoreCase("UP") || userInput.equalsIgnoreCase("U") ||userInput.equalsIgnoreCase("GO U") || userInput.equalsIgnoreCase("GO UP"))
			return "U";
		
		if( userInput.equalsIgnoreCase("DOWN") || userInput.equalsIgnoreCase("d") ||userInput.equalsIgnoreCase("GO d") || userInput.equalsIgnoreCase("GO down"))
			return "D";
		
		if( userInput.equalsIgnoreCase("northeast") || userInput.equalsIgnoreCase("ne") ||userInput.equalsIgnoreCase("GO northeast") || userInput.equalsIgnoreCase("GO ne"))
			return "NE";
		
		if( userInput.equalsIgnoreCase("northwest") || userInput.equalsIgnoreCase("nw") ||userInput.equalsIgnoreCase("GO northwest") || userInput.equalsIgnoreCase("GO nw"))
			return "NW";
		
		if( userInput.equalsIgnoreCase("southeast") || userInput.equalsIgnoreCase("se") ||userInput.equalsIgnoreCase("GO southeast") || userInput.equalsIgnoreCase("GO se"))
			return "SE";
		
		if( userInput.equalsIgnoreCase("southwest") || userInput.equalsIgnoreCase("sw") ||userInput.equalsIgnoreCase("GO SW") || userInput.equalsIgnoreCase("GO southwest"))
			return "SW";
		
		if( userInput.equalsIgnoreCase("north-northeast") || userInput.equalsIgnoreCase("nne") ||userInput.equalsIgnoreCase("GO nne") || userInput.equalsIgnoreCase("GO north-northeast"))
			return "NNE";
		
		if( userInput.equalsIgnoreCase("north-northwest") || userInput.equalsIgnoreCase("nnw") ||userInput.equalsIgnoreCase("GO Nnw") || userInput.equalsIgnoreCase("GO north-northwest"))
			return "NNW";
		
		if( userInput.equalsIgnoreCase("east-northeast") || userInput.equalsIgnoreCase("ene") ||userInput.equalsIgnoreCase("GO ene") || userInput.equalsIgnoreCase("GO east-northeast"))
			return "ENE";
		
		if( userInput.equalsIgnoreCase("west-northwest") || userInput.equalsIgnoreCase("wnw") ||userInput.equalsIgnoreCase("GO west-northwest") || userInput.equalsIgnoreCase("GO wnw"))
			return "WNW";
		
		if( userInput.equalsIgnoreCase("east-southeast") || userInput.equalsIgnoreCase("ese") ||userInput.equalsIgnoreCase("GO east-southeast") || userInput.equalsIgnoreCase("GO ese"))
			return "ESE";
		
		if( userInput.equalsIgnoreCase("west-southwest") || userInput.equalsIgnoreCase("wsw") ||userInput.equalsIgnoreCase("GO wsw") || userInput.equalsIgnoreCase("GO west-southwest"))
			return "WSW";
		
		if( userInput.equalsIgnoreCase("south-southeast") || userInput.equalsIgnoreCase("sse") ||userInput.equalsIgnoreCase("GO sse") || userInput.equalsIgnoreCase("GO south-southeast"))
			return "SSE";
		
		if( userInput.equalsIgnoreCase("south-southwest") || userInput.equalsIgnoreCase("ssw") ||userInput.equalsIgnoreCase("GO ssw") || userInput.equalsIgnoreCase("GO south-southwest"))
			return "SSW";
		
		if( userInput.equalsIgnoreCase("none")  ||userInput.equalsIgnoreCase("GO none"))
			return "NONE";
		
		else
		{
			flagg = false;
			flag = flagg;
			return userInput;
		}
	}
	
	// Displays player's possessions.
	public void inventory( )
	{
		// Printing out Inventory information.
		for( Map.Entry <String, Artifact> entry :  artPlayer.entrySet()) 
		{
			  String key = entry.getKey();
			  Artifact value = entry.getValue();
			  
			  System.out.println("Name----->" +  value.getName());
			  System.out.println("Size-----> " +  value.getSize());
			  System.out.println("Value-----> " +   value.getValue() + "\n\n");
		}
		
		System.out.println ( "TOTAL NUMBER OF ARTIFACTS OF THE PLAYER'S POSSESSION: " + totalArtifacts);
		System.out.println ( "TOTAL SIZE OF THE PLAYER'S POSSESSION: " + art_totalSize);
		System.out.println ( "TOTAL VALUE OF THE PLAYER'S POSSESSION: " + art_totalValue + "\n\n");	
	}
	
	// FUNCTION FROM PLAY IMPLEMENTING THE PLAY METHOD..
	public void display()
	{	
		// Iterate through all direction objects for current place.	
		while( !Current_place.name().equalsIgnoreCase( "EXIT") )
		{
			flag = true;
			System.out.println ("CURRENT PLACE:"  + Current_place.name() );
			System.out.println ( "Artifacts: ");
			Current_place.printPlaceArtifacts();
			
			System.out.println ("\n\nENTER THE COMMAND FOR PROCEEDING THE GAME: ");
			Scanner input = new Scanner(System.in);
			String userInput = " ";       // Variable to declare userinput.
			String input1 = " ";
			String input2= " ";
			userInput = input.nextLine();
			userInput= correct_userInput( userInput, flag);
			
		
			// Divide userInput string into two parts if they contains commands of GET, DROP AND USE.
			if ( userInput.contains("GET") || userInput.contains("DROP")  || userInput.contains("USE") )
			{
				// Divide userInput string into two parts.
				if ( userInput.equalsIgnoreCase("GET")  || userInput.equalsIgnoreCase("USE") || userInput.equalsIgnoreCase("DROP"))
					System.out.println ("Please type the name of the artifact you want to GET, DROP OR USE ");
				else
				{
					input1 =  userInput.substring( 0 , userInput.indexOf(" "));
					input2 = userInput.substring( userInput.indexOf(" ")+1 , userInput.length());	
				}
				
			}
			
			if(userInput.equalsIgnoreCase("QUIT") || userInput.equalsIgnoreCase("EXIT") )  // ---------1
			{
			// Quit the game
			System.out.println (" Game is quit \n");	
			return;
			}	
			else if (userInput.equalsIgnoreCase("LOOK") )                 // ---------2
			{
			// Redisplay the current place.
			display();
			}
			
			// THE FOUR NEW COMMANDS ARE ADDED IN THIS PROJECT.
			else if (input1.equalsIgnoreCase("GET")  )
			{
				// Condition to check if the place that does have some artifacts to take.
				Artifact get = Current_place.transfer (input2);
				if ( get!= null)
				{
					Current_place.printPlaceArtifacts();
					artPlayer.put(input2, get);
					System.out.println ("Putting '" +input2 +"' in the player's bag\n\n");
					Current_place.printPlaceArtifacts();
					
					totalArtifacts++;   // adds the number of artifacts in player's possesion.
					art_totalSize =  art_totalSize +  get.getSize();    // Update total size.
					art_totalValue = art_totalValue + get.getValue();   //  Update total value
				}
				else
				{
					System.out.println ("Nothing is added in this player's possesionss....");
				}

			}
			
			else if (input1.equalsIgnoreCase("DROP")  )
			{
				//  Transfer artifact from player's possessiton to Current place.
				if ( artPlayer.containsKey( input2))
				{
					System.out.println ("Dropping '" +input2 +"' from the player's bag\n\n");
					Artifact give = artPlayer.get(input2);
					Current_place.getFromPlayer (give, input2);
					artPlayer.remove(input2);
					
					totalArtifacts--;  // adds the number of artifacts in player's possesion.
					art_totalSize =  art_totalSize -  give.getSize();    // Update total size.
					art_totalValue = art_totalValue - give.getValue();   //  Update total value
					
				}
				
				else
				{
					System.out.println (" Sorry this artifact isn't present in player's possesion");
				}
			}
			
			else if ( input1.equalsIgnoreCase("USE")  )
			{
				if ( artPlayer.containsKey( input2))
					artPlayer.get(input2).use();
				else
				{
					System.out.println (" Sorry this artifact you are trying to use is not in player's possesion");
				}	
			}   
			
			else if (userInput.equalsIgnoreCase("INVE")   || userInput.equalsIgnoreCase("INVENTORY") )
			{
				inventory ( );
				
			}
			
			else if ( flag )
			{
				// Upadation of Current Place if it has valid unlocked direction.
				Current_place = Current_place.followDirection (userInput);
			}
			else
			{
				System.out.println ("Invalid user command!");
			}
			
		}	
		
		System.out.println ("WOW, YOU FOUND THE DESIRED EXIT PLACE AND WON THE GAME....!!!!!");
		
	}	
}
