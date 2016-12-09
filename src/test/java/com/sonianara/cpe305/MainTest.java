package com.sonianara.cpe305;

import static org.junit.Assert.*;


import org.junit.Test;

public class MainTest {


  @Test
  public void TestPlayerNotNull() {
    Main main = new Main();
    assertNotNull(main);
  }

  public static void main(String[] args) {
    org.junit.runner.JUnitCore.main("MainTest");
  }
}
