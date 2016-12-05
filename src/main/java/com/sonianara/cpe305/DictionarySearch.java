package com.sonianara.cpe305;

/**
 * Represents the dictionary for the application.
 * @author sonianarayanan
 * @author sarahpadlipsky
 * @version October 20, 2016
 */

import java.io.File;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

/**
 * The entire Oxford English dictionary 
 * @author sonianarayanan
 *
 */
public class DictionarySearch {

  
  // The dictionary for the application.
  Set<String> dictionary = new HashSet<>();

  /**
   * @param fileName A file that contains all the words in the dictionary 
   */
  public DictionarySearch(String fileName) {
    createDictionary(fileName);
  }

  /**
   * @param fileName
   *          The file to open
   */
  public void createDictionary(String fileName) {
    Scanner scanner = null;
    Scanner scanner2 = null;
    // Makes sure file exists
    try {
      scanner = new Scanner(new File(fileName));

      while (scanner.hasNextLine()) {
        scanner2 = new Scanner(scanner.nextLine());
        while (scanner2.hasNext()) {
          String s = scanner2.next();
          dictionary.add(s);
        }
        scanner2.close();
      }
    } catch (Exception ex) {
      ex.printStackTrace();
      throw new RuntimeException(ex);
    }
    finally {
      if (scanner != null) {
        scanner.close();
      }
      if (scanner2 != null) {
        scanner2.close();
      }
    }

  }

  /**
   * @return The dictionary for the application
   */
  public Set<String> getDictionary() {
    return dictionary;
  }

  /**
   * @param word The word to search in the dictionary 
   * @return Whether words exists in dictionary
   */
  public boolean contains(String word) {
    return dictionary.contains(word);
  }
}
