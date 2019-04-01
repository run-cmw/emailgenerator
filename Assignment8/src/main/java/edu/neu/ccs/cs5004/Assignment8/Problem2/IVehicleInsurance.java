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
}
