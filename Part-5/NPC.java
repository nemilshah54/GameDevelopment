import java.util.Scanner;

/*
 *  NPC is child of Character.
 *  
 *  Methods: 
 *  
 *  public NPC(Scanner game, double version) 
 *  public NPC(int id, String name, String des)
 *  void makeMove ()
 *  public void Display()
 *  
 */

public class NPC extends Character 
{
	
	Npc_Interface AI ;   // AI interface object.
	
//	Move no = N.getMove(null, null);
	
	public NPC(Scanner game, double version) 
	{
		super(game, version);
	     AI = new Npc_Interface ();
		// TODO Auto-generated constructor stub
	}
	
	void makeMove ()
	{
		super.io.display("hello");
		this.Display();
		
	
		// Step---1 Get the AI interface move.

		  Move nextMove =  AI.getMove( this, this.getCurr()  );   // Get the return status of the move.
		  System.out.println(  nextMove.getType().text + "  "  +  nextMove.getArgument() );
		
		  
		  // Step --2 Implementation.
		  
			if ( nextMove.getType().text.equalsIgnoreCase("GO"))
			{
			//	 Update the current place place.----------1	
				Place from  = super.getCurr();
			   super.setCurr(  super.getCurr().followDirection ( nextMove.getArgument() ));          // update the current place.
			   System.out.println ( "Now you are standing at: "  + super.getCurr().name());
			   Place to =  super.getCurr();
			
			// Update the Character collection in Place class.------------2
			   if ( !(from.name().equalsIgnoreCase(to.name())))
			   {
				   
				   super.health= super.health - super.art_totalSize; // Decrease the health.
				    
				    System.out.println ( "MY HEALTH ----> "  + super.health+ "\n");
				   
				   // Add the character ---------Place to.				 
				     to.addCharacter(this.getName(), this);
				     
				   // Delete the character ---- Place from.			   
				     from.deleteCharacter (this.getName(), this);
				     
					 System.out.print ("Characters in " + from.name().trim() + "---->(");
					  from.placeCharacters();
					 System.out.println ( ")"  + "\n");
				     
				 //	Place.printAll();
	 
			   }
	
	
			 if (super.getCurr().name().equalsIgnoreCase( "EXIT"))
					{
						System.out.println ("Congratulations " +  super.getName() + " , you won the Game!!!!!!!!!");
					
					}
			}
			
			
			else if (nextMove.getType().text.equalsIgnoreCase("GET"))
			{
				// Player can only add get three artifacts unless it is leather bag where they can hold 10 artifacts.
				//System.out.println ("numberL "+ super.totalArtifacts );
				if (super.totalArtifacts < 3  || super.leather_bag )
				{
					Artifact get = super.getCurr().transfer (nextMove.getArgument()  );
					
					if ( get!= null)
					{
						if ( nextMove.getArgument().equalsIgnoreCase("Leather bag"))
						{
							//System.out.println ("evdvdvd.....");
							super.leather_bag = true;
						}
						//super.getCurr().printPlaceArtifacts();
						artPlayer.put( nextMove.getArgument() , get);
						System.out.println ("Putting '" + nextMove.getArgument() +"' in the player's bag\n\n");
						
						 System.out.print ( "MY BAG--->(" );	 
						 super.myArtifacts();			 
						 System.out.println ( ")"  + "\n");
						 
						 System.out.print ("Artifacts in " +super.getCurr().name().trim() + "---->(");
						 super.getCurr().placeArtifacts();
						 System.out.println ( ")"  + "\n");
		
						totalArtifacts++;   // adds the number of artifacts in player's possesion.
						art_totalSize =  art_totalSize +  get.getSize();    // Update total size.
						art_totalValue = art_totalValue + get.getValue();   //  Update total value
					}
					else
					{
						System.out.println ("Nothing is added in this player's possesionss....");
					}
		
				}
				
				else
				{
					System.out.println ("You are not allowed to add more than 3 artifacts.");
				}
	
			}
			
			
			else if (nextMove.getType().text.equalsIgnoreCase("DROP"))
			{
			//  Transfer artifact from player's possessiton to Current place.
				if ( artPlayer.containsKey(  nextMove.getArgument() ))
				{
					System.out.println ("Dropping '" + nextMove.getArgument()  +"' from the player's bag\n\n");

					Artifact give = artPlayer.get( nextMove.getArgument() );
					super.getCurr().getFromPlayer (give, nextMove.getArgument() );
					artPlayer.remove( nextMove.getArgument() );
					
					 System.out.print ( "MY BAG--->(" );	 
					 super.myArtifacts();			 
					 System.out.println ( ")"  + "\n");
					 
					 System.out.print ("Artifacts in " +super.getCurr().name().trim() + "---->(");
					 super.getCurr().placeArtifacts();
					 System.out.println ( ")"  + "\n");
					 
		
					
					totalArtifacts--;  // adds the number of artifacts in player's possesion.
					art_totalSize =  art_totalSize -  give.getSize();    // Update total size.
					art_totalValue = art_totalValue - give.getValue();   //  Update total value
					
				}
				
				else
				{
					System.out.println (" Sorry this artifact isn't present in player's possesion");
				}
		
		   }
			
			else if (nextMove.getType().text.equalsIgnoreCase("USE"))
			{
				if ( artPlayer.containsKey(  nextMove.getArgument()))
					artPlayer.get( nextMove.getArgument()).use(this, this.getCurr());           // might need to change.
				else
				{
					System.out.println (" Sorry this artifact you are trying to use is not in player's possesion");
				}	
			}
	}
	
	
	public void Display()
	{
		 System.out.println ( "\nMY HEALTH ----> "  + super.health+ "\n");
		 System.out.println ( "You are standing: "  + super.getCurr().name() + "\n");
		 
		 System.out.print ("Artifacts in " +super.getCurr().name().trim() + "---->(");
		 super.getCurr().placeArtifacts();
		 System.out.println ( ")"  + "\n");
		 
		 System.out.print ("Characters in " +super.getCurr().name().trim() + "---->(");
		 super.getCurr().placeCharacters();
		 System.out.println ( ")"  + "\n");
		 
		 System.out.print ( "MY BAG--->( " );
	 
		 super.myArtifacts();
		 
		 System.out.println ( ")"  + "\n");
		 
		 System.out.print ( "AI MOVE--->");
	}

}
