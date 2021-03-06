package edu.neu.ccs.cs5004.assignment8.problem2;

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
      ArrayList<ITrafficViolation> trafficViolations) {
    super(trafficViolations);
  }

  /**
   * Returns a string representation of the object.
   * Format for driver - "Violations: [Date: ITrafficViolation, Date: ITrafficViolation, Date: ITrafficViolation, ...]"
   *
   * @return string representation of the object
   */
  @Override
  public String toString() {
    return "Violations: " +
        super.getTrafficViolations();
  }
}
