package edu.neu.ccs.cs5004.Assignment8.Problem2;


import java.util.Objects;

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
  // Overloaded because driver and vehicle require different information
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
  // Overloaded because driver and vehicle require different information
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

  /**
   * Return the type of traffic violation that was committed: MovingViolation or NonMovingViolation.
   *
   * @return type of traffic violation that was committed
   */
  public Enum getType() {
    return this.violationType;
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
    if (!(obj instanceof MovingTrafficViolation)) {
      return false;
    }
    MovingTrafficViolation other = (MovingTrafficViolation) obj;
    return this.getDate() == other.getDate()
        && this.getType() == other.getType()
        && this.getOffender() == other.getOffender();
  }

  /**
   * Returns a hash code value for the object.
   *
   * @return hash code value for the object
   */
  @Override
  public int hashCode() {
    return Objects.hash(date, violationType, offender);
  }

  /**
   * Returns a string representation of the object.
   * Format for driver - "date: type"
   * Format for vehicle - "date: type, offender"
   *
   * @return string representation of the object
   */
  @Override
  public String toString() {
    return date +
        ": " + violationType +
        ", " + offender;
  }
}
