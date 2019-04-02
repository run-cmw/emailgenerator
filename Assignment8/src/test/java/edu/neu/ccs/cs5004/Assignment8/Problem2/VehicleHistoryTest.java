package edu.neu.ccs.cs5004.Assignment8.Problem2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class VehicleHistoryTest {
  private ArrayList<ITrafficViolation> trafficViolations;
  private ArrayList<IVehicleCrash> crashes;

  @Before
  public void setUp() throws Exception {
    trafficViolations = new ArrayList<>();
    crashes = new ArrayList<>();
    IDate date = new Date(31, 3, 2019);
    Name offender = new Name("I'm", "Innocent");
    ITrafficViolation violation1 = new NonMovingTrafficViolation(date, NonMovingViolation.PARKING_VIOLATION);
    ITrafficViolation violation2 = new MovingTrafficViolation(date, MovingViolation.IGNORE_TRAFFIC_SIGNS);
    Crash crash1 = Crash.FENDER_BENDER;
    Crash crash2 = Crash.WITHOUT_INJURIES;

    trafficViolations.add(violation1);
    trafficViolations.add(violation2);
    IVehicleCrash vehicleCrash1 = new VehicleCrash(date, crash1);
    IVehicleCrash vehicleCrash2 = new VehicleCrash(date, crash2);
    crashes.add(vehicleCrash1);
    crashes.add(vehicleCrash2);
  }

  @Test
  public void getTrafficViolations() {
    final String VIOLATIONS_AS_STRING = "";

   // assertEquals(VIOLATIONS_AS_STRING, trafficViolations.toString());
  }

  @Test
  public void getCrashes() {
    final String CRASHES_AS_STRING = "";

  //  assertEquals(CRASHES_AS_STRING, crashes.toString());
  }
}