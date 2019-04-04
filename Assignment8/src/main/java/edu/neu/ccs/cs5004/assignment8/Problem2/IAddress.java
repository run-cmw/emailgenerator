package edu.neu.ccs.cs5004.assignment8.problem2;

/**
 * This interface contains all functionality that all Addresses should support.
 */
public interface IAddress {
  /**
   * Return street number, name, and unit.
   *
   * @return street number, name, and unit
   */
  String getStreetNumberNameUnit();

  /**
   * Return city.
   *
   * @return city
   */
  String getCity();

  /**
   * Return state.
   *
   * @return state
   */
  String getState();

  /**
   * Return zip code.
   *
   * @return zip code
   */
  String getZipCode();

  /**
   * Indicates whether some other object is "equal to" this one.
   *
   * @param obj - the reference object with which to compare
   * @return {@code true} if this object is the same as the obj argument and {@code false} otherwise
   */
  boolean equals(Object obj);

  /**
   * Returns a hash code value for the object.
   *
   * @return hash code value for the object
   */
  int hashCode();

  /**
   * Returns a string representation of the object.
   * Format - "streetNumberNameUnit
   *           city, state zipCode"
   *
   * @return string representation of the object
   */
  String toString();
}
