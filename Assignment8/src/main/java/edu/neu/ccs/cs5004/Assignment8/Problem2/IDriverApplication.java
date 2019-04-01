package edu.neu.ccs.cs5004.Assignment8.Problem2;

/**
 * This interface represents the Driver Application required for .
 */
public interface IDriverApplication {

  /**
   * Return applicant's name.
   *
   * @return applicant's name
   */
  IName getName();

  /**
   * Return applicant's birth date.
   *
   * @return applicant's birth date
   */
  IDate getBirthDate();

  /**
   * Return applicant's driver's license information.
   *
   * @return applicant's driver's license information
   */
  IDriversLicense getDriversLicense();

  /**
   * Return applicant's vehicle information.
   *
   * @return applicant's vehicle information
   */
  IVehicle getVehicle();

  /**
   * Return applicant's vehicle insurance information.
   *
   * @return applicant's vehicle insurance information
   */
  IVehicleInsurance getVehicleInsurance();

  /**
   * Return applicant's driver history.
   *
   * @return applicant's driver history
   */
  DriverHistory getDriverHistory();

  /**
   * Return applicant's vehicle's history.
   *
   * @return applicant's vehicle's history
   */
  VehicleHistory getVehicleHistory();
}