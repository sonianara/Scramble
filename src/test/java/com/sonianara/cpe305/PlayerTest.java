package com.sonianara.cpe305;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PlayerTest {


  @Test
  public void TestPlayerNotNull() {
    Player p = new Player();
    assertNotNull(p);
  }

  @Test
  public void TestPoints() {
    Player p = new Player();
    p.setPoints(19);
    assertEquals(19, p.getPoints());
    p.addPoints(5);
    assertEquals(24, p.getPoints());
  }
  
  @Test
  public void TestName() {
    Player p = new Player();
    p.setName("Jim");
    assertEquals("Jim", p.getName());
  }
  
  @Test 
  public void TestTiles() {
    Player p = new Player();
    
    LetterTile letter = new LetterTile('a');
    LetterTile letter2 = new LetterTile('b');
    LetterTile letter3 = new LetterTile('c');
    LetterTile letter4 = new LetterTile('d');
    LetterTile letter5 = new LetterTile('e');
    LetterTile letter6 = new LetterTile('f');
    
    List<LetterTile> playerList = new ArrayList<>();
    playerList.add(letter);
    playerList.add(letter2);
    playerList.add(letter3);
    playerList.add(letter4);
    playerList.add(letter4);
    playerList.add(letter5);
    playerList.add(letter6);
    
    p.setPlayerSet(playerList);
    assertEquals('a', p.getOneLetter(playerList));                                                                                                                                                              
  }
  
  @Test 
  public void TestPlayerSetSize() {
    Player p = new Player();
    
    LetterTile letter = new LetterTile('a');
    LetterTile letter2 = new LetterTile('b');
    LetterTile letter3 = new LetterTile('c');
    LetterTile letter4 = new LetterTile('d');
    LetterTile letter5 = new LetterTile('e');
    LetterTile letter6 = new LetterTile('f');
    
    List<LetterTile> playerList = new ArrayList<>();
    playerList.add(letter);
    playerList.add(letter2);
    playerList.add(letter3);
    playerList.add(letter4);
    playerList.add(letter5);
    playerList.add(letter6);
    
    p.setPlayerSet(playerList);
   
    assertEquals(6, p.getPlayerSetSize());
    
    p.deleteTile('a');
    
    assertEquals(5, p.getPlayerSetSize());
  }
  

  public static void main(String[] args) {
    org.junit.runner.JUnitCore.main("LetterTest");
  }
}
