package edu.neu.ccs.cs5004.assignment7;

import static org.junit.Assert.*;

import org.junit.Before;

/**
 * Note: inherited methods tested in BeerTest. Testing for construction.
 */
public class SalmonTest {

  AbstractGrocery salmon;

  @Before
  public void setUp() throws Exception {
    salmon = new Salmon("salmonManufacturer", "salmon1", 3,
        21, 20);
  }
}