package edu.neu.ccs.cs5004.Assignment8.Problem2;

import java.util.ArrayList;

/**
 * This interface contains all functionality that each VehicleInsurance should support.
 */
public interface IVehicleInsurance {

  /**
   * Return official vehicle's official owner.
   *
   * @return vehicle's owner
   */
  IName getOwner();

  /**
   * Return list of additional drivers covered on insurance.
   *
   * @return list of additional drivers
   */
  ArrayList<IName> getInsuredDrivers();

  /**
   * Return insurance expiration date.
   *
   * @return expiration date
   */
  IDate getExpirationDate();

  /**
   * Returns the vehicle that is insured.
   * @return vehicle that is insured.
   */
  IVehicle getVehicle();

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
   * Format - "Owner: firstName lastName, Additional Insured: [firstName lastName, firstName lastName, ...]"
   *
   * @return string representation of the object
   */
  String toString();
}
