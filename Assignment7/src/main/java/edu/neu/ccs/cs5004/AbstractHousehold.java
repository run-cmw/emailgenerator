package edu.neu.ccs.cs5004;



public class AbstractHousehold extends AbstractProducts {
  private int units;

  public AbstractHousehold(String manufacturer, String productName, int price, int minAge, int units) {
    super(manufacturer, productName, price, minAge);
    this.units = units;
  }
}
