package edu.neu.ccs.cs5004.Assignment8.Problem2;

import java.util.ArrayList;

/**
 * This class extends AbstractHistory and represents a driver's or vehicle's history.
 */
public class DriverHistory extends AbstractHistory {

  /**
   * Construct a driver's History given traffic violations.
   *
   * @param trafficViolations - list of driver's traffic violations
   */
  public DriverHistory (
      ArrayList<AbstractTrafficViolation> trafficViolations) {
    super(trafficViolations);
  }

  /**
   * Construct a vehicle's History given traffic violations a crashes.
   *
   * @param trafficViolations - a list of vehicle's traffic violations
   * @param crashes - a list of vehicle's crashes
   */
  public DriverHistory (
      ArrayList<AbstractTrafficViolation> trafficViolations,
      ArrayList<Crash> crashes) {
    super(trafficViolations, crashes);
  }
}
