package edu.neu.ccs.cs5004.assignment8.Problem2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class DriverHistoryTest {
  private DriverHistory history;
  private DriverHistory same;
  private DriverHistory different;

  @Before
  public void setUp() throws Exception {
    Date date = new Date(31, 3, 2019);
    ITrafficViolation violation1 = new NonMovingTrafficViolation(date, NonMovingViolation.PARKING_VIOLATION);
    ITrafficViolation violation2 = new MovingTrafficViolation(date, MovingViolation.IGNORE_TRAFFIC_SIGNS);
    ArrayList<ITrafficViolation> trafficViolations = new ArrayList<>();
    history = new DriverHistory(trafficViolations);

    trafficViolations.add(violation1);
    trafficViolations.add(violation2);

    ArrayList<ITrafficViolation> trafficViolations2 = new ArrayList<>();
    same = new DriverHistory(trafficViolations);
    different = new DriverHistory(trafficViolations2);
    trafficViolations2.add(violation1);
  }

  @Test
  public void getTrafficViolations() {
    final String VIOLATIONS_AS_STRING = "[3/31/2019: PARKING_VIOLATION, null, 3/31/2019: IGNORE_TRAFFIC_SIGNS, null]";

    assertEquals(VIOLATIONS_AS_STRING, history.getTrafficViolations().toString());
  }

  @Test
  public void equals() {
    assertTrue(same.equals(same));
    assertTrue(same.equals(history));
    assertTrue(same.equals(same));
    assertFalse(different.equals(history));
    assertFalse(same.equals(2));
  }

  @Test
  public void equalHashCode() {
    assertEquals(same.hashCode(), history.hashCode());
  }

  @Test
  public void differentHashCode() {
    assertNotEquals(different.hashCode(), history.hashCode());
  }

  @Test
  public void testToString() {
    final String HISTORY_AS_STRING = "Violations: [3/31/2019: PARKING_VIOLATION, null, 3/31/2019: IGNORE_TRAFFIC_SIGNS, null]";

    assertEquals(HISTORY_AS_STRING, history.toString());
  }
}