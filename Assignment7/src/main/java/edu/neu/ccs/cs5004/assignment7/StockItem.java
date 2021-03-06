package edu.neu.ccs.cs5004.assignment7;

/**
 * This class represents stock items
 */
public class StockItem implements IStockItem {
  private IProducts product;
  private int quantity;
  private static final int MIN_QUANTITY = 1;

  /**
   * Constructs a stock Item object
   * @param product product
   * @param quantity quantity of product
   */
  public StockItem(IProducts product, int quantity) throws InvalidQuantityException {
    this.product = product;
    if (quantity < MIN_QUANTITY ) {
      throw new InvalidQuantityException();
    } else {
      this.quantity = quantity;
    }
  }

  /**
   * Get a product object
   * @return product
   */
  public IProducts getProduct() {
    return this.product;
  }

  /**
   * Get quantity of product this product that the supermarket has in stock
   * @return quantity of product in stock
   */
  public int getQuantity() {
    return this.quantity;
  }

  /**
   * Reduce the quantity of product.
   * @param quantity of product to reduce
   */
  public void reduceQuantity(int quantity) {
    this.quantity -= quantity;
  }
}
