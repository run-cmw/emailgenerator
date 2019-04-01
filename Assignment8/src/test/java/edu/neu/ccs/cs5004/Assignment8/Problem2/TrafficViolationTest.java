package edu.neu.ccs.cs5004.Assignment8.Problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TrafficViolationTest {
  private ITrafficViolation driverViolation;
  private ITrafficViolation vehicleViolation;
  private Date date;
  private Name offender;
  private MovingViolation movingViolation;
  private NonMovingViolation nonMovingViolation;
  private Name name;

  @Before
  public void setUp() throws Exception {
    date = new Date(31, 03, 2019);
    name = new Name("I'm", "Innocent");
    movingViolation = MovingViolation.IGNORE_TRAFFIC_SIGNS;
    nonMovingViolation = NonMovingViolation.PARKING_VIOLATION;
    driverViolation = new MovingTrafficViolation(date, movingViolation);
    vehicleViolation = new MovingTrafficViolation(date, movingViolation, offender);
  }

  @Test
  public void getDate() {
    String dateAsString = "3/31/2019";

    assertEquals(dateAsString, driverViolation.getDate().toString()); // update after impl toString()
    assertEquals(dateAsString, vehicleViolation.getDate().toString()); // update after impl toString()
  }

  @Test
  public void getType() {
//    assertEquals(driverViolation.getType().);
    // redesign Violations (I, Abstract, & Concrete) b/c should be able to getViolation() without
    // knowing which to get and also getTypeOfViolation() for validateRegistration() in RideshareSystem
  }

  @Test
  public void getOffender() {
  }
}