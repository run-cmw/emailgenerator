package edu.neu.ccs.cs5004.Assignment8.Problem2;

import java.util.Objects;

public class VehicleCrash implements IVehicleCrash {
  private IDate date;
  private Crash crash;

  public VehicleCrash(IDate date, Crash crash) {
    this.date = date;
    this.crash = crash;
  }

  /**
   * Returns the date of the crash.
   *
   * @return date of the crash.
   */
  @Override
  public IDate getCrashDate() {
    return this.date;
  }

  /**
   * Returns the type of crash (from enum Crash).
   *
   * @return the type of crash.
   */
  @Override
  public Crash getCrash() {
    return this.crash;
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
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    VehicleCrash other = (VehicleCrash) obj;
    return Objects.equals(this.date, other.date) &&
        this.crash == other.crash;
  }

  /**
   * Returns a hash code value for the object.
   *
   * @return hash code value for the object
   */
  @Override
  public int hashCode() {
    return Objects.hash(date, crash);
  }

  /**
   * Returns a string representation of the object.
   * Format - "VehicleCrash{date + crash}" "VehicleCrash{date=date, crash=crash}"
   *
   * @return string representation of the object
   */
  @Override
  public String toString() {
    return "VehicleCrash{" +
        "date=" + date +
        ", crash=" + crash +
        "}";
  }
}
