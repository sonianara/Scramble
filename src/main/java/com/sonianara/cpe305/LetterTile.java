package com.sonianara.cpe305;


public class LetterTile implements Tile {
	private char letter;
	private int pointValue;
	
	public LetterTile(char letter) {
		this.letter = letter;
		this.pointValue = TileSet.getLetterValue(letter);
	}
	
	public char getLetter() {
		return letter;
	}
	
	public int getPointValue() {
		return pointValue;
	}
}