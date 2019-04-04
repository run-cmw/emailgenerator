package edu.neu.ccs.cs5004.assignment8.Problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AbstractNameTest {

  AbstractName name;
  Name name2;

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



  @Test
  public void testHashCode() throws Exception{
    Name name2 = new Name("John", "Nash");
    assertTrue(name.hashCode() == name2.hashCode());
  }

  @Test
  public void testEquals() {
    assertTrue(name.equals(name));
    Name name2 = new Name("Johnn", "Nash");
    name = new Name("John", "Nash");
    assertTrue(name.getfirstName().equals("John"));
    assertTrue(name.getlastName().equals("Nash"));
    assertFalse(name.getfirstName().equals("Nash"));
    assertFalse(name.getlastName().equals("John"));
    assertTrue(name2.equals(name2));
    Name name23 = new Name("Johnathan", "Nash");
    assertFalse(name2.equals(name23));
    assertTrue(name.getfirstName().equals("John")
            && name.getlastName().equals("Nash"));
    assertFalse(name.getfirstName().equals("Johnn")
        && name.getlastName().equals("Nash"));
    assertTrue(name instanceof  Name);
    assertFalse(!(name instanceof  Name));



  }

  @Test
  public void testToString() {
    Name name23 = new Name("Johnathan", "Nash");
    assertNotEquals(name23.toString(),"Name{name ='null'}");

  }


  @Test
  public void differentHashCode() {
    Name name23 = new Name("Johnathan", "Nash");
    assertNotEquals(name.hashCode(), name23.hashCode());
  }
}