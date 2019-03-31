package edu.neu.ccs.cs5004.Assignment8.Problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VehicleTest {
  private Vehicle vehicle;
  private Name name;

  @Before
  public void setUp() throws Exception {
    vehicle = new Vehicle("Space", "Machine", 2020, name);
    name = new Name("Unicorn", "Goddess");
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
    assertEquals("UnicornGoddess", vehicle.getOwner().toString());
  }
}