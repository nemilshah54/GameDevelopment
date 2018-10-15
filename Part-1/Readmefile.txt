Name: Nemil R Shah.
netid: nshah213
UIN: 670897116


// DOCUMENTATION.

The makefile has four java files with each class defined in it. In the gametest class, the world is created and Hard coded. World contains vector of 8 places,
and 15 directions objects. There are 3 classes i.e 1) Place class, 2) Direction Class 3) Game class. All the three classes has private members and methods 
defined in it which was mentioned in pdf.

The real implementation of game is done in Game class which is done in method play(). The play() has display() method in it which contains the algorithm 
of the entire "Game". The display method does the following tasks.

1)Loop for playing the game. Loop continues untill the player reaches to the Exit place.
2) At first, displays the current place.
3) Prompt for userInput. If it is exit, quit, or look, it will do the tasks which were mentioned in pdf.
4) I have developed optimum enhancement for the userInput so if the user says "north" , "GO North", and many other inputs are valid to go for
North direction. Upper case or lower case won't matter since I have ignore the case.
5) Now the follow.direction() will update the current place by two cases:
a) If the door has valid direction. If it has then it will do in follow() function of direction class and see if the door is locked or unlcoked.
b) If the door is locked or unlocked.

Note:
1)Place ids and direction ids are randomly assigned for now.
2) print() method of every classs will help you to see all classes are working properly.