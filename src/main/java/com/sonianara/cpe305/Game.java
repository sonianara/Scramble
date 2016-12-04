package com.sonianara.cpe305;

import java.util.ArrayList;
import java.util.Arrays;

public class Game {

  int BOARDSIZE = 15;

  private Board mainBoard;
  private TileSet tileSet;
  private DictionarySearch dictionary;

  public Game() {

    this.mainBoard = new Board();
    // Initialize a unique TileSet for each game
    this.tileSet = new TileSet();

    this.dictionary = new DictionarySearch("words.txt");

  }

  public TileSet getTileSet() {
    return tileSet;
  }
  
  public DictionarySearch getDictionary() {
    return dictionary;
  }
  
  public String checkWords(ArrayList<Location> locs, char[][] board) {
    String word = "";
    int xDiff = locs.get(1).getX() - locs.get(0).getX() + 1;
    int yDiff = locs.get(1).getY() - locs.get(0).getY() + 1;
    
    if (locs.get(0).getY() == locs.get(1).getY()  || locs.size() == 1) {
      for (int i = 0; i < xDiff; i++) {
        word += board[locs.get(0).getX() + i][locs.get(0).getY()];
      }
    }
    else {
      for (int i = 0; i < yDiff; i++) {
        word += board[locs.get(0).getX()][locs.get(0).getY() + i];
      }
    }
    return word;
  }
  
  public Location getLeft(ArrayList<Location> locArray, char[][] board) {
    int i = 1;
    Location temp = new Location(locArray.get(0).getX(), locArray.get(0).getY());
    while ((locArray.get(0).getX() - 1 > 0) && (board[locArray.get(0).getX() - i][locArray.get(0).getY()]) != ' ') {
      temp = new Location(locArray.get(0).getX() - i, locArray.get(0).getY());
      i++;
    }
    return temp;
  }
  
  public Location getRight(ArrayList<Location> locArray, char[][] board) {
    int i = 0;
    Location temp = new Location(locArray.get(0).getX(), locArray.get(0).getY());

    while ((locArray.get(0).getX() + i < 15) && (board[locArray.get(0).getX() + i][locArray.get(0).getY()]) != ' ') {
      temp = new Location(locArray.get(0).getX() + i, locArray.get(0).getY());
      i++;
    }
    return temp;
  }
  
  public Location getTop(ArrayList<Location> locArray, char[][] board) {
    int i = 1;
    Location temp = new Location(locArray.get(0).getX(), locArray.get(0).getY());
    while ((locArray.get(0).getY() - i > 0) && board[locArray.get(0).getX()][locArray.get(0).getY() - i] != ' ') {
      temp = new Location(locArray.get(0).getX(), locArray.get(0).getY() - i);
      i++;
    }
    return temp;
  }
  
  public Location getBottom(ArrayList<Location> locArray, char[][] board) {
    int i = 0;
    Location temp = new Location(locArray.get(0).getX(), locArray.get(0).getY());
    while ((locArray.get(0).getY() + i < 15) && board[locArray.get(0).getX()][locArray.get(0).getY() + i] != ' ') {
      temp = new Location(locArray.get(0).getX(), locArray.get(0).getY() + i);
      i++;
    }
    return temp;
  }
  
  public ArrayList<Character> getEnteredLetters(ArrayList<Location> newLetters, char[][] board) {
    ArrayList<Character> chars = new ArrayList<Character>();
    
    for (int i = 0; i < newLetters.size(); i++) {
      chars.add(board[newLetters.get(i).getX()][newLetters.get(i).getY()]);
    }
    return chars;
  }
  
  
  public ArrayList<String> getWordsString(char [][] currentBoard) {
    
    char[][] previousBoard = mainBoard.getBoard();
    char[][] gameBoard = currentBoard;
       
    ArrayList<Location> newLetters = getNewLetterLocation(previousBoard, gameBoard);
    
 
    ArrayList<Character> charsEntered = getEnteredLetters(newLetters, gameBoard);
    ArrayList<String> newWords = allMyNewWords(newLetters, gameBoard);
    
    return newWords;
  }
  
