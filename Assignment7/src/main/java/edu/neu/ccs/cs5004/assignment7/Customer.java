package edu.neu.ccs.cs5004.assignment7;

/**
 * This class represents a Customer
 */
public class Customer implements ICustomer {
  private String name;
  private ShoppingCart cart;
  private Integer age;

  /**
   * This constructs a Customer object
   * @param name of the customer
   * @param cart of the customer
   * @param age of the customer
   */
  public Customer(String name, ShoppingCart cart, Integer age) {
    this.name = name;
    this.cart = cart;
    this.age = age;
  }

  /**
   * Returns the name of the customer
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the shopping cart of the customer
   * @return cart
   */
  public ShoppingCart getCart() {
    return cart;
  }

  /**
   * Returns the age of the customer
   * @return age
   */

  public Integer getAge() {
    return age;
  }
  /**
   * Returns the total cost of items
   * @return cost of items
   */


}
