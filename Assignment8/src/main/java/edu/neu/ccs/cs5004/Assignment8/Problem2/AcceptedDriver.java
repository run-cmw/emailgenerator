package edu.neu.ccs.cs5004.Assignment8.Problem2;

public class AcceptedDriver implements IAcceptedDriver{

  /**
   * Name of the accepted driver.
   */
  private IName name;
  /**
   * Birthday of the accepted driver.
   */
  private IDate birthday;
  /**
   * License of the accepted driver.
   */
  private IDriversLicense license;
  /**
   * Vehicle of the accepted driver.
   */
  private IVehicle vehicle;

  /**
   * Returns the name of the accepted driver.
   * @return name of the accepted driver.
   */
  @Override
  public IName getName() {
    return this.name;
  }

  /**
   * Returns birthday of the accepted driver.
   * @return birthday of the accepted driver.
   */
  @Override
  public IDate getBirthday() {
    return this.birthday;
  }

  /**
   * Returns license of the accepted driver.
   * @return license of the accepted driver.
   */
  @Override
  public IDriversLicense getLicense() {
    return this.license;
  }

  /**
   * Returns vehicle of the accepted driver.
   * @return vehicle of the accepted driver.
   */
  @Override
  public IVehicle getVehicle() {
    return this.vehicle;
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
    if (! (obj instanceof AcceptedDriver)) {
      return false;
    }
    AcceptedDriver other = (AcceptedDriver) obj;
    return this.birthday.equals(other.getBirthday()) &&
        this.license.equals(other.getLicense()) &&
        this.vehicle.equals(other.getVehicle()) &&
        this.name.equals(other.getName());
  }

  /**
   * Returns a string representation of the object.
   * Format - "Driver: First Name Last Name,
   *           Vehicle: Year Make Model"
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "Driver: " + this.name.getFirstName() + " " + this.name.getLastName()
        + ", Vehicle: " + this.vehicle.getYear()+ " " +
        this.vehicle.getMake() + " " + this.vehicle.getModel();
  }

}
