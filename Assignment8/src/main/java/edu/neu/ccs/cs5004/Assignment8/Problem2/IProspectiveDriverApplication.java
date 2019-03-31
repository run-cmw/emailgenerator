package edu.neu.ccs.cs5004.Assignment8.Problem2;

/**
 * This interface contains all functionality that all ProspectiveDrivers should support.
 */
public interface IProspectiveDriverApplication {

  /**
   * Return applicant's name.
   *
   * @return applicant's name
   */
  AbstractName getName();

  /**
   * Return applicant's birth date.
   *
   * @return applicant's birth date
   */
  AbstractDate getBirthDate();

  /**
   * Return applicant's driver's license information.
   *
   * @return applicant's driver's license information
   */
  AbstractDriversLicense getDriversLicense();

  /**
   * Return applicant's vehicle information.
   *
   * @return applicant's vehicle information
   */
  AbstractVehicle getVehicle();

  /**
   * Return applicant's vehicle insurance information.
   *
   * @return applicant's vehicle insurance information
   */
  AbstractVehicleInsurance getVehicleInsurance();

  /**
   * Return applicant's driver history.
   *
   * @return applicant's driver history
   */
  AbstractHistory getDriverHistory();

  /**
   * Return applicant's vehicle's history.
   *
   * @return applicant's vehicle's history
   */
  AbstractHistory getVehicleHistory();
}