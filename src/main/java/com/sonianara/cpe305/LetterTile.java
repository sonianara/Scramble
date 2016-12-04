package com.sonianara.cpe305;

/**
 * This class represents a single Letter Tile with a character and a point value 
 * @author sonianarayanan
 *
 */
public class LetterTile {
  private char letter;
  private int pointValue;

  /**
   * This constructor assigns a char and a point value to the letter tile 
   * @param letter
   */
  public LetterTile(char letter) {
    this.letter = letter;
    this.pointValue = TileSet.getLetterValue(letter);
  }

  /**
   * 
   * @return the letter of the tile 
   */
  public char getLetter() {
    return letter;
  }

  /**
   * Assigns a letter to the letter tile 
   * @param newLetter
   */
  public void setLetter(char newLetter) {
    letter = newLetter;
  }

  /**
   * 
   * @return the value of the letter
   */
  public int getPointValue() {
    return pointValue;
  }
}