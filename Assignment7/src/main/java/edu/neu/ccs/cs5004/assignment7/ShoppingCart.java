package edu.neu.ccs.cs5004.assignment7;
import java.util.ArrayList;

/**
 * This class represents the shopping cart
 */

public class ShoppingCart implements IShoppingCart {
  private static final int MIN_QUANTITY = 1;
  private IInventorySystem inventory;

  private ArrayList<IProducts> shoppingCart;

  public ShoppingCart(IInventorySystem inventory) {
    shoppingCart = new ArrayList<IProducts>();
    this.inventory = inventory;
  }

  //create a method to add items to the shopping cart
  public void addProduct(IProducts product) throws NotEnoughItemsInStockException {
    int quantity = MIN_QUANTITY;
    IStockItem item = this.inventory.findStockItem(product);
    try {
      if (item.getQuantity() < quantity) {
        throw new NotEnoughItemsInStockException();
      } else {
        shoppingCart.add(product);
      }
    } catch (Exception NotEnoughItemsInStockException) {
        System.out.print("Cannot add " + item.getProduct().getProductName() + " to the cart.");
    }
  }

  public void addProduct (IProducts product, int quantity) throws NotEnoughItemsInStockException {
    IStockItem item = this.inventory.findStockItem(product);
    try {
      if (item.getQuantity() < quantity) {
        throw new NotEnoughItemsInStockException();
      } else {
        for (int i = quantity; i > 0; i--) {
          shoppingCart.add(product);
        }
      }
    } catch (Exception NotEnoughItemsInStockException) {
      System.out.print("Cannot add " + item.getProduct().getProductName() + " to the cart.");
    }
  }

  public int getTotalCostOfItems(){
    int value = 0;
    int cartSize = this.shoppingCart.size();

    // Iterating through shoppingCart list and adding all prices.
    for (int i = 0; i < cartSize; i++) {
      IProducts currentProduct = this.shoppingCart.get(i);
      value += currentProduct.getPrice();
    }
    return value;
  }
}
