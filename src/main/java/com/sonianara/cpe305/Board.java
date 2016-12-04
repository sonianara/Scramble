package com.sonianara.cpe305;


/**
 * This class represents a general 15 x 15 gBoard
 */

public class Board {
  private int gBoardSize = 15;
  private char[][] gBoard = new char[gBoardSize][gBoardSize];
  private int height;
  private int width;

  
  /**
   * This class represents the creation of a 15 x 15 game gBoard
   */
  public Board() {
    for (int i = 0; i < gBoardSize; i++) {
      for (int j = 0; j < gBoardSize; j++) {
        gBoard[i][j] = ' ';
      }
    }
  }
  
  /**
   * The creation of a gBoard of any height or width
   * @param height
   * @param width
   */
  public Board(int height, int width) {
    this.height = height;
    this.width = width;

    createBoard();
  }
  
  public void setBoard(char[][] newBoard) {
    gBoard = newBoard;
  }

  public char[][] getBoard() {
    return gBoard;
  }
  
  /**
   * @param ch represents a specific character
   * @param i represents the x coordinate
   * @param j represents the y coordinate
   */
  public void setChar(char ch, int i, int j) {
    gBoard[i][j] = ch;
  }

  public int getHeight() {
    return this.height;
  }

  public int getWidth() {
    return this.width;
  }

  /**
   * @param x coordinate
   * @param y coordinate
   * @return char at the x, y coordinate
   */
  public char getChar(int x, int y) {
    return gBoard[x][y];
  }

  public int setWidth(int newWidth) {
    this.width = newWidth;
    return width;
  }

  public int setHeight(int newHeight) {
    this.height = newHeight;
    return this.height;
  }

  public boolean isEmpty() {
    boolean empty = true;
    for (int i = 0; i < gBoard.length; i++) {
      for (int j = 0; j < gBoard[i].length; j++) {
        if (gBoard[i][j] != ' ') {
          empty = false;
        }
      }
    }
    return empty;
  }

  /**
   * This method initializes an empty gBoard 
   */
  public void createBoard() {
    gBoard = new char[gBoardSize][gBoardSize];

    for (int i = 0; i < gBoardSize; i++) {
      for (int j = 0; j < gBoardSize; j++) {
        gBoard[i][j] = ' ';
      }
    }
  }

}
