package edu.neu.ccs.cs5004.assignment8.problem2;

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
   * @param vehicle - vehicle that is insured.
   */
  public VehicleInsurance(IName owner,
      ArrayList<IName> insuredDrivers,
      IDate expirationDate,
      IVehicle vehicle) {
    super(owner, insuredDrivers, expirationDate, vehicle);
  }
}
