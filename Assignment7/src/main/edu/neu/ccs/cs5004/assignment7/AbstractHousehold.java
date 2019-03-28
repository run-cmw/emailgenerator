package edu.neu.ccs.cs5004.assignment7;

import java.util.Objects;

/**
 * This abstract class is for Household items
 */

public abstract class AbstractHousehold extends AbstractProducts {
  private int units;

  /**
   * Constructs a Household item
   * @param manufacturer of the household item
   * @param productName of the household item
   * @param price of the household item
   * @param minAge required to purchase the household item
   * @param units of the household item
   */
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AbstractHousehold)) {
      return false;
    }
    AbstractHousehold that = (AbstractHousehold) o;
    return getUnits() == that.getUnits();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getUnits());
  }
}
