package com.sonianara.cpe305;

public class Board {
  private int BOARDSIZE = 15;
  private char[][] board;
  private int height;
  private int width;

  public Board(int height, int width) {
    this.height = height;
    this.width = width;

    createBoard();
  }

  public void setChar(char c, int i, int j) {
    board[i][j] = c;
  }

  public int getHeight() {
    return this.height;
  }

  public int getWidth() {
    return this.width;
  }

  public char getChar(int x, int y) {
    return board[x][y];
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
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] != ' ') {
          empty = false;
        }
      }
    }
    return empty;
  }

  public void createBoard() {
    board = new char[BOARDSIZE][BOARDSIZE];

    for (int i = 0; i < BOARDSIZE; i++) {
      for (int j = 0; j < BOARDSIZE; j++) {
        board[i][j] = ' ';
      }
    }
  }

}
