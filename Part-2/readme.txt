Name: Nemil R Shah.
netid: nshah213
UIN: 670897116


// RUN THE PROGRAM.

1) To run the program, do normally make, compile and run. Input data file is grabbed by the File object created in GameTester class, and reads the entire file

Note: PLEASE PLEASE , PUT THE INPUT DATA TEXT FILE IN THE GAME CLASS DIRECTORY.
// Documentation.

The makefile has five java files with each class defined in it. The World is created by parsing the data input file. The job of Game tester class is to create a 
 Put the input file ("Mystic City.txt") in the directory of Game folder. File object now grabs this input text file and attaches it to the scanner, and then passes
 this scanner to the "Game Class". A loop in game class runs the entire input file. 
 
 // Game Class.
 
 --> It creates the entire world by file input processing and has a play implemnetation method.
 
 1) File input processing.
 
 a) Initially the loop calls "getcleanLine" function which extracts and trim the spaces. Now this line is attached to scanner. Thereby, grabbing the 
 tokens from that line and processing ahead. getcleanLine() function is static, so it is used by all classes.
 
 b) Contains multiple "if else-if" conditions to pass the scanner to 'Place, Direction, and Artifact' Class.

 2) Play method:
 
 a) Given three new commands :
 --> USE Brass key -- > Uses this artifact.
  --> GET Brass key -- > Get this artifact.
   --> DROP Brass key -- > Drop this artifact.
   
  " Please make sure that type the name of artifact exactly as the name written in the input file.
  
  b) Invenotry command will print all information for player's possessions.
  
  c) For the 18 different directions, I have created the "enum class", but I failed to implement it. So I have created 18 if else if conditions to
  use 18 different commands to go to different place.
  
  d) Other commands are same as project 1.
 
