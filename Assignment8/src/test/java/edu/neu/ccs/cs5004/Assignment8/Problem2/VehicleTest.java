package edu.neu.ccs.cs5004.Assignment8.Problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VehicleTest {
  private Vehicle vehicle;
  private Vehicle same;
  private Vehicle different;

  @Before
  public void setUp() throws Exception {
    Name name = new Name("Unicorn", "Goddess");
    vehicle = new Vehicle("Space", "Machine", 2020, name);
    same = new Vehicle("Space", "Machine", 2020, name);
    different = new Vehicle("Space", "Machine", 2021, name);
  }

  @Test
  public void getMake() {
    assertEquals("Space", vehicle.getMake());
  }

  @Test
  public void getModel() {
    assertEquals("Machine", vehicle.getModel());
  }

  @Test
  public void getYear() {
    assertEquals(2020, vehicle.getYear());
  }

  @Test
  public void getOwner() {
    final String OWNER_AS_STRING = "Unicorn Goddess";

    assertEquals(OWNER_AS_STRING, vehicle.getOwner().toString());
  }

  @Test
  public void equals() {
    assertTrue(same.equals(vehicle));
    assertFalse(different.equals(vehicle));
  }

  @Test
  public void equalHashCode() {
    assertEquals(same.hashCode(),vehicle.hashCode());
  }

  @Test
  public void differentHashCode() {
    assertNotEquals(different.hashCode(), vehicle.hashCode());
  }

  @Test
  public void testToString() {
    final String INSURANCE_AS_STRING = "2020 Space Machine";

    assertEquals(INSURANCE_AS_STRING, vehicle.toString());
  }
}