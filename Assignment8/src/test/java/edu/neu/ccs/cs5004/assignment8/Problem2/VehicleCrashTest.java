package edu.neu.ccs.cs5004.assignment8.Problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VehicleCrashTest {
  private VehicleCrash crash;

  @Before
  public void setUp() throws Exception {
    Date date = new Date(1, 1, 2011);
    crash = new VehicleCrash(date, Crash.FENDER_BENDER);
  }

  @Test
  public void getCrashDate() {
    final String DATE_AS_STRING = "1/1/2011";

    assertEquals(DATE_AS_STRING, crash.getCrashDate().toString());
  }

  @Test
  public void getCrash() {
    assertEquals(Crash.FENDER_BENDER, crash.getCrash());
  }
}