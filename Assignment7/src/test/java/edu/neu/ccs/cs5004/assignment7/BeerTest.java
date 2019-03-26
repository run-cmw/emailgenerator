package edu.neu.ccs.cs5004.assignment7;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BeerTest {
  AbstractGrocery beer;

  @Before
  public void setUp() throws Exception {
    beer = new Beer("beerManufacturer", "beer1", 3,
        21, 20);
  }

  @Test
  public void testGetAge() {
    assertEquals((int) 21, beer.getMinAge());
  }

  @Test
  public void testGetProductName() {
    assertEquals("beer1", beer.getProductName());
  }

  @Test
  public void testGetPrice() {
    assertEquals((int) 3, beer.getPrice());
  }

  @Test
  public void testGetManufacturer() {
    assertEquals("beerManufacturer", beer.getManufacturer());
  }

  @Test
  public void testGetWeight() {
    assertEquals((int) 20, beer.getWeight());
  }

}