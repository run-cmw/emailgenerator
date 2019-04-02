package edu.neu.ccs.cs5004.Assignment8.Problem2;

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
    trafficViolations = new ArrayList<>();
    Date date = new Date(31, 3, 2019);
    ITrafficViolation violation1 = new NonMovingTrafficViolation(date, NonMovingViolation.PARKING_VIOLATION);
    ITrafficViolation violation2 = new MovingTrafficViolation(date, MovingViolation.IGNORE_TRAFFIC_SIGNS);
    ArrayList<Enum> trafficViolations = new ArrayList<>();
    history = new DriverHistory(trafficViolations);

    trafficViolations.add(violation1.getType());
    trafficViolations.add(violation2.getType());

    ArrayList<Enum> trafficViolations2 = new ArrayList<>();
    same = new DriverHistory(trafficViolations);
    different = new DriverHistory(trafficViolations2);
    trafficViolations2.add(violation1.getType());
  }

  @Test
  public void getTrafficViolations() {
    final String VIOLATIONS_AS_STRING = "[PARKING_VIOLATION, IGNORE_TRAFFIC_SIGNS]";

    assertEquals(VIOLATIONS_AS_STRING, history.getTrafficViolations().toString());
  }

  @Test
  public void equals() {
    assertTrue(same.equals(history));
    assertFalse(different.equals(history));
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
    final String HISTORY_AS_STRING = "Violations: [PARKING_VIOLATION, IGNORE_TRAFFIC_SIGNS]";

    assertEquals(HISTORY_AS_STRING, history.toString());
  }
}