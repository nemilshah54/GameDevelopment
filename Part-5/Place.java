
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

/* 
 *  Methods:
 *  
 *  //Getters
 *  
 *  public String name()
 *  public String description() 
 *  public TreeMap < String, Artifact> getAllArtifacts() 
 *  public  ArrayList<Direction> dirArray ()
 *  
 *  // Methods.
 *  
 *  public Place(Scanner game) // Default constructor.
 *  static Place getPlaceByID ( int key)  // Static function returns the place by key.
 *  static Place getRandomPlace()   // Static function returns the random place.
 *  public void usekey( Artifact art)
 *  public void getFromPlayer ( Artifact get , String key)  
 *  public Artifact transfer ( String key) 
 *  public void addArtifact (String key, Artifact add_art) 
 *  public void deleteCharacter ( String key, Character value)
 *	public void addCharacter ( String key, Character add_CharObject)
 *	public void addDirection ( Direction add_DirObject)
 *  public Place followDirection ( String checkDirection)  // Trying to match user direction with all direction objects in place.
 * 
 *  
 *  // Debugging
 *  
 *   void printPlaceArtifacts()
 *   void placeCharacters()
 *   static void printAll( )
 * 
 */

public class Place 
{
	//---------------------------------------------------------------------------------------------------------------------//
	// Attribues of Places.
	//private IO io2;
	private String output;
	private int id;
	private String name;
	private String description;
	static boolean firstTime = true;    // Variable to switch of the first use of exit and nowhere place.
	
	// Containers.
	private ArrayList<Direction> directions = new ArrayList <Direction>(20);  //  Container for all outgoing Directions
	private TreeMap < String, Artifact> artPlace = new TreeMap < String, Artifact> ();     // Map container for all artifacts in this place.
	private TreeMap < String,  Character> characterPlace = new TreeMap < String, Character> ();  // Map container for all characters in this place
	static TreeMap < Integer, Place> tm = new TreeMap < Integer, Place > ();     // Map container to store static collection of known places.private ArrayList<Direction> directions = new ArrayList <Direction>(20);
    static ArrayList<Place> knownPlaces = new ArrayList <Place>(20);
	
	//---------------------------------------------------------------------------------------------------------------------//
	
	
	//---------------------------------------------------------------------------------------------------------------------//
	// Methods and other variables 
	static int flag =0;	           // Variable to switch of the first use of exit and nowhere place.   
	
	public int numArt;   // Count the number of artifacts.

	public Place(Scanner game) 
	{
		// Initially adding exit and nowhere place to static collection.
		if ( firstTime)
		{	
			if( flag ==0)
			{
				id = 1;
				name = "Exit";
				description = " Exit";
				tm.put(id, this);
				flag =1;
			}
			else
			{
				id = 0;
				name = "no where";
				description = "no where";
				tm.put(id, this);
				firstTime = false;
			}
		
		}	
		else
		{
			// Get a line and extend it as scanner input.. Parse and extract the data from scanner and initialze data fields of Place class.
			String line = null;
			line =  Game.getCleanLine(game);
			Scanner input = new Scanner (line);
		    
			// Parsing the data and plugging into data fields of Place class.
			id = input.nextInt();	
			String restOfLine = input.nextLine();
			name = restOfLine;
		
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
			 knownPlaces.add(this);
			tm.put(id, this);	      // Pushing this place to static collection of known places. ( Map).
		}
		
		//io2= new IO();
	}
	
	// Static function returns the place by key.
	static Place getPlaceByID ( int key)
	{
		return tm.get(key);
	}
	
	// Static function returns the random place.
	static Place getRandomPlace()
	{
		Place randomPlace =  knownPlaces.get( new Random().nextInt ( knownPlaces.size()));
		return randomPlace;
	}
	
	// Various getters funcitons.
	public String name()
	{
		return name;
	}
	
	public String description() 
	{
		return description;
	}
	
	public TreeMap < String, Artifact> getAllArtifacts() 
	{
		return artPlace;
	}
	
	public  ArrayList<Direction> dirArray ()
	{
		return directions;
	}

	public void usekey( Artifact art)
	{
		for( int i=0; i < directions.size(); i++)
		{
				directions.get(i).useKey(art);
		 } 
	
	} 
	
