package edu.neu.ccs.cs5004.Assignment8.problem2;

/**
 * This interface contains all functionality that all TrafficViolations should support.
 */
public interface ITrafficViolation {

  /**
   * Return date of violation.
   *
   * @return violation date
   */
  IDate getDate();

  /**
   * Person who committed violation.
   *
   * @return offender
   */
  IName getOffender();

  /**
   * Return the type of traffic violation that was committed: MovingViolation or NonMovingViolation.
   *
   * @return type of traffic violation that was committed
   */
  Enum getType();

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
   * Format for driver - "date: type"
   * Format for vehicle - "date: type, offender"
   *
   * @return string representation of the object
   */
  String toString();
}
