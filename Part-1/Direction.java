// Name: Nemil R Shah
// netID: nshah213
// UIN: 670897116


import java.util.ArrayList;

public class Direction 
{
	private int  direct_id;
	private Place Place_from;
	private Place Place_to;
	private String correct_direction;
	private boolean unlocked = true;
	
	public Direction(int id, Place from, Place to, String dir)
	{
		direct_id =  id;
		Place_from = from;
		Place_to = to;
		correct_direction = dir;
	}
	
	public Place getPlaceTo()
	{
		return Place_to;
	}
	
	public String right_direction ()
	{
		return correct_direction;
	}
	
	public String showPlaceTo ()
	{
		return Place_to.name();
	}
	
	public boolean match ( String s)
	{
		return false;
	}
	
	public void lock ()
	{
		unlocked= false;
	}
	
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
	
	public Place follow ()
	{
		if ( islocked() == false)
		{
			System.out.println (" THE DOOR IS UNLOCKED. You are about to proceed at  " + Place_to.name());    //DEBUG.
			return Place_to;
		}
			
		else
		{	
			System.out.println (" THE DOOR IS LOCKED....OH No, You are stuck at this Current Place:" + Place_from. name());
			return Place_from;	
		}
	}
	
	public void print()
	{
		System.out.println (" PLACE FROM:" + this.Place_from.name() + " ---->   PLACE TO:" + this.Place_to.name() + " by direction: (" + this.right_direction() + ")");
	}	

}