  public boolean makeFinalMove(char[][] currentBoard, Player p) {
    
    char[][] previousBoard = mainBoard.getBoard();
    char[][] gameBoard = currentBoard;
   
    if (Arrays.deepEquals(previousBoard, gameBoard)) {
      return false;
    }
    
    boolean makemove = true;
    
    ArrayList<Location> newLetters = getNewLetterLocation(previousBoard, gameBoard);
    
    if (newLetters.size() < 2 && mainBoard.isEmpty()) {
      makemove = false;
    }
    
    ArrayList<Character> charsEntered = getEnteredLetters(newLetters, gameBoard);
    ArrayList<String> newWords = allMyNewWords(newLetters, gameBoard);
    int points = pointsForAll(newWords);
    
    int numberOfWrongLetters = isBlankLetter(charsEntered, p);  
    int numOfBlankLetters = containsBlankLetters(charsEntered);
    System.out.println("number of wrong letters" + numberOfWrongLetters);
    System.out.println("number of blank letters" + numOfBlankLetters);
    
    for (int i = 0; i < newWords.size(); i++) {
      System.out.println("word" + newWords.get(i));
    }
    
    if (isHorizontal(newLetters) == false && isVertical(newLetters) == false) {
      makemove = false;
    }
    
    if (numberOfWrongLetters > numOfBlankLetters) {
      makemove = false;
    }
    
    if (allWords(newWords) == false) {
      System.out.println("Shouldn't be here also ");
      makemove = false;
    }
    
    if (makemove == true) {
      mainBoard.setBoard(gameBoard);
      p.addPoints(points);
      replenishPlayerTiles(charsEntered, p);
    }
    System.out.println("makemove: " + makemove);
    return makemove;
  }
    
  public int containsBlankLetters(ArrayList<Character> enteredLetters) {
    int count = 0;
    for (int i = 0; i < enteredLetters.size(); i++) {
      if (Character.toLowerCase(enteredLetters.get(i)) == '_') {
        count++;
      }
    }
    return count;
  }
 
  
  public int isBlankLetter(ArrayList<Character> enteredLetters, Player p) {
    int count = 0;
    for (int i = 0; i < enteredLetters.size(); i++) {
      for (int j = 0; j < p.getPlayerSetSize(); j++) {
        if (Character.toLowerCase(enteredLetters.get(i)) == p.getPlayerSet().get(j).getLetter()) {
          count++;
          break;
        }
      }
    }
    return enteredLetters.size() - count;
  }
    
    public ArrayList<String> allMyNewWords(ArrayList<Location> locArray, char[][] gameBoard) {

      ArrayList<String> retString = new ArrayList<String>();
      ArrayList<Location> firstlast = new ArrayList<Location>();
      
      if (isHorizontal(locArray) || locArray.size() == 1) {
        firstlast.add(getLeft(locArray, gameBoard));
        firstlast.add(getRight(locArray, gameBoard));
      }
      else {
        firstlast.add(getTop(locArray, gameBoard));
        firstlast.add(getBottom(locArray, gameBoard));
      }
      
      retString.add(checkWords(firstlast, gameBoard));
      for (int i = 0; i < retString.size(); i++) {
      }
      
      return retString;
    }


  public void printString(ArrayList<String> str) {
    for (int i = 0; i < str.size(); i++) {
      System.out.println("word: " + str.get(i));
    }
  }
  
  public void getOtherHorizWords(ArrayList<Location> loc, char[][] board, ArrayList<String> retString) {
    for (int i = 0; i < loc.size(); i++) {
      ArrayList<Location> horiz = new ArrayList<Location>();
      horiz.add(loc.get(i));
      ArrayList<Location> checkHoriz = new ArrayList<Location>();
      checkHoriz.add(getTop(loc, board));
      checkHoriz.add(getBottom(loc, board));
      retString.add(checkWords(checkHoriz, board));
    }
  }
  
  public void getOtherVertWords(ArrayList<Location> loc, char[][] board, ArrayList<String> retString) {
    for (int i = 0; i < loc.size(); i++) {
      ArrayList<Location> vert = new ArrayList<Location>();
      vert.add(loc.get(i));
      ArrayList<Location> checkVert = new ArrayList<Location>();
      checkVert.add(getRight(loc, board));
      checkVert.add(getLeft(loc, board));
      retString.add(checkWords(checkVert, board));
    }
  }
  

  // Get the location of all the new letters
  public ArrayList<Location> getNewLetterLocation(char[][] previousBoard, char[][] gameBoard) {

    ArrayList<Location> newLocations = new ArrayList<Location>();
    for (int x = 0; x < BOARDSIZE; x++) {
      for (int y = 0; y < BOARDSIZE; y++) {
        if (previousBoard[x][y] != gameBoard[x][y]) {
          newLocations.add(new Location(x, y));
        }
      }
    }
    return newLocations;
  }
  

  public boolean checkValidityOfWords(ArrayList<String> newWords) {
    for (int i = 0; i < newWords.size(); i++) {
      if (dictionary.contains(newWords.get(i).toLowerCase()) || newWords.size() == 1 || newWords.get(i) == " " ||
          newWords.get(i) == "") {
        return true;
      }
    }
    return false;
  }
  
