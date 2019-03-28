package edu.neu.ccs.cs5004.assignment7;

/**
 * This is an abstract class for Grocery items
 */
public abstract class AbstractGrocery extends AbstractProducts {
  private int weight;

  /**
   * Construct grocery object
   * @param manufacturer of grocery item
   * @param productName of grocery item
   * @param price of grocery item
   * @param minAge to purchase grocery item
   * @param weight of grocery item
   */

  public AbstractGrocery(String manufacturer, String productName, int price, int minAge, int weight) {
    super(manufacturer, productName, price, minAge);
    this.weight = weight;
  }

  /**
   * Returns the weight of the grocery items
   * @return weight
   */
  public int getWeight() {
    return this.weight;
  }
}
