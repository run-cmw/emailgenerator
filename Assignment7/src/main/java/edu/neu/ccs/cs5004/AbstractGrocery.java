package edu.neu.ccs.cs5004;

public class AbstractGrocery extends AbstractProducts {
  private int weight;


  public AbstractGrocery(String manufacturer, String productName, int price, int minAge, int weight) {
    super(manufacturer, productName, price, minAge);
    this.weight = weight;
  }
}
