package edu.neu.ccs.cs5004;



public class Beer extends AbstractGrocery {
  private static final int minimumAge = 21;

  public Beer(String manufacturer, String productName, int price, int minAge, int weight) {
    super(manufacturer, productName, price, minAge, weight);
  }
}
