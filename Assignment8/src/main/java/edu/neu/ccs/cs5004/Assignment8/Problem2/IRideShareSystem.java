package edu.neu.ccs.cs5004.Assignment8.Problem2;

import java.util.Set;

/**
 * This interface contains all functionality that the RideshareSystem supports.
 */
public interface IRideShareSystem {

  /**
   * Validate information to determine if the driver meets rideshare acceptance requirements.
   *
   * @return true if applicant meets all requirements, false if missing at least one
   * requirement
   */
  boolean validateRegistration(IName name,
      IDate birthDate, IDriversLicense driversLicense, IVehicle vehicle,
      IVehicleInsurance vehicleInsurance,
      DriverHistory driverHistory, VehicleHistory vehicleHistory);

}
