import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


/*  Artifacts are materials present in room or in player's bag.
 * 
 *  Methods: 
 *  
 *  public Artifact ( Scanner game )
 *  
 *  //Methods.
 *  
 *  public void use(  Character me, Place here)
 *  public void print()
 *  
 *  // Getters.
 *  public String getName()
 *	public String getDescription() 
 *  public int getValue() 
 *  public int getSize() 
 *  public int getKeyPattern() 
 * 
 */

public class Artifact 
{
	private String name;   
	private String description;
	private int value;      // Cost or worth of an artifact 
	private int size;      // Size of artifact
	private int keyPattern;    // Key to be match with lockPattern.
	private int id;
	
	// Scanner Constructer to initialize all data of Artifactss.
	public Artifact ( Scanner game )
	{
		// Get a line and extend it as scanner input.. Parse and extract the data from scanner and initialze data fields of Artifact class.
		String line = null;
		line =  Game.getCleanLine(game);
		Scanner input = new Scanner (line);
		
		int source = input.nextInt();        // Source to put this artifact.
	
		String lin = null;
		lin =  Game.getCleanLine(game);
		Scanner inp = new Scanner (lin);
		
		// Parsing the tokens from input line.
		 
		//  System.out.println("Input is " +  inp.nextLine());
		id = inp.nextInt();
		value = inp.nextInt();
		size = inp.nextInt();
		keyPattern = inp.nextInt();
		
		String restOfLine = inp.nextLine();
		name = restOfLine;
		int number = game.nextInt();  
	
		// Loop to get the three lines description in  "description" field.
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
		
		if ( source < 0)    // Goes in desired character possessions.
		{
			source =Math.abs (source);
			Character desiredCharacter =  Character.getCharacterByID(source);
			desiredCharacter.addArtifact(name, this);
		}
		
		else if ( source > 0)    // Goes in desired place
		{
			Place  desiredPlace  =  Place.getPlaceByID(source); 
			desiredPlace.addArtifact(name, this);
		}
		
		else if ( source == 0)  // Goes in random place.
		{
			Place  randomPlace  =  Place.getRandomPlace();
			randomPlace.addArtifact(name, this);
		}
		
		//myPlace.addArtifact(name,this);    // This artifact goes in this place.
	
	}
	
	// Various getter functions of thiss class.
	public String getName()
	{
		return name;
	}
	
	public String getDescription() 
	{
		return description;
	}
	
	public int getValue() 
	{
		return value;
	}
	
	public int getSize() 
	{
		return size;
	}
	
	public int getKeyPattern() 
	{
		return keyPattern;
	}
	
	public void print()
	{
		System.out.println (" ID of the artifact: " + this.id);
		System.out.println (" Name of the artifact: " + this.name);
		System.out.println (" Value of the artifact: " + this.value);
		System.out.println (" Size of the artifact: " + this.size);
		System.out.println (" KeyPattern of the artifact: " + this.keyPattern);
		System.out.println (" Description of the place: " + this.description);	
		System.out.println ("\n");
	}
	
	// Use the artifact.
	public void use(  Character me, Place here)
	{
		if ( keyPattern > 0 )
		{
			here.usekey(this);
		}
		

		else if ( name.trim().equalsIgnoreCase("Purple potion"))
		{
			me.health = 500;
			me.artPlayer.remove(name.trim());
			System.out.println ( "Maximising the health to -->" + me.health );
		}
		
		// Improve health by using this artifact.
		else if (value >= 100  &&  !(name.equalsIgnoreCase("Purple potion")))
		{
			me.health = me.health+ 50;
		//	System.out.println ( "Remvoing artifact name: " + name );
			me.artPlayer.remove(name.trim()); /// need to remove.
			System.out.println ( "Increasing the health to " + me.health );
		}
		else
		{
			System.out.println ( "This artifact cant be use at this moment\n\n");
		}
	}


}
