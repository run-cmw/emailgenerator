package edu.neu.ccs.cs5004.Assignment8.Problem2;

import java.util.ArrayList;
import java.util.HashMap;

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
  public IName getOwner() {
    return this.owner;
  }

  /**
   * Return list of additional drivers covered by insurance.
   *
   * @return list of additional drivers
   */
  public ArrayList<IName> getInsuredDrivers() {
    return this.insuredDrivers;
  }

  /**
   * Return insurance expiration date.
   *
   * @return expiration date
   */
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
   * Returns a hash code value for the object.
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    return super.hashCode();
  }

  /**
   * Returns a string representation of the object.
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return super.toString();
  }
}
