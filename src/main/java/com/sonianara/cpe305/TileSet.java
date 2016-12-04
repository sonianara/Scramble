package com.sonianara.cpe305;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

/**
 *  Singleton Design Pattern: Using a class to hold all Scrabble letters & return new letters if needed

 *  This pattern is used because each player can potentially have the  same letters, 
 * but each player has their own set of letters 
   
 *  Only one instance of this class must be created for each game. 
  
 */

public class TileSet {
  private int numLetters;
  public ArrayList<LetterTile> letters;
  private HashMap<Character, Integer> numLettersMap;
  public static HashMap<Character, Integer> letterValueMap;

  
  
  /**
   * This class represents the bag of letters tiles that exists for one game
   */
  public TileSet() {
    System.out.println("Testing");
    numLettersMap = new HashMap<Character, Integer>();
    letterValueMap = new HashMap<Character, Integer>();
    letters = new ArrayList<LetterTile>();
    numLetters = 0;

    for (char tempLetter = 'a'; tempLetter <= 'z'; tempLetter++) {
      switch (tempLetter) {
      case 'a':
        numLettersMap.put(tempLetter, 9);
        letterValueMap.put(tempLetter, 1);
        break;
      case 'b':
        numLettersMap.put(tempLetter, 2);
        letterValueMap.put(tempLetter, 3);
        break;
      case 'c':
        numLettersMap.put(tempLetter, 2);
        letterValueMap.put(tempLetter, 3);
        break;
      case 'd':
        numLettersMap.put(tempLetter, 4);
        letterValueMap.put(tempLetter, 2);
        break;
      case 'e':
        numLettersMap.put(tempLetter, 12);
        letterValueMap.put(tempLetter, 1);
        break;
      case 'f':
        numLettersMap.put(tempLetter, 2);
        letterValueMap.put(tempLetter, 4);
        break;
      case 'g':
        numLettersMap.put(tempLetter, 3);
        letterValueMap.put(tempLetter, 2);
        break;
      case 'h':
        numLettersMap.put(tempLetter, 2);
        letterValueMap.put(tempLetter, 4);
        break;
      case 'i':
        numLettersMap.put(tempLetter, 9);
        letterValueMap.put(tempLetter, 1);
        break;
      case 'j':
        numLettersMap.put(tempLetter, 1);
        letterValueMap.put(tempLetter, 8);
        break;
      case 'k':
        numLettersMap.put(tempLetter, 1);
        letterValueMap.put(tempLetter, 5);
        break;
      case 'l':
        numLettersMap.put(tempLetter, 4);
        letterValueMap.put(tempLetter, 1);
        break;
      case 'm':
        numLettersMap.put(tempLetter, 2);
        letterValueMap.put(tempLetter, 3);
        break;
      case 'n':
        numLettersMap.put(tempLetter, 6);
        letterValueMap.put(tempLetter, 1);
        break;
      case 'o':
        numLettersMap.put(tempLetter, 8);
        letterValueMap.put(tempLetter, 1);
        break;
      case 'p':
        numLettersMap.put(tempLetter, 2);
        letterValueMap.put(tempLetter, 3);
        break;
      case 'q':
        numLettersMap.put(tempLetter, 1);
        letterValueMap.put(tempLetter, 10);
        break;
      case 'r':
        numLettersMap.put(tempLetter, 6);
        letterValueMap.put(tempLetter, 1);
        break;
      case 's':
        numLettersMap.put(tempLetter, 4);
        letterValueMap.put(tempLetter, 1);
        break;
      case 't':
        numLettersMap.put(tempLetter, 6);
        letterValueMap.put(tempLetter, 1);
        break;
      case 'u':
        numLettersMap.put(tempLetter, 4);
        letterValueMap.put(tempLetter, 1);
        break;
      case 'v':
        numLettersMap.put(tempLetter, 2);
        letterValueMap.put(tempLetter, 4);
        break;
      case 'w':
        numLettersMap.put(tempLetter, 2);
        letterValueMap.put(tempLetter, 4);
        break;
      case 'x':
        numLettersMap.put(tempLetter, 1);
        letterValueMap.put(tempLetter, 8);
        break;
      case 'y':
        numLettersMap.put(tempLetter, 2);
        letterValueMap.put(tempLetter, 4);
        break;
      case 'z':
        numLettersMap.put(tempLetter, 1);
        letterValueMap.put(tempLetter, 10);
        break;
      }

    }
    // Add the two blank tiles
    numLettersMap.put('_', 2);
    letterValueMap.put('_', 0);
    letters.add(new LetterTile('_'));
    letters.add(new LetterTile('_'));
    numLetters = 2;

    // Adding all the tiles
    char tempLetter = 'a';
    while (tempLetter <= 'z') {
      int count = numLettersMap.get(tempLetter);
      while (count-- > 0) {
        letters.add(new LetterTile(tempLetter));
        numLetters++;
      }
      tempLetter++;
    }

    // Randomize the letters
    long seed = System.nanoTime();
    Collections.shuffle(letters, new Random(seed));

  }

  /**
   * 
   * @param letter - a specific character 
   * @return the scrabble value of the character
   */
  public static int getLetterValue(char letter) {
    int val = 0;
    char c = Character.toLowerCase(letter);
    if (letterValueMap.containsKey(c)) {
      val = letterValueMap.get(c);
    }
    return val;
  }

  /**
   * 
   * @return a random letter tile 
   */
  public LetterTile getRandomLetter() {
    if (numLetters <= 0)
      return null;

    numLetters--;
    return letters.remove(0);
  }

  /**
   * 
   * @return a set of 7 random letters
   */
  public ArrayList<LetterTile> getFullSet() {
    if (numLetters < 7)
      return null;
    ArrayList<LetterTile> newLetters = new ArrayList<LetterTile>();
    for (int i = 0; i < 7; i++) {
      newLetters.add(letters.remove(0));
      numLetters--;
    }
    return newLetters;
  }

  /**
   * 
   * @param letterSet - An array list of letter tiles 
   * @return whether the arraylist is empty
   */
  public boolean isEmpty(ArrayList<LetterTile> letterSet) {
    if (letterSet.isEmpty()) {
      return true;
    }
    return false;
  }

  /**
   * 
   * @return the bag of letters
   */
  public ArrayList<LetterTile> getBagOfLetters() {
    return letters;
  }

/**
 * the number of letters in the tile set bag 
 * @return
 */
  public int getNumLettersInBag() {
    return letters.size();
  }

  /**
   * 
   * @return an array list of random letter tiles 
   */
  public ArrayList<LetterTile> removeRandomLetters() {
    return letters;
  }

}
