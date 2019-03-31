package edu.neu.ccs.cs5004.Assignment8.Problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ViolationsTest {
  private Violations movingViolation;
  private Violations nonMovingViolation;

  @Before
  public void setUp() throws Exception {
    movingViolation = new Violations(MovingViolation.IGNORE_TRAFFIC_SIGNS);
    nonMovingViolation = new Violations(NonMovingViolation.PARKING_VIOLATION);
  }

  @Test
  public void getMoving() {
    assertEquals(MovingViolation.IGNORE_TRAFFIC_SIGNS, movingViolation.getMoving());
  }

  @Test
  public void getNonMoving() {
    assertEquals(NonMovingViolation.PARKING_VIOLATION, nonMovingViolation.getNonMoving());
  }
}