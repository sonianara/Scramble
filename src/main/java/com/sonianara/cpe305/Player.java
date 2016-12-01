package com.sonianara.cpe305;

import java.util.ArrayList;

public class Player {

  private String name;
  private int points;
  private ArrayList<LetterTile> playerSet;

  public Player() {

  }

  public void addPoints(int val) {
    points += val;
  }

  public int getPoints() {
    return points;
  }

  public String getName() {
    return name;
  }

  public boolean hasName() {
    if (getName() != "" || getName() != null) {
      return true;
    }
    return false;
  }

  public void setPoints(int newPoints) {
    points = newPoints;
  }

  public void setName(String newName) {
    name = newName;
  }

  public void setPlayerSet(ArrayList<LetterTile> newSet) {
    playerSet = newSet;
  }

  public ArrayList<LetterTile> getPlayerSet() {
    return playerSet;
  }

  public void printPlayerSet(ArrayList<LetterTile> playerSet) {
    for (LetterTile lt : playerSet) {
      System.out.print(lt.getLetter());
    }
  }

  public int getNumLetters() {
    return playerSet.size();
  }

  public char getOneLetter(ArrayList<LetterTile> playerSet) {
    return (playerSet.remove(0)).getLetter();
  }
}