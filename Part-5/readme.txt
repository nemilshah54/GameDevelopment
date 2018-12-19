Names: Nemil R Shah, Wishy Parikh, Harshil Patel.
netids: nshah213
UINs: 670897116

// RUN THE PROGRAM

1) First of all 'put the input data file in Game class directory' for which you need to make the world.

Commands: make
          java GameTester.
By this, it successfuly creates the world and you are ready to play the game.

  2) File input processing.
  
  -  This is similar to HW2. All the changes required for the project are implemented successfully.
  
  3) PLAY METHOD.
  
  - Mutiple characters can play the game.
  - For playing the game, Please read the instructions shown at the starting of the game.
  
  Implementation and Notices:
  
  - Write the commands appropriately for the proper implementation of the game.
  - Each Player and NPC will get only one move at a time. (Even if it is LOOK, EXIT etc commands will still counted as a move.
  - For AI interface, it is smart and will only make valid moves.
  
  When you play the game, you will see following output design.
  
  1) Player's Turn ----Name and display of Player's health.
  2) Player's Current Place.
  3) Artifacts in that Current Place. ( By this, you can Decide what artifacts you want).
  4) Characters in that Current Place. ( By this, you can see who are at this place).
  5) Player's BAG. ( To see that what player actually has). Note: Invenotry command gives the list of all possesion, value and mobility.
  6) Input Command. ( It can be by 'User' or 'AI'.
  7) Repeat.

 Some new rules:

	1) Each player is allowed to take only 3 artifacts
        2) If you want to take more than 3 artifacts, grab the leather bag. Leather bag allows you to take any number of artifacts.
	3) Each Player is given 500 points of initial health.
	4) Player's health decreases when he goes from one room to another. Amount of heath decrease depends upon the total weightage in bag.
	   For example, if total weightage of bag is 40 and player's health is 500. Then going from 'Place A' -->'Place B' will reduce its health 
	   to 460. 
	   Health formula:
 	   New health = Old health - total weight of load(bag) carried.
        5) Player can increase the health by using the artifacts of gold whose value is more than 100. 
           For example, using artifacts like Pot O Gold, sparkling rubies will increase the health of player by 50 points.
	   Note: By using the artifact, it will be removed from the player's possession.
	6) Purple potion maximizes the health of player to 500 points.


   Note: All NPC characters will take their turn automatically and update everything. 
   For example: If there are 4 characters :
   1) Player 2) Npc 3) Npc 4) Npc. By this, keyboard input will only for Player 1 and Player 4. Player 2 and Player 3 information will played 
   automatically after player 1. So next time, the turn will be for Player 4.
   
   The above oupput design is made to make player's life easy and make their own strategies.
  
  
  'AI interface implementation':
  
  - For AI, I have created all possible valid moves. Inshort, it contains array of all valid moves. 
  - Then, it randomly selects the index of that array and that move object gets return.
  
  EXTRA NOTICES:
  
  1)  "Please make sure that type the name of artifact is exactly as the name written in the input file.
   
  
  
 