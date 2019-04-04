package edu.neu.ccs.cs5004.Assignment8.problem2;

import java.util.ArrayList;

/**
 * This abstract class implements IHistory and represents a driver's or vehicle's history.
 */
public class AbstractHistory implements IHistory {
  private ArrayList<ITrafficViolation> trafficViolations;
  private ArrayList<IVehicleCrash> crashes;

  /**
   * Construct a driver's History given traffic violations.
   *
   * @param trafficViolations - list of driver's traffic violations
   */
  // Overloaded because driver and vehicle require different information
  public AbstractHistory(
      ArrayList<ITrafficViolation> trafficViolations) {
    this.trafficViolations = trafficViolations;
  }

  /**
   * Construct a vehicle's History given traffic violations a crashes.
   *
   * @param trafficViolations - a list of vehicle's traffic violations
   * @param crashes - a list of vehicle's crashes
   */
  // Overloaded because driver and vehicle require different information
  public AbstractHistory(
      ArrayList<ITrafficViolation> trafficViolations,
      ArrayList<IVehicleCrash> crashes) {
    this.trafficViolations = trafficViolations;
    this.crashes = crashes;
  }

  /**
   * Return a list of traffic violations in a driver's or vehicle's history.
   *
   * @return list of driver's or vehicle's traffic violation history
   */
  @Override
  public ArrayList<ITrafficViolation> getTrafficViolations() {
    return trafficViolations;
  }

  /**
   * Return a list of crashes in a vehicle's history.
   *
   * @return list of vehicle crash history
   */
  @Override
  public ArrayList<IVehicleCrash> getCrashes() {
    return crashes;
  }


  /**
   * Returns a string representation of the object.
   * Format for driver - "Violations: [Date: ITrafficViolation, Date: ITrafficViolation,
   * Date: ITrafficViolation, ...]"
   * Format for vehicle - "Violations: [Date: ITrafficViolation,
   * Date: ITrafficViolation, Date: ITrafficViolation, ...]
   * [VehicleCrash{date=Date, crash=IVehicleCrash}, VehicleCrash{date=Date, crash=IVehicleCrash}]"
   *
   * @return string representation of the object
   */
  @Override
  public String toString() {
    return super.toString();
  }
}
