package edu.neu.ccs.cs5004.assignment7;

import java.util.ArrayList;

/**
 * This is an interface for receipt
 */
public interface IReceipt {

  /**
   * Returns the list of products that were removed from the order because the customer did
   * not meet the minimum age requirement.
   * @return list of products that were removed from the order because the customer did
   * not meet the minimum age requirement.
   */
  ArrayList<IProducts> getRemovedProductList();

  /**
   * Returns the list of products that were out of stock and could not be substituted.
   * @return list of products that were out of stock and could not be substituted.
   */
  ArrayList<IProducts> getOutOfStockProductList();

  /**
   * Returns a list of products that the customer received when the order was processed.
   * @return list of products that the customer received when the order was processed.
   */
  ArrayList<IProducts> getListOfProductsReceived();

  /**
   * Returns the total price paid for all the products that the customer received.
   * @return total price paid for all the products that the customer received.
   */
  int getTotalPricePaid();


}
