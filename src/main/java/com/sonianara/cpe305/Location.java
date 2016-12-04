package com.sonianara.cpe305;

/**
 * This class represents a specific coordinate on a board 
 * @author sonianarayanan
 *
 */
public class Location {

  private int[] coords = new int[2];

  /**
   * Empty constructor
   */
  public Location () {
    /* Initialize empty constructor */
  }
  
  /**
   * Sets an x and y coordinate to a location 
   * @param x
   * @param y
   */
  public Location(int x, int y) {
    coords[0] = x;
    coords[1] = y;
  }

  /**
   * 
   * @return the x-coordinate 
   */
  public int getX() {
    return coords[0];
  }

  /**
   * 
   * @return the y-coordinate
   */
  public int getY() {
    return coords[1];
  }

  /**
   * sets the x and y location 
   * @param x
   * @param y
   */
  public void setLocation(int x, int y) {
    coords[0] = x;
    coords[1] = y;
  }
}