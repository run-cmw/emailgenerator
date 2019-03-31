package edu.neu.ccs.cs5004.Assignment8.Problem2;

import java.util.ArrayList;

/**
 * This class extends AbstractHistory and represents a driver's or vehicle's history.
 */
public class VehicleHistory extends AbstractHistory {
  /**
   * Construct a vehicle's History given traffic violations a crashes.
   *
   * @param trafficViolations - a list of vehicle's traffic violations
   * @param crashes - a list of vehicle's crashes
   */
  public VehicleHistory (
      ArrayList<ITrafficViolation> trafficViolations,
      ArrayList<Crash> crashes) {
    super(trafficViolations, crashes);
  }

}
