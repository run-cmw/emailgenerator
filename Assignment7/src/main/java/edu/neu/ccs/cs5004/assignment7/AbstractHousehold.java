package edu.neu.ccs.cs5004.assignment7;

/**
 * This abstract class is for Household items
 */

public abstract class AbstractHousehold extends AbstractProducts {
  private int units;

  public AbstractHousehold(String manufacturer, String productName, int price, int minAge, int units) {
    super(manufacturer, productName, price, minAge);
    this.units = units;
  }

  /**
   * return the number of household items
   * @return units
   */
  public int getUnits() {
    return units;
  }
}
