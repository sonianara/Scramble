package com.sonianara.cpe305;

public class Driver {

	public static void main(String[]args) {
		
      System.out.println("Testing");
      
      TileSet rl = new TileSet();
      for (LetterTile l: rl.getFullSet()) {
      	System.out.println(l.getLetter());
      }

      System.out.println("Testing Dictionary");
      DictionarySearch dictionary = new DictionarySearch("words.txt");
      //Should return true
      System.out.println("tests: " + dictionary.contains("tests"));
      //Should return false
      System.out.println("thisisfalse: " + dictionary.contains("lalapoooo"));


   }
}