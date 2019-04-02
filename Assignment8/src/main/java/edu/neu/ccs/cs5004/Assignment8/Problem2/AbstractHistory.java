package edu.neu.ccs.cs5004.Assignment8.Problem2;

import java.util.ArrayList;
import java.util.Objects;

/**
 * This abstract class implements IHistory and represents a driver's or vehicle's history.
 */
public class AbstractHistory implements IHistory {
  private ArrayList<Enum> trafficViolations;
  private ArrayList<Enum> crashes;

  /**
   * Construct a driver's History given traffic violations.
   *
   * @param trafficViolations - list of driver's traffic violations
   */
  // Overloaded because driver and vehicle require different information
  public AbstractHistory(
      ArrayList<Enum> trafficViolations) {
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
      ArrayList<Enum> trafficViolations,
      ArrayList<Enum> crashes) {
    this.trafficViolations = trafficViolations;
    this.crashes = crashes;
  }

  /**
   * Return a list of traffic violations in a driver's or vehicle's history.
   *
   * @return list of driver's or vehicle's traffic violation history
   */
  @Override
  public ArrayList<Enum> getTrafficViolations() {
    return trafficViolations;
  }

  /**
   * Return a list of crashes in a vehicle's history.
   *
   * @return list of vehicle crash history
   */
  @Override
  public ArrayList<Enum> getCrashes() {
    return crashes;
  }

  /**
   * Indicates whether some other object is "equal to" this one.
   *
   * @param obj - the reference object with which to compare
   * @return {@code true} if this object is the same as the obj argument and {@code false} otherwise
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof DriverHistory)) {
      return false;
    }
    DriverHistory other = (DriverHistory) obj;
    return this.getTrafficViolations().equals(other.getTrafficViolations());
  }

  /**
   * Returns a hash code value for the object.
   *
   * @return hash code value for the object
   */
  @Override
  public int hashCode() {
    return Objects.hash(trafficViolations);
  }

  /**
   * Returns a string representation of the object.
   * Format for driver - "Violations: [ITrafficViolation, ITrafficViolation, ITrafficViolation...]"
   * Format for vehicle - "Violations: [ITrafficViolation, ITrafficViolation, ITrafficViolation...]
   *                       [Crashes: Crash, Crash, Crash...]"
   *
   * @return string representation of the object
   */
  @Override
  public String toString() {
    return super.toString();
  }
}
