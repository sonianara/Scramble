package com.sonianara.cpe305;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;

public class LocationTest {

  @Test
  public void testLocationX() {
    Location loc = new Location(5, 3);
    loc.setLocation(5, 3);
    assertEquals(5, loc.getX());
  }

  public void testLocationY() {
    Location loc = new Location(0, 10);
    loc.setLocation(0, 10);
    assertEquals(10, loc.getY());
  }
}
