package edu.neu.ccs.cs5004.Assignment8.Problem2;

/**
 * This interface contains all functionality that all Addresses should support.
 */
public interface IAddress {
  /**
   * Return street number, name, and unit.
   *
   * @return street number, name, and unit
   */
  String getStreetNumberNameUnit();

  /**
   * Return city.
   *
   * @return city
   */
  String getCity();

  /**
   * Return state.
   *
   * @return state
   */
  String getState();

  /**
   * Return zip code.
   *
   * @return zip code
   */
  String getZipCode();
}
