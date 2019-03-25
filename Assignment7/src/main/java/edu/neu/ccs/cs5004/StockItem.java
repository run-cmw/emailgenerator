package edu.neu.ccs.cs5004;

public class StockItem {
  private AbstractProducts product;
  private int quantitiy;

  public StockItem(AbstractProducts product, int quantitiy) {
    this.product = product;
    this.quantitiy = quantitiy;
  }
}
