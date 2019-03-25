package edu.neu.ccs.cs5004;


public abstract class AbstractProducts implements IProducts {
  protected String manufacturer;
  protected String productName;
  protected int price;
  protected int minAge;

  public AbstractProducts(String manufacturer, String productName, int price, int minAge) {
    this.manufacturer = manufacturer;
    this.productName = productName;
    this.price = price;
    this.minAge = 0;
  }
}
