
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Place 
{
	private int id;
	private String name;
	private String description;
	static boolean firstTime = true;    // Variable to switch of the first use of exit and nowhere place.
	static int flag =0;	           // Variable to switch of the first use of exit and nowhere place.        
	private ArrayList<Direction> directions = new ArrayList <Direction>(20);  // Vector of outgoing directions from this place ( an array of directions object).
	private TreeMap < String, Artifact> artPlace = new TreeMap < String, Artifact> ();     // Map container to store all artifacts in this place.
	static TreeMap < Integer, Place> tm = new TreeMap < Integer, Place > ();     // Map container to store static collection of known places. 
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
		
			tm.put(id, this);	      // Pushing this place to static collection of known places. ( Map).
		}
	}
	
	// Static function returns the place by key.
	static Place getPlaceByID ( int key)
	{
		return tm.get(key);
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
	
	public void addArtifact (String key, Artifact add_art)
	{
		String noSpaceKey = null;  
		noSpaceKey = key.trim();
		numArt++;
		artPlace.put( noSpaceKey, add_art);	
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

	public void addDirection ( Direction add_DirObject)
	{
		directions.add(add_DirObject);	
	}
	
	// Trying to match user direction with all direction objects in place.
	public Place followDirection ( String checkDirection)
	{	
		 for( int i=0; i < directions.size(); i++)
		 {
			 	 // If condition to check if the direction is valid or not.
			 if(checkDirection.equals( directions.get(i).right_direction()))
			 {
				 // If direction matches with direction object's direction, now again check that if the door is unlocked or not. 
				 return directions.get(i).follow();
			 }
		 } 
		 System.out.println ("There is no direction from this DOOR....OH No, You are stuck at this Current Place:" + this.name());
		 return this;
	}
	
	public void print()
	{
		System.out.println ("ID of the place: " + this.id);
		System.out.println ("Name of the place: " + this.name);
		System.out.println ("Description of the place: " + this.description);	
		System.out.println ("\n");
		
		// Make this in Range for loop later.
		// Prints out the possible directions from this place.
		for ( int i=0 ; i < directions.size() ; i++)
		{
			directions.get(i).print();
		}
		
		// Printing all the artifacts this place has.
		System.out.println ("This place has following artifacts: ");
		
		for( Map.Entry <String, Artifact> entry : artPlace.entrySet()) 
		{
			  String key = entry.getKey();
			  Artifact value = entry.getValue();

			  System.out.println("Name----->" +  value.getName());
			  System.out.println("Size-----> " +  value.getSize());
			  System.out.println("Value-----> " +   value.getValue());
		}
		 
		System.out.println ("\n");	  
	}
  
	// Function prints all artifacts contained in this place.
	void printPlaceArtifacts()
	{
		for( Map.Entry <String, Artifact> entry : artPlace.entrySet()) 
		{
			  String key = entry.getKey();
			  Artifact value = entry.getValue();
			  
			  System.out.println("Name----->" +  value.getName());
			  System.out.println("Size-----> " +  value.getSize());
			  System.out.println("Value-----> " +   value.getValue());	
		}
	}

	// Debuggng functions.
	public void iter_dirObjects()
	{	
	 for( int i=0; i < directions.size() ; i++)
	 {
		 System.out.println ( this.name() + " leads to -----> " +  directions. get(i). showPlaceTo()+ " through direction: [" + directions. get(i).right_direction() + "] \n" );
	 }
	}
	
}
