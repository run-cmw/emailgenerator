package edu.neu.ccs.cs5004.Assignment8.Problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MovingTrafficViolationTest {
  private ITrafficViolation driverViolation;
  private ITrafficViolation vehicleViolation;

  @Before
  public void setUp() throws Exception {
    Date date = new Date(31, 3, 2019);
    Name offender = new Name("I'm", "Innocent");
    MovingViolation movingViolation = MovingViolation.IGNORE_TRAFFIC_SIGNS;
    driverViolation = new MovingTrafficViolation(date, movingViolation);
    vehicleViolation = new MovingTrafficViolation(date, movingViolation, offender);
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
    assertEquals(MovingViolation.IGNORE_TRAFFIC_SIGNS, driverViolation.getType());
    assertEquals(MovingViolation.IGNORE_TRAFFIC_SIGNS, vehicleViolation.getType());
  }
}