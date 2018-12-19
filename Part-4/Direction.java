

import java.util.ArrayList;
import java.util.Scanner;


/*
 *  It contains enum DirType.
 *  
 *  Methods: 
 *  
 *  public Direction(Scanner game)  // CONSTRUCTOR BY SCANNING THE FILE.
 *  public String showPlaceTo ()
 *  public boolean doorStatus()
 *  public boolean match ( String s)
 *  public void lock ()
 *  public void unlock ()
 *  public boolean islocked ()
 *  public Place follow ()
 *  public void useKey ( Artifact art)
 *  
 *  // Getters.
 *  public Place getPlaceTo()  
 *	public DirType getDirection ()
 *  
 * 
 * 
 */
public class Direction 
{
	private int  direct_id;
	private Place Place_from;
	private Place Place_to;
	private DirType type;
	private boolean unlocked = true;     // DOOR IS LOCKED OR NOT.
	private int lockPattern;             // LOCK NUMBER TO MATCH WITH KEY NUMBER TO UNLOCK THE DOOR.
	

	
     // DirType implementation didnt success.
	enum DirType
	{
		
		// 19 named constants.
		NONE ( "None","None"),
		N ( "North","N"),
		S ( "South","S"),
		E ( "East","E"),
		W ( "West","W"),
		U ( "Up","U"),
		D ( "Down","D"),
		
		NE ( "NorthEast","NE"),
		NW ( "NorthWest" ,"NW"),
		SE ( "SouthEast", "SE"),
		SW ( "SouthWest", "SW"),
		NNE ( "North-NorthEast", "NNE"),
		NNW ( "North-NorthWest", "NNW"),
		
		ENE ( "East-NorthEast", "ENE"),
		ESE ( "East-SouthEast", "ESE"),
		WNW( "West-NorthWest", "WNW"),
		WSW ( "West-SouthWest", "WSW"),
		SSE ( "South-SouthEast", "SSE"),
		SSW ( "South-SouthWest", "SSW");

		public String text;
		private String Abb;
		
		DirType ( String text, String abb)
		{
			this.text = text;
			this.Abb = abb;
		}
		
		public boolean match ( String s)
		{
			if ( this  == NONE)
				return false;
			
			return s.equalsIgnoreCase( text) || s.equalsIgnoreCase(Abb);
		}
		
		public String toString()
		{
			return text;
		}

	   }      

	// CONSTRUCTOR BY SCANNING THE FILE.
	public Direction(Scanner game) 
	{
		// Get a line and extend it as scanner input.. Parse and extract the data from scanner and initialze data fields of Direction class.
		String line = null;
		int Pf =0;               // Get place_from id from data file to initialze Place_from place.
		int Pt =0;                // Get place_to id from data file to initialze Place_to place.
		line =  Game.getCleanLine(game);
		Scanner input = new Scanner (line);
		
		// Parsing the data and plugging into data fields of Direciton class.
		direct_id = input.nextInt();
		Pf = input.nextInt();
		Place_from = Place.getPlaceByID(Pf);
		//correct_direction = input.next();
		String d = input.next();
		
		type = DirType.NONE;  // initilaizing.
		
		for ( DirType s : DirType.values())
		{
			if ( s.match ( d))
			{
				type = s;
				break;
			}
		}
		
		
		Pt = input.nextInt();	
		if ( Pt <= 0 )    // If it is negative token, then lock the door.
			lock ();
		Pt = Math.abs (Pt);      // Make the negative value to Postive.
		
		Place_to = Place.getPlaceByID(Pt);
		lockPattern = input.nextInt();
		
		Place_from.addDirection(this);   // add direction object to the "Place from" Place.
	}

	// Various getter functions.
	public Place getPlaceTo()
	{
		return Place_to;
	}
	
	public DirType getDirection ()
	{
		return type;
	}
		
	

	
/*	public String right_direction ()
	{
		return correct_direction;
	}  */
	
	public String showPlaceTo ()
	{
		return Place_to.name();
	}
	
	public boolean doorStatus()
	{
		return unlocked;
	}
	
	public boolean match ( String s)
	{
		return type.match(s);
	}
	
	public void lock () { unlocked= false; }
	
	public void unlock ()
	{
		unlocked= true;
	}
	
	public boolean islocked ()
	{
		if (unlocked == true)
			return false;
		else
			return true;
	}
	
	// CHECK THE STATUS OF THE DOOR AND RETURNS BY THAT.
	public Place follow ()
	{
		if ( islocked() == false)
		{
			System.out.println ("'THE DOOR IS UNLOCKED'. PROCEED TO----> " + Place_to.name() + "\n\n");    //DEBUG.
			return Place_to;
		}
			
		else
		{	
			System.out.println ("'THE DOOR IS LOCKED'....OH No, You are stuck at this Current Place:" + Place_from. name() +"\n\n");
			return Place_from;	
		}
	}
	
	/*public void print()
	{
		System.out.println ("PLACE FROM:" + this.Place_from.name() + " ---->   PLACE TO:" + this.Place_to.name() + " by direction: (" + this.right_direction() + ")");
		System.out.println ("ID: " + direct_id);
		System.out.println ("DOOR STATUS: " + unlocked);
		System.out.println ("Lock Pattern: " + lockPattern + "\n\n");
		
		
	}  */
	
	// USING KEY IF THE KEY MATCHES WITH THE LOCK. If, then toggling the status of the door.
	public void useKey ( Artifact art)
	{
		if ( lockPattern == art.getKeyPattern())
		{
			System.out.println("WOW KEY MATCHESS.....TOGGLING THE STATE OF THE DOOR " + Place_to.name());
			System.out.println("DOOR STATUS: " + unlocked);
	
			// Toggling.
			if ( unlocked)
				lock();
			else
				unlock();
			
			System.out.println("DOOR STATUS: " + unlocked + "\n\n");
		}
		
		else
		{
			System.out.println("SORRY!!!!!!!! THE KEY DOESN'T MATCH to the door of" + Place_to.name());
		}
	}

}
