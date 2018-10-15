
import java.util.ArrayList;
import java.util.Iterator;

public class Place 
{
	private int id;
	private String name;
	private String description;
	
	private ArrayList<Direction> directions = new ArrayList <Direction>(20);  // Vector of outgoing directions from this place ( an array of directions object).
	
	public Place( int idd, String namee, String descriptionn)
	{
		id=  idd;
		name = namee;
		description=  descriptionn;
		//System.out.println("YOYOYOYOYOYOYYOYOYY");
	}
	
	public String name()
	{
		return name;
	}
	
	public String description() 
	{
		return description;
	}
	
	public void addDirection ( Direction add_DirObject)
	{
		directions.add(add_DirObject);	
	}
	
	public Place followDirection ( String checkDirection)
	{	
		 for( int i=0; i < directions.size(); i++)
		 {
			 	 // If condition to check if the direction is valid or not.
			 if(checkDirection.equals( directions.get(i).right_direction()))
			 {
				 // If direction matches with direction object's direction, now again check that if the door is unlocked or not. 
				// System.out.println (" DIRECTION MATCHES");
				 return directions.get(i).follow();
			 }
		 } 
		 
		 System.out.println (" There is no direction from this DOOR....OH No, You are stuck at this Current Place:" + this.name());
		 return this;
	}
	
	public void print()
	{
		System.out.println (" Name of the place: " + this.name);
		System.out.println (" Description of the place: " + this.description);
		System.out.println ("\n");
		
		// Make this in for loop later.

		
		
		for ( int i=0 ; i < directions.size() ; i++)
		{
			//System.out.println (" enter.....");
			directions.get(i).print();
		}
	/*	if( directions.size()==3 )
		{
			directions.get(0).print();
			directions.get(1).print();
			directions.get(2).print();
		}
		
		if( directions.size()==2 )
		{
			directions.get(0).print();
			directions.get(1).print();
		}
		
		if( directions.size()==1 )
		{
			directions.get(0).print();
		}	  */
		System.out.println ("\n");	
		// Need to add more.
		
	}
	
	
	public void iter_dirObjects()
	{	
	 for( int i=0; i < directions.size() ; i++)
	 {
		 System.out.println ( this.name() + " leads to -----> " +  directions. get(i). showPlaceTo()+ " through direction: [" + directions. get(i).right_direction() + "] \n" );
	 }
	}
	
}
