package edu.neu.ccs.cs5004.Assignment8.Problem2;

import com.sun.xml.internal.bind.v2.model.core.ID;
import java.util.Iterator;

/**
 * This abstract class implements IDriversLicense and represents a driver's license.
 */
public class AbstractDriversLicense implements IDriversLicense{
  private String licenseNumber;
  private IName driverName;
  private IAddress driverAddress;
  private IDate driverBirthDate;
  private Country issuingCountry;
  private String issuingState;
  private IDate issueDate;
  private IDate expirationDate;

  /**
   * Construct a driver's license given a license number; driver name, address, and birth date;
   * issuing country and state; issue date; and expiration date.
   *
   * @param licenseNumber - unique license number
   * @param driverName - driver's name
   * @param driverAddress - driver's address
   * @param driverBirthDate - driver's birth date
   * @param issuingCountry - license issuing country
   * @param issuingState - license issuing state
   * @param issueDate - license issue date
   * @param expirationDate - license expiration date
   */
  public AbstractDriversLicense (String licenseNumber,
      IName driverName, IAddress driverAddress,
      IDate driverBirthDate, Country issuingCountry, String issuingState,
      IDate issueDate, IDate expirationDate) {
    this.licenseNumber = licenseNumber;
    this.driverName = driverName;
    this.driverAddress = driverAddress;
    this.driverBirthDate = driverBirthDate;
    this.issuingCountry = issuingCountry;
    this.issuingState = issuingState;
    this.issueDate = issueDate;
    this.expirationDate = expirationDate;

//    validateUniqueLicenseNumber();
  }

  /**
   * Return unique license number.
   *
   * @return license number
   */
  public String getLicenseNumber() {
    return this.licenseNumber;
  }

  /**
   * Return driver's name.
   *
   * @return driver's name
   */
  public IName getDriverName() {
    return this.driverName;
  }

  /**
   * Return driver's address.
   *
   * @return driver's address
   */
  public IAddress getDriverAddress() {
    return this.driverAddress;
  }

  /**
   * Return driver's birth date.
   *
   * @return driver's birth date
   */
  public IDate getDriverBirthDate() {
    return this.driverBirthDate;
  }

  /**
   * Return country that issued license.
   *
   * @return license issuing country
   */
  public Country getIssuingCountry() {
    return this.issuingCountry;
  }

  /**
   * Return state that issued license.
   *
   * @return license issuing state
   */
  public String getIssuingState() {
    return this.issuingState;
  }

  /**
   * Return date license was issued.
   *
   * @return license issue date
   */
  public IDate getIssueDate() {
    return this.issueDate;
  }

  /**
   * Return date license expires.
   *
   * @return license expiration date
   */
  public IDate getExpirationDate() {
    return this.expirationDate;
  }

  /**
   * Return whether the license number entered is unique.
   *
   * @return true if licence number is unique, false otherwise
   * @throws NonUniqueNumberException if license number entered is already in system
   */
  private void validateUniqueLicenseNumber() throws NonUniqueNumberException {
    // return if number !exist in allLicenseNumbers set
    //not sure if Set has contains()
//    if (AcceptedDriver.getList().contains(licenseNumber)) {
//      throw new NonUniqueNumberException("This licence number is already paired with an "
//          + "AcceptedDriver. Please enter a unique license number.");
//    }

  }

  /**
   * Indicates whether some other object is "equal to" this one.
   *
   * @param obj - the reference object with which to compare
   * @return {@code true} if this object is the same as the obj argument and {@code false} otherwise
   */
  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  /**
   * Returns a hash code value for the object.
   *
   * @return hash code value for the object
   */
  @Override
  public int hashCode() {
    return super.hashCode();
  }

  /**
   * Returns a string representation of the object.
   * Format - "License number: licenseNumber, Driver: driverName, Expiration date: expirationDate"
   *
   * @return string representation of the object
   */
  @Override
  public String toString() {
    return super.toString();
  }
}
