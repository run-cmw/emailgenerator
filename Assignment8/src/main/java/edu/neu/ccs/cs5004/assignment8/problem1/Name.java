package edu.neu.ccs.cs5004.assignment8.problem1;;

import java.util.Objects;

/**
 *  This is a concrete class that extends AbstractName class.
 */
public class Name extends AbstractName {

  private String name;

  /**
   * Constructor for Name
   * @param firstName of the Media Creator
   * @param lastName of the Media Creator
   */
  public Name(String firstName, String lastName) {
    super(firstName, lastName);
  }

  /**
   * Returns the Name
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * Returns if the objects are the same
   * @param obj reference to compare
   * @return true if the object is same as the object being passed as param, false otherwise
   */

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Name)) {
      return false;
    }
    if (!super.equals(obj)) {
      return false;
    }
    Name name1 = (Name) obj;
    return getName().equals(name1.getName());
  }

  /**
   * returns the hashcode value for the object
   * @return hashcode
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getName());
  }

  /**
   * Returns string representation of the object
   * @return String representation of the object
   */
  @Override
  public String toString() {
    return "Name{" +
        "name='" + name + '\'' +
        '}';
  }
}
