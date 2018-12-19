import java.util.ArrayList;
import java.util.Map;
import java.util.Random;


/*
 *  THIS IS TO IMPLEMENT THE AI INTERACE.
 *  
 *  Methods: 
 *  
 *  public Move getMove(Character me, Place Curr_Place)
 *  
 */
public class Npc_Interface implements DecisionMaker 
{
	
	
	private static ArrayList<Move> randomMoves = new ArrayList <Move>(20);   // Random list of moves.
	private ArrayList<String> randomDir = new ArrayList <String>(20);   // Random list of moves.

	public Move getMove(Character me, Place Curr_Place)
	{
		// Random number alrogirthm.
		// Adding moves for GO.
		
		for ( int i=0; i < Curr_Place.dirArray().size(); i++)
		{
			//System.out.println("Direction: " +   Curr_Place.dirArray().get(i).getDirection().text);
			Move temp = new Move ("GO", Curr_Place.dirArray().get(i).getDirection().text );
			randomMoves.add(temp);
		}
		
		// Adding moves for GET..AI tries to get possible artifacts in that Current Place.
		for( Map.Entry <String, Artifact> entry : Curr_Place.getAllArtifacts().entrySet()) 
		{
			  String key = entry.getKey();
			  Artifact value = entry.getValue();
			  
			 // System.out.println("Name----->" +  key);	  
			  Move temp = new Move ("GET", key);  // Initilialize move object.
			  randomMoves.add(temp);
			  
			
		}
		
		// Adding moves for DROP and USE. AI tries to DROP and USE all artifacts possessed in his bag.
			for( Map.Entry <String, Artifact> entry : me.artPlayer.entrySet()) 
			{
				  String key = entry.getKey();
				  Artifact value = entry.getValue();
				  
				  //System.out.println("Name----->" +  key);	  
				  Move temp = new Move ("DROP", key);  // Initilialize move object.
				  randomMoves.add(temp);
				  
				  Move flag = new Move ("USE", key);  // Initilialize move object.
				  randomMoves.add(flag);
			
			}
				
		 // Step to return any random moves.		
			Move AImove = randomMoves.get( new Random().nextInt (randomMoves.size()));         // AI random move selected.
			return AImove;
	}
	
	
	 static void printrandomMoves ()
	{
		 System.out.println(" TOTAL RANDOM MOVES ARE : ");
		 
		for ( Move m:  randomMoves )
		{
			
			System.out.println( m.getType().text + "  "  + m.getArgument() );
		}
	}


}
