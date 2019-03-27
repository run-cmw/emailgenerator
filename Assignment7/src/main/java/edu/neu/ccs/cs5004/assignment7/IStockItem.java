package edu.neu.ccs.cs5004.assignment7;

/**
 * Interface for Stock Item
 */
public interface IStockItem {

  /**
   * Returns the product
   * @return product
   */
  IProducts getProduct();

  /**
   * Returns the quantity of product
   * @return the product quantity
   */
  int getQuantity();

  /**
   * Reduces the quantity of product
   * @param quantity of product
   */
  void reduceQuantity(int quantity);

}
