package edu.neu.ccs.cs5004.assignment8.problem2;

import java.util.ArrayList;

/**
 * This interface contains all functionality that the RideshareSystem supports.
 */
public interface IRideShareSystem {

  /**
   * A method that allows a person to register as a prospective driver.
   * Returns true if the driver is accepted to be a driver and false it not.
   * @param name - applicant's name
   * @param birthDate - applicant's birth date
   * @param driversLicense - applicant's driver's license
   * @param vehicle - vehicle information
   * @param vehicleInsurance - vehicle insurance information
   * @param driverHistory - applicant's driver history
   * @param vehicleHistory - vehicle's history
   * @return true if the driver is accepted to be a driver and false it not.
   */
  boolean registerAsProspectiveDriver(IName name,
      IDate birthDate, IDriversLicense driversLicense, IVehicle vehicle,
      IVehicleInsurance vehicleInsurance,
      IHistory driverHistory, IHistory vehicleHistory);

  /**
   * Returns a list of the accepted drivers of the ride share system.
   * @return list of the accepted drivers of the ride share system.
   */
  ArrayList<IAcceptedDriver> getAcceptedDriversList();
}
