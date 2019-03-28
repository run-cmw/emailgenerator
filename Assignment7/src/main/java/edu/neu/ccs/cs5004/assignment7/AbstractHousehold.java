package edu.neu.ccs.cs5004.assignment7;

import java.util.Objects;

/**
 * This abstract class is for Household items
 */

public abstract class AbstractHousehold extends AbstractProducts {
  private int units;

  /**
   * Constructs a Household product
   * @param manufacturer of the household product
   * @param productName of the household product
   * @param price of the household product
   * @param minAge required to purchase household product
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

  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AbstractHousehold)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    AbstractHousehold that = (AbstractHousehold) o;
    return getUnits() == that.getUnits();
  }

  public int hashCode() {
    return Objects.hash(super.hashCode(), getUnits());
  }
}
