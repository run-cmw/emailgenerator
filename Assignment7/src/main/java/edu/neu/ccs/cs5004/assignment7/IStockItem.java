package java.edu.neu.ccs.cs5004.assignment7;

/**
 * This interface contains all operations that all types of StockItems should support.
 */
public interface IStockItem {
  /**
   * Returns product information.
   *
   * @return product information
   */
  IProducts getProduct();

  /**
   * Return quantity of this product that the supermarket has in stock.
   *
   * @return quantity of product in stock
   */
  int getQuantity();

  /**
   * Reduce the quantity of an item in the event of a purchase if there is sufficient quantity.
   *
   * @param quantity
   * @throws NotEnoughItemsInStockException
   */
  void reduceQuantity(int quantity) throws NotEnoughItemsInStockException;
}