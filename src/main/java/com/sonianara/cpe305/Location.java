package com.sonianara.cpe305;

public class Location {

  private int[] coords = new int[2];

  public Location(int x, int y) {
    coords[0] = x;
    coords[1] = y;
  }

  public int getX() {
    return coords[0];
  }

  public int getY() {
    return coords[1];
  }

  public int[] getCoordArray() {
    return coords;
  }

  public void setLocation(int x, int y) {
    coords[0] = x;
    coords[1] = y;
  }
}