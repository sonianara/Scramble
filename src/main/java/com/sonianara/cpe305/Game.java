package com.sonianara.cpe305;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



/**
 * This class contains all of the game logic 
 */
public class Game {

  int boardSize = 15;

  private Board mainBoard;
  TileSet tileSet = TileSet.getInstance();
  private DictionarySearch dictionary;
  private static Game instance;


  /**
   * This constructor represents the initialization
   * of a board, a bag of tiles, and the dictionary 
   */
  private Game() {

    this.mainBoard = new Board();
    // Initialize a unique TileSet for each game

    this.dictionary = DictionarySearch.getInstance();

  }

  public TileSet getTileSet() {
    return tileSet;
  }
  
  public DictionarySearch getDictionary() {
    return dictionary;
  }
  
  /**
   * Implementing the Singleton get instance function
   * @return the Game object 
   */
  public static Game getInstance() {
    if (instance == null) {
      instance = new Game();
    }
    return instance;
  }
  
  /**
   * This function returns a string containing a word
   * using letters placed on a board
   * @param locs a list of the new locations 
   * @param board
   * @return
   */
  public String checkWords(List<Location> locs, char[][] board) {
    StringBuilder sb = new StringBuilder();
    int xDiff = locs.get(1).getX() - locs.get(0).getX() + 1;
    int yDiff = locs.get(1).getY() - locs.get(0).getY() + 1;
    
    if (locs.get(0).getY() == locs.get(1).getY()  || locs.size() == 1) {
      for (int i = 0; i < xDiff; i++) {
        sb.append(Character.toString(board[locs.get(0).getX() + i][locs.get(0).getY()]));
      }
    }
    else {
      for (int i = 0; i < yDiff; i++) {
        sb.append(Character.toString(board[locs.get(0).getX()][locs.get(0).getY() + i]));
      }
    }
    return sb.toString();
  }
  
  /**
   * Instantiate a char board to all empty spots
   * @param b board
   */
  public void instantiateBoard(char [][] b) {
    for (int i = 0; i < 15; i++) {
      for (int j = 0; j < 15; j++) {
        b[i][j] = ' ';
      }
    }
  }
  
  /**
   * This function returns the location of the leftmost letter
   * @param locArray the list of locations of the new letters
   * @param board
   * @return
   */
  public Location getLeft(List<Location> locArray, char[][] board) {
    int i = 1;
    Location temp = new Location(locArray.get(0).getX(), locArray.get(0).getY());
    while ((locArray.get(0).getX() - 1 > 0) && (board[locArray.get(0).getX() - i][locArray.get(0).getY()]) != ' ') {
      temp = new Location(locArray.get(0).getX() - i, locArray.get(0).getY());
      i++;
    }
    return temp;
  }
  
  /**
   * This function returns the location of the right-most letter 
   * @param locArray the list of locations of the new letters
   * @param board
   * @return
   */
  public Location getRight(List<Location> locArray, char[][] board) {
    int i = 0;
    Location temp = new Location(locArray.get(0).getX(), locArray.get(0).getY());

    while ((locArray.get(0).getX() + i < 15) && (board[locArray.get(0).getX() + i][locArray.get(0).getY()]) != ' ') {
      temp = new Location(locArray.get(0).getX() + i, locArray.get(0).getY());
      i++;
    }
    return temp;
  }
  
  /**
   * This function returns the location of the top-most letter
   * @param locArray the list of locations of the new letters
   * @param board
   * @return
   */
  public Location getTop(List<Location> locArray, char[][] board) {
    int i = 1;
    Location temp = new Location(locArray.get(0).getX(), locArray.get(0).getY());
    while ((locArray.get(0).getY() - i > 0) && board[locArray.get(0).getX()][locArray.get(0).getY() - i] != ' ') {
      temp = new Location(locArray.get(0).getX(), locArray.get(0).getY() - i);
      i++;
    }
    return temp;
  }
  
