package edu.neu.ccs.cs5004.Assignment8.Problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NameTest {
  private Name name;

  @Before
  public void setUp() throws Exception {
    name = new Name("Unicorn", "Goddess");
  }

  @Test
  public void getFirstName() {
    assertEquals("Unicorn", name.getFirstName());
  }

  @Test
  public void getLastName() {
    assertEquals("Goddess", name.getLastName());
  }
}