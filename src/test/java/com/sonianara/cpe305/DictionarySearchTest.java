package com.sonianara.cpe305;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sonianara.cpe305.DictionarySearch;

public class DictionarySearchTest {
  DictionarySearch dictionary = DictionarySearch.getInstance();
  @Test
  public void TestContainsTrue() {
    assertTrue(dictionary.contains("tests"));
    assertTrue(dictionary.contains("apple"));
    assertTrue(dictionary.contains("lollipop"));
    assertTrue(dictionary.contains("table"));
    assertTrue(dictionary.contains("phone"));
  }

  @Test
  public void TestContainsFalse() {
    assertEquals(false, dictionary.contains("thisisfalse"));
    assertEquals(false, dictionary.contains("NotInDictionary"));
    assertEquals(false, dictionary.contains("shouldntbetrue"));
    assertEquals(false, dictionary.contains("`1234"));

  }

  public static void main(String[] args) {
    org.junit.runner.JUnitCore.main("DictionarySearchTest");
  }

}
