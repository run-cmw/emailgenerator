package edu.neu.ccs.cs5004.Assignment8.Problem2;

import java.util.Objects;

/**
 * This abstract class implements IName and represents a name.
 */
public class AbstractName implements IName {
  private String firstName;
  private String lastName;

  /**
   * Construct a Name with the given first name and last name.
   * @param firstName - first name
   * @param lastName - last name
   */
  public AbstractName(String firstName, String lastName) {
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

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName);
  }

  @Override
  public String toString() {
    return firstName + " " + lastName;
  }
}