  public void printGameBoard(Board board) {
    for (int i = 0; i < 15; i++) {
      for (int j = 0; j < 15; j++) {
        if (Character.isAlphabetic(board.getChar(i, j))) {
          System.out.println(board.getChar(i, j));
        }
      }
    }
  }

  public ArrayList<String> getNewWords(ArrayList<Location> newLetters, Board gameBoard) {
    printGameBoard(gameBoard);
    ArrayList<String> allNewWords = new ArrayList<String>();
    
    if (isHorizontal(newLetters)) {
      for (int i = 0; i < newLetters.size(); i++) {
        if (i == newLetters.size() - 1) {
          if (bordersRight(gameBoard, newLetters.get(i))) {
            ArrayList<Location> arrLoc = traverseRight(newLetters.get(i), gameBoard);
            ArrayList<Character> word = getWord(gameBoard, arrLoc);
            String str = arraytoString(word);
            allNewWords.add(str);
          }
        }
        if (i == 0) {
          if (bordersLeft(gameBoard, newLetters.get(i))) {
            ArrayList<Location> arrLoc = traverseLeft(newLetters.get(i), gameBoard);
            ArrayList<Character> word = getWord(gameBoard, arrLoc);
            String str = arraytoString(word);
            allNewWords.add(str);
          }
        }
        if (bordersTop(gameBoard, newLetters.get(i))) {
          ArrayList<Location> arrLoc = traverseUp(newLetters.get(i), gameBoard);
          ArrayList<Character> word = getWord(gameBoard, arrLoc);
          String str = arraytoString(word);
          allNewWords.add(str);
        }
        if (bordersBottom(gameBoard, newLetters.get(i))) {
          ArrayList<Location> arrLoc = traverseDown(newLetters.get(i), gameBoard);
          ArrayList<Character> word = getWord(gameBoard, arrLoc);
          String str = arraytoString(word);
          allNewWords.add(str);
        }
      }
    }
    else if (isVertical(newLetters)) {
      for (int i = 0; i < newLetters.size(); i++) {
        if (bordersRight(gameBoard, newLetters.get(i))) {
          ArrayList<Location> arrLoc = traverseRight(newLetters.get(i), gameBoard);
          ArrayList<Character> word = getWord(gameBoard, arrLoc);
          String str = arraytoString(word);
          allNewWords.add(str);
        }
      
        if (bordersLeft(gameBoard, newLetters.get(i))) {
          ArrayList<Location> arrLoc = traverseLeft(newLetters.get(i), gameBoard);
          ArrayList<Character> word = getWord(gameBoard, arrLoc);
          String str = arraytoString(word);
          allNewWords.add(str);
        }
      
        if (i == newLetters.size() - 1) {
          if (bordersTop(gameBoard, newLetters.get(i))) {
            ArrayList<Location> arrLoc = traverseUp(newLetters.get(i), gameBoard);
            ArrayList<Character> word = getWord(gameBoard, arrLoc);
            String str = arraytoString(word);
            allNewWords.add(str);
          }
        }
        //if (i == 0 || i == newLetters.size() - 1) {
        if (i == 0) {
          if (bordersBottom(gameBoard, newLetters.get(i))) {
            ArrayList<Location> arrLoc = traverseDown(newLetters.get(i), gameBoard);
            ArrayList<Character> word = getWord(gameBoard, arrLoc);
            String str = arraytoString(word);
            allNewWords.add(str);
          }
        }
      }
    }
    return allNewWords;
  }
  
  

  public ArrayList<Location> traverseUp(Location loc, Board gameBoard) {
    int i = 0;
    ArrayList<Location> retLoc = new ArrayList<Location>();

    while (loc.getY() + i < 15) {
      if (gameBoard.getChar(loc.getX(), loc.getY() + i) != ' ') {
        retLoc.add(new Location(loc.getX(), loc.getY() + i));
      }
      i++;
    }
    return retLoc;
  }

  public ArrayList<Location> traverseDown(Location loc, Board gameBoard) {
    int i = 0;
    ArrayList<Location> retLoc = new ArrayList<Location>();

    while (loc.getY() - i >= 0) {
      if (gameBoard.getChar(loc.getX(), loc.getY() - i) != ' ') {
        retLoc.add(new Location(loc.getX(), loc.getY() - i));
      }
      i++;
    }
    return retLoc;
  }

  public ArrayList<Location> traverseRight(Location loc, Board gameBoard) {
    int i = 0;
    ArrayList<Location> retLoc = new ArrayList<Location>();

    while (loc.getX() + i < 15) {
      if (gameBoard.getChar(loc.getX() + i, loc.getY()) != ' ') {
        retLoc.add(new Location(loc.getX() + i, loc.getY()));
      }
      i++;
    }
    return retLoc;
  }

