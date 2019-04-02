package edu.neu.ccs.cs5004.Assignment8.Problem2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class DriverHistoryTest {
  private ArrayList<ITrafficViolation> trafficViolations;

  @Before
  public void setUp() throws Exception {
    trafficViolations = new ArrayList<>();
    Date date = new Date(31, 3, 2019);
    ITrafficViolation violation1 = new NonMovingTrafficViolation(date, NonMovingViolation.PARKING_VIOLATION);
    ITrafficViolation violation2 = new MovingTrafficViolation(date, MovingViolation.IGNORE_TRAFFIC_SIGNS);

    trafficViolations.add(violation1);
    trafficViolations.add(violation2);
  }

  @Test
  public void getTrafficViolations() {
    final String VIOLATIONS_AS_STRING = "";

  //  assertEquals(VIOLATIONS_AS_STRING, trafficViolations.toString());
  }
}