
// Name: Nemil R Shah
// netID: nshah213
// UIN: 670897116

//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/*
 * Game class creates the world and has main method Play to implement the entire game.
 *  
 *  Methods:
 *  
 *  public void  displayInstructions()
 *  public Game( Scanner game)    	// Default constructor
 *  public static String getCleanLine( Scanner game) // Method to get a clean line free of comments and space
 *  public void play()   // Play the game.
 *  
 *  // Debugging
 *  
 *  public void printCharacter()
 * 
 */


public class Game 
{
	private ArrayList<Character> characters= new ArrayList < Character> (15);  // Vector of charaters. ( an array of places object).
	private TreeMap < String, Artifact> artPlayer = new TreeMap < String, Artifact> ();     // Map container to store all player's possessions.
	private int totalArtifacts;    // Total number of artifacts.
	private int art_totalSize;   // Total mobility of player's possesion.
	private int art_totalValue;   // Total value of player's possesion.
	public boolean flag = true;     // Helpful somewhere 
	public boolean yesCharacter = false;   // it turns true if there is a character in data file. 
	
	public double versionNo;  
	
	public void  displayInstructions()
	{
		System.out.println ("'......WELCOME TO THE GAME.......'\n");
		
		System.out.println ("RULES AND REGULATIONS..!!\n");
		
		System.out.println ("GAME has multiple players played with both User-Interface and Artifical-Intelligent Interface\n");
		System.out.println ("RULES FOR USER PLAYER ( USER INTERFACE)-----A ");
		System.out.println ( "User has different commands to use to play with game. ");
		System.out.println ( "First type the Command name and Secondly type the argument to use for that command. ");
		System.out.println ( "1) COMMAND---GO. Type GO  'Direction Name' to go new place. Note here GO as command and Direction name is argument.");
		System.out.println ( "You have 18 different directions to use according to map.");
		System.out.println ( "Example -- 'GO NORTH' \n");
		
		
		System.out.println ( "2) COMMAND---GET,DROP AND USE. Type GO,GET OR DROP 'Artificat Name' to either use,drop,or get");
		System.out.println ( "You can take artifacts from the room you reside.");
		System.out.println ( "You can drop or use artifacts which are in your bag.");
		System.out.println ( "Example -- 'GET Brass key'\n");
		
		System.out.println ( "3) COMMAND--INVENTORY will check your all current possesions and informations");
		System.out.println ( "4) COMMAND--LOOK will show your current status like current place, bag...etc");
		System.out.println ( "5) COMMAND--QUIT will quit the game.");
		
		System.out.println ("Make sure whatever command you use, it will be counted as move.");
		System.out.println ("For example LOOK,INVE are counted as move. So don't waste moves if you know the things.");
		
		System.out.println ("Lastly please enter a valid command. If the name of artifact is not exaclty match, then it won't be valid command\n\n");
		
		
		System.out.println ("REGULATIONS OF AI INTERFACE-----B");
		System.out.println ("AI here is very Smart. It will use four commands as 'GO,GET,DROP,USE'");
		System.out.println ("AI will always give the valid command. Further, it will alaways go to right direction door");
		System.out.println ("AI gives command like use,get or drop for the right artifact present in current place. No error making here again ");
		System.out.println ("Basically it has less chances of making error moves. I told you it is smart; yet it isn't that smart to open the lock door.\n");	
		System.out.println("'---------ENJOY THE GAME AND PLAY CLEVERLY..............");
	
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
		    	    versionNo = input.nextDouble();
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
		    		Place P1 = new Place (game);             // Pushing in the place container.
		   
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
		    
		    else if ("CHARACTERS".equalsIgnoreCase( firstToken)  )
		    {
		    	yesCharacter= true;
		    	int number = input.nextInt();

		    	for ( int i=0;  i < number ; i++)
		    	{
		    		line = getCleanLine(game);             // call the function to get a clean line.
		 		    Scanner in = new Scanner (line);   // Extend scanner to input from line. 
		 		    
		 		    String type = in.next();
		 		    
		 		    if ( type.equalsIgnoreCase("PLAYER"))
		 		    {
		 		    
		 		    	int whichPlaceId = in.nextInt();
		 		    
		 		    	Character c = new Player (game, versionNo);
		 		    	
		 		    	if ( whichPlaceId > 0)               //  Go on desired place.
		 		    	{
		 		    		Place startingPlace = Place.getPlaceByID( whichPlaceId);
		 		    		startingPlace.addCharacter( c.getName(), c);
		 		    		
		 		    		c.set( startingPlace);
		 		    	}
		 		    	
		 		       if ( whichPlaceId == 0 )           // Go on random starting place.
		 		    	{
		 		    	
		 		    	   Place   startingPlace = Place.getRandomPlace ();
		 		     	   startingPlace.addCharacter( c.getName(), c);
		 		    	   c.set( startingPlace);
		 		    	}
	
		 		    	
		 		    	characters.add (c);
	
		 		    }
		 		    
		 		    if ( type.equalsIgnoreCase( "NPC"))
		 		    {
		 		    	int whichPlaceId = in.nextInt();
		 		
		 		    	
		 		    	Character c = new NPC (game, versionNo);
		 		    	
		 		    	if ( whichPlaceId > 0)
		 		    	{
		 		    		Place sp = Place.getPlaceByID( whichPlaceId);
		 		    		sp.addCharacter( c.getName(), c);
		 		    		c.set( sp);
		 		    	}
	 		    	
		 		    	 if ( whichPlaceId == 0 )
		 		    	{
		 		    		Place sp = Place.getRandomPlace ();
		 		    		sp.addCharacter( c.getName(), c);
		 		    		c.set( sp);
		 		    	}
		 		    	characters.add (c);
		 		    }

   				}
		    	
		    	
		    }
		    else if ( "ARTIFACTS".equalsIgnoreCase( firstToken))
		    {
		    	
		    	int number = input.nextInt();     // Parse number to loop and create that no of artifacts.
		    	for ( int i=0; i < number ; i++)
		    	{
		    		Artifact A1 = new Artifact (game);	
   				}  
		    	
		    	break;   // fix later on for thrown exception.
		    } 

		}
		
