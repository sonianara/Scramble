package com.sonianara.cpe305;

import java.util.Dictionary;
import java.util.List;

public class Game {
	
	private Board gameBoard;
	private List<Player> listOfPlayers;
	private boolean gameOver;
	private int numPlayers;
	private int turn;
	private Dictionary dictionary;
	private TileSet setOfTiles;


	public void beginGame() {

	}

	public void endGame() {

	}

	public void nextTurn() {

	}

	public boolean isValidMove(Action move) {
		return false;
	}

	public void executeMove(Action move) {

	}

	public void refillTileStack() {

	}

	//return a Player
	public void getCurrentPlayer() {

	}

	public int getPlayerPoints(Player player) {
		return 1;
	}

	public void addPlayerPoints(Player player) {

	}
}