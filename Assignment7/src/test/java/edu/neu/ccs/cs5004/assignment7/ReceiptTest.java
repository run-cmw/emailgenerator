package edu.neu.ccs.cs5004.assignment7;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class ReceiptTest {
  private ArrayList<IProducts> received;
  private ArrayList<IProducts> outOfStock;
  private ArrayList<IProducts> removed;
  private IProducts beer  = new Beer("beerManufacturer", "beer1", 3,
      21, 20);
  private IProducts cheese = new Cheese("cheeseManufacturer", "cheese1", 2,
      0, 20);
  private IProducts shampoo = new Shampoo("shampooCreator", "shampoo1", 5,
      0, 20);
  private IProducts salmon = new Salmon("salmonManufacturer", "salmon1", 4,
      21, 20);
  private IReceipt receipt;

  @Before
  public void setUp() throws Exception {
    received = new ArrayList<>();
    outOfStock = new ArrayList<>();
    removed = new ArrayList<>();
    received.add(cheese);
    received.add(shampoo);
    outOfStock.add(salmon);
    removed.add(beer);
    receipt = new Receipt(received, outOfStock, removed);
  }

  @Test
  public void getRemovedProductList() {
    ArrayList list = receipt.getRemovedProductList();
    assertEquals(removed, list);
    assertEquals(beer, list.get(0));
  }

  @Test
  public void getOutOfStockProductList() {
    ArrayList list = receipt.getOutOfStockProductList();
    assertEquals(outOfStock, list);
    assertEquals(salmon, list.get(0));
  }

  @Test
  public void getListOfProductsReceived() {
    ArrayList list = receipt.getListOfProductsReceived();
    assertEquals(received, list);
    assertEquals(cheese, list.get(0));
    assertEquals(shampoo, list.get(1));
  }

  @Test
  public void getTotalPricePaid() {
    int price = receipt.getTotalPricePaid();
    assertEquals((int) 5, price);
  }
}