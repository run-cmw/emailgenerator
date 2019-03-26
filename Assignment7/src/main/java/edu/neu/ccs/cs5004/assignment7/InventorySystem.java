package edu.neu.ccs.cs5004.assignment7;

import java.util.ArrayList;

public class InventorySystem implements IInventorySystem{
  private ArrayList<IStockItem> groceryStock;
  private ArrayList<IStockItem> householdStock;

  public InventorySystem() {
    groceryStock = new ArrayList<IStockItem>();
    householdStock = new ArrayList<IStockItem>();
  }

  @Override
  public Boolean enoughItemsInStock(IStockItem item) {
    return null;
  }

  @Override
  public void reduceStockItem(IStockItem item) {

  }

  @Override
  public void addNewItem(IStockItem item) {
    Class grocery = AbstractGrocery.class;
    Class household = AbstractHousehold.class;
    Boolean isGrocery = grocery.isInstance(item.getProduct());
    if (isGrocery) {
      groceryStock.add(item);
    } else {
      householdStock.add(item);
    }
  }

  public ArrayList<IStockItem> getGroceryStock() {
    return this.groceryStock;
  }

  public ArrayList<IStockItem> getHouseholdStock() {
    return this.householdStock;
  }
}