  /**
   * This function returns the location of the bottom-most letter
   * @param locArray the list of locations of the new letters
   * @param board
   * @return
   */
  public Location getBottom(List<Location> locArray, char[][] board) {
    int i = 0;
    Location temp = new Location(locArray.get(0).getX(), locArray.get(0).getY());
    while ((locArray.get(0).getY() + i < 15) && board[locArray.get(0).getX()][locArray.get(0).getY() + i] != ' ') {
      temp = new Location(locArray.get(0).getX(), locArray.get(0).getY() + i);
      i++;
    }
    return temp;
  }
  
  /**
   * 
   * @param newLetters
   * @param board
   * @return the list of characters given the new locations on the board 
   */
  public List<Character> getEnteredLetters(List<Location> newLetters, char[][] board) {
    List<Character> chars = new ArrayList<>();
    
    for (int i = 0; i < newLetters.size(); i++) {
      chars.add(board[newLetters.get(i).getX()][newLetters.get(i).getY()]);
    }
    return chars;
  }
  
  /**
   * 
   * @param currentBoard
   * @return a list of all the new words formed on the board 
   */
  public List<String> getWordsString(char [][] currentBoard) {
    
    char[][] previousBoard = mainBoard.getBoard();
    char[][] gameBoard = currentBoard;
       
    List<Location> newLetters = getNewLetterLocation(previousBoard, gameBoard);
    return allMyNewWords(newLetters, gameBoard);
  }
  
  
  /**
   * 
   * @param currentBoard with the new location of letters 
   * @param p current player 
   * @return whether the words played were valid 
   */
  public boolean makeFinalMove(char[][] currentBoard, Player p) {
    
    char[][] previousBoard = mainBoard.getBoard();
    char[][] gameBoard = currentBoard;
   
    if (Arrays.deepEquals(previousBoard, gameBoard)) {
      return false;
    }
    
    boolean makemove = true;
    
    List<Location> newLetters = getNewLetterLocation(previousBoard, gameBoard);
    
    if (newLetters.size() < 2 && mainBoard.isEmpty()) {
      makemove = false;
    }
    
    List<Character> charsEntered = getEnteredLetters(newLetters, gameBoard);
    List<String> newWords = allMyNewWords(newLetters, gameBoard);
    int points = pointsForAll(newWords);
    
    int numberOfWrongLetters = isBlankLetter(charsEntered, p);  
    int numOfBlankLetters = containsBlankLetters(charsEntered);
 
    
    if (!isHorizontal(newLetters) && !isVertical(newLetters)) {
      makemove = false;
    }
    
    if (numberOfWrongLetters > numOfBlankLetters) {
      makemove = false;
    }
    
    if (!allWords(newWords)) {
      makemove = false;
    }
    
    if (makemove) {
      mainBoard.setBoard(gameBoard);
      p.addPoints(points);
      replenishPlayerTiles(charsEntered, p);
    }
    return makemove;
  }
    
  /**
   * 
   * @param charsEntered
   * @return the number of blank letter in the list of characters played
   */
  public int containsBlankLetters(List<Character> charsEntered) {
    int count = 0;
    for (int i = 0; i < charsEntered.size(); i++) {
      if (Character.toLowerCase(charsEntered.get(i)) == '_') {
        count++;
      }
    }
    return count;
  }
 
  /**
   * 
   * @param charsEntered
   * @param p player
   * @return the number of wrong letters played
   */
  public int isBlankLetter(List<Character> charsEntered, Player p) {
    int count = 0;
    for (int i = 0; i < charsEntered.size(); i++) {
      for (int j = 0; j < p.getPlayerSetSize(); j++) {
        if (Character.toLowerCase(charsEntered.get(i)) == p.getPlayerSet().get(j).getLetter()) {
          count++;
          break;
        }
      }
    }
    return charsEntered.size() - count;
  }
    
