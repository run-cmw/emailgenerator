package edu.neu.ccs.cs5004.Assignment8.Problem2;

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



}
