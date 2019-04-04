package edu.neu.ccs.cs5004.assignment8.problem1;;


import java.util.Objects;

/**
 * This is an Abstract class for Name. It implements interface  IName.
 */
public abstract class AbstractName implements IName {

  private String firstName;
  private String lastName;


  /**
   * Constructor for creating a Name object.
   * @param firstName of the Media creator
   * @param lastName of the Media creator
   */
  public AbstractName(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Getter for First Name.
   */
  public String getfirstName() {
    return this.firstName;
  }

  /**
   * Getter for Last Name.
   */
  public String getlastName() {
    return this.lastName;
  }


//  /**
//   * Returns if the objects are the same.
//   * @param obj reference to compare
//   * @return true if the object is same as the object being passed as param, false otherwise
//   */
//
//  @Override
//  public boolean equals(Object obj) {
//    if (this == obj) {
//      return true;
//    }
//    if (!(obj instanceof AbstractName)) {
//      return false;
//    }
//    AbstractName that = (AbstractName) obj;
//    return firstName.equals(that.firstName)
//        && lastName.equals(that.lastName);
//  }


  /**
   * returns the hashcode value for the object.
   * @return hashcode
   */

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName);
  }


  /**
   * Returns string representation of the object.
   * @return String representation of the object
   */
  @Override
  public String toString() {
    return "AbstractName{" +
        "firstName='" + firstName + '\''
        + ", lastName='" + lastName + '\''
        + '}';
  }


}
