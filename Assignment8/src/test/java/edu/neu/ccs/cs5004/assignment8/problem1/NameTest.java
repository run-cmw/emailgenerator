package edu.neu.ccs.cs5004.assignment8.problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NameTest {

  Name name1;

  @Before
  public void setUp(){
    name1 = new Name("John", "Nash");


  }

  @Test
  public void name() {
    assertEquals("John", name1.getfirstName());
    assertEquals("Nash", name1.getlastName());
  }

  @Test
  public void testHashCode() throws Exception{
    Name name2 = new Name("John", "Nash");
    assertTrue(name1.hashCode() == name2.hashCode());
  }

  @Test
  public void testEquals() {
    assertTrue(name1.equals(name1));
    Name name2 = new Name("Johnn", "Nash");
    assertTrue(name2.equals(name2));
    assertFalse(name1.equals(name2));

  }



}