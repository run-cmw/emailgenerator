package edu.neu.ccs.cs5004.Assignment8.Problem2;

/**
 * This abstract class implements IAddress and represents an address.
 */
public class AbstractAddress implements IAddress {
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
  public AbstractAddress(String streetNumberNameUnit, String city, String state,
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
    return streetNumberNameUnit;
  }

  /**
   * Return city.
   *
   * @return city
   */
  public String getCity() {
    return city;
  }

  /**
   * Return state.
   *
   * @return state
   */
  public String getState() {
    return state;
  }

  /**
   * Return zip code.
   *
   * @return zip code
   */
  public String getZipCode() {
    return zipCode;
  }
}
