package java.edu.neu.ccs.cs5004.assignment7;

import java.util.ArrayList;

public class InventorySystem implements IInventorySystem{
  private ArrayList<IStockItem> groceryStock;
  private ArrayList<IStockItem> householdStock;

  public InventorySystem() {
    groceryStock = new ArrayList<IStockItem>();
    householdStock = new ArrayList<IStockItem>();
  }

  @Override
  public Boolean enoughItemsInStock(IStockItem item, int quantity) {
    if (item.getQuantity() >= quantity) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public void reduceStockItem(IStockItem item, int quantity) throws NotEnoughItemsInStockException{
    if (enoughItemsInStock(item, quantity)) {
      item.reduceQuantity(quantity);
    } else {
      throw new NotEnoughItemsInStockException();
    }
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

  @Override
  public ArrayList<IStockItem> getGroceryStock() {
    return this.groceryStock;
  }

  @Override
  public ArrayList<IStockItem> getHouseholdStock() {
    return this.householdStock;
  }

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
}
