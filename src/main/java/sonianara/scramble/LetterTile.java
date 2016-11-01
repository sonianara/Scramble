public class LetterTile implements Tile {
	private char letter;
	private int pointValue;
	
	public Letter(char letter) {
		this.letter = letter;
		this.pointValue = RandomLetters.getLetterValue(letter);
	}
	
	public char getLetter() {
		return letter;
	}
	
	public int getPointValue() {
		return pointValue;
	}
}