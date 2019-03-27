package edu.neu.ccs.cs5004.assignment7;


import java.util.ArrayList;

/**
 * This class represents the shopping cart
 */

public class ShoppingCart extends AbstractProducts {


  private ArrayList<IProducts> shoppingCart;

  public ShoppingCart(String manufacturer, String productName, int price, int minAge) {
    super(manufacturer, productName, price, minAge);
  }

  //TODO: SHOULD HAVE A WAY TO CALCULATE TOTAL COST OF ALL ITEMS

  //create a method to add items to the shopping cart

  public void addProduct(IStockItem item) throws NotEnoughItemsInStockException{



  }


  public void addporduct(IStockItem item, int quantity) throws NotEnoughItemsInStockException {

  }




  public int gettotalCostOfItems(){
    return 0;
  }
}
