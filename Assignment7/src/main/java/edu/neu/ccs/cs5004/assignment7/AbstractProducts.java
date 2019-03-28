package edu.neu.ccs.cs5004.assignment7;

import java.util.Objects;

/**
 * This class represents the abstract class for products
 */

public abstract class AbstractProducts implements IProducts {
  protected String manufacturer;
  protected String productName;
  protected int price;
  protected int minAge;

  /**
   * Constructs a product
   * @param manufacturer of the product
   * @param productName of the product
   * @param price of the product
   * @param minAge required to purchase product
   */
  public AbstractProducts(String manufacturer, String productName, int price, int minAge) {
    this.manufacturer = manufacturer;
    this.productName = productName;
    this.price = price;
    this.minAge = minAge;
  }

  /**
   * returns manufacturer of the product
   * @return manufacturer
   */
  public String getManufacturer() {
    return this.manufacturer;
  }

  /**
   * returns the product name
   * @return productName
   */
  public String getProductName() {
    return this.productName;
  }

  /**
   * returns the price of the product
   * @return
   */
  public int getPrice() {
    return this.price;
  }

  /**
   * returns the minimum age to purchase the product
   * @return minAge
   */
  public int getMinAge() {
    return this.minAge;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (!(object instanceof AbstractProducts)) {
      return false;
    }
    AbstractProducts that = (AbstractProducts) object;
    return getPrice() == that.getPrice() &&
        getMinAge() == that.getMinAge() &&
        getManufacturer().equals(that.getManufacturer()) &&
        getProductName().equals(that.getProductName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getManufacturer(), getProductName(), getPrice(), getMinAge());
  }
}
