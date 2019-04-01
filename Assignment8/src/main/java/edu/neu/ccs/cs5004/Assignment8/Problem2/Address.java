package edu.neu.ccs.cs5004.Assignment8.Problem2;

import java.util.Objects;

/**
 * This class extends IAddress and represents an address.
 */
public class Address implements IAddress {
  private String streetNumberNameUnit;
  private String city;
  private String state;
  private String zipCode;

  /**
   * Construct an Address with the given street number, name, and unit; city; state; and zip code.
   *
   * @param streetNumberNameUnit - street number, name, and unit (if applicable)
   * @param city - the city
   * @param state - the state
   * @param zipCode - the zip code
   */
  public Address(String streetNumberNameUnit, String city, String state,
      String zipCode) {
    this.streetNumberNameUnit = streetNumberNameUnit;
    this.city = city;
    this.state = state;
    this.zipCode = zipCode;
  }

  /**
   * Return street number, name, and unit.
   *
   * @return street number, name, and unit
   */
  public String getStreetNumberNameUnit() {
    return this.streetNumberNameUnit;
  }

  /**
   * Return city.
   *
   * @return city
   */
  public String getCity() {
    return this.city;
  }

  /**
   * Return state.
   *
   * @return state
   */
  public String getState() {
    return this.state;
  }

  /**
   * Return zip code.
   *
   * @return zip code
   */
  public String getZipCode() {
    return this.zipCode;
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
    if (!(obj instanceof Address)) {
      return false;
    }
    Address other = (Address) obj;
    return this.getCity().equals(other.getCity())
        && this.getState().equals(other.getState())
        && this.getZipCode().equals(other.getZipCode())
        && this.getStreetNumberNameUnit().equals(other.getStreetNumberNameUnit());
  }

  /**
   * Returns a hash code value for the object.
   *
   * @return hash code value for the object
   */
  @Override
  public int hashCode() {
    return Objects.hash(streetNumberNameUnit, city, state, zipCode);
  }

  /**
   * Returns a string representation of the object.
   * Format - "streetNumberNameUnit
   * city, state zipCode"
   *
   * @return string representation of the object
   */
  @Override
  public String toString() {
    return streetNumberNameUnit + "\n" + city + ", " + state + " " + zipCode;
  }
}
