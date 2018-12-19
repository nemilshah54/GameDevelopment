Name: Nemil R Shah.
netid: nshah213
UIN: 670897116

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
  
  1) Player's Turn ----Name.
  2) Player's Current Place.
  3) Artifacts in that Current Place. ( By this, you can Decide what artifacts you want).
  4) Characters in that Current Place. ( By this, you can see who are at this place).
  5) Player's BAG. ( To see that what player actually has). Note: Invenotry command gives the list of all possesion, value and mobility.
  6) Input Command. ( It can be by 'User' or 'AI'.
  7) Repeat.
  
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
   
  
  
 