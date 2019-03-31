package edu.neu.ccs.cs5004.Assignment8.Problem2;

/**
 * This abstract class implements IProspectiveDriverApplication and represents a prospective
 * driver's application.
 */
public class AbstractProspectiveDriverApplication implements IProspectiveDriverApplication {
  private AbstractName name;
  private AbstractDate birthDate;
  private AbstractDriversLicense driversLicense;
  private AbstractVehicle vehicle;
  private AbstractVehicleInsurance vehicleInsurance;
  private AbstractHistory driverHistory;
  private AbstractHistory vehicleHistory;

  /**
   * Construct a IProspectiveDriverApplication given an applicant's name, birth date, license,
   * vehicle, vehicle insurance, driver history, and vehicle history.
   *
   * @param name - applicant's name
   * @param birthDate - applicant's birth date
   * @param driversLicense - applicant's driver's license
   * @param vehicle - vehicle information
   * @param vehicleInsurance - vehicle insurance information
   * @param driverHistory - applicant's driver history
   * @param vehicleHistory - vehicle's history
   */
  public AbstractProspectiveDriverApplication(AbstractName name,
      AbstractDate birthDate, AbstractDriversLicense driversLicense, AbstractVehicle vehicle,
      AbstractVehicleInsurance vehicleInsurance,
      AbstractHistory driverHistory, AbstractHistory vehicleHistory) {
    this.name = name;
    this.birthDate = birthDate;
    this.driversLicense = driversLicense;
    this.vehicle = vehicle;
    this.vehicleInsurance = vehicleInsurance;
    this.driverHistory = driverHistory;
    this.vehicleHistory = vehicleHistory;
  }

  /**
   * Return applicant's name.
   *
   * @return applicant's name
   */
  public AbstractName getName() {
    return name;
  }

  /**
   * Return applicant's birth date.
   *
   * @return applicant's birth date
   */
  public AbstractDate getBirthDate() {
    return birthDate;
  }

  /**
   * Return applicant's driver's license information.
   *
   * @return applicant's driver's license information
   */
  public AbstractDriversLicense getDriversLicense() {
    return driversLicense;
  }

  /**
   * Return applicant's vehicle information.
   *
   * @return applicant's vehicle information
   */
  public AbstractVehicle getVehicle() {
    return vehicle;
  }

  /**
   * Return applicant's vehicle insurance information.
   *
   * @return applicant's vehicle insurance information
   */
  public AbstractVehicleInsurance getVehicleInsurance() {
    return vehicleInsurance;
  }

  /**
   * Return applicant's driver history.
   *
   * @return applicant's driver history
   */
  public AbstractHistory getDriverHistory() {
    return driverHistory;
  }

  /**
   * Return applicant's vehicle's history.
   *
   * @return applicant's vehicle's history
   */
  public AbstractHistory getVehicleHistory() {
    return vehicleHistory;
  }
}
