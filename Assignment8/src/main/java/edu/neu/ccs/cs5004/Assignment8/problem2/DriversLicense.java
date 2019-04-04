package edu.neu.ccs.cs5004.Assignment8.problem2;

import java.util.Objects;

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
      IDate issueDate, IDate expirationDate) {
    super(licenseNumber, driverName, driverAddress, driverBirthDate, issuingCountry, issuingState,
        issueDate, expirationDate);
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
    return Objects.hash(this.getLicenseNumber(), this.getDriverName(), this.getDriverAddress(),
        this.getDriverBirthDate(), this.getIssuingCountry(), this.getIssuingState(),
        this.getIssueDate(), this.getExpirationDate());
  }
}
