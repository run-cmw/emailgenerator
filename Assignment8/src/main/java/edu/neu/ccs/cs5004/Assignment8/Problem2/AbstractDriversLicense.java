package edu.neu.ccs.cs5004.Assignment8.Problem2;

import java.util.Iterator;

/**
 * This abstract class implements IDriversLicense and represents a driver's license.
 */
public class AbstractDriversLicense implements IDriversLicense{
  private String licenseNumber;
  private AbstractName driverName;
  private AbstractAddress driverAddress;
  private AbstractDate driverBirthDate;
  private String issuingCountry;
  private String issuingState;
  private AbstractDate issueDate;
  private AbstractDate expirationDate;

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
      AbstractName driverName, AbstractAddress driverAddress,
      AbstractDate driverBirthDate, String issuingCountry, String issuingState,
      AbstractDate issueDate, AbstractDate expirationDate) {
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
    return licenseNumber;
  }

  /**
   * Return driver's name.
   *
   * @return driver's name
   */
  public AbstractName getDriverName() {
    return driverName;
  }

  /**
   * Return driver's address.
   *
   * @return driver's address
   */
  public AbstractAddress getDriverAddress() {
    return driverAddress;
  }

  /**
   * Return driver's birth date.
   *
   * @return driver's birth date
   */
  public AbstractDate getDriverBirthDate() {
    return driverBirthDate;
  }

  /**
   * Return country that issued license.
   *
   * @return license issuing country
   */
  public String getIssuingCountry() {
    return issuingCountry;
  }

  /**
   * Return state that issued license.
   *
   * @return license issuing state
   */
  public String getIssuingState() {
    return issuingState;
  }

  /**
   * Return date license was issued.
   *
   * @return license issue date
   */
  public AbstractDate getIssueDate() {
    return issueDate;
  }

  /**
   * Return date license expires.
   *
   * @return license expiration date
   */
  public AbstractDate getExpirationDate() {
    return expirationDate;
  }

  /**
   * Return whether the license number entered is unique.
   *
   * @return true if licence number is unique, false otherwise
   * @throws NonUniqueNumberException if license number entered is already in system
   */
  private boolean validateUniqueLicenseNumber() throws NonUniqueNumberException {
    // return if number !exist in allLicenseNumbers set
    //not sure if Set has contains()
//    return (!(RideshareSystem.getAllLicenseNumbers().contains(licenseNumber)));
    return false;
  }
}
