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

    previousBoard.setChar('s', 3, 8);
    previousBoard.setChar('o', 3, 7);
    previousBoard.setChar('a', 3, 6);
    previousBoard.setChar('p', 3, 5);
    currentBoard.setChar('s', 3, 8);
    currentBoard.setChar('o', 3, 7);
    currentBoard.setChar('a', 3, 6);
    currentBoard.setChar('p', 3, 5);
    currentBoard.setChar('o', 4, 5);
    currentBoard.setChar('o', 5, 5);
    currentBoard.setChar('q', 6, 5);
    newBoard.setChar('s', 3, 8);
    newBoard.setChar('o', 3, 7);
    newBoard.setChar('a', 3, 6);
    newBoard.setChar('p', 3, 5);
    newBoard.setChar('o', 4, 5);
    newBoard.setChar('o', 5, 5);
    newBoard.setChar('q', 6, 5);
    newBoard.setChar('i', 6, 4);
    newBoard.setChar('s', 6, 3);
    newBoard.setChar('e', 6, 2);
    newBoard.setChar('c', 7, 2);
    newBoard.setChar('h', 8, 2);
    newBoard.setChar('o', 8, 2);
    newBoard.setChar('a', 8, 3);
    newBoard.setChar('h', 8, 4);

    board.setChar('s', 3, 8);
    board.setChar('o', 3, 7);
    board.setChar('a', 3, 6);
    board.setChar('p', 3, 5);
    board.setChar('o', 4, 5);
    board.setChar('o', 5, 5);
    board.setChar('q', 6, 5);
    board.setChar('i', 6, 4);
    board.setChar('s', 6, 3);
    board.setChar('e', 6, 2);
    board.setChar('c', 7, 2);
    board.setChar('h', 8, 2);
    board.setChar('o', 8, 2);
    board.setChar('a', 8, 3);
    board.setChar('h', 8, 4);
    board.setChar('h', 7, 3);

    ArrayList<Location> newLocations = game.getNewLetterLocation(board, newBoard);
    // ArrayList<Character> temp = game.getWord(board, newLocations);
    ArrayList<String> myWords = game.getNewWords(newLocations, board);
    // game.printChars(temp);

    assertEquals(false, game.checkValidityOfWords(myWords));

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
