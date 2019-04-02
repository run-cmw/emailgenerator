package edu.neu.ccs.cs5004.Assignment8.Problem2;

import java.util.ArrayList;

/**
 * This interface contains all functionality that all Histories should support.
 */
public interface IHistory {

  /**
   * Return a list of traffic violations in a driver's or vehicle's history.
   *
   * @return list of driver's or vehicle's traffic violation history
   */
  ArrayList<Enum> getTrafficViolations();

  /**
   * Return a list of crashes in a vehicle's history.
   *
   * @return list of vehicle crash history
   */
  ArrayList<Enum> getCrashes();

  /**
   * Indicates whether some other object is "equal to" this one.
   *
   * @param obj - the reference object with which to compare
   * @return {@code true} if this object is the same as the obj argument and {@code false} otherwise
   */
  boolean equals(Object obj);

  /**
   * Returns a hash code value for the object.
   *
   * @return hash code value for the object
   */
  int hashCode();

  /**
   * Returns a string representation of the object.
   * Format for driver - "Violations: [ITrafficViolation, ITrafficViolation, ITrafficViolation...]"
   * Format for vehicle - "Violations: [ITrafficViolation, ITrafficViolation, ITrafficViolation...]
   *                       Crashes: [Crash, Crash, Crash...]"
   *
   * @return string representation of the object
   */
  String toString();
}
