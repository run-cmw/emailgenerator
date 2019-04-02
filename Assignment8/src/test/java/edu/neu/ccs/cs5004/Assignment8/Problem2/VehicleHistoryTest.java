package edu.neu.ccs.cs5004.Assignment8.Problem2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class VehicleHistoryTest {
  private VehicleHistory history;
  private VehicleHistory same;
  private VehicleHistory different;

  @Before
  public void setUp() throws Exception {
    Date date = new Date(31, 3, 2019);
    ITrafficViolation violation1 = new NonMovingTrafficViolation(date, NonMovingViolation.PARKING_VIOLATION);
    ITrafficViolation violation2 = new MovingTrafficViolation(date, MovingViolation.IGNORE_TRAFFIC_SIGNS);
    Crash crash1 = Crash.FENDER_BENDER;
    Crash crash2 = Crash.WITHOUT_INJURIES;
    ArrayList<Enum> trafficViolations = new ArrayList<>();
    ArrayList<Enum> crashes = new ArrayList<>();
    history = new VehicleHistory(trafficViolations, crashes);

    trafficViolations.add(violation1.getType());
    trafficViolations.add(violation2.getType());
    crashes.add(crash1);
    crashes.add(crash2);

    ArrayList<Enum> trafficViolations2 = new ArrayList<>();
    same = new VehicleHistory(trafficViolations, crashes);
    different = new VehicleHistory(trafficViolations2, crashes);
    trafficViolations2.add(violation1.getType());
  }

  @Test
  public void getTrafficViolations() {
    final String VIOLATIONS_AS_STRING = "[PARKING_VIOLATION, IGNORE_TRAFFIC_SIGNS]";

    assertEquals(VIOLATIONS_AS_STRING, history.getTrafficViolations().toString());
  }

  @Test
  public void getCrashes() {
    final String CRASHES_AS_STRING = "[FENDER_BENDER, WITHOUT_INJURIES]";

    assertEquals(CRASHES_AS_STRING, history.getCrashes().toString());
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
    final String HISTORY = "Violations: [PARKING_VIOLATION, IGNORE_TRAFFIC_SIGNS]\n"
        + "Crashes: [FENDER_BENDER, WITHOUT_INJURIES]";

    assertEquals(HISTORY, history.toString());
  }
}