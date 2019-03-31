package edu.neu.ccs.cs5004.Assignment8.Problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AddressTest {
  private Address address;

  @Before
  public void setUp() throws Exception {
    address = new Address("1039 45th Street #6", "Emeryville", "CA", "94608");
  }

  @Test
  public void getStreetNumberNameUnit() {
    assertEquals("1039 45th Street #6", address.getStreetNumberNameUnit());
  }

  @Test
  public void getCity() {
    assertEquals("Emeryville", address.getCity());
  }

  @Test
  public void getState() {
    assertEquals("CA", address.getState());
  }

  @Test
  public void getZipCode() {
    assertEquals("94608", address.getZipCode());
  }
}