package edu.neu.ccs.cs5004.Assignment8.Problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TrafficViolationTest {
  private TrafficViolation driverViolation;
  private TrafficViolation vehicleViolation;
  private Date date;
  private Violations type;
  private Name offender;
  private Violations movingViolation;
  private Violations nonMovingViolation;
  private Name name;

  @Before
  public void setUp() throws Exception {
    driverViolation = new TrafficViolation(date, type);
    vehicleViolation = new TrafficViolation(date, type, offender);
    date = new Date(31, 03, 2019);
    movingViolation = new Violations(MovingViolation.IGNORE_TRAFFIC_SIGNS);
    nonMovingViolation = new Violations(NonMovingViolation.PARKING_VIOLATION);
    name = new Name("I'm", "Innocent");
  }

  @Test
  public void getDate() {
    String dateAsString = "31032019";

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