package edu.neu.ccs.cs5004.Assignment8.Problem2;

import java.util.ArrayList;

/**
 * This abstract class implements IVehicleInsurance and represents a vehicle's insurance
 * information.
 */
public class AbstractVehicleInsurance implements IVehicleInsurance {
  private AbstractName owner;
  private ArrayList<AbstractName> insuredDrivers;
  private AbstractDate expirationDate;

  /**
   * Construct a new VehicleInsurance given the owner, insured drivers, and expiration date.
   *
   * @param owner - vehicle's official owner
   * @param insuredDrivers - additional drivers covered by insurance
   * @param expirationDate - insurance expiration date
   */
  public AbstractVehicleInsurance(AbstractName owner,
      ArrayList<AbstractName> insuredDrivers, AbstractDate expirationDate) {
    this.owner = owner;
    this.insuredDrivers = insuredDrivers;
    this.expirationDate = expirationDate;
  }

  /**
   * Return official vehicle's official owner.
   *
   * @return vehicle's owner
   */
  public AbstractName getOwner() {
    return owner;
  }

  /**
   * Return list of additional drivers covered by insurance.
   *
   * @return list of additional drivers
   */
  public ArrayList<AbstractName> getInsuredDrivers() {
    return insuredDrivers;
  }

  /**
   * Return insurance expiration date.
   *
   * @return expiration date
   */
  public AbstractDate getExpirationDate() {
    return expirationDate;
  }
}
