package edu.neu.ccs.cs5004.Assignment8.Problem2;

/**
 * Represents a Driver that has been accepted in the RideShare System. Includes
 * Driver and Vehicle information.
 */
public interface IAcceptedDriver {

  /**
   * Returns the name of the accepted driver.
   * @return name of the accepted driver.
   */
  IName getName();

  /**
   * Returns birthday of the accepted driver.
   * @return birthday of the accepted driver.
   */
  IDate getBirthday();

  /**
   * Returns license of the accepted driver.
   * @return license of the accepted driver.
   */
  IDriversLicense getLicense();
  /**
   * Returns vehicle of the accepted driver.
   * @return vehicle of the accepted driver.
   */
  IVehicle getVehicle();

  /**
   * Indicates whether some other object is "equal to" this one.
   *
   * @param obj the reference object with which to compare.
   * @return {@code true} if this object is the same as the obj argument; {@code false} otherwise.
   */
  boolean equals(Object obj);

  /**
   * Returns a string representation of the object.
   * Format - "Driver: First Name Last Name,
   *           Vehicle: Year Make Model"
   * @return a string representation of the object.
   */
  String toString();

  /**
   * Returns a hash code value for the object.
   * @return a hash code value for this object.
   */
  int hashCode();
}
