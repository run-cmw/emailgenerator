package edu.neu.ccs.cs5004.Assignment8.Problem2;

import java.util.ArrayList;
import java.util.Objects;

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
   * @param obj - the reference object with which to compare
   * @return {@code true} if this object is the same as the obj argument and {@code false} otherwise
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

  /**
   * Returns a hash code value for the object.
   *
   * @return hash code value for the object
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.getOwner(), this.getInsuredDrivers(), this.getExpirationDate(), this.getVehicle());
  }

  /**
   * Returns a string representation of the object.
   * Format - "Owner: firstName lastName, Additional Insured: firstName lastName, firstName lastName, ..."
   *
   * @return string representation of the object
   */
  @Override
  public String toString() {
    return "Owner: " +
        super.getOwner() +
        ", Additional Insured: " +
        super.getInsuredDrivers();
  }
}
