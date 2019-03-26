package edu.neu.ccs.cs5004.assignment7;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;

/**
 * Note: inherited methods tested in BeerTest. Testing for construction.
 */
public class CheeseTest {

  AbstractGrocery cheese;

  @Before
  public void setUp() throws Exception {
    cheese = new Cheese("cheeseManufacturer", "cheese1", 3,
        21, 20);
  }
}