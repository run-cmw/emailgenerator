package edu.neu.ccs.cs5004.Assignment8.Problem1;


/**
 * This is an Abstract class for Name. It implements interface  IName.
 */
public class AbstractName implements IName {

  private String firstName;
  private String lastName;


  /**
   * Constructor for creating a Name object
   * @param firstName of the Media creator
   * @param lastName of the Media creator
   */
  public AbstractName(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Getter for First Name
   */
  public String getfirstName() {
    return this.firstName;
  }

  /**
   * Getter for Last Name
   */
  public String getlastName() {
    return this.lastName;
  }


  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }


}
