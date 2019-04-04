package edu.neu.ccs.cs5004.assignment8.Problem2;

/**
 * Interface for a vehicle crash. Includes the crash and the date of the crash.
 */
public interface IVehicleCrash {

  /**
   * Returns the date of the crash.
   * @return date of the crash.
   */
  IDate getCrashDate();

  /**
   * Returns the type of crash (from enum Crash).
   * @return the type of crash.
   */
  Crash getCrash();

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
   * Format - "VehicleCrash{date + crash}" "VehicleCrash{date=date, crash=crash}"
   *
   * @return string representation of the object
   */
  String toString();
}