  public ArrayList<Location> traverseLeft(Location loc, Board gameBoard) {
    int i = 0;
    ArrayList<Location> retLoc = new ArrayList<Location>();

    while (loc.getX() - i >= 0) {
      if (gameBoard.getChar(loc.getX() - i, loc.getY()) != ' ') {
        retLoc.add(new Location(loc.getX() - i, loc.getY()));
      }
      i++;
    }
    return retLoc;
  }
  
  public int pointsForAll(ArrayList<String> words) {
    int total = 0;
    for (int i = 0; i < words.size(); i++) {
      total += calculatePointsForWord(words.get(i));
    }
    return total;
  }

  // tested
  public int calculatePointsForWord(String str) {
    int totalPoints = 0;
    for (int i = 0; i < str.length(); i++) {
      totalPoints += TileSet.getLetterValue(str.charAt(i));
    }
    
    return totalPoints;
  }

  public boolean isHorizontal(ArrayList<Location> locArray) {
    for (int i = 0; i < locArray.size() - 1; i++) {
      //if (locArray.get(i).getX() == (locArray.get(i + 1).getX() - 1)
       //   || (locArray.get(i).getX() == (locArray.get(i + 1).getX() + 1))) {
        if (!(locArray.get(i).getY() == locArray.get(i + 1).getY())) {
          return false;
        }
     // }
    }
    return true;
  }

  public boolean isVertical(ArrayList<Location> locArray) {
    for (int i = 0; i < locArray.size() - 1; i++) {
      if (!(locArray.get(i).getX() == locArray.get(i + 1).getX())) {
        //if (locArray.get(i).getY() == (locArray.get(i + 1).getY() - 1)
        //    || (locArray.get(i).getY() == (locArray.get(i + 1).getY() + 1))) {
        //  return true;
        //}
        return false;
      }
    }
    return true;
  }

  public ArrayList<Location> traverseLeftCoordinates(ArrayList<Location> arrLoc, Board wholeBoard) {

    ArrayList<Location> leftLetters = new ArrayList<Location>();
    Location leftestLetter = getLeftLetter(arrLoc);
    int i = 0;

    while (leftestLetter.getX() - i >= 0) {
      if (wholeBoard.getChar(leftestLetter.getX() - i, leftestLetter.getY()) != ' ') {
        leftLetters.add(new Location(leftestLetter.getX() - i, leftestLetter.getY()));
      }
      i++;
    }
    return leftLetters;
  }

  public ArrayList<Location> traverseRightCoordinates(ArrayList<Location> arrLoc,
      Board wholeBoard) {

    ArrayList<Location> rightLetters = new ArrayList<Location>();
    Location rightestLetter = getRightLetter(arrLoc);
    int i = 0;

    while (rightestLetter.getX() + i < 15) {
      if (wholeBoard.getChar(rightestLetter.getX() + i, rightestLetter.getY()) != ' ') {
        rightLetters.add(new Location(rightestLetter.getX() + i, rightestLetter.getY()));
      }
      i++;
    }
    return rightLetters;
  }

  public ArrayList<Location> traverseUpperCoordinates(ArrayList<Location> arrLoc,
      Board wholeBoard) {

    ArrayList<Location> upperLetters = new ArrayList<Location>();
    Location topLetter = getTopLetter(arrLoc);
    int i = 0;

    while (topLetter.getY() + i < 15) {
      if (wholeBoard.getChar(topLetter.getX(), topLetter.getY() + i) != ' ') {
        upperLetters.add(new Location(topLetter.getX(), topLetter.getY() + i));
      }
      i++;
    }
    return upperLetters;
  }

  public ArrayList<Location> traverseLowerCoordinates(ArrayList<Location> arrLoc,
      Board wholeBoard) {

    ArrayList<Location> lowestLetters = new ArrayList<Location>();
    Location bottomLetter = getBottomLetter(arrLoc);
    int i = 0;

    while (bottomLetter.getY() - i >= 0) {
      if (wholeBoard.getChar(bottomLetter.getX(), bottomLetter.getY() - i) != ' ') {
        lowestLetters.add(new Location(bottomLetter.getX(), bottomLetter.getY() - i));
      }
      i++;
    }
    return lowestLetters;
  }

  public void printArrayTiles(ArrayList<LetterTile> letterSet) {
    for (int i = 0; i < 15; i++) {
      System.out.println(letterSet.get(i).getLetter());
    }
  }

