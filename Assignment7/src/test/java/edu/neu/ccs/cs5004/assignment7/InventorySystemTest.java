package edu.neu.ccs.cs5004.assignment7;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InventorySystemTest {
  IInventorySystem system;
  IStockItem groceryItem;
  IStockItem householdItem;
  AbstractGrocery salmon = new Salmon("salmonManufacturer", "salmon1", 3,
      21, 20);
  AbstractHousehold towel =  new PaperTowels("towelCreator", "towel1", 3,
      0, 20);

  @Before
  public void setUp() throws Exception {
    system = new InventorySystem();
    groceryItem = new StockItem(salmon, 20);
    householdItem = new StockItem(towel, 21);
  }

  @Test
  public void enoughItemsInStock() {
  }

  @Test
  public void reduceStockItem() {
  }

  @Test
  public void addNewGroceryItem() {
    system = new InventorySystem();
    int grocerySize = system.getGroceryStock().size();
    int householdSize = system.getHouseholdStock().size();
    assertEquals((int)0, grocerySize);
    assertEquals((int)0, householdSize);
    system.addNewItem(groceryItem);
    grocerySize = system.getGroceryStock().size();
    householdSize = system.getHouseholdStock().size();
    assertEquals((int)1, grocerySize);
    assertEquals((int)0, householdSize);
  }


  @Test
  public void addNewHouseholdItem() {

    int grocerySize = system.getGroceryStock().size();
    int householdSize = system.getHouseholdStock().size();
    assertEquals((int)0, grocerySize);
    assertEquals((int)0, householdSize);
    system.addNewItem(householdItem);
    grocerySize = system.getGroceryStock().size();
    householdSize = system.getHouseholdStock().size();
    assertEquals((int)0, grocerySize);
    assertEquals((int)1, householdSize);
  }

}