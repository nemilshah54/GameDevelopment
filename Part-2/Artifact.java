import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

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
		int Place_location = 0;
		Place_location  = input.nextInt();   // throw artifact in this place.
		Place myPlace =  Place.getPlaceByID(Place_location);  
	
		
		String lin = null;
		lin =  Game.getCleanLine(game);
		Scanner inp = new Scanner (lin);
		
		// Parsing the tokens from input line.
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
			description = a.next();	
			//System.out.println ( " Description  " +   description);
		}	
		
		myPlace.addArtifact(name,this);    // This artifact goes in this place.
	
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
	public void use()
	{
		if ( keyPattern > 0 )
		{
			Place curr =  Game.getCurrentPlace();
			curr.usekey(this);
		}
		else
		{
			System.out.println ( "This artifact cant be use at this moment\n\n");
		}
	}


}
