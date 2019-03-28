package edu.neu.ccs.cs5004.assignment7;

import java.util.ArrayList;

/**
 * This Abstract class represents receipts.
 */
public class Receipt implements IReceipt{
  private int totalPrice;
  private ArrayList<IProducts> receivedItemsList;
  private ArrayList<IProducts> outOfStockList;
  private ArrayList<IProducts> removedItemsList;


  public Receipt(ArrayList<IProducts> receivedItemsList,
      ArrayList<IProducts> outOfStockList,
      ArrayList<IProducts> removedItemsList) {
    this.receivedItemsList = receivedItemsList;
    this.outOfStockList = outOfStockList;
    this.removedItemsList = removedItemsList;
    this.totalPrice = this.calculateTotalPrice();

  }

  /**
   * Returns the list of products that were removed from the order because the customer did not meet
   * the minimum age requirement.
   *
   * @return list of products that were removed from the order because the customer did not meet the
   * minimum age requirement.
   */
  @Override
  public ArrayList<IProducts> getRemovedProductList() {
    return this.getRemovedProductList();
  }

  /**
   * Returns the list of products that were out of stock and could not be substituted.
   *
   * @return list of products that were out of stock and could not be substituted.
   */
  @Override
  public ArrayList<IProducts> getOutOfStockProductList() {
    return null;
  }

  /**
   * Returns a list of products that the customer received when the order was processed.
   *
   * @return list of products that the customer received when the order was processed.
   */
  @Override
  public ArrayList<IProducts> getListOfProductsReceived() {
    return null;
  }

  /**
   * Returns the total price paid for all the products that the customer received.
   *
   * @return total price paid for all the products that the customer received.
   */
  @Override
  public int getTotalPricePaid() {
    return 0;
  }

  /**
   * Helper method that calculates and returns the total price of the products that the
   * customer received.
   * @return the total price of the products that the
   * customer received.
   */
  private int calculateTotalPrice() {
    int total = 0;
    for (int i = 0; i < this.receivedItemsList.size(); i++) {
      total += this.receivedItemsList.get(i).getPrice();
    }
    return total;
  }
}
