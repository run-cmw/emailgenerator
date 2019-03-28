package edu.neu.ccs.cs5004.assignment7;

import java.util.ArrayList;

/**
 * Interface for the inventory System
 */
public interface IInventorySystem {

  /**
   * Checks if there are enough items in stock
   * @param item items in stock
   * @param quantity of items in stock
   * @return true if there are enough items, false otherwise
   */
  Boolean enoughItemsInStock(IStockItem item, int quantity);

  /**
   * Reduce the amount of stock given items and  quantity of items
   * @param item to be reduced from stock
   * @param quantity of items to be reduced from stock
   * @throws NotEnoughItemsInStockException thrown if enough items are not in stock
   */
  void reduceStockItem(IStockItem item, int quantity) throws NotEnoughItemsInStockException;

  /**
   * Add a new item
   * @param item item added
   */
  void addNewItem(IStockItem item);

  /**
   * Returns the total retail value
   * @return total retail value
   */
  int getTotalRetailValue();

  /**
   * Returns a list of Grocery stock
   * @return grocery items in stock
   */
  ArrayList<IStockItem> getGroceryStock();

  /**
   * Returns a list of Household stock
   * @return household items in stock
   */
  ArrayList<IStockItem> getHouseholdStock();

  /**
   * Gathers all items in the cart and prepares for pickup.
   *
   * @param cart - The shopping cart filled with the order that the customer has placed.
   * @return - Updated shopping cart with applicable substitutions
   */
  IShoppingCart fulfillOrder(IShoppingCart cart, ArrayList<IProducts> outOfStockList)
      throws NotEnoughItemsInStockException;

  /**
   * Processes the order by removing products that the customer is not old enough to
   * purchase and returning a receipt summarizing the purchase.
   * @param cart - The shopping cart filled with the order that the customer has placed.
   * @param customer - The customer that the shopping cart belongs to
   * @param outOfStockList - A list of items that were out of stock.
   * @return - Receipt summarizing the order.
   * @throws NotEnoughItemsInStockException - Exception that is thrown if there are not enough items
   * in stock for the customer to obtain that quantity.
   */
  IReceipt processOrder(IShoppingCart cart, ICustomer customer,
      ArrayList<IProducts> outOfStockList) throws NotEnoughItemsInStockException;

  /**
   * Helper method to find the StockItem that maps to a product.
   * @param product - The product that the StockItem should map to.
   * @return IStockItem that maps to the given product.
   */
  IStockItem findStockItem(IProducts product);

}
