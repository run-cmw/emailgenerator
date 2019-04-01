package edu.neu.ccs.cs5004.Assignment8.Problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NonMovingTrafficViolationTest {
  private ITrafficViolation driverViolation;
  private ITrafficViolation vehicleViolation;

  @Before
  public void setUp() throws Exception {
    Date date = new Date(31, 3, 2019);
    Name offender = new Name("I'm", "Innocent");
    NonMovingViolation nonMovingViolation = NonMovingViolation.PARKING_VIOLATION;
    driverViolation = new NonMovingTrafficViolation(date, nonMovingViolation);
    vehicleViolation = new NonMovingTrafficViolation(date, nonMovingViolation, offender);
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
}