package java.edu.neu.ccs.cs5004.assignment7;

/**
 * Interface for Products
 */
public interface IProducts {

  /**
   * Returns the manufacturer of the product
   * @return manufacturer
   */
  String getManufacturer();

  /**
   * Returns the product name
   * @return product name
   */
  String getProductName();

  /**
   * Returns the price of the product
   * @return price of the product
   */
  int getPrice();

  /**
   * Returns the minimum Age required to buy the product
   * @return minimum age
   */
  int getMinAge();



}
