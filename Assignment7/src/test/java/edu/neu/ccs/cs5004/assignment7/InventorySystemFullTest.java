package edu.neu.ccs.cs5004.assignment7;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class InventorySystemFullTest {
  private IInventorySystem system;
  IShoppingCart cart;
  private IStockItem salmonItem;
  private IStockItem towelItem;
  private IStockItem beerItem;
  private IStockItem cheeseItem;
  private IStockItem shampooItem;
  private AbstractGrocery salmon = new Salmon("salmonManufacturer", "salmon1", 5,
      21, 20);
  private AbstractHousehold towel =  new PaperTowels("towelCreator", "towel1", 3,
      0, 20);
  private IProducts beer  = new Beer("beerManufacturer", "beer1", 4,
      21, 20);
  private IProducts cheese = new Cheese("cheeseManufacturer", "cheese1", 2,
      0, 20);
  private IProducts shampoo = new Shampoo("shampooCreator", "shampoo1", 7,
      0, 20);
  private ArrayList<IProducts> outOfStockList;

  @Before
  public void setUp() throws Exception {
    system = new InventorySystem();
    salmonItem = new StockItem(salmon, 1);
    towelItem = new StockItem(towel, 2);
    beerItem = new StockItem(beer, 3);
    cheeseItem = new StockItem(cheese, 4);
    shampooItem = new StockItem(shampoo, 5);
    cart = new ShoppingCart(system);
  }



  @Test
  public void addNewGroceryItem() {
    int grocerySize = system.getGroceryStock().size();
    int householdSize = system.getHouseholdStock().size();
    assertEquals((int)0, grocerySize);
    assertEquals((int)0, householdSize);
    system.addNewItem(salmonItem);
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
    system.addNewItem(towelItem);
    grocerySize = system.getGroceryStock().size();
    householdSize = system.getHouseholdStock().size();
    assertEquals((int)0, grocerySize);
    assertEquals((int)1, householdSize);
  }

  @Test
  public void enoughItemsInStock() {
    // Salmon has quantity 1.
    assertEquals(true, system.enoughItemsInStock(salmonItem, 1));
    assertEquals(false, system.enoughItemsInStock(salmonItem, 2));

  }

  @Test
  public void reduceStockItem() throws NotEnoughItemsInStockException {
    assertEquals((int) 1, salmonItem.getQuantity());
    system.reduceStockItem(salmonItem, 1);
    assertEquals((int) 0, salmonItem.getQuantity());
  }

  @Test (expected = NotEnoughItemsInStockException.class )
  public void invalidReduceStockItem() throws NotEnoughItemsInStockException {
    assertEquals((int) 1, salmonItem.getQuantity());
    system.reduceStockItem(salmonItem, 1);
    assertEquals((int) 0, salmonItem.getQuantity());
    system.reduceStockItem(salmonItem, 1);
  }

  @Test
  public void getTotalRetailValue() {
    assertEquals((int) 0, system.getTotalRetailValue());
    // Adding salmon grocery product that costs 5.
    system.addNewItem(salmonItem);
    assertEquals((int) 5, system.getTotalRetailValue());

    // Adding towel household product that costs 3. Total should be 8
    system.addNewItem(towelItem);
    assertEquals((int) 8, system.getTotalRetailValue());
  }

  @Test
  public void getGroceryStock() {
    int grocerySize = system.getGroceryStock().size();
    int householdSize = system.getHouseholdStock().size();
    assertEquals((int)0, grocerySize);
    assertEquals((int)0, householdSize);
    system.addNewItem(salmonItem);
    // Salmon should be the only item in the grocery stock list.
    grocerySize = system.getGroceryStock().size();
    assertEquals((int) 1, grocerySize);
    assertEquals(salmonItem, system.getGroceryStock().get(0));

  }

  @Test
  public void getHouseholdStock() {
    int grocerySize = system.getGroceryStock().size();
    int householdSize = system.getHouseholdStock().size();
    assertEquals((int)0, grocerySize);
    assertEquals((int)0, householdSize);
    system.addNewItem(towelItem);
    // Salmon should be the only item in the grocery stock list.
    householdSize = system.getHouseholdStock().size();
    assertEquals((int) 1, householdSize);
    assertEquals(towelItem, system.getHouseholdStock().get(0));

  }

  @Test
  public void findStockItem() {
    // Cheese Stock Item - price 2 quantity 4
    // First adding cheese to inventory system.
    system.addNewItem(cheeseItem);
    IStockItem item = system.findStockItem(cheese);
    assertEquals((int) 4, item.getQuantity());
    assertEquals((int) 2, item.getProduct().getPrice());
  }

}