package edu.neu.ccs.cs5004.Assignment8.Problem2;

/**
 * This class extends IProspectiveDriverApplication and represents a prospective driver's
 * application.
 */
public class DriverApplication implements IDriverApplication {
    private IName name;
    private IDate birthDate;
    private IDriversLicense driversLicense;
    private IVehicle vehicle;
    private IVehicleInsurance vehicleInsurance;
    private DriverHistory driverHistory;
    private VehicleHistory vehicleHistory;

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
    public DriverApplication(IName name,
        IDate birthDate, IDriversLicense driversLicense, IVehicle vehicle,
        IVehicleInsurance vehicleInsurance,
        DriverHistory driverHistory, VehicleHistory vehicleHistory) {
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
    public IName getName() {
      return this.name;
    }

    /**
     * Return applicant's birth date.
     *
     * @return applicant's birth date
     */
    public IDate getBirthDate() {
      return this.birthDate;
    }

    /**
     * Return applicant's driver's license information.
     *
     * @return applicant's driver's license information
     */
    public IDriversLicense getDriversLicense() {
      return this.driversLicense;
    }

    /**
     * Return applicant's vehicle information.
     *
     * @return applicant's vehicle information
     */
    public IVehicle getVehicle() {
      return this.vehicle;
    }

    /**
     * Return applicant's vehicle insurance information.
     *
     * @return applicant's vehicle insurance information
     */
    public IVehicleInsurance getVehicleInsurance() {
      return this.vehicleInsurance;
    }

    /**
     * Return applicant's driver history.
     *
     * @return applicant's driver history
     */
    public DriverHistory getDriverHistory() {
      return this.driverHistory;
    }

    /**
     * Return applicant's vehicle's history.
     *
     * @return applicant's vehicle's history
     */
    public VehicleHistory getVehicleHistory() {
      return this.vehicleHistory;
    }

}
