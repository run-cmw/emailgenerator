package java.edu.neu.ccs.cs5004.assignment7;

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


}
