package edu.neu.ccs.cs5004.Assignment8.Problem2;

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

  Enum getType();


}
