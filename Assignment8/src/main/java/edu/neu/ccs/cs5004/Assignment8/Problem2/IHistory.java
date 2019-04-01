package edu.neu.ccs.cs5004.Assignment8.Problem2;

import java.util.ArrayList;

/**
 * This interface contains all functionality that all Histories should support.
 */
public interface IHistory {

  /**
   * Return a list of traffic violations in a driver's or vehicle's history.
   *
   * @return list of driver's or vehicle's traffic violation history
   */
  ArrayList<ITrafficViolation> getTrafficViolations();

  /**
   * Return a list of crashes in a vehicle's history.
   *
   * @return list of vehicle crash history
   */
  ArrayList<IVehicleCrash> getCrashes();
}
