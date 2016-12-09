package com.sonianara.cpe305;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;


public class GameTest {
  Game game = Game.getInstance();

  @Test
  public void TestConstructor() {
    assertNotNull(game);
  }
  
  @Test
  public void TestGetTileSet() {
    assertEquals(TileSet.getInstance(), game.getTileSet());
  }
  
  @Test
  public void TestGetDicSearch() {
    assertEquals(DictionarySearch.getInstance(), game.getDictionary());
  }
  
  @Test
  public void TestCheckWord() {
    char[][] board = new char[15][15];
    Location loc1 = new Location(8, 8);
    Location loc2 = new Location(9, 8);
    Location loc3 = new Location(10, 8);
    board[8][8] = 'p';
    board[9][8] = 'a';
    List<Location> myList = new ArrayList<>();
    myList.add(loc1);
    myList.add(loc2);
    myList.add(loc3);
    assertEquals("pa", game.checkWords(myList, board));
  }
  
  
  @Test
  public void TestGetLeft() {
    char[][] board = new char[15][15];
    game.instantiateBoard(board);
    board[8][8] = 'p';
    board[9][8] = 'a';
    board[7][8] = 's';
    Location loc1 = new Location(8, 8);
    Location loc2 = new Location(9, 8);
    Location loc3 = new Location(10, 8);
    List<Location> myList = new ArrayList<>();
    myList.add(loc1);
    myList.add(loc2);
    myList.add(loc3);

    assertEquals(7, game.getLeft(myList, board).getX());
    assertEquals(8, game.getLeft(myList, board).getY());
  }
  
  @Test
  public void TestGetRight() {
    char[][] board = new char[15][15];
    game.instantiateBoard(board);
    board[8][8] = 'p';
    board[9][8] = 'a';
    board[7][8] = 's';
    board[10][8] = 't';
    board[11][8] = 's';
    Location loc1 = new Location(8, 8);
    Location loc2 = new Location(9, 8);
    Location loc3 = new Location(10, 8);
    List<Location> myList = new ArrayList<>();
    myList.add(loc1);
    myList.add(loc2);
    myList.add(loc3);

    assertEquals(11, game.getRight(myList, board).getX());
    assertEquals(8, game.getRight(myList, board).getY());
  }
  
  @Test
  public void TestGetTop() {
    char[][] board = new char[15][15];
    game.instantiateBoard(board);
    board[8][7] = 's';
    board[8][8] = 'p';
    board[8][9] = 'a';
    board[8][10] = 's';
    board[8][11] = 't';
    board[8][12] = 's';
    Location loc1 = new Location(8, 8);
    Location loc2 = new Location(8, 9);
    Location loc3 = new Location(8, 10);
    List<Location> myList = new ArrayList<>();
    myList.add(loc1);
    myList.add(loc2);
    myList.add(loc3);

    assertEquals(8, game.getTop(myList, board).getX());
    assertEquals(7, game.getTop(myList, board).getY());
  }
  
  @Test 
  public void TestGetWordString() {
    char[][] board = new char[15][15];
    game.instantiateBoard(board);
    board[8][8] = 'p';
    board[8][9] = 'a';
    board[8][10] = 's';
    board[8][11] = 't';
    board[8][12] = 's';
    
    List<String> strs = new ArrayList<>();
    strs.add("pasts");
    assertEquals(strs, game.getWordsString(board));
  }
  
  @Test
  public void TestMakeFinalMove() {
    char[][] board = new char[15][15];
    game.instantiateBoard(board);
    board[8][8] = 'p';
    board[8][9] = 'a';
    board[8][10] = 's';
    board[8][11] = 't';
    board[8][12] = 's';
    
    Player p = new Player();
    LetterTile lt = new LetterTile('p');
    LetterTile lt1 = new LetterTile('a');
    LetterTile lt2 = new LetterTile('s');
    LetterTile lt3 = new LetterTile('t');
    LetterTile lt4 = new LetterTile('s');
    LetterTile lt5 = new LetterTile('f');
    LetterTile lt6 = new LetterTile('_');
    
    List<LetterTile> tileList = new ArrayList<LetterTile>();
    tileList.add(lt);
    tileList.add(lt1);
    tileList.add(lt2);
    tileList.add(lt3);
    tileList.add(lt4);
    tileList.add(lt5);
    tileList.add(lt6);
    
    p.setPlayerSet(tileList);
    
    assertEquals(true, game.makeFinalMove(board, p));
  }
  
