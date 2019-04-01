package edu.neu.ccs.cs5004.Assignment8.Problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NameTest {

  Name name1;

  @Before
  public void setUp() throws Exception {
    name1 = new Name("John", "Nash");


  }

  @Test
  public void name() {
    assertEquals("John", name1.getfirstName());
    assertEquals("Nash", name1.getlastName());

  }
}