		if ( yesCharacter == false)
		{
			
	    		// Create the new characters manually.
	    		
	    		Scanner no = new Scanner(System.in);
	    		int userInput = no.nextInt();
	    		
	    		System.out.println ( "Total Number of characters to make: " +userInput);	
	    		
	    		for ( int i=0;  i < userInput ; i++)
		    	{
	    			Scanner idd = new Scanner(System.in);
		    		int id = idd.nextInt();
		    		
		    		Scanner in = new Scanner(System.in);
		    		String name = in.nextLine();
		    		
		    		Scanner inp = new Scanner(System.in);
		    		String des = inp.nextLine();
		    		
		    		Character c = new Player (id, name, des);
		    		
		        	characters.add (c);
		        	//System.out.println ( " \n\n" );
   				} 
		}
		
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

	public void play()
	{
		System.out.println ( "\n\n\nLET'S PLAY..............!!!!!!!!! \n");
		
	    while(true)
	    {
	    	for ( int i=0;  i < characters.size() ; i++)
			{
	    		
				System.out.println ( (i+1)+ ") TURN OF PLAYER------> " + characters.get(i).getName().trim());	
				characters.get(i).makeMove();
				System.out.println( "\n\n");
			}	
	    }	
	}

		
		//------------------------DEBUGGGNG INFORMATION--------------------------------------------------------------//

		public void printCharacter()
		{
			
			for ( Character c: characters )
			{
				System.out.println ("\n\nCHARACTER------> "  +c.getName());
				System.out.println ("Current place:  "  +c.getCurr().name() + " \n" );
				System.out.println ("This place contains following artifacts ");
				c.getCurr().printPlaceArtifacts();
				
				System.out.println ( c.getName() + " contains following artifacts in his bag ");  
				c.printCharacterArtifacts();
			}
		}
		
}



