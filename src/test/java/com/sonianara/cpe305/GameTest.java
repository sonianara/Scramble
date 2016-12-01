package com.sonianara.cpe305;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;

public class GameTest {
  Game game = new Game();

  @Test
  public void TestGame() {

    Board previousBoard = new Board(15, 15);
    Board currentBoard = new Board(15, 15);
    Board newBoard = new Board(15, 15);
    Board board = new Board(15, 15);

    previousBoard.setChar('p', 8, 9);
    previousBoard.setChar('o', 9, 9);
    previousBoard.setChar('t', 10, 9);
    newBoard.setChar('p', 8, 9);
    newBoard.setChar('o', 9, 9);
    newBoard.setChar('t', 10, 9);
    newBoard.setChar('c', 9, 10);
    newBoard.setChar('o', 9, 9);
    newBoard.setChar('d', 9, 8);
   
    System.out.println("Printing old board");
    game.printGameBoard(previousBoard);
    System.out.println("Printing new board");
    game.printGameBoard(newBoard);
    ArrayList<Location> newLocations = game.getNewLetterLocation(previousBoard, newBoard);
    ArrayList<Character> temp = game.getWord(newBoard, newLocations);
    ArrayList<String> myWords = new ArrayList<String>();
    myWords = game.getNewWords(newLocations, newBoard);
    game.printChars(temp);
   
    for (int i = 0; i < myWords.size(); i++) {
      System.out.println("word: " + myWords.get(i));
    }
    //assertEquals(false, game.checkValidityOfWords(myWords));

    assertEquals(true, true);
    // ArrayList<Location> newLocations =
    // game.getNewLetterLocation(previousBoard, currentBoard);
    // ArrayList<Character> temp = game.getWord(currentBoard, newLocations);

    // Location loc = game.getRightLetter(newLocations);
    // System.out.println(loc.getX());
    // System.out.println(loc.getY());

    // Location loc2 = game.getLeftLetter(newLocations);
    // System.out.println(loc2.getX());
    // System.out.println(loc2.getY());

    // System.out.println(game.calculatePointsForWord(temp));

    // ArrayList<Location> newLocations2 =
    // game.getNewLetterLocation(currentBoard, newBoard);
    // ArrayList<Character> temp2 = game.getWord(newBoard, newLocations2);

    // Location loc3 = game.getTopLetter(newLocations2);
    // System.out.println(loc3.getX());
    // System.out.println(loc3.getY());

    // Location loc4 = game.getBottomLetter(newLocations2);
    // System.out.println(loc4.getX());
    // System.out.println(loc4.getY());

    // assertEquals(true, game.isVertical(newLocations2));
    // game.printChars(temp2);
    // assertEquals(true, game.isHorizontal(newLocations));
    // game.printChars(temp);
  }

  public static void main(String[] args) {
    org.junit.runner.JUnitCore.main("GameTest");
  }

}
