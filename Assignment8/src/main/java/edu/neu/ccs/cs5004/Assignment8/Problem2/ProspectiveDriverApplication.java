package edu.neu.ccs.cs5004.Assignment8.Problem2;

/**
 * This class extends AbstractProspectiveDriverApplication and represents a prospective driver's
 * application.
 */
public class ProspectiveDriverApplication extends AbstractProspectiveDriverApplication {

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
  public ProspectiveDriverApplication(AbstractName name,
      AbstractDate birthDate, AbstractDriversLicense driversLicense,
      AbstractVehicle vehicle, AbstractVehicleInsurance vehicleInsurance,
      AbstractHistory driverHistory, AbstractHistory vehicleHistory) {
    super(name, birthDate, driversLicense, vehicle, vehicleInsurance, driverHistory,
        vehicleHistory);
  }
}
