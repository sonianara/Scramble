package com.sonianara.cpe305;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;

public class TileSetTest {

  /**
   * test getting letter value from RandomLetters
   */
  @Test
  public void TestGetLetterValueGetCorrectValues() {
    assertEquals(1, TileSet.getLetterValue('a'));
    assertEquals(3, TileSet.getLetterValue('b'));
    assertEquals(3, TileSet.getLetterValue('c'));
    assertEquals(2, TileSet.getLetterValue('d'));

  }

  /**
   * test getFullSet return value is not null cannot test with hard concrete
   * values because of randomness
   */
  @Test
  public void TestGetFullSetNotNull() {
    TileSet randomLetters = new TileSet();
    ArrayList<LetterTile> fullSet = (ArrayList<LetterTile>) randomLetters.getFullSet();
    assertNotNull(fullSet);

  }

  /**
   * test that getFullSet method does not return null for each Letter in
   * getFullSet cannot test with hard concrete values because of randomness
   */
  @Test
  public void TestGetFullSetGetLetterChar() {
    TileSet randomLetters = new TileSet();
    for (LetterTile letter : randomLetters.getFullSet()) {
      assertTrue(letter.getLetter() >= 0);
    }
  }

  public static void main(String[] args) {
    org.junit.runner.JUnitCore.main("TileSetTest");
  }

}
