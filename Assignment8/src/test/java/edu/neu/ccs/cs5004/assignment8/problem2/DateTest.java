package edu.neu.ccs.cs5004.assignment8.Problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DateTest {
  private IDate date;
  private IDate same;
  private IDate different;

  @Before
  public void setUp() throws Exception {
    date = new Date(20, 3, 1989);
    same = new Date(20, 3, 1989);
    different = new Date(20, 3, 2020);
  }

  @Test
  public void getDay() {
    assertEquals(20, date.getDay());
  }

  @Test
  public void getMonth() {
    assertEquals(3, date.getMonth());
  }

  @Test
  public void getYear() {
    assertEquals(1989, date.getYear());
  }

  @Test
  public void equals() {
    assertTrue(same.equals(date));
    assertTrue(same.equals(same));
    assertFalse(different.equals(date));
    assertFalse(same.equals(2));
  }

  @Test
  public void equalHashCode() {
    assertEquals(same.hashCode(), date.hashCode());
  }

  @Test
  public void differentHashCode() {
    assertNotEquals(different.hashCode(), date.hashCode());
  }

  @Test
  public void testToString() {
    final String ADDRESS_AS_STRING = "3/20/1989";

    assertEquals(ADDRESS_AS_STRING, date.toString());
  }
}