package edu.neu.ccs.cs5004.Assignment8.Problem2;


/**
 * This class extends ITrafficViolation and represents a Moving Traffic violation.
 */
public class MovingTrafficViolation implements ITrafficViolation {
  private MovingViolation violationType;
  private IDate date;
  private IName offender;

  /**
   * Construct a TrafficViolation for a driver given the date and type of violation.
   *
   * @param date - violation date
   * @param type - violation type
   */
  public MovingTrafficViolation(IDate date, MovingViolation type) {
    this.date = date;
    this.violationType = type;
  }

  /**
   * Construct a TrafficViolation for a vehicle given the date and type of violation and
   * the person who committed the violation.
   *
   * @param date - violation date
   * @param type - violation type
   * @param offender - person who committed violation
   */
  public MovingTrafficViolation(IDate date, MovingViolation type,
      IName offender) {
    this.date = date;
    this.violationType = type;
    this.offender = offender;
  }

  /**
   * Return date of violation.
   *
   * @return violation date
   */
  public IDate getDate() {
    return this.date;
  }


  /**
   * Person who committed violation.
   *
   * @return offender
   */
  public IName getOffender() {
    return this.offender;
  }

  public Enum getType() {
    return this.violationType;
  }
}
