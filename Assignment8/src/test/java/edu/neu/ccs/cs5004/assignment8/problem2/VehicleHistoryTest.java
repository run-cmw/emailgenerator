package edu.neu.ccs.cs5004.assignment8.problem2;

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
    Name name = new Name("Unicorn", "Goddess");
    ITrafficViolation violation1 = new NonMovingTrafficViolation(date, NonMovingViolation.PARKING_VIOLATION, name);
    ITrafficViolation violation2 = new MovingTrafficViolation(date, MovingViolation.IGNORE_TRAFFIC_SIGNS, name);
    IVehicleCrash crash1 = new VehicleCrash(date, Crash.FENDER_BENDER);
    IVehicleCrash crash2 = new VehicleCrash(date, Crash.WITHOUT_INJURIES);
    ArrayList<ITrafficViolation> trafficViolations = new ArrayList<>();
    ArrayList<IVehicleCrash> crashes = new ArrayList<>();
    trafficViolations.add(violation1);
    trafficViolations.add(violation2);
    crashes.add(crash1);
    crashes.add(crash2);
    history = new VehicleHistory(trafficViolations, crashes);

    ArrayList<ITrafficViolation> trafficViolations2 = new ArrayList<>();
    same = new VehicleHistory(trafficViolations, crashes);
    different = new VehicleHistory(trafficViolations2, crashes);
    trafficViolations2.add(violation1);
  }

  @Test
  public void getTrafficViolations() {
    final String VIOLATIONS_AS_STRING = "[3/31/2019: PARKING_VIOLATION, Unicorn Goddess, 3/31/2019: IGNORE_TRAFFIC_SIGNS, Unicorn Goddess]";

    assertEquals(VIOLATIONS_AS_STRING, history.getTrafficViolations().toString());
  }

  @Test
  public void getCrashes() {
    final String CRASHES_AS_STRING = "[VehicleCrash{date=3/31/2019, crash=FENDER_BENDER}, VehicleCrash{date=3/31/2019, crash=WITHOUT_INJURIES}]";

    assertEquals(CRASHES_AS_STRING, history.getCrashes().toString());
  }

  @Test
  public void equals() {
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
    final String HISTORY = "Violations: [3/31/2019: PARKING_VIOLATION, Unicorn Goddess, 3/31/2019: IGNORE_TRAFFIC_SIGNS, Unicorn Goddess]\n"
        + "Crashes: [VehicleCrash{date=3/31/2019, crash=FENDER_BENDER}, VehicleCrash{date=3/31/2019, crash=WITHOUT_INJURIES}]";

    assertEquals(HISTORY, history.toString());
  }
}