  @Test
  public void TestMakeFinalMove2() {
    char[][] board = new char[15][15];
    game.instantiateBoard(board);
    board[8][8] = 'p';
    board[8][9] = 'a';
    board[8][10] = 's';
    board[8][11] = 't';
    board[8][12] = 's';
    
    Player p = new Player();
    LetterTile lt = new LetterTile('a');
    LetterTile lt1 = new LetterTile('b');
    LetterTile lt2 = new LetterTile('c');
    LetterTile lt3 = new LetterTile('d');
    LetterTile lt4 = new LetterTile('e');
    LetterTile lt5 = new LetterTile('f');
    LetterTile lt6 = new LetterTile('_');
    
    List<LetterTile> tileList = new ArrayList<LetterTile>();
    tileList.add(lt);
    tileList.add(lt1);
    tileList.add(lt2);
    tileList.add(lt3);
    tileList.add(lt4);
    tileList.add(lt5);
    tileList.add(lt6);
    
    p.setPlayerSet(tileList);
    
    assertEquals(false, game.makeFinalMove(board, p));
  }
  
  @Test
  public void TestMakeFinalMove3() {
    char[][] board = new char[15][15];
    game.instantiateBoard(board);
    board[8][8] = 'p';
    board[10][12] = 'a';
   
    Player p = new Player();
    LetterTile lt = new LetterTile('a');
    LetterTile lt1 = new LetterTile('b');
    LetterTile lt2 = new LetterTile('c');
    LetterTile lt3 = new LetterTile('d');
    LetterTile lt4 = new LetterTile('e');
    LetterTile lt5 = new LetterTile('f');
    LetterTile lt6 = new LetterTile('_');
    
    List<LetterTile> tileList = new ArrayList<LetterTile>();
    tileList.add(lt);
    tileList.add(lt1);
    tileList.add(lt2);
    tileList.add(lt3);
    tileList.add(lt4);
    tileList.add(lt5);
    tileList.add(lt6);
    
    p.setPlayerSet(tileList);
    
    assertEquals(false, game.makeFinalMove(board, p));
  }
  
  @Test
  public void TestGetBottom() {
    char[][] board = new char[15][15];
    game.instantiateBoard(board);
    board[8][8] = 'p';
    board[8][9] = 'a';
    board[8][10] = 's';
    board[8][11] = 't';
    board[8][12] = 's';
    Location loc1 = new Location(8, 8);
    Location loc2 = new Location(8, 9);
    Location loc3 = new Location(8, 10);
    List<Location> myList = new ArrayList<>();
    myList.add(loc1);
    myList.add(loc2);
    myList.add(loc3);

    assertEquals(8, game.getBottom(myList, board).getX());
    assertEquals(12, game.getBottom(myList, board).getY());
  }
  
  @Test
  public void TestEnteredLetters() {
    char[][] board = new char[15][15];
    game.instantiateBoard(board);
    board[8][8] = 'w';
    board[8][9] = 'a';
    board[8][10] = 's';
  
    Location loc1 = new Location(8, 8);
    Location loc2 = new Location(8, 9);
    Location loc3 = new Location(8, 10);
    List<Location> myList = new ArrayList<>();
    myList.add(loc1);
    myList.add(loc2);
    myList.add(loc3);
    
    List<Character> chars = new ArrayList<>();
    chars.add('w');
    chars.add('a');
    chars.add('s');

    assertEquals(chars, game.getEnteredLetters(myList, board));
  }
  
  @Test 
  public void TestCalcPointsForWord() {
    String str = "word";
    assertEquals(8, game.calculatePointsForWord(str));
  }
  
  @Test
  public void TestPointsForAll() {
    String s1 = "one";
    String s2 = "two";
    String s3 = "three";
    List<String> newWords = new ArrayList<>();
    newWords.add(s1);
    newWords.add(s2);
    newWords.add(s3);
    assertEquals(17, game.pointsForAll(newWords));
  }
  
  @Test
  public void TestCheckValidityOfWords() {
    String s1 = "one";
    String s2 = "two";
    String s3 = "three";
    List<String> newWords = new ArrayList<>();
    newWords.add(s1);
    newWords.add(s2);
    newWords.add(s3);
    assertEquals(true, game.checkValidityOfWords(newWords));
  }
  
