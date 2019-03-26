package edu.neu.ccs.cs5004.assignment7;

import static org.junit.Assert.*;

import org.junit.Before;
/**
 * Note: inherited methods tested in PaperTowelsTest. Testing for construction.
 */
public class ShampooTest {
  AbstractHousehold shampoo;

  @Before
  public void setUp() throws Exception {
    shampoo = new Shampoo("shampooCreator", "shampoo1", 3,
        0, 20);
  }
}