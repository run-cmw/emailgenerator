package edu.neu.ccs.cs5004.assignment7;
import java.util.ArrayList;

/**
 * This class represents the shopping cart
 */

public class ShoppingCart implements IShoppingCart {
  private static final int MIN_QUANTITY = 1;

  private ArrayList<IStockItem> shoppingCart;

  public ShoppingCart() {
    shoppingCart = new ArrayList<IStockItem>();
  }

  //create a method to add items to the shopping cart
  public void addProduct(IStockItem item) throws NotEnoughItemsInStockException {
    int quantity = MIN_QUANTITY;
    try {
      if (item.getQuantity() < quantity) {
        throw new NotEnoughItemsInStockException();
      } else {
        shoppingCart.add(item);
      }
    } catch (Exception NotEnoughItemsInStockException) {
        System.out.print("Cannot add " + item.getProduct().getProductName() + " to the cart.");
    }
  }

  public void addProduct (IStockItem item, int quantity) throws NotEnoughItemsInStockException {
    try {
      if (item.getQuantity() < quantity) {
        throw new NotEnoughItemsInStockException();
      } else {
        for (int i = quantity; i > 0; i--) {
          shoppingCart.add(item);
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
      value += this.shoppingCart.get(i).getProduct().getPrice();
    }
    return value;
  }
}
