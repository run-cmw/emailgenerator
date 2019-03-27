package edu.neu.ccs.cs5004.assignment7;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StockItemTest {
  IProducts salmon;
  IStockItem item;

  @Before
  public void setUp() throws Exception {
    salmon = new Salmon("salmonManufacturer", "salmon1", 3,
        21, 20);
    item = new StockItem(salmon, 2);
  }

  @Test
  public void getProduct() {
    assertEquals("salmon1", item.getProduct().getProductName());
  }

  @Test
  public void getQuantity() {
    assertEquals(2, item.getQuantity());
  }

  @Test
  public void reduceQuantity() {
    item.reduceQuantity(1);
    assertEquals(1, item.getQuantity());
    item.reduceQuantity(1);
    assertEquals(0, item.getQuantity());
  }
}