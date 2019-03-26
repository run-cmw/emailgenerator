package edu.neu.ccs.cs5004.assignment7;

import java.util.ArrayList;

public interface IInventorySystem {
  Boolean enoughItemsInStock(IStockItem item);
  void reduceStockItem(IStockItem item);
  void addNewItem(IStockItem item);
  ArrayList<IStockItem> getGroceryStock();
  ArrayList<IStockItem> getHouseholdStock();


}
