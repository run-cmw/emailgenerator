package edu.neu.ccs.cs5004.assignment8.Problem1;

import java.util.Objects;

/**
 * This class represents an Actor
 */
public class Actor {

  protected Name name;

  /**
   * Constructs an Actor object.
   * @param name of Actor
   */
  public Actor(Name name) {
    this.name = name;
  }

  /**
   * Returns Actor name.
   * @return actor name
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
    if (!(obj instanceof Actor)) {
      return false;
    }
    Actor actor = (Actor) obj;
    return getName().equals(actor.getName());
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
    return "Actor{"
        + "name=" + name
        + '}';
  }
}
