
// Name: Nemil R Shah
// netID: nshah213
// UIN: 670897116


public class GameTester 
{
	public static void main ( String args[])
	{
		System.out.println (" Name: Nemil Shah");
		System.out.println (" netID: nshah213");
		
		String gameName = " WORLD OF TRAPPED ROOMS";
		
		Game game= new Game (gameName);    // Creates the game object.
		//Game game (gameName);
		
		// HardCode the 6 Places object and 15 direction objects.
		
		
		// Creation of Six objects of Places.
		 Place EH = new Place (0, " Entrace hall", "\"*You are standing in the entrance hall of the great six-room dungeon\\r\\n\" + \r\n" + 
		 		"				\"*There are doors to the east and north, and a stairway leading down\\r\\n\" + \r\n" + 
		 		"				\"*The main exit ( from the game ) is to the west\"");
		 
		 Place OL = new Place (1, " Orge's Lair", "*You have entered the Ogre's Lair!  Better leave before he wakes up . . .\r\n" + 
					"*There are doors to the south and the east");
		 
		 Place PS = new Place (2, " Potions Storeroom",  "*This room has shelves full of bottles and jars\r\n" + 
					"*Some labels read \"Powdered bat's wings\" and \"Toad eyes\".\r\n" + 
					"*There is a door to the east, and a stairway leading up.");
		 
		 Place PL = new Place (3," Potions lab",  "*There is a cauldron of thick green goop here, \r\n" + 
					"*bubbling slowly over a cool blue flame.\r\n" + 
					"*Doors lead to the west and east.");
		 
		 Place POE = new Place (4," Pool of enchantement", "*You are in a round room with a clear enchanting pool of water.\r\n" + 
					"*There are doors to the north and west.\r\n" + 
					"*There is a slide leading downwards to the floor below.");
		 
		 Place TS = new Place (5," Treasure Storeroom",  "*You have found a storeroom full of gold, jewels, and treasure!\r\n" + 
					"*There are doors to the north and south.");
		 
		 Place EXIT = new Place (6,"EXIT", " This is exit place and once entered you will win the game.");
		 
		 Place NoWhere = new Place (7,"NoWhere", "There is no way from here.");
		 
		 
 // Creation of 15 objects of Directions.
		 
		 // OUTGOING EDGES OF ENTRANCE HALL
		 Direction EH_POF = new Direction (0, EH, POE, "EAST" );
		 Direction EH_OL = new Direction (1, EH, OL, "NORTH" );
		 Direction EH_PS = new Direction (2, EH, PS, "DOWN" ); 
		 Direction EH_EXIT = new Direction (2, EH, EXIT, "WEST" );
		 
		 EH.addDirection(EH_POF);
		 EH.addDirection(EH_OL);
		 EH.addDirection(EH_PS);
		 EH.addDirection( EH_EXIT);
		 
		 
		 
		// OUTGOING EDGES OF OL
		 Direction OL_TS  = new Direction (3, OL, EH, "SOUTH" );
		 Direction OL_EH = new Direction (4, OL, TS, "EAST" ); 
		 OL.addDirection( OL_TS);
		 OL.addDirection(OL_EH);
		 
		 // OUTGOING EDGES OF POTIONS STOREROOM
		 Direction PS_EH = new Direction (5, PS, EH, "UP" );
		 Direction PS_PL = new Direction (6, PS, PL, "EAST" ); 
		 PS.addDirection( PS_EH);
		 PS.addDirection( PS_PL);
		 PS_PL.lock();    //LOCKS THE DOOR.
		 
		 
		 //  OUTGOING EDGES OF POTIONS LAB
		 Direction PL_NoWhere= new Direction (7, PL, NoWhere, "EAST" );
		 Direction PL_PS= new Direction (7, PL , PS, "WEST" );
		 PL.addDirection( PL_NoWhere);
		 PL.addDirection(PL_PS);
		 PL_NoWhere.lock();    //LOCKS THE DOOR.
		 
		 //  OUTGOING EDGES OF POL OF ENCHANTEMENT
		 Direction POL_PL = new Direction (7,  POE, PL, "DOWN" );
		 Direction POL_TS = new Direction (8,  POE, TS, "NORTH" ); 
		 Direction POL_EH = new Direction (9,  POE, EH, "WEST" ); 
		 POE.addDirection( POL_PL);
		 POE.addDirection(POL_TS );
		 POE.addDirection( POL_EH );
		 POL_TS.lock();          // LOCKS THE DOOR.
		      
		 
		 //  OUTGOING EDGES OF POL OF ENCHANTEMENT
		 Direction TS_OL = new Direction (10, TS, OL, "NORTH" );
		 Direction TS_POL = new Direction (11, TS, POE, "SOUTH" ); 
		 TS.addDirection( TS_OL);
		 TS.addDirection(TS_POL);
		 
		 game.addPlace(EH);
		 game.addPlace(OL);
		 game.addPlace(PS);
		 game.addPlace(PL);
		 game.addPlace(POE);
		 game.addPlace(TS);
		 
		 
		//game.addPlace();
		//game.print();
		 
		//EH.print();
		
		
		//OL.print();
		
		// GAME STARTS HERE BY.
		
		game.play();
		
		
	}
}
