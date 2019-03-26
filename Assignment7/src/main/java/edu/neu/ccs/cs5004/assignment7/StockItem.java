package java.edu.neu.ccs.cs5004.assignment7;

public class StockItem implements IStockItem {
  private IProducts product;
  private int quantity;

  public StockItem(IProducts product, int quantity) {
    this.product = product;
    this.quantity = quantity;
  }

  public IProducts getProduct() {
    return this.product;
  }

  public int getQuantity() {
    return this.quantity;
  }

  public void reduceQuantity(int quantity) {
    this.quantity -= quantity;
  }
}
