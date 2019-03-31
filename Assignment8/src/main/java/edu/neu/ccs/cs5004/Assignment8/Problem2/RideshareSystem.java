package edu.neu.ccs.cs5004.Assignment8.Problem2;

import java.util.Set;

/**
 * This class implements IRideshareSystem and represents a rideshare system.
 */
public class RideshareSystem implements IRideshareSystem {
  private static Set<String> allLicenseNumbers;

  // needs constructor

  /**
   * Return set of all license number in system.
   *
   * @return set of all license number in system
   */
  public Set<String> getAllLicenseNumbers() {
    return allLicenseNumbers;
  }

  /**
   * Validate IProspectiveDriverApplication information to determine if the driver meets rideshare
   * acceptance requirements.
   *
   * @return true if ProspectiveDriver meets all requirements, false if missing at least one
   * requirement
   */
  @Override
  public boolean validateRegistration() {
    return false;
  }

  /**
   * Return application decision: whether a prospective driver has been accepted or denied.
   *
   * @return application decision
   */
  @Override
  public String giveDecision() {
    return "null";
  }
}