  @Test 
  public void testContainsBlankLetters() {
    Player p = new Player();
    LetterTile lt = new LetterTile('a');
    LetterTile lt1 = new LetterTile('b');
    LetterTile lt2 = new LetterTile('c');
    LetterTile lt3 = new LetterTile('d');
    LetterTile lt4 = new LetterTile('e');
    LetterTile lt5 = new LetterTile('f');
    LetterTile lt6 = new LetterTile('_');
    
    List<LetterTile> tileList = new ArrayList<LetterTile>();
    tileList.add(lt);
    tileList.add(lt1);
    tileList.add(lt2);
    tileList.add(lt3);
    tileList.add(lt4);
    tileList.add(lt5);
    tileList.add(lt6);
    
    p.setPlayerSet(tileList);
    char c1 = 'a';
    char c2 = 'b';
    char c3 = '_';
    List<Character> noBlanks = new ArrayList<Character>();
    noBlanks.add(c1);
    noBlanks.add(c2);
    noBlanks.add(c3);
    List <Character> yesBlanks = new ArrayList<Character>();
    char c4 = 'z';
    yesBlanks.add(c1);
    yesBlanks.add(c2);
    yesBlanks.add(c3);
    yesBlanks.add(c4);
    assertEquals(0, game.isBlankLetter(noBlanks, p));
    assertEquals(1, game.isBlankLetter(yesBlanks, p));
  }
  
  @Test
  public void TestContainsBlank() {
    char c1 = 'a';
    char c2 = 'b';
    char c3 = '_';
    char c4 = '_';
    List<Character> noBlanks = new ArrayList<Character>();
    noBlanks.add(c1);
    noBlanks.add(c2);
    noBlanks.add(c3);
    noBlanks.add(c4);
    assertEquals(2, game.containsBlankLetters(noBlanks));
  }
  
  @Test
  public void TestAllMyNewWords() {
    char[][] board = new char[15][15];
    game.instantiateBoard(board);
    Location loc1 = new Location(8, 8);
    Location loc2 = new Location(9, 8);
    Location loc3 = new Location(10, 8);
    board[8][8] = 'p';
    board[9][8] = 'a';
    List<Location> myList = new ArrayList<>();
    myList.add(loc1);
    myList.add(loc2);
    myList.add(loc3);
    List<String> myWords = new ArrayList<>();
    String str = "pa";
    myWords.add(str);
    assertEquals(myWords, game.allMyNewWords(myList, board));
  }
  
  @Test
  public void TestHorizontal() {
    Location loc1 = new Location(8, 8);
    Location loc2 = new Location(9, 8);
    Location loc3 = new Location(10, 8);
    List<Location> myList = new ArrayList<>();
    myList.add(loc1);
    myList.add(loc2);
    myList.add(loc3);
    assertEquals(true, game.isHorizontal(myList));
  }
  
  @Test
  public void TestVertical() {
    Location loc1 = new Location(8, 8);
    Location loc2 = new Location(8, 9);
    Location loc3 = new Location(8, 10);
    List<Location> myList = new ArrayList<>();
    myList.add(loc1);
    myList.add(loc2);
    myList.add(loc3);
    assertEquals(true, game.isVertical(myList));
  }
  
  @Test
  public void TestGetWord() {
    Location loc1 = new Location(8, 8);
    Location loc2 = new Location(8, 9);
    Location loc3 = new Location(8, 10);
    List<Location> myList = new ArrayList<>();
    myList.add(loc1);
    myList.add(loc2);
    myList.add(loc3);
    Board b = new Board();
    b.createBoard();
    b.setChar('c', 8, 8);
    b.setChar('a', 8, 9);
    b.setChar('t', 8, 10);
    char c1 = 'c';
    char c2 = 'a';
    char c3 = 't';
    List<Character> chars = new ArrayList<Character>();
    chars.add(c1);
    chars.add(c2);
    chars.add(c3);
    assertEquals(chars, game.getWord(b, myList));
  }
  
  @Test
  public void TestArrayToString() {
    char c1 = 'c';
    char c2 = 'a';
    char c3 = 't';
    List<Character> chars = new ArrayList<Character>();
    chars.add(c1);
    chars.add(c2);
    chars.add(c3);
    assertEquals("cat", game.arraytoString(chars));
  }
 
  @Test
  public void TestIsWord() {
    String str = "yellow";
    assertEquals(true, game.isWord(str));
  }
  
  @Test
  public void TestAllWords() {
    String str = "yellow";
    String str2 = "blue";
    String str3 = "red";
    String str4 = "green";
    List<String> myList = new ArrayList<>();
    myList.add(str);
    myList.add(str2);
    myList.add(str3);
    myList.add(str4);
    assertEquals(true, game.allWords(myList));
  }
  
  
  public static void main(String[] args) {
    org.junit.runner.JUnitCore.main("GameTest");
  }

}
