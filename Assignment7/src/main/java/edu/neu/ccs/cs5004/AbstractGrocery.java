package edu.neu.ccs.cs5004;

/**
 * This is an abstract class for Grocery items
 */
public abstract class AbstractGrocery extends AbstractProducts {
  private int weight;


  public AbstractGrocery(String manufacturer, String productName, int price, int minAge, int weight) {
    super(manufacturer, productName, price, minAge);
    this.weight = weight;
  }

  /**
   * Returns the weight of the grocery items
   * @return weight
   */
  public int getWeight() {
    return weight;
  }
}
