package com.sonianara.cpe305;

/**
 * Represents the dictionary for the application.
 * @author sarahpadlipsky
 * @version October 20, 2016
 */

import java.io.File;
import java.util.Scanner;
import java.util.HashSet;

public class DictionarySearch {

  // The dictionary for the application.
  HashSet<String> dictionary = new HashSet<String>();

  public DictionarySearch(String fileName) {
    createDictionary(fileName);
  }

  /**
   * @param fileName
   *          The file to open
   */
  public void createDictionary(String fileName) {

    // Makes sure file exists
    try {
      Scanner scanner = new Scanner(new File(fileName));

      while (scanner.hasNextLine()) {
        Scanner scanner2 = new Scanner(scanner.nextLine());
        while (scanner2.hasNext()) {
          String s = scanner2.next();
          dictionary.add(s);
        }
        scanner2.close();
      }
      scanner.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    }

  }

  /**
   * @return The dictionary for the application
   */
  public HashSet<String> getDictionary() {
    return dictionary;
  }

  /**
   * @return Whether words exists in dictionary
   */
  public boolean contains(String word) {
    return dictionary.contains(word);
  }
}