  public void printChars(ArrayList<Character> arr) {
    for (int i = 0; i < arr.size(); i++) {
      System.out.println(arr.get(i));
    }
  }

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

  public ArrayList<Character> getWord(Board currentGameBoard, ArrayList<Location> locArray) {
    ArrayList<Character> word = new ArrayList<Character>();

    for (int i = 0; i < locArray.size(); i++) {
      word.add(currentGameBoard.getChar(locArray.get(i).getX(), locArray.get(i).getY()));
    }
    return word;
  }

  public String arraytoString(ArrayList<Character> letters) {
    StringBuilder builder = new StringBuilder(letters.size());
    for (Character ch : letters) {
      builder.append(ch);
    }

    return builder.toString().toLowerCase();
  }
  
  public boolean allWords(ArrayList<String> words) {
    for (int i = 0; i < words.size(); i++) {
      String w = words.get(i).toLowerCase();
      System.out.println("Checking: " + w);
      if (isWord(w)) {
        return true;
      }
    }
    return false;
  }

  public boolean isWord(String word) {
    if (dictionary.contains(word)) {
      return true;
    }
    return false;
  }

  public boolean checkWord(ArrayList<Location> locArray, Board currentGameBoard) {
    boolean isWord = false;
    ArrayList<Character> tempArray = new ArrayList<Character>();
    tempArray = getWord(currentGameBoard, locArray);
    String word = arraytoString(tempArray);
    if (isWord(word)) {
      isWord = true;
    }
    return isWord;
  }

  public boolean bordersLeft(Board previousGameBoard, Location coordinates) {
    char c = previousGameBoard.getChar(coordinates.getX() - 1, coordinates.getY());
    if (Character.isAlphabetic(c) == false) {
      return false;
    }
    return true;
  }

  public boolean bordersRight(Board previousGameBoard, Location coordinates) {
    char c = previousGameBoard.getChar(coordinates.getX() + 1, coordinates.getY());
    if (Character.isAlphabetic(c) == false)  {
      return false;
    }
    return true;
  }

  public boolean bordersBottom(Board previousGameBoard, Location coordinates) {
    char c = previousGameBoard.getChar(coordinates.getX(), coordinates.getY() - 1);
    if (Character.isAlphabetic(c) == false) {
      return false;
    }
    return true;
  }

  public boolean bordersTop(Board previousGameBoard, Location coordinates) {
    char c = previousGameBoard.getChar(coordinates.getX(), coordinates.getY() + 1);
    if (Character.isAlphabetic(c) == false) {
      return false;
    }
    return true;
  }

  // if the word is vertical, get the coordinate of the top-most letter
  public Location getTopLetter(ArrayList<Location> coords) {

    Location largest = coords.get(0);

    if (isVertical(coords)) {
      for (int i = 0; i < coords.size(); i++) {
        if (coords.get(i).getY() > largest.getY()) {
          largest = coords.get(i);
        }
      }
    }
    return largest;
  }

  // if the word is vertical, get the coordinate of the bottom-most letter
  public Location getBottomLetter(ArrayList<Location> coords) {

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

  // if the word is horizontal, get the coordinate of the left-most letter
  public Location getLeftLetter(ArrayList<Location> coords) {

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

  // if the word is horizontal, get the coordinate of the right-most letter
  public Location getRightLetter(ArrayList<Location> coords) {

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

  public boolean isAdjacentToAWord(Board previousGameBoard, ArrayList<Location> coordinates) {

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

  public boolean playedFromRack(Player p, ArrayList<Location> coordinates, Board currentGameBoard) {
    ArrayList<Character> temp = getWord(currentGameBoard, coordinates);
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

  public boolean isValid(Player p, ArrayList<Location> coordinates, Board previousGameBoard) {
    if (playedFromRack(p, coordinates, previousGameBoard)
        && isAdjacentToAWord(previousGameBoard, coordinates)
        && checkWord(coordinates, previousGameBoard)) {
      return true;
    }
    return false;
  }

  public boolean isValidMovePlayerOne(Player p, ArrayList<Location> coordinates,
      Board previousGameBoard) {
    if (playedFromRack(p, coordinates, previousGameBoard)
        && checkWord(coordinates, previousGameBoard)) {
      return true;
    }
    return false;
  }
  
  public void replenishPlayerTiles(ArrayList<Character> playedLetters, Player p) {
    for (int i = 0; i < playedLetters.size(); i++) {
      char c = Character.toLowerCase(playedLetters.get(i));
      p.deleteTile(c);
    }
   while (p.getPlayerSetSize() < 7) {
     p.getPlayerSet().add(tileSet.getRandomLetter());
   }
  }
}