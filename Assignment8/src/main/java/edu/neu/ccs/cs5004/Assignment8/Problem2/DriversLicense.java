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
      IName  driverName, IAddress driverAddress,
      IDate driverBirthDate, Country issuingCountry, String issuingState,
      IDate issueDate, IDate expirationDate) throws NonUniqueNumberException {
    super(licenseNumber, driverName, driverAddress, driverBirthDate, issuingCountry, issuingState,
        issueDate, expirationDate);
  }
}
