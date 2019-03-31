package edu.neu.ccs.cs5004.Assignment8.Problem2;

import com.sun.xml.internal.bind.v2.model.core.ID;

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
  IDate getIssueDate();

  /**
   * Return date license expires.
   *
   * @return license expiration date
   */
  IDate getExpirationDate();
}