	// Transfer from player's bag to place.
	public void getFromPlayer ( Artifact get , String key)
	{
		artPlace.put( key, get);
	}
	
	// Transfer from place to player's bag.
	public Artifact transfer ( String key)
	{
		if ( artPlace.containsKey( key))
		{
			Artifact get = artPlace.get(key);
			artPlace.remove(key);
			return get;
		
		}
		else
		{
			System.out.println (" Sorry there is no artifact in this room") ;
			return null;
		}	
	}
	
	public void addArtifact (String key, Artifact add_art)
	{
		String noSpaceKey = null;  
		noSpaceKey = key.trim();
		numArt++;
		artPlace.put( noSpaceKey, add_art);	
	}
	
	public void deleteCharacter ( String key, Character value)
	{
		String noSpaceKey = null;  
		noSpaceKey = key.trim();
		
		characterPlace.remove(noSpaceKey);
	}
	
	public void addCharacter ( String key, Character add_CharObject)
	{
		
		String noSpaceKey = null;  
		noSpaceKey = key.trim();
		characterPlace.put( noSpaceKey, add_CharObject);
	}  

	
	public void addDirection ( Direction add_DirObject)
	{
		directions.add(add_DirObject);	
	}

	// Trying to match user direction with all direction objects in place.
	public Place followDirection ( String checkDirection)
	{	
		 for( int i=0; i < directions.size(); i++)
		 {
			 if(  directions.get(i).match( checkDirection))
			 {
				 // If direction matches with direction object's direction, now again check that if the door is unlocked or not. 
				 return directions.get(i).follow();
				 
			 }
		 } 
		 System.out.println ("There is no direction from this DOOR....OH No, You are stuck at this Current Place:" + this.name());
		 return this;
	}
	
	// Function prints all artifacts contained in this place.
	void printPlaceArtifacts()
	{
		for( Map.Entry <String, Artifact> entry : artPlace.entrySet()) 
		{
			  String key = entry.getKey();
			  Artifact value = entry.getValue();
			  
			 // System.out.println("Place Name: " +  this.name());
			  
			  System.out.println(" Artifact Name----->" +  value.getName());
			  System.out.println("Size-----> " +  value.getSize());
			  System.out.println("Value-----> " +   value.getValue() + " \n");	
		}
	}
	
	
	// Function prints all artifacts contained in this place. Function for Player.
	void placeArtifacts(IO io)
	{
		
		for( Map.Entry <String, Artifact> entry : artPlace.entrySet()) 
		{
			  String key = entry.getKey();
			  Artifact value = entry.getValue();
			  
			  if (! (value.getName().isEmpty()))
			  {
				   io.display( value.getName().trim() + ", ");
			  }

			  
			// System.out.print( value.getName().trim() + ", ");
		}
	}
	
	// Function prints all artifacts contained in this place. Function for NPC.
	void placeArtifacts()
	{
		
		for( Map.Entry <String, Artifact> entry : artPlace.entrySet()) 
		{
			  String key = entry.getKey();
			  Artifact value = entry.getValue();
			  
			  System.out.print( value.getName().trim() + ", ");
			  
			/*  if (! (value.getName().isEmpty()))
			  {
				   io.display( value.getName().trim() + ", ");
			  }  */
 
			// System.out.print( value.getName().trim() + ", ");
		}
	}
	
	void placeCharacters( IO io)
	{
		for( Map.Entry <String, Character> entry : characterPlace.entrySet()) 
		{
			  String key = entry.getKey();
			  Character value = entry.getValue();
			  
			  if (! (value.getName().isEmpty()))
			  {
				   io.display( value.getName().trim() + ", ");
			  }
			
			  //System.out.print( value.getName().trim() + ", ");
		}
	}
	
	
	void placeCharacters( )
	{
		for( Map.Entry <String, Character> entry : characterPlace.entrySet()) 
		{
			  String key = entry.getKey();
			  Character value = entry.getValue();
			  
			
			  System.out.print( value.getName().trim() + ", ");
		}
	}
	

	static void printAll( )
	{
		// Print all places.		
		for( Map.Entry <Integer, Place> entry : tm.entrySet()) 
		{
			  Place value = entry.getValue();
			  System.out.println("PLACE NAME:  " + value.name());
			value.printPlaceArtifacts();
			
		}
			
	}
	
}
