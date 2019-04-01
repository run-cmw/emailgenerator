package edu.neu.ccs.cs5004.Assignment8.Problem2;

import java.util.HashMap;

/**
 * This class extends AbstractName and represents a name.
 */
public class Name extends AbstractName {
  /**
   * Construct a Name with the given first name and last name.
   * @param firstName - first name
   * @param lastName - last name
   */
  public Name(String firstName, String lastName) {
    super(firstName, lastName);
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
    if (!(obj instanceof Name)) {
      return false;
    }
    Name other = (Name) obj;
    return this.getFirstName().equals(other.getFirstName())
        && this.getLastName().equals(other.getLastName());
  }

}
