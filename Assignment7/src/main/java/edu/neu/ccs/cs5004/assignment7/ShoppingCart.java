package edu.neu.ccs.cs5004.assignment7;
import java.util.ArrayList;

/**
 * This class represents the shopping cart
 */

public class ShoppingCart implements IShoppingCart {
  private static final int MIN_QUANTITY = 1;
  private IInventorySystem inventory;

  private ArrayList<IProducts> cart;

  public ShoppingCart(IInventorySystem inventory) {
    cart = new ArrayList<IProducts>();
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
        cart.add(product);
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
          cart.add(product);
        }
      }
    } catch (Exception NotEnoughItemsInStockException) {
      System.out.print("Cannot add " + item.getProduct().getProductName() + " to the cart.");
    }
  }

  public int getTotalCostOfItems(){
    int value = 0;
    int cartSize = this.cart.size();

    // Iterating through shoppingCart list and adding all prices.
    for (int i = 0; i < cartSize; i++) {
      IProducts currentProduct = this.cart.get(i);
      value += currentProduct.getPrice();
    }
    return value;
  }

  /**
   * Returns the list of products in the shopping cart.
   * @return list of products in the shopping cart.
   */
  public ArrayList<IProducts> getShoppingCartProductsList() {
    return this.cart;
  }


  /**
   * Removes the given product from the shopping cart.
   */
  public void removeProduct(IProducts product) {
    this.cart.remove(product);
  }

}
