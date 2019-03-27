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
   * Return the quantity of this product that the supermarket has in stock
   * @return the product quantity in stock
   */
  int getQuantity();

  /**
   * Reduce the quantity of product.
   * @param quantity of product to reduce
   */
  void reduceQuantity(int quantity);
}