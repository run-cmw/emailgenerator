package edu.neu.ccs.cs5004.assignment7;

/**
 *This class represents Beer. It extends the abstract class AbstractGrocery.
 */

public class Beer extends AbstractGrocery {
  private static final int MINIMUM_AGE = 21;

  /**
   * Constructs a Beer object given manufactuer, productName, price, minAge required to purchase
   * and weight
   * @param manufacturer of this Beer
   * @param productName of this Beer
   * @param price of this Beer
   * @param minAge required to purchase this Beer
   * @param weight of this Beer
   */
  public Beer(String manufacturer, String productName, int price, int minAge, int weight) {
    super(manufacturer, productName, price, MINIMUM_AGE, weight);
  }
}
