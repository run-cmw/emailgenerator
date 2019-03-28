package edu.neu.ccs.cs5004.assignment7;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
public class CustomerTest {
  IShoppingCart cart;
  IProducts salmon;
  IProducts shampoo;
  IStockItem salmonItem;
  IStockItem shampooItem;
  IInventorySystem inventory;
  ICustomer customer;
  @Before
  public void setUp() throws Exception {
    salmon = new Salmon("salmonManufacturer", "salmon1", 2,
        0, 20);
    shampoo = new Shampoo("shampooManufacturer", "shampoo", 3,
        0, 20);
    salmonItem = new StockItem(salmon, 3);
    shampooItem = new StockItem(shampoo, 1);
    inventory = new InventorySystem();
    inventory.addNewItem(salmonItem);
    inventory.addNewItem(shampooItem);
    cart = new ShoppingCart(inventory);
    cart.addProduct(salmon, 1);
    customer = new Customer("Hi", cart, 25);
  }
  @Test
  public void getName() {
    assertEquals("Hi", customer.getName());
  }
  @Test
  public void getCart() {
    IShoppingCart currentCart = customer.getCart();
    assertEquals(cart, currentCart);
    assertEquals(salmon, currentCart.getShoppingCartProductsList().get(0));
  }
  @Test
  public void getAge() {
    assertEquals( (int) 25, customer.getAge());
  }
}
