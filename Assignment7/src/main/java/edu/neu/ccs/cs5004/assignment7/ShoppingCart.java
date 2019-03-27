package edu.neu.ccs.cs5004.assignment7;


import java.util.ArrayList;

/**
 * This class represents the shopping cart
 */

public class ShoppingCart extends AbstractProducts {
  private static final int MIN_QUANTITY = 1;

  private ArrayList<IStockItem> shoppingCart;

  public ShoppingCart(String manufacturer, String productName, int price, int minAge) {
    super(manufacturer, productName, price, minAge);
  }

  //TODO: SHOULD HAVE A WAY TO CALCULATE TOTAL COST OF ALL ITEMS

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
        shoppingCart.add(item);
      }
    } catch (Exception NotEnoughItemsInStockException) {
      System.out.print("Cannot add " + item.getProduct().getProductName() + " to the cart.");
    }
  }




  public int gettotalCostOfItems(){
    return 0;
  }
}
