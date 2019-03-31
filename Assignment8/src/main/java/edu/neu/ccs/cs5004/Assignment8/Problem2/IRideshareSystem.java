package edu.neu.ccs.cs5004.Assignment8.Problem2;

import java.util.Set;

/**
 * This interface contains all functionality that the RideshareSystem supports.
 */
public interface IRideshareSystem {
  /**
   * Return set of all license number in system.
   *
   * @return set of all license number in system
   */
  Set<String> getAllLicenseNumbers();

  // need method and javadoc for accepted drivers - just not sure of most suitable data structure

  /**
   * Validate IProspectiveDriverApplication information to determine if the driver meets
   * rideshare acceptance requirements.
   *
   * @return true if ProspectiveDriver meets all requirements, false if missing at least one
   * requirement
   */
  boolean validateRegistration();

  /**
   * Return application decision: whether a prospective driver has been accepted or denied.
   *
   * @return application decision
   */
  String giveDecision();
}
