package edu.neu.ccs.cs5004.Assignment8.Problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NonMovingTrafficViolationTest {
  private ITrafficViolation driverViolation;
  private ITrafficViolation vehicleViolation;
  private ITrafficViolation sameDriver;
  private ITrafficViolation differentDriver;
  private ITrafficViolation sameVehicle;
  private ITrafficViolation differentVehicle;

  @Before
  public void setUp() throws Exception {
    Date date = new Date(31, 3, 2019);
    Name offender = new Name("I'm", "Innocent");
    NonMovingViolation nonMovingViolation = NonMovingViolation.PARKING_VIOLATION;
    driverViolation = new NonMovingTrafficViolation(date, nonMovingViolation);
    vehicleViolation = new NonMovingTrafficViolation(date, nonMovingViolation, offender);

    Date differentDate = new Date(2, 4, 2019);
    sameDriver = new NonMovingTrafficViolation(date, nonMovingViolation);
    differentDriver = new NonMovingTrafficViolation(differentDate, nonMovingViolation);
    sameVehicle = new NonMovingTrafficViolation(date, nonMovingViolation, offender);
    differentVehicle = new NonMovingTrafficViolation(differentDate, nonMovingViolation, offender);
  }

  @Test
  public void getDate() {
    final String DATE_AS_STRING = "3/31/2019";

    assertEquals(DATE_AS_STRING, driverViolation.getDate().toString());
    assertEquals(DATE_AS_STRING, vehicleViolation.getDate().toString());
  }

  @Test
  public void getOffender() {
    final String OFFENDER_AS_STRING = "I'm Innocent";

    assertEquals(OFFENDER_AS_STRING, vehicleViolation.getOffender().toString());
  }

  @Test
  public void getType() {
    assertEquals(NonMovingViolation.PARKING_VIOLATION, driverViolation.getType());
    assertEquals(NonMovingViolation.PARKING_VIOLATION, vehicleViolation.getType());
  }

  @Test
  public void equals() {
    assertTrue(sameDriver.equals(driverViolation));
    assertTrue(sameDriver.equals(sameDriver));
    assertTrue(sameVehicle.equals(vehicleViolation));
    assertTrue(sameVehicle.equals(sameVehicle));
    assertFalse(differentDriver.equals(driverViolation));
    assertFalse(differentVehicle.equals(vehicleViolation));
    assertFalse(sameVehicle.equals(2));
    assertFalse(sameDriver.equals(2));
  }

  @Test
  public void equalHashCode() {
    assertEquals(sameDriver.hashCode(), driverViolation.hashCode());
    assertEquals(sameVehicle.hashCode(), vehicleViolation.hashCode());
  }

  @Test
  public void differentHashCode() {
    assertNotEquals(differentDriver.hashCode(), driverViolation.hashCode());
    assertNotEquals(differentVehicle.hashCode(), vehicleViolation.hashCode());
  }

  @Test
  public void testToString() {
    final String DRIVER_VIOLATIONS_AS_STRING = "3/31/2019: PARKING_VIOLATION, null";
    final String VEHICLE_VIOLATIONS_AS_STRING = "3/31/2019: PARKING_VIOLATION, I'm Innocent";

    assertEquals(DRIVER_VIOLATIONS_AS_STRING, driverViolation.toString());
    assertEquals(VEHICLE_VIOLATIONS_AS_STRING, vehicleViolation.toString());
  }
}