  /**
   * 
   * @param locArray
   * @param gameBoard
   * @return a list of all of the new words played on the board 
   */
    public List<String> allMyNewWords(List<Location> locArray, char[][] gameBoard) {

      List<String> retString = new ArrayList<>();
      List<Location> firstlast = new ArrayList<>();
      
      if (isHorizontal(locArray) || locArray.size() == 1) {
        firstlast.add(getLeft(locArray, gameBoard));
        firstlast.add(getRight(locArray, gameBoard));
      }
      else {
        firstlast.add(getTop(locArray, gameBoard));
        firstlast.add(getBottom(locArray, gameBoard));
      }
      
      retString.add(checkWords(firstlast, gameBoard));
      
      return retString;
    }


  /**
   * Prints out the string
   * Used for debugging purposes
   * @param str list of strings
   */
  public void printString(List<String> str) {
    for (int i = 0; i < str.size(); i++) {
      System.out.println("word: " + str.get(i));
    }
  }
  
  /**
   * This function checks all possible horizontal words 
   * @param loc list of new locations 
   * @param board game board
   * @param retString 
   */
  public void getOtherHorizWords(List<Location> loc, char[][] board, List<String> retString) {
    for (int i = 0; i < loc.size(); i++) {
      ArrayList<Location> horiz = new ArrayList<>();
      horiz.add(loc.get(i));
      ArrayList<Location> checkHoriz = new ArrayList<>();
      checkHoriz.add(getTop(loc, board));
      checkHoriz.add(getBottom(loc, board));
      retString.add(checkWords(checkHoriz, board));
    }
  }
  
  /**
   * This function checks all possible verticle words
   * @param loc list of new locations
   * @param board game board
   * @param retString
   */
  public void getOtherVertWords(List<Location> loc, char[][] board, List<String> retString) {
    for (int i = 0; i < loc.size(); i++) {
      ArrayList<Location> vert = new ArrayList<>();
      vert.add(loc.get(i));
      ArrayList<Location> checkVert = new ArrayList<>();
      checkVert.add(getRight(loc, board));
      checkVert.add(getLeft(loc, board));
      retString.add(checkWords(checkVert, board));
    }
  }
  

  /**
   * Get the location of all new letters 
   * @param previousBoard
   * @param gameBoard
   * @return
   */
  public List<Location> getNewLetterLocation(char[][] previousBoard, char[][] gameBoard) {

    List<Location> newLocations = new ArrayList<>();
    for (int x = 0; x < boardSize; x++) {
      for (int y = 0; y < boardSize; y++) {
        if (previousBoard[x][y] != gameBoard[x][y]) {
          newLocations.add(new Location(x, y));
        }
      }
    }
    return newLocations;
  }
  
  /**
   * Check if all the words played are valid words in the dictionary 
   * @param newWords
   * @return
   */
  public boolean checkValidityOfWords(List<String> newWords) {
    for (int i = 0; i < newWords.size(); i++) {
      if (dictionary.contains(newWords.get(i).toLowerCase()) || newWords.size() == 1 || newWords.get(i) == " " ||
          newWords.get(i) == "") {
        return true;
      }
    }
    return false;
  }
  
  /**
   * Print the game board 
   * @param board
   */
  public void printGameBoard(Board board) {
    for (int i = 0; i < 15; i++) {
      for (int j = 0; j < 15; j++) {
        if (Character.isAlphabetic(board.getChar(i, j))) {
          System.out.println(board.getChar(i, j));
        }
      }
    }
  }

/**
 * This function starts with a given location and traverses all the way up
 * while there are still letters in that direction
 * @param loc
 * @param gameBoard
 * @return a list of locations on the traversal up 
 */
  public List<Location> traverseUp(Location loc, Board gameBoard) {
    int i = 0;
    List<Location> retLoc = new ArrayList<>();

    while (loc.getY() + i < 15) {
      if (gameBoard.getChar(loc.getX(), loc.getY() + i) != ' ') {
        retLoc.add(new Location(loc.getX(), loc.getY() + i));
      }
      i++;
    }
    return retLoc;
  }

