package edu.neu.ccs.cs5004.Assignment8.Problem2;

/**
 * This interface contains all functionality that all Vehicles should support.
 */
public interface IVehicle {
  /**
   * Return vehicle make.
   *
   * @return vehicle make
   */
  String getMake();

  /**
   * Return vehicle model.
   *
   * @return vehicle model
   */
  String getModel();

  /**
   * Return vehicle year.
   *
   * @return vehicle year
   */
  int getYear();

  /**
   * Return vehicle owner.
   *
   * @return vehicle owner
   */
  AbstractName getOwner();
}
