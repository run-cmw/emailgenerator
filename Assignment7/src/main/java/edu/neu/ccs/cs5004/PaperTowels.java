package edu.neu.ccs.cs5004;

/**
 * This class represents paper towels. It extends form the abstract class AbstractHousehold
 */

public class PaperTowels extends AbstractHousehold {

  /**
   * Constructs a paper towel object given its manufacturer name, product name, price,
   * minimum age required to purchase and number of units.
   * @param manufacturer of this paper towels
   * @param productName of this paper towels
   * @param price of this paper towels
   * @param minAge required to purchase this paper towels
   * @param units of this paper towels
   */

  public PaperTowels(String manufacturer, String productName, int price, int minAge, int units) {
    super(manufacturer, productName, price, minAge, units);
  }
}