  /**
   * This function starts with a given location and traverses all the way down
   * while there are still letters in that direction
   * @param loc
   * @param gameBoard
   * @return a list of locations on the traversal down 
   */
  public List<Location> traverseDown(Location loc, Board gameBoard) {
    int i = 0;
    List<Location> retLoc = new ArrayList<>();

    while (loc.getY() - i >= 0) {
      if (gameBoard.getChar(loc.getX(), loc.getY() - i) != ' ') {
        retLoc.add(new Location(loc.getX(), loc.getY() - i));
      }
      i++;
    }
    return retLoc;
  }

  /**
   * This function starts with a given location and traverses right
   * while there are still letters in that direction
   * @param loc
   * @param gameBoard
   * @return a list of locations on the traversal to the right 
   */
  public List<Location> traverseRight(Location loc, Board gameBoard) {
    int i = 0;
    List<Location> retLoc = new ArrayList<>();

    while (loc.getX() + i < 15) {
      if (gameBoard.getChar(loc.getX() + i, loc.getY()) != ' ') {
        retLoc.add(new Location(loc.getX() + i, loc.getY()));
      }
      i++;
    }
    return retLoc;
  }

  /**
   * This function starts with a given location and traverses left
   * while there are still letters in that direction
   * @param loc
   * @param gameBoard
   * @return a list of locations on the traversal to the left 
   */
  public List<Location> traverseLeft(Location loc, Board gameBoard) {
    int i = 0;
    List<Location> retLoc = new ArrayList<>();

    while (loc.getX() - i >= 0) {
      if (gameBoard.getChar(loc.getX() - i, loc.getY()) != ' ') {
        retLoc.add(new Location(loc.getX() - i, loc.getY()));
      }
      i++;
    }
    return retLoc;
  }
  
  /**
   * 
   * @param newWords a string of words played 
   * @return the number of points for each word in the string 
   */
  public int pointsForAll(List<String> newWords) {
    int total = 0;
    for (int i = 0; i < newWords.size(); i++) {
      total += calculatePointsForWord(newWords.get(i));
    }
    return total;
  }

  /**
   * 
   * @param str A word 
   * @return the number of points for one word 
   */
  public int calculatePointsForWord(String str) {
    int totalPoints = 0;
    for (int i = 0; i < str.length(); i++) {
      totalPoints += TileSet.getLetterValue(str.charAt(i));
    }
    
    return totalPoints;
  }

  
  /**
   * 
   * @param newLetters the list of locations of newly placed letters 
   * @return if the word played is horizontal 
   */
  public boolean isHorizontal(List<Location> newLetters) {
    for (int i = 0; i < newLetters.size() - 1; i++) {
      if (newLetters.get(i).getY() != newLetters.get(i + 1).getY()) {
        return false;
      }
    }
    return true;
  }

  /**
   * 
   * @param newLetters the list of locations of newly placed letters
   * @return if the word played is vertical 
   */
  public boolean isVertical(List<Location> newLetters) {
    for (int i = 0; i < newLetters.size() - 1; i++) {
      if (newLetters.get(i).getX() != newLetters.get(i + 1).getX()) {
        return false;
      }
    }
    return true;
  }

 /**
  * Prints the list of letters played 
  * @param letterSet
  */
  public void printArrayTiles(List<LetterTile> letterSet) {
    for (int i = 0; i < 15; i++) {
      System.out.println(letterSet.get(i).getLetter());
    }
  }

  /**
   * Prints the characters in an array 
   * @param arr
   */
  public void printChars(List<Character> arr) {
    for (int i = 0; i < arr.size(); i++) {
      System.out.println(arr.get(i));
    }
  }

  /**
   * Prints the character at the x and y coordinate if the location 
   * on the board is not empty 
   * @param board
   */
  public void printBoard(char[][] board) {
    for (int i = 0; i < 15; i++) {
      for (int j = 0; j < 15; j++) {
        if (board[i][j] != ' ') {
          char c = board[i][j];
          System.out.println(c);
        }
      }
    }
  }

