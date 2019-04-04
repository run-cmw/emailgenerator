package edu.neu.ccs.cs5004.assignment8.problem2;

/**
 * Enumerate the types of moving violations a Driver and Vehicle may have a history of.
 */
public enum MovingViolation {
  /**
   * Distracted driving
   */
  DISTRACTED_DRIVING,
  /**
   * Reckless driving
   */
  RECKLESS_DRIVING,
  /**
   * Speeding
   */
  SPEEDING,
  /**
   * Driving under the influence
   */
  DUI,
  /**
   * Not respecting traffic signs
   */
  IGNORE_TRAFFIC_SIGNS,
  /**
   * Driving without or with expired License or VehicleInsurance
   */
  INVALID_LICENSE_OR_INSURANCE
}
