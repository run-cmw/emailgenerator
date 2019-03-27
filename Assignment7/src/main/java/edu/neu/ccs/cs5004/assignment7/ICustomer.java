package edu.neu.ccs.cs5004.assignment7;

/**
 * This is an interface for the Customer
 */
public interface ICustomer {


  /**
   * returns the Name of the customer
   * @return name
   */
  String getName();

  /**
   * returns the cart of the customer
   * @return cart
   */
  ShoppingCart getCart();

  /**
   * return the age of the customer
   * @return age
   */
  Integer getAge();



}
