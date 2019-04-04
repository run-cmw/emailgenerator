package edu.neu.ccs.cs5004.assignment8.Problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ActorTest {

  Actor john;
  Name name1;
  Actor johnny;
  Name name2;
  Actor timmy;

  @Before
  public void setUp() throws Exception {
    name1 = new Name("John", "Nash");
    john = new Actor(name1);
    name2 = new Name("Tim", "Nash");
    johnny = new Actor(name2);
    name2 = new Name("Timmy", "Nash");
    timmy = new Actor(name2);

  }


  @Test
  public void testGetName() {

    assertEquals(name1, john.getName());
    assertNotEquals(name2, john.getName());

  }

  @Test
  public void testHashCode(){
    name2 = new Name("John", "Nash");
    john = new Actor(name2);
    assertEquals(john.hashCode(), john.hashCode());
  }

  @Test
  public void testEquals() {
    assertTrue(name1.equals(name1));
    Name name2 = new Name("John", "Nash");
    assertTrue(name2.equals(name2));
    name2 = new Name("John", "Nash");
    john = new Actor(name2);
    assertTrue(john instanceof Actor);


  }


  @Test
  public void testToString() {
    assertFalse(john.toString() == "Actor{name = Name {name='null'}}");
  }
}