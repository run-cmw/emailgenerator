package edu.neu.ccs.cs5004.assignment7;

/**
 * This class represents a Customer
 */
public class Customer implements ICustomer {
  private String name;
  private IShoppingCart cart;
  private int age;

  /**
   * This constructs a Customer object
   * @param name of the customer
   * @param cart of the customer
   * @param age of the customer
   */
  public Customer(String name, IShoppingCart cart, int age) {
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
  public IShoppingCart getCart() {
    return this.cart;
  }

  /**
   * Returns the age of the customer
   * @return age
   */

  public int getAge() {
    return age;
  }
  /**
   * Returns the total cost of items
   * @return cost of items
   */


}
