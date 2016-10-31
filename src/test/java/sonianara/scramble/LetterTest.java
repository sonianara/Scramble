import static org.junit.Assert.*;

import org.junit.Test;

import source.Letter;

public class LetterTest {

	@Test
	public void TestLetterNotNull() {
		Letter letter = new Letter('a');
		assertNotNull(letter);
	}
	
	@Test
	public void TestLetterGetLetter() {
		Letter letter = new Letter('a');
		Letter letter2 = new Letter('b');
		Letter letter3 = new Letter('c');
		Letter letter4 = new Letter('d');
		Letter letter5 = new Letter('e');
		Letter letter6 = new Letter('f');
		
		assertEquals('a', letter.getLetter());
		assertEquals('b', letter2.getLetter());
		assertEquals('c', letter3.getLetter());
		assertEquals('d', letter4.getLetter());
		assertEquals('e', letter5.getLetter());
		assertEquals('f', letter6.getLetter());
		
	}

	@Test
	public void TestLetterGetPointValue() {
		Letter letter = new Letter('a');
		Letter letter2 = new Letter('b');
		Letter letter3 = new Letter('c');
		Letter letter4 = new Letter('d');
		Letter letter5 = new Letter('e');
		Letter letter6 = new Letter('f');
		
		assertEquals(1, letter.getPointValue());
		assertEquals(3, letter2.getPointValue());
		assertEquals(3, letter3.getPointValue());
		assertEquals(2, letter4.getPointValue());
		assertEquals(1, letter5.getPointValue());
		assertEquals(4, letter6.getPointValue());
		
	}
}
