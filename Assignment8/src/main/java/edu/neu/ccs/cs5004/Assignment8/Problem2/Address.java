package edu.neu.ccs.cs5004.Assignment8.Problem2;

/**
 * This class extends AbstractAddress and represents an address.
 */
public class Address extends AbstractAddress {

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
    super(streetNumberNameUnit, city, state, zipCode);
  }
}
