import static org.junit.Assert.*;

import org.junit.Test;

import source.Letter;
import source.RandomLetters;
import java.util.*;

public class RandomLettersTest {
	
	/**
	 * test getting letter value from RandomLetters
	 */
	@Test
	public void TestGetLetterValueGetCorrectValues() {
		assertEquals(1, RandomLetters.getLetterValue('a'));
		assertEquals(3, RandomLetters.getLetterValue('b'));
		assertEquals(3, RandomLetters.getLetterValue('c'));
		assertEquals(2, RandomLetters.getLetterValue('d'));
		
	}
	/**
	 * test getFullSet return value is not null
	 * cannot test with hard concrete values because of randomness
	 */	
	@Test
	public void TestGetFullSetNotNull() {
		RandomLetters randomLetters = new RandomLetters();
		ArrayList<Letter> fullSet = randomLetters.getFullSet();
		assertNotNull(fullSet);	
		
	}

	/**
	 * test that getFullSet method does not return null for each Letter 
	 * in getFullSet
	 * cannot test with hard concrete values because of randomness
	 */
	@Test
	public void TestGetFullSetGetLetterChar() {
		RandomLetters randomLetters = new RandomLetters();
		for (Letter letter : randomLetters.getFullSet()) {
			assertTrue(letter.getLetter() >= 0);
		}
	}

}
