package com.sonianara.cpe305;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents an individual player 
 * @author sonianarayanan
 *
 */
public class Player {

  private String name;
  private int points;
  private ArrayList<LetterTile> playerSet;

  
  /**
   * empty constructor 
   */
  public Player() {

  }

  /**
   * 
   * @param val - an integer value that represents points 
   */
  public void addPoints(int val) {
    points += val;
  }

  /**
   * 
   * @return the player's points 
   */
  public int getPoints() {
    return points;
  }

  /**
   * 
   * @return the player's name 
   */
  public String getName() {
    return name;
  }

  /**
   * 
   * @return whether the player has a name 
   */
  public boolean hasName() {
    if (getName() != "" || getName() != null) {
      return true;
    }
    return false;
  }

  /** 
   * 
   * @param newPoints - player's points 
   */
  public void setPoints(int newPoints) {
    points = newPoints;
  }

  /**
   * This method sets the player's name
   * @param newName
   */
  public void setName(String newName) {
    name = newName;
  }

  /**
   * This method sets the player's set of tiles
   * @param list
   */
  public void setPlayerSet(List<LetterTile> list) {
    playerSet = (ArrayList<LetterTile>) list;
  }

  /**
   * 
   * @return the player's set of tiles
   */
  public ArrayList<LetterTile> getPlayerSet() {
    return playerSet;
  }
  
  /**
   * This method deletes a character from the player's set of tiles
   * @param ch 
   */
  public void deleteTile(char ch) {
    for (int i = 0; i < playerSet.size(); i++) {
      if (playerSet.get(i).getLetter() == ch) {
        playerSet.remove(i);
      }
    }
  }
 
  /**
   * 
   * @return the size of the player's set of tiles
   */
  public int getPlayerSetSize() {
    return playerSet.size();
  }
  
  /**
   * prints the player's set of tiles 
   * @param playerSet
   */
  public void printPlayerSet(ArrayList<LetterTile> playerSet) {
    for (LetterTile lt : playerSet) {
      System.out.print(lt.getLetter() + " ");
    }
  }

  /**
   * get one letter from the player's set of tiles 
   * @param playerSet
   * @return a random character 
   */
  public char getOneLetter(ArrayList<LetterTile> playerSet) {
    return (playerSet.remove(0)).getLetter();
  }
}