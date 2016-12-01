package com.sonianara.cpe305;


public class LetterTile {
	private char letter;
	private int pointValue;
	
	public LetterTile(char letter) {
		this.letter = letter;
		this.pointValue = TileSet.getLetterValue(letter);
	}
	
	public char getLetter() {
		return letter;
	}
	
	public void setLetter(char newLetter) {
		letter = newLetter;
	}
	
	public int getPointValue() {
		return pointValue;
	}
}