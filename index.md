### Overview
Scramble is a Scrabble-clone game that is written in Java. The board and overall display of the game is rendered by the JavaFX GUI. 

The purpose of the game is for players to form interlocking words on the game board using letter tiles of different values. The game is over when there are no more tiles left in the bag- the player with the most points wins.

### Implemented Features:
- 15x15 game board
- 2-4 players 
- A scoreboard that displays updated player scores 
- An algorithm to check the validity of each word
- 7 tiles for each user 
- The ability for users to enter their player names before starting the game 
- Random letter generator for each player at the beginning of the game 

### Class Diagram of Scramble:

![](https://github.com/cpe305/fall2016-project-sonianara/blob/master/Class Diagram.png?raw=true)

### Design Patterns

- Singleton pattern: TileSet

The TileSet class represents all the potential Scrabble letter tiles from which players receive random letters. There ca only be one instance of this class for each game and it is a shared resource among several classes.  

- Singleton pattern: DictionarySearch class
 
The DictionarySearch class represents the entire Oxford English dictionary. This class primarily reads in a text file containing all the words in the dictionary and allows other classes to check if a word exists in the dictionary. 


### Walk-through

The welcome screen looks like the following: 

![](https://github.com/cpe305/fall2016-project-sonianara/blob/master/WelcomeScreen.png?raw=true)

When the "Begin" button is clicked, the following screen pops up: 

![](https://github.com/cpe305/fall2016-project-sonianara/blob/master/PlayerName.png?raw=true)

When at least two players have entered their names and clicked "Let's Play!", the board is displayed: 

![](https://github.com/cpe305/fall2016-project-sonianara/blob/master/Game.png?raw=true)

### Key Takeaways
- Build and manage to a project schedule
- Test frequently and early on 
- Brainstorm architecture and design patterns before starting to write any code
- Document code as the project is progressing
- If there are too many bugs and print statements don't help, it may be a good time to refactor

