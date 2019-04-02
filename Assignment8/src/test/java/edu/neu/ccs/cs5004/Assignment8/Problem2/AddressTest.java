package edu.neu.ccs.cs5004.Assignment8.Problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AddressTest {
  private IAddress address;
  private IAddress same;
  private IAddress different;

  @Before
  public void setUp() throws Exception {
    address = new Address("1039 45th Street #6", "Emeryville", "CA", "94608");
    same = new Address("1039 45th Street #6", "Emeryville", "CA", "94608");
    different = new Address("1039 43th Street", "Emeryville", "CA", "94608");
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

  @Test
  public void equals() {
    assertTrue(same.equals(address));
    assertFalse(different.equals(address));
  }

  @Test
  public void equalHashCode() {
    assertEquals(same.hashCode(), address.hashCode());
  }

  @Test
  public void differentHashCode() {
    assertNotEquals(different.hashCode(), address.hashCode());
  }

  @Test
  public void testToString() {
    final String ADDRESS_AS_STRING = "1039 45th Street #6\nEmeryville, CA 94608";

    assertEquals(ADDRESS_AS_STRING, address.toString());
  }
}