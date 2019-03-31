package edu.neu.ccs.cs5004.Assignment8.Problem2;

import java.util.ArrayList;

/**
 * This abstract class implements IHistory and represents a driver's or vehicle's history.
 */
public class AbstractHistory implements IHistory {
  private ArrayList<ITrafficViolation> trafficViolations;
  private ArrayList<Crash> crashes;

  /**
   * Construct a driver's History given traffic violations.
   *
   * @param trafficViolations - list of driver's traffic violations
   */
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
  public AbstractHistory(
      ArrayList<ITrafficViolation> trafficViolations,
      ArrayList<Crash> crashes) {
    this.trafficViolations = trafficViolations;
    this.crashes = crashes;
  }

  /**
   * Return a list of traffic violations in a driver's or vehicle's history.
   *
   * @return list of driver's or vehicle's traffic violation history
   */
  public ArrayList<ITrafficViolation> getTrafficViolations() {
    return trafficViolations;
  }

  /**
   * Return a list of crashes in a vehicle's history.
   *
   * @return list of vehicle crash history
   */
  public ArrayList<Crash> getCrashes() {
    return crashes;
  }
}
