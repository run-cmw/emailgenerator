package edu.neu.ccs.cs5004.Assignment8.Problem2;

import java.util.ArrayList;

/**
 * This class extends AbstractVehicleInsurance and represents a vehicle's insurance inforamtion.
 */
public class VehicleInsurance extends AbstractVehicleInsurance {

  /**
   * Construct a new VehicleInsurance given the owner, insured drivers, and expiration date.
   *
   * @param owner - vehicle's official owner
   * @param insuredDrivers - additional drivers covered by insurance
   * @param expirationDate - insurance expiration date
   */
  public VehicleInsurance(AbstractName owner,
      ArrayList<AbstractName> insuredDrivers,
      AbstractDate expirationDate) {
    super(owner, insuredDrivers, expirationDate);
  }
}
