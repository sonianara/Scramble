package com.sonianara.cpe305;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;


public class GameTest {
  Game game = new Game();

  @Test
  public void TestConstructor() {
    assertNotNull(game);
  }
  
  /*
  @Test
  public void TestCheckWord() {
    char[][] board = new char[15][15];
    Location loc1 = new Location(8, 8);
    Location loc2 = new Location(9, 8);
    Location loc3 = new Location(10, 8);
    board[8][8] = 'p';
    board[9][8] = 'a';
    List<Location> myList = new ArrayList<>();
    myList.add(loc1);
    myList.add(loc2);
    myList.add(loc3);
    assertEquals("pa", game.checkWords(myList, board));
  }
  
  @Test
  public void TestGetLeft() {
    char[][] board = new char[15][15];
    game.instantiateBoard(board);
    board[8][8] = 'p';
    board[9][8] = 'a';
    board[7][8] = 's';
    Location loc1 = new Location(8, 8);
    Location loc2 = new Location(9, 8);
    Location loc3 = new Location(10, 8);
    List<Location> myList = new ArrayList<>();
    myList.add(loc1);
    myList.add(loc2);
    myList.add(loc3);

    assertEquals(7, game.getLeft(myList, board).getX());
    assertEquals(8, game.getLeft(myList, board).getY());
  }
  
  @Test
  public void TestGetRight() {
    char[][] board = new char[15][15];
    game.instantiateBoard(board);
    board[8][8] = 'p';
    board[9][8] = 'a';
    board[7][8] = 's';
    board[10][8] = 't';
    board[11][8] = 's';
    Location loc1 = new Location(8, 8);
    Location loc2 = new Location(9, 8);
    Location loc3 = new Location(10, 8);
    List<Location> myList = new ArrayList<>();
    myList.add(loc1);
    myList.add(loc2);
    myList.add(loc3);

    assertEquals(11, game.getRight(myList, board).getX());
    assertEquals(8, game.getRight(myList, board).getY());
  }
  
  @Test
  public void TestGetTop() {
    char[][] board = new char[15][15];
    game.instantiateBoard(board);
    board[8][8] = 'p';
    board[8][9] = 'a';
    board[8][10] = 's';
    board[8][11] = 't';
    board[8][12] = 's';
    Location loc1 = new Location(8, 8);
    Location loc2 = new Location(8, 9);
    Location loc3 = new Location(8, 10);
    List<Location> myList = new ArrayList<>();
    myList.add(loc1);
    myList.add(loc2);
    myList.add(loc3);

    assertEquals(8, game.getTop(myList, board).getX());
    assertEquals(8, game.getTop(myList, board).getY());
  }
  
  @Test
  public void TestGetBottom() {
    char[][] board = new char[15][15];
    game.instantiateBoard(board);
    board[8][8] = 'p';
    board[8][9] = 'a';
    board[8][10] = 's';
    board[8][11] = 't';
    board[8][12] = 's';
    Location loc1 = new Location(8, 8);
    Location loc2 = new Location(8, 9);
    Location loc3 = new Location(8, 10);
    List<Location> myList = new ArrayList<>();
    myList.add(loc1);
    myList.add(loc2);
    myList.add(loc3);

    assertEquals(8, game.getBottom(myList, board).getX());
    assertEquals(12, game.getBottom(myList, board).getY());
  }
  
  @Test
  public void TestEnteredLetters() {
    char[][] board = new char[15][15];
    game.instantiateBoard(board);
    board[8][8] = 'w';
    board[8][9] = 'a';
    board[8][10] = 's';
  
    Location loc1 = new Location(8, 8);
    Location loc2 = new Location(8, 9);
    Location loc3 = new Location(8, 10);
    List<Location> myList = new ArrayList<>();
    myList.add(loc1);
    myList.add(loc2);
    myList.add(loc3);
    
    List<Character> chars = new ArrayList<>();
    chars.add('w');
    chars.add('a');
    chars.add('s');

    assertEquals(chars, game.getEnteredLetters(myList, board));
  }
  */

  public static void main(String[] args) {
    org.junit.runner.JUnitCore.main("GameTest");
  }

}
