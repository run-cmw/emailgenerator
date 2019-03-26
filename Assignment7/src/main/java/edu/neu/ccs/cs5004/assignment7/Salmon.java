package java.edu.neu.ccs.cs5004.assignment7;

/**
 * This class represents product Salmon. This class extends from the abstract class AbstractGrocery.
 */
public class Salmon extends AbstractGrocery  {

  /**
   * Constructs a Salmon object given its manufacturer, productName, price, minimum age required to
   * purchase and weight
   * @param manufacturer of this salmon
   * @param productName of this salmon
   * @param price of this salmon
   * @param minAge required to purchase salmon
   * @param weight of this salmon
   */

  public Salmon(String manufacturer, String productName, int price, int minAge, int weight) {
    super(manufacturer, productName, price, minAge, weight);
  }
}
