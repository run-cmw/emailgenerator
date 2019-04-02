package edu.neu.ccs.cs5004.Assignment8.Problem2;

/**
 * This class  implements IName and represents a name.
 */
public class Name implements IName {
  private String firstName;
  private String lastName;

  /**
   * Construct a Name with the given first name and last name.
   * @param firstName - first name
   * @param lastName - last name
   */
  public Name(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Return first name.
   *
   * @return first name
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Return last name.
   *
   * @return last name
   */
  public String getLastName() {
    return lastName;
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
    if (!(obj instanceof Name)) {
      return false;
    }
    Name other = (Name) obj;
    return this.getFirstName().equals(other.getFirstName())
        && this.getLastName().equals(other.getLastName());
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  /**
   * Returns a string representation of the object.
   * Format - "firstName lastName"
   *
   * @return string representation of the object
   */
  @Override
  public String toString() {
    return firstName + " " + lastName;
  }
}
