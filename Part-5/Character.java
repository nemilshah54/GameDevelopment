import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/*
 *  Character is parent of Player and Npc.
 *  
 *  Methods: 
 *  
 *  public Character ( Scanner game, double version)
 *  public Character ( int idd, String namee, String des)
 *  public void addArtifact (String key, Artifact add_art)
 *  void makeMove ()
 *  void printCharacterArtifacts()
 *  
 *  // Getters.
 *   int getId () 
 *   String getName () 
 *   String getDes () 
 *   public void set ( Place start)
 *   public Place getCurr ()
 *   static Character getCharacterByID ( int key)

 */

public class Character 
{
	protected IO io;
	private int id;
	private String name;
	private String description;
	protected boolean leather_bag;
	
	static TreeMap < Integer, Character> kC = new TreeMap < Integer, Character > ();     // Map container to store static collection of known places. 
	protected TreeMap < String, Artifact> artPlayer = new TreeMap < String, Artifact> ();   //Collection of artifacts possesed by player.
	private Place curr;
	
	
	protected int totalArtifacts;    // Total number of artifacts in character's bag.
	protected int art_totalSize;   // Total mobility of player's possesion.
	protected  int art_totalValue;   // Total value of player's possesion.
	
	protected int health;        // Health value of a player.
	
	public Character ( Scanner game, double version)
	{

		// Get a line and extend it as scanner input.. Parse and extract the data from scanner and initialze data fields of Place class.
		String line = null;
		line =  Game.getCleanLine(game);
		Scanner input = new Scanner (line);
		
		id = input.nextInt();
		name = input.nextLine();

		int number = game.nextInt();    

		for ( int i=0; i < number ; i ++)
		{
			line =  Game.getCleanLine(game);
			Scanner a = new Scanner (line);
			if (description == null)
				description =a.nextLine().concat("\n");
			else
			{
				description = description.concat( a.nextLine().concat( "\n"));
			}
			
		}
		
		// Initilizae Players total artifacts, value and size.
		totalArtifacts=0;
		art_totalSize=0;
		art_totalValue=0;
		
		health = 500;  // Initial health.
		
		kC.put(id, this);	      // Pushing this place to static collection of known places. ( Map).
		
		
		 System.out.println("Player " + this.name + " provide the user interface number: ");
		 
		Scanner num = new Scanner(System.in);
	 	int user = num.nextInt();   
	 	
	    io = new IO ();
	 	io.selectInterface(user);
	 	io.playerName(this);
	
	}
	
	// External...
		public Character ( int idd, String namee, String des)
		{

			this.id = idd;
			this.name = namee;
			this.description = des;
			
			// Initilizae Players total artifacts, value and size.
			totalArtifacts=0;
			art_totalSize=0;
			art_totalValue=0;
			
			curr = Place.getRandomPlace();
			
			kC.put(id, this);	      // Pushing this place to static collection of known places. ( Map).
					
		}
	
	//--------------SIMPLE GETTERS..............--------------------------------------------------------------------------//
	
	int getId ()  { return id; } 
	String getName () { return name ;} 
	String getDes () { return description; } 

	public void set ( Place start)
	{
		curr = start;
	}
	
	public void setCurr( Place newPlace)
	{
		curr = newPlace;
	}
	
	
	public Place getCurr ()
	{
		return curr;
	}
	
	
	
	
	static Character getCharacterByID ( int key)
	{
		return kC.get(key);
	}  
	
	public void addArtifact (String key, Artifact add_art)
	{
		String noSpaceKey = null;  
		noSpaceKey = key.trim();
		//numArt++;
		artPlayer.put( noSpaceKey, add_art);	
		
		totalArtifacts++;   // adds the number of artifacts in player's possesion.
		art_totalSize =  art_totalSize +  add_art.getSize();    // Update total size.
		art_totalValue = art_totalValue + add_art.getValue();   //  Update total value
	}

	void makeMove ()
	{
		//most of the implemented code is here.
		
		System.out.println ( "character enter ");		
	}


	// Player's possessions.
	public void inventory( )
	{
		// Printing out Inventory information.
		for( Map.Entry <String, Artifact> entry :  artPlayer.entrySet()) 
		{
			  String key = entry.getKey();
			  Artifact value = entry.getValue();
			  
			  if (! (value.getName().isEmpty()))
			  {
				  io.display("Artifact----->" +  value.getName() );
				  io.display("\n") ;
				
			  }
			  
		
			  
			  io.display("Size-----> " +  value.getSize()) ;
			  io.display("\n") ;
			  io.display("Value-----> " +   value.getValue() + "\n\n" );
			  
		
	
		}
		
		 io.display( "TOTAL NUMBER OF ARTIFACTS OF THE PLAYER'S POSSESSION: " + totalArtifacts );
		 io.display("\n") ;
		 io.display("TOTAL SIZE OF THE PLAYER'S POSSESSION: " + art_totalSize);
		 io.display("\n") ;
		 io.display("TOTAL VALUE OF THE PLAYER'S POSSESSION: " + art_totalValue + "\n\n" );

	}
	
	
	
	// Function prints all artifacts contained in character's bag.
	void printCharacterArtifacts()
	{
		for( Map.Entry <String, Artifact> entry : artPlayer.entrySet()) 
		{
			  String key = entry.getKey();
			  Artifact value = entry.getValue();
			  
			  System.out.println("Name----->" +  value.getName());
			  System.out.println("Size-----> " +  value.getSize());
			  System.out.println("Value-----> " +   value.getValue());	
		}
	}
	
	void myArtifacts()
	{
		for( Map.Entry <String, Artifact> entry : artPlayer.entrySet()) 
		{
			  String key = entry.getKey();
			  Artifact value = entry.getValue();	  
			  io.display(value.getName().trim() + ",");
			  
		}
	}
	
	
}	
