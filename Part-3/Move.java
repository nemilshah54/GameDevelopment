
/*
 *  MOVE Class does the encapsulation of the decision making.
 *  
 */
public class Move 
{
	private MoveType type;
	private String argument;
	
	public enum MoveType
	{
		//GET,DROP,USE,GO,LOOK,EXIT,INVENTORY;  // Constants.
		
		GO ("GO"),
		GET ( "GET"),
		DROP ( "DROP"),
		USE ( "USE"),
		INVENTORY ( "INVENTORY"),
		LOOK ( "LOOK"),
		EXIT ( "EXIT"),
		QUIT ( "QUIT");

		public String text;
		
		MoveType ( String text)
		{
			this.text = text;
		}
	
		public boolean match (String s)
		{
		    return s.equalsIgnoreCase( text);
		}
		
	}
	
	// Default constructor for move.
	Move ( String typee, String argument)
	{
		 
		String arg = argument.trim();
		//type = MoveType.GET;  // initilaizing.
		
		for (   MoveType s :   MoveType.values())
		{
			if ( s.match ( typee))
			{
				type = s;
				break;
			}
		}

		this.argument  =   arg;

	}

	// Simple getters.
	public String getArgument ()
	{
		return  argument;
	}
	
	public MoveType getType  ()
	{
		return  type;
	}

}
