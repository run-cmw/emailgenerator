package edu.neu.ccs.cs5004.assignment7;

public interface IShoppingCart {

  /**
   * Adds an item to the shopping cart
   * @param item item
   */
  void addProduct(IStockItem item) throws NotEnoughItemsInStockException;

  /**
   * Adds item to the shopping cart based on quantity
   * @param item item
   * @param quantity of item
   */
  void addProduct(IStockItem item, int quantity) throws NotEnoughItemsInStockException;

  /**
   * Returns the total cost of items in the cart
   * @return the total cost of items in the cart
   */
  int getTotalCostOfItems();




}
