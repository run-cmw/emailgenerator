package edu.neu.ccs.cs5004.Assignment8.problem2;

/**
 * This abstract class implements IVehicle and represents a vehicle.
 */
public class AbstractVehicle implements IVehicle {
  private String make;
  private String model;
  private int year;
  private IName owner;

  /**
   * Construct a Vehicle with the given make, model, year, and owner.
   *
   * @param make - vehicle's make
   * @param model - vehicle's model
   * @param year  - vehicle's year created
   * @param owner - vehicle's official owner
   */
  public AbstractVehicle(String make, String model, int year,
      IName owner) {
    this.make = make;
    this.model = model;
    this.year = year;
    this.owner = owner;
  }

  /**
   * Return vehicle make.
   *
   * @return vehicle make
   */
  @Override
  public String getMake() {
    return make;
  }

  /**
   * Return vehicle model.
   *
   * @return vehicle model
   */
  @Override
  public String getModel() {
    return model;
  }

  /**
   * Return vehicle year.
   *
   * @return vehicle year
   */
  @Override
  public int getYear() {
    return year;
  }

  /**
   * Return vehicle owner.
   *
   * @return vehicle owner
   */
  @Override
  public IName getOwner() {
    return owner;
  }

  /**
   * Returns a string representation of the object.
   * Format - "year make model"
   *
   * @return string representation of the object
   */
  @Override
  public String toString() {
    return year + " " + make + " " + model;
  }
}
