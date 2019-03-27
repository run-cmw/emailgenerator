package edu.neu.ccs.cs5004.assignment7;

import java.util.ArrayList;

/**
 * This class represents  the inventory system
 */
public class InventorySystem implements IInventorySystem {

  private ArrayList<IStockItem> groceryStock;
  private ArrayList<IStockItem> householdStock;

  public InventorySystem() {
    groceryStock = new ArrayList<IStockItem>();
    householdStock = new ArrayList<IStockItem>();
  }


  /**
   * Checks if there are enough items in stock
   *
   * @param item items in stock
   * @param quantity of items in stock
   * @return true if there are enough items, false otherwise
   */

  @Override
  public Boolean enoughItemsInStock(IStockItem item, int quantity) {
    if (item.getQuantity() >= quantity) {
      return true;
    } else {
      return false;
    }

  }

  /**
   * Reduce the amount of stock given items and  quantity of items
   *
   * @param item to be reduced from stock
   * @param quantity of items to be reduced from stock
   * @throws NotEnoughItemsInStockException thrown if enough items are not in stock
   */
  @Override
  public void reduceStockItem(IStockItem item, int quantity) throws NotEnoughItemsInStockException {
    if (enoughItemsInStock(item, quantity)) {
      item.reduceQuantity(quantity);
    } else {
      throw new NotEnoughItemsInStockException();
    }
  }

  /**
   * Add a new item
   *
   * @param item item added
   */
  @Override
  public void addNewItem(IStockItem item) {
    Class grocery = AbstractGrocery.class;
    Boolean isGrocery = grocery.isInstance(item.getProduct());
    if (isGrocery) {
      groceryStock.add(item);
    } else {
      householdStock.add(item);
    }
  }

  /**
   * Returns a list of Grocery stock
   *
   * @return grocery items in stock
   */
  @Override
  public ArrayList<IStockItem> getGroceryStock() {
    return this.groceryStock;
  }

  /**
   * Returns a list of Household stock
   *
   * @return household items in stock
   */
  @Override
  public ArrayList<IStockItem> getHouseholdStock() {
    return this.householdStock;
  }

  /**
   * Returns the total retail value
   *
   * @return total retail value
   */
  @Override
  public int getTotalRetailValue() {
    int value = 0;
    int grocerySize = this.groceryStock.size();
    int householdSize = this.householdStock.size();

    // Iterating through groceryStock list and adding all prices.
    for (int i = 0; i < grocerySize; i++) {
      value += this.groceryStock.get(i).getProduct().getPrice();
    }
    // Iterating through householdStock list and adding all prices.
    for (int i = 0; i < householdSize; i++) {
      value += this.householdStock.get(i).getProduct().getPrice();
    }
    return value;
  }

  /**
   * Gathers all items in the cart and prepares for pickup.
   *
   * @param cart - The shopping cart filled with the order that the customer has placed.
   * @return - A shopping cart
   */
  @Override
  public IShoppingCart fulfillOrder(IShoppingCart cart) {
    return null;
  }

  /**
   * Private method to find the StockItem that maps to a product.
   * @param product - The product that the StockItem should map to.
   * @return IStockItem that maps to the given product.
   */
  public IStockItem findStockItem(IProducts product) {
    Class grocery = AbstractGrocery.class;
    Boolean isGrocery = grocery.isInstance(product);
    int size;
    ArrayList<IStockItem> list;
    IStockItem item = null;

    if (isGrocery) {
      size = this.groceryStock.size();
      list = this.groceryStock;
    } else {
      size = this.householdStock.size();
      list = this.householdStock;
    }
    for (int i = 0; i < size; i++) {
      IProducts currentProduct = list.get(i).getProduct();
      if (currentProduct == product) {
         item = list.get(i);
      }
    }
    return item;
  }
}
