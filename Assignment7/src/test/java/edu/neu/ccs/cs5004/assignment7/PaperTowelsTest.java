package edu.neu.ccs.cs5004.assignment7;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PaperTowelsTest {
  AbstractHousehold paperTowel;

  @Before
  public void setUp() throws Exception {
    paperTowel = new PaperTowels("towelCreator", "towel1", 3,
        0, 20);
  }

  @Test
  public void testGetAge() {
    assertEquals((int) 0, paperTowel.getMinAge());
  }

  @Test
  public void testGetProductName() {
    assertEquals("towel1", paperTowel.getProductName());
  }

  @Test
  public void testGetPrice() {
    assertEquals((int) 3, paperTowel.getPrice());
  }

  @Test
  public void testGetManufacturer() {
    assertEquals("towelCreator", paperTowel.getManufacturer());
  }

  @Test
  public void testGetUnits() {
    assertEquals((int) 20, paperTowel.getUnits());
  }
}