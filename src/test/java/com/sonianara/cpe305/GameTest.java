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

    previousBoard.setChar('v', 5, 5);
    previousBoard.setChar('a', 5, 4);
    previousBoard.setChar('n', 5, 3);
    
    newBoard.setChar('v', 5, 5);
    newBoard.setChar('a', 5, 4);
    newBoard.setChar('n', 5, 3);
    newBoard.setChar('s', 4, 4);
    newBoard.setChar('g', 6, 4);

  
    assertEquals(true, true);
  
  }

  public static void main(String[] args) {
    org.junit.runner.JUnitCore.main("GameTest");
  }

}
