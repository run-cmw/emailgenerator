package java.edu.neu.ccs.cs5004.assignment7;

public class StockItem implements IStockItem {
  private IProducts product;
  private int quantity;

  public StockItem(IProducts product, int quantity) {
    this.product = product;
    this.quantity = quantity;
  }

  /**
   * Returns product information.
   *
   * @return product information
   */
  public IProducts getProduct() {
    return this.product;
  }

  /**
   * Return quantity of this product that the supermarket has in stock.
   *
   * @return quantity of product in stock
   */
  public int getQuantity() {
    return this.quantity;
  }

  /**
   * Reduce the quantity of an item in the event of a purchase if there is sufficient quantity.
   *
   * @param quantity
   * @throws NotEnoughItemsInStockException
   */
  public void reduceQuantity(int quantity) throws NotEnoughItemsInStockException {
    if (InventorySystem.enoughItemsInStock()) {
      this.quantity -= quantity;
    }
    else {
      throw new NotEnoughItemsInStockException();
    }
  }
}
