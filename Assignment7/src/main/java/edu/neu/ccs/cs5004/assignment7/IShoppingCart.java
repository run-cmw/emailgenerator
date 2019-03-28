package edu.neu.ccs.cs5004.assignment7;

import java.util.ArrayList;

public interface IShoppingCart {

  /**
   * Adds an item to the shopping cart
   * @param product - Product to be added to the shopping cart.
   */
  void addProduct (IProducts product) throws NotEnoughItemsInStockException;

  /**
   * Adds item to the shopping cart based on quantity
   * @param product - Product to be added to the shopping cart.
   * @param quantity of item
   */
  void addProduct (IProducts product, int quantity) throws NotEnoughItemsInStockException;

  /**
   * Returns the total cost of items in the cart
   * @return the total cost of items in the cart
   */
  int getTotalCostOfItems();

  /**
   * Returns the list of products in the shopping cart.
   * @return list of products in the shopping cart.
   */
  ArrayList<IProducts> getShoppingCartProductsList();




}
