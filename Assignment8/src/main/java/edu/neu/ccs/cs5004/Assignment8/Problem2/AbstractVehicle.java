package edu.neu.ccs.cs5004.Assignment8.Problem2;


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
  public String getMake() {
    return make;
  }

  /**
   * Return vehicle model.
   *
   * @return vehicle model
   */
  public String getModel() {
    return model;
  }

  /**
   * Return vehicle year.
   *
   * @return vehicle year
   */
  public int getYear() {
    return year;
  }

  /**
   * Return vehicle owner.
   *
   * @return vehicle owner
   */
  public IName getOwner() {
    return owner;
  }

  /**
   * Returns a hash code value for the object.
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    return super.hashCode();
  }

  /**
   * Returns a string representation of the object.
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return super.toString();
  }
}
