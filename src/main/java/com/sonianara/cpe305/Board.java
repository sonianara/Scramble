package com.sonianara.cpe305;

public class Board {
	
	private Tile[][] gameBoard;
	private int height;
	private int width;

	public Board(int height, int width) {
		this.height = height;
		this.width = width;
		this.gameBoard = gameBoard;
	}
	public int getHeight() {
		return this.height;
	}

	public int getWidth() {
		return this.width;
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
	  for (int i = 0; i < gameBoard.length; i++) {
	    for (int j = 0; j < gameBoard[i].length; j++) {
	      if (gameBoard[i][j] != null) {
	        empty = false;
	      }   
	    }
	  }
		return empty;
	}
	
	
	//create a 20x20 board
	public void createBoard() {
		gameBoard = new Tile[20][20];
	}

	public void putLetterOnBoard(Tile t) {

	}
}