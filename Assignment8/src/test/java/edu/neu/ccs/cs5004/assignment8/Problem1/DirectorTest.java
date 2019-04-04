package edu.neu.ccs.cs5004.assignment8.Problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DirectorTest {

  Director john;
  Name name1;
  Director johnny;
  Name name2;

  @Before
  public void setUp() throws Exception {
    name1 = new Name("John", "Nash");
    john = new Director(name1);
    name2 = new Name("Tim", "Nash");
    johnny = new Director(name2);

  }


  @Test
  public void testGetName() {

    assertEquals(name1, john.getName());
    assertNotEquals(name2, john.getName());
  }

  @Test
  public void testHashCode(){
    name2 = new Name("John", "Nash");
    john = new Director(name2);
    assertEquals(john.hashCode(), john.hashCode());
  }

  @Test
  public void testEquals() {
    assertTrue(name1.equals(name1));
    Name name2 = new Name("John", "Nash");
    assertTrue(name2.equals(name2));
    assertTrue(name1 instanceof Name);


  }


}