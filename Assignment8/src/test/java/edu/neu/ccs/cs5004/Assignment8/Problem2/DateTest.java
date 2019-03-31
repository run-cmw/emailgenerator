package edu.neu.ccs.cs5004.Assignment8.Problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DateTest {
  private Date date;

  @Before
  public void setUp() throws Exception {
    date = new Date(20, 03, 1989);
  }

  @Test
  public void getDay() {
    assertEquals(20, date.getDay());
  }

  @Test
  public void getMonth() {
    assertEquals(03, date.getMonth());
  }

  @Test
  public void getYear() {
    assertEquals(1989, date.getYear());
  }
}