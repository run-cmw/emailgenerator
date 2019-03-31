package edu.neu.ccs.cs5004.Assignment8.Problem2;

/**
 * This class extends Vehicle and represents a vehicle.
 */
public class Vehicle extends AbstractVehicle {
  /**
   * Construct a Vehicle with the given make, model, year, and owner.
   *
   * @param make - vehicle's make
   * @param model - vehicle's model
   * @param year - vehicle's year created
   * @param owner - vehicle's official owner
   */
  public Vehicle(String make, String model, int year,
      AbstractName owner) {
    super(make, model, year, owner);
  }
}
