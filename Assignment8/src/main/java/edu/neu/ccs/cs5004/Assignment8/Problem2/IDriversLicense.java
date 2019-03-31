package edu.neu.ccs.cs5004.Assignment8.Problem2;

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
  AbstractName getDriverName();

  /**
   * Return driver's address.
   *
   * @return driver's address
   */
  AbstractAddress getDriverAddress();

  /**
   * Return driver's birth date.
   *
   * @return driver's birth date
   */
  AbstractDate getDriverBirthDate();

  /**
   * Return country that issued license.
   *
   * @return license issuing country
   */
  String getIssuingCountry();

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
  AbstractDate getIssueDate();

  /**
   * Return date license expires.
   *
   * @return license expiration date
   */
  AbstractDate getExpirationDate();
}