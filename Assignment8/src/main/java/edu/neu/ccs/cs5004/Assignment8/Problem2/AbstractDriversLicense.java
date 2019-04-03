package edu.neu.ccs.cs5004.Assignment8.Problem2;

import java.util.Objects;

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
  }

  /**
   * Return unique license number.
   *
   * @return license number
   */
  @Override
  public String getLicenseNumber() {
    return this.licenseNumber;
  }

  /**
   * Return driver's name.
   *
   * @return driver's name
   */
  @Override
  public IName getDriverName() {
    return this.driverName;
  }

  /**
   * Return driver's address.
   *
   * @return driver's address
   */
  @Override
  public IAddress getDriverAddress() {
    return this.driverAddress;
  }

  /**
   * Return driver's birth date.
   *
   * @return driver's birth date
   */
  @Override
  public IDate getDriverBirthDate() {
    return this.driverBirthDate;
  }

  /**
   * Return country that issued license.
   *
   * @return license issuing country
   */
  @Override
  public Country getIssuingCountry() {
    return this.issuingCountry;
  }

  /**
   * Return state that issued license.
   *
   * @return license issuing state
   */
  @Override
  public String getIssuingState() {
    return this.issuingState;
  }

  /**
   * Return date license was issued.
   *
   * @return license issue date
   */
  @Override
  public IDate getIssueDate() {
    return this.issueDate;
  }

  /**
   * Return date license expires.
   *
   * @return license expiration date
   */
  @Override
  public IDate getExpirationDate() {
    return this.expirationDate;
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
    if (!(obj instanceof DriversLicense)) {
      return false;
    }
    DriversLicense other = (DriversLicense) obj;
    return this.getLicenseNumber().equals(other.getLicenseNumber())
        && this.getDriverName().equals(other.getDriverName())
        && this.getDriverAddress().equals(other.getDriverAddress())
        && this.getDriverBirthDate().equals(other.getDriverBirthDate())
        && this.getIssuingCountry().equals(other.getIssuingCountry())
        && this.getIssuingState().equals(other.getIssuingState())
        && this.getIssueDate().equals(other.getIssueDate())
        && this.getExpirationDate().equals(other.getExpirationDate());
  }

  /**
   * Returns a hash code value for the object.
   *
   * @return hash code value for the object
   */
  @Override
  public int hashCode() {
    return Objects.hash(licenseNumber, driverName, driverAddress, driverBirthDate, issuingCountry, issuingState, issueDate, expirationDate);
  }

  /**
   * Returns a string representation of the object.
   * Format - "License number: licenseNumber, Driver: driverName, Expiration date: expirationDate"
   *
   * @return string representation of the object
   */
  @Override
  public String toString() {
    return
        "License number: " +
            licenseNumber +
            ", Driver: " +
            driverName +
            ", Expiration date: " +
            expirationDate;
  }
}
