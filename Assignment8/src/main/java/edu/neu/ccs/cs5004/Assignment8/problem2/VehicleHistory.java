package edu.neu.ccs.cs5004.Assignment8.problem2;

import java.util.ArrayList;
import java.util.Objects;

/**
 * This class extends AbstractHistory and represents a driver's or vehicle's history.
 */
public class VehicleHistory extends AbstractHistory {
  /**
   * Construct a vehicle's History given traffic violations a crashes.
   *
   * @param trafficViolations - a list of vehicle's traffic violations
   * @param crashes - a list of vehicle's crashes
   */
  public VehicleHistory(
      ArrayList<ITrafficViolation> trafficViolations,
      ArrayList<IVehicleCrash> crashes) {
    super(trafficViolations, crashes);
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
    if (!(obj instanceof VehicleHistory)) {
      return false;
    }
    VehicleHistory other = (VehicleHistory) obj;
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
   * Format for vehicle - "Violations: [Date: ITrafficViolation, Date: ITrafficViolation,
   * Date: ITrafficViolation, ...]
   * [VehicleCrash{date=Date, crash=IVehicleCrash}, VehicleCrash{date=Date, crash=IVehicleCrash}]"
   *
   * @return string representation of the object
   */
  @Override
  public String toString() {
    return "Violations: "
        + super.getTrafficViolations()
        + "\nCrashes: "
        + super.getCrashes();
  }
}
