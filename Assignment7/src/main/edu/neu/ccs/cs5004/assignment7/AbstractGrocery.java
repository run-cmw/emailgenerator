package edu.neu.ccs.cs5004.assignment7;

import java.util.Objects;

/**
 * This is an abstract class for Grocery items
 */
public abstract class AbstractGrocery extends AbstractProducts {
  private int weight;

  /**
   * Construct a grocery object
   * @param manufacturer of the Grocery item
   * @param productName of the Grocery item
   * @param price of the Grocery item
   * @param minAge required to purchase the grocery item
   * @param weight of the Grocery item
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AbstractGrocery)) {
      return false;
    }
    AbstractGrocery that = (AbstractGrocery) o;
    return getWeight() == that.getWeight();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getWeight());
  }
}
