package edu.neu.ccs.cs5004.Assignment8.Problem2;

/**
 * This class extends AbstractTrafficViolation and represents a traffic violation.
 */
public class TrafficViolation extends AbstractTrafficViolation {

  /**
   * Construct a TrafficViolation for a driver given the date and type of violation.
   *
   * @param date - violation date
   * @param type - violation type
   */
  public TrafficViolation(AbstractDate date, AbstractViolations type) {
    super(date, type);
  }

  /**
   * Construct a TrafficViolation for a vehicle given the date and type of violation and the person
   * who committed the violation.
   *
   * @param date - violation date
   * @param type - violation type
   * @param offender - person who committed violation
   */
  public TrafficViolation(AbstractDate date, AbstractViolations type,
      AbstractName offender) {
    super(date, type, offender);
  }
}
