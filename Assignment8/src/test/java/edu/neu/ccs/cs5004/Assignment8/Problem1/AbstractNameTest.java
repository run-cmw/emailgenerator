package edu.neu.ccs.cs5004.Assignment8.Problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AbstractNameTest {

  AbstractName name;

  @Before
  public void setUp() throws Exception {
    name = new Name("John", "Nash");
  }

  @Test
  public void getfirstName() {
    assertEquals("John", name.getfirstName());
    assertNotEquals("Tim", name.getfirstName());

  }

  @Test
  public void getlastName() {
    assertEquals("Nash", name.getlastName());
    assertNotEquals("John", name.getlastName());
  }
}