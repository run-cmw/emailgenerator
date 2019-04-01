package edu.neu.ccs.cs5004.Assignment8.Problem2;

import java.util.Objects;

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
      IName owner) {
    super(make, model, year, owner);
  }

  /**
   * Indicates whether some other object is "equal to" this one.
   *
   * @param obj the reference object with which to compare.
   * @return {@code true} if this object is the same as the obj argument; {@code false} otherwise.
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
    return Objects.hash(this.getMake(), this.getModel(), this.getYear(), this.getOwner());
  }

  /**
   * Returns a string representation of the object.
   * Format - "year make model"
   *
   * @return string representation of the object
   */
  @Override
  public String toString() {
    return super.getYear() + " " + super.getMake() + " " + super.getModel();
  }
}
