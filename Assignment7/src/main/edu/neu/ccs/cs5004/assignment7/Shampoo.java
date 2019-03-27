package edu.neu.ccs.cs5004.assignment7;

/**
 * This class represents Shampoo objects. It extends from the abstract class AbstractHousehold
 */
public class Shampoo extends AbstractHousehold{

  /**
   * Constructs a Shampoo object given its manufacturer, productName, price,
   * minimum age required to purchase Shampoo, and the number of units of Shampoo
   * @param manufacturer of this Shampoo
   * @param productName of this Shampoo
   * @param price of this Shampoo
   * @param minAge required to purchase Shampoo
   * @param units of this Shampoo
   */

  public Shampoo(String manufacturer, String productName, int price, int minAge, int units) {
    super(manufacturer, productName, price, minAge, units);
  }
}
