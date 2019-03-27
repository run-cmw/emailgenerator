package edu.neu.ccs.cs5004.assignment7;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ShoppingCartTest {
  IShoppingCart cart;
  IProducts salmon;
  IProducts shampoo;
  IStockItem salmonItem;
  IStockItem shampooItem;

  @Before
  public void setUp() throws Exception {
    salmon = new Salmon("salmonManufacturer", "salmon1", 2,
        0, 20);
    shampoo = new Shampoo("shampooManufacturer", "shampoo", 3,
        0, 20);
    salmonItem = new StockItem(salmon, 3);
    shampooItem = new StockItem(shampoo, 1);
    cart = new ShoppingCart();
  }

  @Test
  public void addProduct() throws NotEnoughItemsInStockException {
    cart.addProduct(salmonItem);
    assertEquals((int) 2, cart.getTotalCostOfItems());
  }

  @Test
  public void invalidAddProduct() throws NotEnoughItemsInStockException {
    cart.addProduct(salmonItem, 4);
  }

  @Test
  public void getTotalCostOfItems() throws NotEnoughItemsInStockException {
    cart.addProduct(salmonItem);
    assertEquals((int) 2, cart.getTotalCostOfItems());
    cart.addProduct(salmonItem, 2);
    assertEquals((int) 6, cart.getTotalCostOfItems());
    cart.addProduct(shampooItem);
    assertEquals((int) 9, cart.getTotalCostOfItems());
  }
}