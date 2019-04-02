package edu.neu.ccs.cs5004.Assignment8.Problem2;

import java.util.Objects;

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
    if (!(obj instanceof Vehicle)) {
      return false;
    }
    Vehicle other = (Vehicle) obj;
    return this.getModel().equals(other.getModel())
        && this.getMake().equals(other.getMake())
        && this.getOwner().equals(other.getOwner())
        && this.getYear() == other.getYear();
  }

  /**
   * Returns a hash code value for the object.
   *
   * @return hash code value for the object
   */
  @Override
  public int hashCode() {
    return Objects.hash(make, model, year, owner);
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
