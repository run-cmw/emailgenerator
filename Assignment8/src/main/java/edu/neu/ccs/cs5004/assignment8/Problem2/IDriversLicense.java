package edu.neu.ccs.cs5004.assignment8.Problem2;

/**
 * This interface contains all functionality that all DriversLicenses should support.
 */
public interface IDriversLicense {

  /**
   * Return unique license number.
   *
   * @return license number
   */
  String getLicenseNumber();

  /**
   * Return driver's name.
   *
   * @return driver's name
   */
  IName getDriverName();

  /**
   * Return driver's address.
   *
   * @return driver's address
   */
  IAddress getDriverAddress();

  /**
   * Return driver's birth date.
   *
   * @return driver's birth date
   */
  IDate getDriverBirthDate();

  /**
   * Return country that issued license.
   *
   * @return license issuing country
   */
  Country getIssuingCountry();

  /**
   * Return state that issued license.
   *
   * @return license issuing state
   */
  String getIssuingState();

  /**
   * Return date license was issued.
   *
   * @return license issue date
   */
  IDate getIssueDate();

  /**
   * Return date license expires.
   *
   * @return license expiration date
   */
  IDate getExpirationDate();

  /**
   * Indicates whether some other object is "equal to" this one.
   *
   * @param obj - the reference object with which to compare
   * @return {@code true} if this object is the same as the obj argument and {@code false} otherwise
   */
  boolean equals(Object obj);

  /**
   * Returns a hash code value for the object.
   *
   * @return hash code value for the object
   */
  int hashCode();

  /**
   * Returns a string representation of the object.
   * Format - "License number: licenseNumber, Driver: driverName, Expiration date: expirationDate"
   *
   * @return string representation of the object
   */
  String toString();
}