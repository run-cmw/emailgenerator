package edu.neu.ccs.cs5004;

/**
 * This class represents the abstract class for products
 */

public abstract class AbstractProducts implements IProducts {
  protected String manufacturer;
  protected String productName;
  protected int price;
  protected int minAge;



  public AbstractProducts(String manufacturer, String productName, int price, int minAge) {
    this.manufacturer = manufacturer;
    this.productName = productName;
    this.price = price;
    this.minAge = 0;
  }

  /**
   * returns manufacturer of the product
   * @return manufacturer
   */
  public String getManufacturer() {
    return manufacturer;
  }

  /**
   * returns the product name
   * @return productName
   */
  public String getProductName() {
    return productName;
  }

  /**
   * returns the price of the product
   * @return
   */
  public int getPrice() {
    return price;
  }

  /**
   * returns the minimum age to purchase the product
   * @return minAge
   */
  public int getMinAge() {
    return minAge;
  }
}
