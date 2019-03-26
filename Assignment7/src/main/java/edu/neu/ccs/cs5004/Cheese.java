package edu.neu.ccs.cs5004;

/**
 * This class represents cheese. It extends from the abstract class AbstractGrocery
 */
public class Cheese extends AbstractGrocery {

  /**
   * Constructs a Cheese object that has Manufacturer, productName, price, min Age required
   * to purchase the product and weight
   * @param manufacturer of this Cheese
   * @param productName of this Cheese
   * @param price of this Cheese
   * @param minAge required to purchase this cheese
   * @param weight of this Cheese
   */

  public Cheese(String manufacturer, String productName, int price, int minAge, int weight) {
    super(manufacturer, productName, price, minAge, weight);
  }
}
