import static org.junit.Assert.*;

import org.junit.Test;

import source.DictionarySearch;

public class DictionarySearchTest {

	@Test
	public void TestContainsTrue() {
		DictionarySearch dictionary = new DictionarySearch("words.txt");
		assertTrue(dictionary.contains("tests"));
		assertTrue(dictionary.contains("apple"));
		assertTrue(dictionary.contains("lollipop"));
		assertTrue(dictionary.contains("table"));
		assertTrue(dictionary.contains("phone"));
		
	}
	
	@Test
	public void TestContainsFalse() {
		DictionarySearch dictionary = new DictionarySearch("words.txt");
		assertEquals(false, dictionary.contains("thisisfalse"));
		assertEquals(false, dictionary.contains("NotInDictionary"));
		assertEquals(false, dictionary.contains("shouldntbetrue"));
		assertEquals(false, dictionary.contains("`1234"));
		
	}
}

