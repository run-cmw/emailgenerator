package edu.neu.ccs.cs5004.Assignment8.Problem2;

/**
 * This abstract class implements ITrafficViolation and represents a traffic violation.
 */
public class AbstractTrafficViolation implements ITrafficViolation {
  private AbstractDate date;
  private AbstractViolations type;
  private AbstractName offender;             // Return offenders name or unique license number?

  /**
   * Construct a TrafficViolation for a driver given the date and type of violation.
   *
   * @param date - violation date
   * @param type - violation type
   */
  public AbstractTrafficViolation(AbstractDate date, AbstractViolations type) {
    this.date = date;
    this.type = type;
  }

  /**
   * Construct a TrafficViolation for a vehicle given the date and type of violation and
   * the person who committed the violation.
   *
   * @param date - violation date
   * @param type - violation type
   * @param offender - person who committed violation
   */
  public AbstractTrafficViolation(AbstractDate date, AbstractViolations type,
      AbstractName offender) {
    this.date = date;
    this.type = type;
    this.offender = offender;
  }

  /**
   * Return date of violation.
   *
   * @return violation date
   */
  public AbstractDate getDate() {
    return date;
  }

  /**
   * Return type of violation.
   *
   * @return violation type
   */
  public AbstractViolations getType() {
    return type;
  }

  /**
   * Person who committed violation.
   *
   * @return offender
   */
  public AbstractName getOffender() {
    return offender;
  }
}
