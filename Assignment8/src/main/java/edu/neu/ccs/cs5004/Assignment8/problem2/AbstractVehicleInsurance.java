package edu.neu.ccs.cs5004.Assignment8.problem2;

import java.util.ArrayList;

/**
 * This abstract class implements IVehicleInsurance and represents a vehicle's insurance
 * information.
 */
public class AbstractVehicleInsurance implements IVehicleInsurance {
  private IName owner;
  private ArrayList<IName> insuredDrivers;
  private IDate expirationDate;
  private IVehicle vehicle;

  /**
   * Construct a new VehicleInsurance given the owner, insured drivers, and expiration date.
   *
   * @param owner - vehicle's official owner
   * @param insuredDrivers - additional drivers covered by insurance
   * @param expirationDate - insurance expiration date
   * @param vehicle - vehicle that is insured.
   */
  public AbstractVehicleInsurance(IName owner,
      ArrayList<IName> insuredDrivers, IDate expirationDate, IVehicle vehicle) {
    this.owner = owner;
    this.insuredDrivers = insuredDrivers;
    this.expirationDate = expirationDate;
    this.vehicle = vehicle;
  }

  /**
   * Return official vehicle's official owner.
   *
   * @return vehicle's owner
   */
  @Override
  public IName getOwner() {
    return this.owner;
  }

  /**
   * Return list of additional drivers covered by insurance.
   *
   * @return list of additional drivers
   */
  @Override
  public ArrayList<IName> getInsuredDrivers() {
    return this.insuredDrivers;
  }

  /**
   * Return insurance expiration date.
   *
   * @return expiration date
   */
  @Override
  public IDate getExpirationDate() {
    return this.expirationDate;
  }

  /**
   * Returns the vehicle that is insured.
   *
   * @return vehicle that is insured.
   */
  @Override
  public IVehicle getVehicle() {
    return this.vehicle;
  }

  /**
   * Returns a string representation of the object.
   * Format - "Owner: firstName lastName,
   * Additional Insured: [firstName lastName, firstName lastName, ...]"
   *
   * @return string representation of the object
   */
  @Override
  public String toString() {
    return "Owner: "
        + owner
        + ", Additional Insured: "
        + insuredDrivers;
  }
}
