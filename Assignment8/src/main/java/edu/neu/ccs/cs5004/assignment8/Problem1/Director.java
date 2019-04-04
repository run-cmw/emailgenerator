package edu.neu.ccs.cs5004.assignment8.Problem1;

import java.util.Objects;

/**
 * This is a class Director
 */
public class Director{

  protected Name name;

  /**
   * This constructs a Director object.
   * @param name of director
   */
  public Director(Name name) {
    this.name = name;
  }

  /**
   * Returns the name of the director.
   * @return director name
   */
  public Name getName() {
    return name;
  }

  /**
   * Returns if the objects are the same.
   * @param obj reference to compare
   * @return true if the object is same as the object being passed as param, false otherwise
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Director)) {
      return false;
    }
    Director director = (Director) obj;
    return getName().equals(director.getName());
  }

  /**
   * returns the hashcode value for the object.
   * @return hashcode
   */
  @Override
  public int hashCode() {
    return Objects.hash(getName());
  }
  /**
   * Returns string representation of the object.
   * @return String representation of the object
   */

  @Override
  public String toString() {
    return "Director{"
        + "name=" + name
        + '}';
  }
}
