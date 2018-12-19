import java.util.Scanner;



/*
 *  Player is child of Character.
 *  
 *  Methods: 
 *  
 *  public Player(Scanner game, double version) 
 *  public Player(int id, String name, String des)
 *  void makeMove ()
 *  public void Display()
 *  
 */
public class Player extends Character 
{
	// Reference to userInterface method.

	
	PlayerInterface UI;


	public Player(Scanner game, double version) 
	{
		super(game, version);
	    UI = new PlayerInterface() ;   // P object reference to UI 
		// TODO Auto-generated constructor stub
	}
	

	public Player(int id, String name, String des) 
	{
		super (id, name, des);
		UI = new PlayerInterface() ; 
	
	}

	void makeMove ()
	{
		// Original Play Game for this Character starts here.
		
			this.Display();
		     
		  //Step ---1  get the move
			Move nextMove =  UI.getMove( this, this.getCurr()  );   // Get the return status of the move.
			
			if (  nextMove == null )
			{
				  System.out.println ( "NoT a valid Command...Please read instructions");
				  return;
			}
				
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
				     
				 //	Place.printAll();  //Set for debugging.
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
					artPlayer.get( nextMove.getArgument()).use( this, this.getCurr());           // might need to change.
				else
				{
					System.out.println (" Sorry this artifact you are trying to use is not in player's possesion");
				}	
			}
			
			else if (nextMove.getType().text.equalsIgnoreCase("INVENTORY") || nextMove.getType().text.equalsIgnoreCase("INVE") )
			{
				inventory ( );
			
			}
			
			else if (nextMove.getType().text.equalsIgnoreCase("EXIT") || nextMove.getType().text.equalsIgnoreCase("QUIT") )
			{
				   System.exit(0);
			}
			
			else if (nextMove.getType().text.equalsIgnoreCase("LOOK") )
			{
				this.Display();  // might need to change later.
			}
			
			else
			{
				System.out.println ("Do nothing");
			}

		

	}
	
	// Displaying the Player's Information...........
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
			 
			 System.out.print ( "PLEASE MAKE A MOVE--->");
		}

}
