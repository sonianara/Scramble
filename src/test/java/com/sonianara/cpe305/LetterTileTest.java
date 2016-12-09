package com.sonianara.cpe305;

import static org.junit.Assert.*;

import org.junit.Test;

public class LetterTileTest {

  TileSet ts = TileSet.getInstance();

  @Test
  public void TestLetterNotNull() {
    LetterTile letter = new LetterTile('a');
    assertNotNull(letter);
  }

  @Test
  public void TestLetterGetLetter() {
    LetterTile letter = new LetterTile('a');
    LetterTile letter2 = new LetterTile('b');
    LetterTile letter3 = new LetterTile('c');
    LetterTile letter4 = new LetterTile('d');
    LetterTile letter5 = new LetterTile('e');
    LetterTile letter6 = new LetterTile('f');

    assertEquals('a', letter.getLetter());
    assertEquals('b', letter2.getLetter());
    assertEquals('c', letter3.getLetter());
    assertEquals('d', letter4.getLetter());
    assertEquals('e', letter5.getLetter());
    assertEquals('f', letter6.getLetter());

  }

  @Test
  public void TestLetterGetPointValue() {
    LetterTile letter = new LetterTile('a');
    LetterTile letter2 = new LetterTile('b');
    LetterTile letter3 = new LetterTile('c');
    LetterTile letter4 = new LetterTile('d');
    LetterTile letter5 = new LetterTile('e');
    LetterTile letter6 = new LetterTile('f');

    assertEquals(1, letter.getPointValue());
    assertEquals(3, letter2.getPointValue());
    assertEquals(3, letter3.getPointValue());
    assertEquals(2, letter4.getPointValue());
    assertEquals(1, letter5.getPointValue());
    assertEquals(4, letter6.getPointValue());

  }

  public static void main(String[] args) {
    org.junit.runner.JUnitCore.main("LetterTest");
  }
}
