package edu.neu.ccs.cs5004.assignment8.Problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NameTest {
  private Name name;
  private IName same;
  private IName different;

  @Before
  public void setUp() throws Exception {
    name = new Name("Unicorn", "Goddess");
    same = new Name("Unicorn", "Goddess");
    different = new Name("Aaliyah", "Haughton");
  }

  @Test
  public void getFirstName() {
    assertEquals("Unicorn", name.getFirstName());
  }

  @Test
  public void getLastName() {
    assertEquals("Goddess", name.getLastName());
  }

  @Test
  public void equals() {
    assertTrue(same.equals(name));
    assertTrue(same.equals(same));
    assertFalse(different.equals(name));
    assertFalse(same.equals(2));
  }

  @Test
  public void equalHashCode() {
    assertEquals(same.hashCode(), name.hashCode());
  }

  @Test
  public void differentHashCode() {
    assertNotEquals(different.hashCode(), name.hashCode());
  }

  @Test
  public void testToString() {
    final String NAME_AS_STRING = "Unicorn Goddess";

    assertEquals(NAME_AS_STRING, name.toString());
  }
}