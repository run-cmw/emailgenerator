package edu.neu.ccs.cs5004.assignment8.Problem2;

/**
 * This interface contains all functionality that all Vehicles should support.
 */
public interface IVehicle {
  /**
   * Return vehicle make.
   *
   * @return vehicle make
   */
  String getMake();

  /**
   * Return vehicle model.
   *
   * @return vehicle model
   */
  String getModel();

  /**
   * Return vehicle year.
   *
   * @return vehicle year
   */
  int getYear();

  /**
   * Return vehicle owner.
   *
   * @return vehicle owner
   */
  IName getOwner();

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
   * Format - "year make model"
   *
   * @return string representation of the object
   */
  String toString();
}
