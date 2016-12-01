package com.sonianara.cpe305;

import java.util.ArrayList;

public class Game {

  int BOARDSIZE = 15;

  private TileSet tileSet;
  private ArrayList<Location> newWords;
  private DictionarySearch dictionary;

  public Game() {

    // Initialize a unique TileSet for each game
    this.tileSet = new TileSet();

    this.dictionary = new DictionarySearch("words.txt");

    this.newWords = new ArrayList<Location>();
  }

  public TileSet getTileSet() {
    return tileSet;
  }

  // Get the location of all the new letters
  public ArrayList<Location> getNewLetterLocation(Board currentGameBoard, Board previousGameBoard) {
    for (int x = 0; x < BOARDSIZE; x++) {
      for (int y = 0; y < BOARDSIZE; y++) {
        if (currentGameBoard.getChar(x, y) != previousGameBoard.getChar(x, y)) {
          newWords.add(new Location(x, y));
        }
      }
    }
    return newWords;
  }

  public boolean checkValidityOfWords(ArrayList<String> newWords) {
    for (int i = 0; i < newWords.size(); i++) {
      if (!dictionary.contains(newWords.get(i))) {
        return false;
      }
    }
    return true;
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
    System.out.println("Printing in method");
    printGameBoard(gameBoard);
    ArrayList<String> allNewWords = new ArrayList<String>();

    System.out.println("is horizontal: " + isHorizontal(newLetters));
    
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

  // tested
  public int calculatePointsForWord(ArrayList<Character> charArray) {
    int totalPoints = 0;
    for (int i = 0; i < charArray.size(); i++) {
      totalPoints += TileSet.getLetterValue(charArray.get(i));
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

  public void printBoard(Board board) {
    for (int i = 0; i < 15; i++) {
      for (int j = 0; j < 15; j++) {
        System.out.println(board.getChar(i, j));
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

  public boolean isWord(String word) {
    System.out.println(word);
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

  public void replenishPlayerRack(Player p) {
    int numLetters = p.getNumLetters();
    while (numLetters < 7) {
      p.getPlayerSet().add(tileSet.getRandomLetter());
      numLetters++;
    }
  }

}