  /**
   * 
   * @param currentGameBoard
   * @param arrLoc
   * @return an arraylist of c
   */
  public List<Character> getWord(Board currentGameBoard, List<Location> arrLoc) {
    List<Character> word = new ArrayList<>();

    for (int i = 0; i < arrLoc.size(); i++) {
      word.add(currentGameBoard.getChar(arrLoc.get(i).getX(), arrLoc.get(i).getY()));
    }
    return word;
  }

  /**
   * 
   * @param word
   * @return a string that represents a list of characters 
   */
  public String arraytoString(List<Character> word) {
    StringBuilder builder = new StringBuilder(word.size());
    for (Character ch : word) {
      builder.append(ch);
    }

    return builder.toString().toLowerCase();
  }
  
  /**
   * 
   * @param words
   * @return if the string of words are all valid words in the dictionary 
   */
  public boolean allWords(List<String> words) {
    for (int i = 0; i < words.size(); i++) {
      String w = words.get(i).toLowerCase();
      System.out.println("Checking: " + w);
      if (isWord(w)) {
        return true;
      }
    }
    return false;
  }

  /**
   *
   * @param word
   * @return if the dictionary contains the given word 
   */
  public boolean isWord(String word) {
    if (dictionary.contains(word)) {
      return true;
    }
    return false;
  }

  /**
   * 
   * @param locArray
   * @param currentGameBoard
   * @return if the given list of locations forms a valid word
   */
  public boolean checkWord(List<Location> locArray, Board currentGameBoard) {
    boolean isWord = false;
    List<Character>tempArray = getWord(currentGameBoard, locArray);
    String word = arraytoString(tempArray);
    if (isWord(word)) {
      isWord = true;
    }
    return isWord;
  }

  /**
   * 
   * @param previousGameBoard
   * @param coordinates - A single location 
   * @return if there is a letter bordering the left of the given location 
   */
  public boolean bordersLeft(Board previousGameBoard, Location coordinates) {
    char c = previousGameBoard.getChar(coordinates.getX() - 1, coordinates.getY());
    if (!Character.isAlphabetic(c)) {
      return false;
    }
    return true;
  }
  
  /**
   * 
   * @param previousGameBoard
   * @param coordinates - A single location 
   * @return if there is a letter bordering the right of the given location 
   */
  public boolean bordersRight(Board previousGameBoard, Location coordinates) {
    char c = previousGameBoard.getChar(coordinates.getX() + 1, coordinates.getY());
    if (!Character.isAlphabetic(c))  {
      return false;
    }
    return true;
  }

  /**
   * 
   * @param previousGameBoard
   * @param coordinates - A single location 
   * @return if there is a letter bordering the bottom of the given location 
   */
  public boolean bordersBottom(Board previousGameBoard, Location coordinates) {
    char c = previousGameBoard.getChar(coordinates.getX(), coordinates.getY() - 1);
    if (!Character.isAlphabetic(c)) {
      return false;
    }
    return true;
  }

  /**
   * 
   * @param previousGameBoard
   * @param coordinates - A single location 
   * @return if there is a letter bordering the top of the given location  
   */
  public boolean bordersTop(Board previousGameBoard, Location coordinates) {
    char c = previousGameBoard.getChar(coordinates.getX(), coordinates.getY() + 1);
    if (!Character.isAlphabetic(c)) {
      return false;
    }
    return true;
  }

  /**
   * The word must be vertical first 
   * @param coordinates
   * @return the coordinate of the top-most letter 
   */
  public Location getTopLetter(List<Location> coordinates) {

    Location largest = coordinates.get(0);

    if (isVertical(coordinates)) {
      for (int i = 0; i < coordinates.size(); i++) {
        if (coordinates.get(i).getY() > largest.getY()) {
          largest = coordinates.get(i);
        }
      }
    }
    return largest;
  }

