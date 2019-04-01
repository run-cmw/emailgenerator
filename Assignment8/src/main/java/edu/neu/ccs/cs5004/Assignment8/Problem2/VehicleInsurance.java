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
   * @param vehicle - vehicle that is insured.
   */
  public VehicleInsurance(IName owner,
      ArrayList<IName> insuredDrivers,
      IDate expirationDate,
      IVehicle vehicle) {
    super(owner, insuredDrivers, expirationDate, vehicle);
  }

  /**
   * Indicates whether some other object is "equal to" this one.
   *
   * @param obj the reference object with which to compare.
   * @return {@code true} if this object is the same as the obj argument; {@code false} otherwise.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof VehicleInsurance)) {
      return false;
    }
    VehicleInsurance other = (VehicleInsurance) obj;
    return this.getOwner().equals(other.getOwner())
        && this.getExpirationDate().equals(other.getExpirationDate())
        && this.getInsuredDrivers().equals(other.getInsuredDrivers())
        && this.getVehicle().equals(other.getVehicle());
  }
}
