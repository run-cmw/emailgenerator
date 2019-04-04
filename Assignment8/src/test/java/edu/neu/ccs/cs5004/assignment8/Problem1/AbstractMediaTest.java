package edu.neu.ccs.cs5004.assignment8.Problem1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class AbstractMediaTest {

  AbstractMedia media1;
  Director director1;
  Director director2;
  Director director3;
  Director director4;
  Director director12;

  @Before
  public void setUp() throws Exception {
    ArrayList<Director> directorlist = new ArrayList<>();
    ArrayList<Actor> actorlist = new ArrayList<>();

    Name name = new Name("John", "Nash");
    director1 = new Director(name);
    directorlist.add(director1);
    Name name2 = new Name("Tim", "Nash");
    director2 = new Director(name2);
    directorlist.add(director2);
    Name name3 = new Name("Bo", "Nash");
    director3 = new Director(name3);
    directorlist.add(director3);
    Name name4 = new Name("Ash", "Nash");
    director4 = new Director(name4);
    directorlist.add(director4);

    media1 = new Media("TV2", "Drug Lords", 2012, directorlist, actorlist, 35);


  }

  @Test
  public void getAlias() {
    assertEquals("TV2", media1.getAlias());
    assertNotEquals("TV3", media1.getAlias());

  }

  @Test
  public void getTitle() {
    assertEquals("Drug Lords", media1.getTitle());
    assertNotEquals("Drug Lordws", media1.getTitle());

  }

  @Test
  public void getReleaseYear() {
    assertEquals((Integer) 2012, media1.getReleaseYear());
    assertNotEquals((Integer) 2011, media1.getReleaseYear());

  }

  @Test
  public void getDirectors() {
    ArrayList<Director> directorlist = new ArrayList<>();

    Name name = new Name("John", "Nash");
    Director director1 = new Director(name);
    directorlist.add(director1);
    Name name2 = new Name("Tim", "Nash");
    Director director2 = new Director(name);
    directorlist.add(director2);
    Name name3 = new Name("Bo", "Nash");
    Director director3 = new Director(name);
    directorlist.add(director3);
    Name name4 = new Name("Ash", "Nash");
    Director director4 = new Director(name);
    directorlist.add(director4);

    assertEquals(4, directorlist.size());
    directorlist.remove(director2);
    assertEquals(3, directorlist.size());


  }

  @Test
  public void getActors() {
    ArrayList<Actor> actorlist = new ArrayList<>();
    Name name1 = new Name("Albert", "Einstein");
    Actor actor1 = new Actor(name1);
    actorlist.add(actor1);
    Name name2 = new Name("Nikola", "Tesla");
    Actor actor2 = new Actor(name2);
    actorlist.add(actor2);
    Name name3 = new Name("Bill", "Gates");
    Actor actor3 = new Actor(name3);
    actorlist.add(actor3);
    Name name4 = new Name("Grace", "Hopper");
    Actor actor4 = new Actor(name4);
    actorlist.add(actor4);
    assertEquals(4, actorlist.size());
    actorlist.remove(actor2);
    assertEquals(3, actorlist.size());

  }


  @Test
  public void testHashCode() throws Exception {
    Name name = new Name("John", "Nash");
    Director director2 = new Director(name);
    assertTrue(director1.hashCode() == director2.hashCode());

  }


  @Test
  public void testEquals() {
    Name name222 = new Name("John", "Nash");
    director12 = new Director(name222);
    assertTrue(director12.equals(director12));
    Name name2 = new Name("Johnn", "Nash");
    assertTrue(name2.equals(name2));
    Name name23 = new Name("Johnathan", "Nash");
    assertTrue(name23.equals(name23));
    assertTrue( name23 instanceof Name);
    assertFalse( !(name23 instanceof Name));

  }

}