  /**
   * The word must be vertical first 
   * @param coords
   * @return the coordinate of the bottom-most letter 
   */
  public Location getBottomLetter(List<Location> coords) {

    Location smallest = coords.get(0);

    if (isVertical(coords)) {
      for (int i = 0; i < coords.size(); i++) {
        if (coords.get(i).getY() < smallest.getY()) {
          smallest = coords.get(i);
        }
      }
    }
    return smallest;
  }

  /**
   * The word must be horizontal first 
   * @param coords
   * @return the coordinate of the left-most letter 
   */
  public Location getLeftLetter(List<Location> coords) {

    Location smallest = coords.get(0); // x-value

    if (isHorizontal(coords)) {
      for (int i = 0; i < coords.size(); i++) {
        if (coords.get(i).getX() < smallest.getX()) {
          smallest = coords.get(i);
        }
      }
    }
    return smallest;
  }
  
  
  /**
   * The word must be horizontal first 
   * @param coords
   * @return the coordinate of the right-most letter 
   */
  public Location getRightLetter(List<Location> coords) {

    Location largest = coords.get(0);

    if (isHorizontal(coords)) {
      for (int i = 0; i < coords.size(); i++) {
        if (coords.get(i).getX() > largest.getX()) {
          largest = coords.get(i);
        }
      }
    }
    return largest;
  }

  /**
   * 
   * @param previousGameBoard
   * @param coordinates placed on the board 
   * @return if the list of letters played are played adjacent to already played letters
   */
  public boolean isAdjacentToAWord(Board previousGameBoard, List<Location> coordinates) {

    boolean isAdjacent = false;

    for (int i = 0; i < coordinates.size(); i++) {
      if (isHorizontal(coordinates)) {
        Location leftest = getLeftLetter(coordinates);
        Location rightest = getRightLetter(coordinates);
        if (bordersTop(previousGameBoard, coordinates.get(i))
            || bordersBottom(previousGameBoard, coordinates.get(i))) {
          if (bordersLeft(previousGameBoard, leftest)
              || bordersRight(previousGameBoard, rightest)) {
            isAdjacent = true;
          }
        }
      } else if (isVertical(coordinates)) {
        Location topmost = getTopLetter(coordinates);
        Location bottomost = getBottomLetter(coordinates);
        if (bordersLeft(previousGameBoard, coordinates.get(i))
            || bordersRight(previousGameBoard, coordinates.get(i))) {
          if (bordersTop(previousGameBoard, topmost)
              || bordersBottom(previousGameBoard, bottomost)) {
            isAdjacent = true;
          }
        }
      }
    }
    return isAdjacent;
  }

  /**
   * 
   * @param p Player 
   * @param coordinates list of locations of new letters 
   * @param currentGameBoard
   * @return if the letters played are contained in the player's rack 
   */
  public boolean playedFromRack(Player p, List<Location> coordinates, Board currentGameBoard) {
    List<Character> temp = getWord(currentGameBoard, coordinates);
    boolean flag = true;

    for (int i = 0; i < temp.size(); i++) {
      for (int j = 0; j < p.getPlayerSet().size(); j++) {
        if (temp.get(i) == p.getPlayerSet().get(j).getLetter()) {
          break;
        }
        if (j == p.getPlayerSet().size()) {
          flag = false;
        }
      }
    }
    return flag;
  }

  /**
   * Replenishes the player's rack
   * Removes letters that the player played and adds letters from the bag 
   * @param charsEntered
   * @param p player 
   */
  public void replenishPlayerTiles(List<Character> charsEntered, Player p) {
    for (int i = 0; i < charsEntered.size(); i++) {
      char c = Character.toLowerCase(charsEntered.get(i));
      p.deleteTile(c);
    }
   while (p.getPlayerSetSize() < 7) {
     p.getPlayerSet().add(tileSet.getRandomLetter());
   }
  }
}