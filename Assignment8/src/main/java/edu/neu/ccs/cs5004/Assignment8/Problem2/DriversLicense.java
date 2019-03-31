package edu.neu.ccs.cs5004.Assignment8.Problem2;

/**
 * This class extends AbstractDriversLicense and represents a driver's license.
 */
public class DriversLicense extends AbstractDriversLicense {

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
  public DriversLicense(String licenseNumber,
      AbstractName driverName, AbstractAddress driverAddress,
      AbstractDate driverBirthDate, String issuingCountry, String issuingState,
      AbstractDate issueDate, AbstractDate expirationDate) {
    super(licenseNumber, driverName, driverAddress, driverBirthDate, issuingCountry, issuingState,
        issueDate, expirationDate);
  }
}
