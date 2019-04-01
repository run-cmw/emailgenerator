package edu.neu.ccs.cs5004.Assignment8.Problem2;

import java.util.ArrayList;
import java.util.Objects;

/**
 * This class extends AbstractHistory and represents a driver's or vehicle's history.
 */
public class DriverHistory extends AbstractHistory {

  /**
   * Construct a driver's History given traffic violations.
   *
   * @param trafficViolations - list of driver's traffic violations
   */
  public DriverHistory (
      ArrayList<ITrafficViolation> trafficViolations) {
    super(trafficViolations);
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
    return this.getTrafficViolations().equals(other.getTrafficViolations())
        && this.getCrashes().equals(other.getCrashes());
  }

  /**
   * Returns a hash code value for the object.
   *
   * @return hash code value for the object
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.getTrafficViolations(), this.getCrashes());
  }

  /**
   * Returns a string representation of the object.
   * Format for driver - "Violations: ITrafficViolation, ITrafficViolation, ITrafficViolation..."
   *
   * @return string representation of the object
   */
  @Override
  public String toString() {
    return "Violations: " +
        super.getTrafficViolations();
  }

}
