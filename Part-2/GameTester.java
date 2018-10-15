
// Name: Nemil R Shah
// netID: nshah213
// UIN: 670897116

// HEADER-------------------------------------------------------------------------------------------------------------------------

// In this program, World is created of artifacts, places, directions by processing the input process file. Input file is passed by scanner in 
// Game class, and then further extended to different classes reading the entire file. 
// The programs run by play method. There are 18 differenet commands for going to different places. The four new commands get,drop, use and 
// inventory updates the player possesions.
// Commands like GET, USE AND DROP are applied by 
// 1) GET Brasskey   ( Take the artifact. Note : Please type the name of artifact exactly as the name defined in input file.
// 2) DROP Brasskey   ( Drop the artifact. Note : Please type the name of artifact exactly as the name defined in input file.
// 3) USE Brasskey   ( Use the artifact. Note : Please type the name of artifact exactly as the name defined in input file.
// 4) INVE... Displays the information for player's possessiosn.
// 
// WIN----GO TO THE EXIT PLACE, and you will win the Game.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 

public class GameTester 
{
	public static void main ( String args[]) throws FileNotFoundException
	{
		System.out.println (" Name: Nemil Shah");
		System.out.println (" netID: nshah213\n\n");
	
		// File input.
		File text = new File ("Mystic City 3.1 GDF.txt");
		Scanner scan = new Scanner (text);	
		Game game = new Game (scan);
		
	  //  game.print();	
		game.play();
	
	}
}
