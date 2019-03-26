package java.edu.neu.ccs.cs5004.assignment7;

import java.util.ArrayList;

public interface IInventorySystem {
  Boolean enoughItemsInStock(IStockItem item, int quantity);
  void reduceStockItem(IStockItem item, int quantity) throws NotEnoughItemsInStockException;
  void addNewItem(IStockItem item);
  int getTotalRetailValue();
  ArrayList<IStockItem> getGroceryStock();
  ArrayList<IStockItem> getHouseholdStock();


}
