package edu.neu.ccs.cs5004.assignment8.problem1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class MediaTest {

  Director newDirector20;
  Media mediatotest;
  Media mediatotest1;



  @Before
  public void setUp() throws Exception {
    ArrayList<Director> directorlist = new ArrayList<>();
    ArrayList<Actor> actorsList = new ArrayList<>();

    Name newDirectorName20 = new Name("John", "Nash");
    newDirector20 = new Director(newDirectorName20);
  }

  @Test
  public void addNewDirector() {
    ArrayList<Director> directorlist = new ArrayList<>();
    Name newDirectorName = new Name("John", "Nash");
    Director newDirector = new Director(newDirectorName);
    directorlist.add(newDirector);
    assertEquals(true, directorlist.size() == 1);
    Name newDirectorName1 = new Name("Tim", "Nash");
    Director newDirector1 = new Director(newDirectorName1);
    directorlist.add(newDirector1);
    assertEquals(true, directorlist.size() == 2);
    directorlist.remove(newDirector1);
    assertEquals(true, directorlist.size() == 1);
    directorlist.remove(newDirector);
    assertEquals(true, directorlist.size() == 0);
    ArrayList<Actor> actorsList = new ArrayList<>();
    String first1 = "Timmy";
    String last1 = "John";
    Name newActorName = new Name(first1, last1);
    Actor newActor = new Actor(newActorName);
    actorsList.add(newActor);

    mediatotest = new Media("TV1", "wild west", 2001, directorlist,
        actorsList ,23 );

    mediatotest.addNewDirector("Busan", "Train");

    assertTrue(directorlist.size() == 1);




  }

  @Test
  public void addNewActor() {
    ArrayList<Actor> actorsList = new ArrayList<>();
    ArrayList<Director> directorlist = new ArrayList<>();
    String first1 = "Timmy";
    String last1 = "John";
    Name newActorName = new Name(first1, last1);
    Actor newActor = new Actor(newActorName);
    actorsList.add(newActor);
    assertEquals(true, actorsList.size() == 1);
    String first2 = "Timmy";
    String last2 = "John";
    Name newActorName1 = new Name(first2, last2);
    Actor newActor1 = new Actor(newActorName1);
    actorsList.add(newActor1);

    assertEquals(true, actorsList.size() == 2);

    mediatotest = new Media("TV1", "wild west", 2001, directorlist,
        actorsList ,23 );

    mediatotest.addNewActor("Busany", "Trainy");

    assertFalse(actorsList.size() == 1);




  }

  @Test
  public void testCompareto() {
    ArrayList<Actor> actorsList = new ArrayList<>();
    ArrayList<Director> directorlist = new ArrayList<>();
    mediatotest = new Media("TV1", "wild west", 2001, directorlist,
        actorsList ,23 );

    mediatotest1 = new Media("TV1", "wild west", 2010, directorlist,
        actorsList ,23 );


    assertEquals(-1, mediatotest.compareTo(mediatotest1));



  }


  @Test
  public void getNumberOfTimesStreamed() {
    ArrayList<Director> directorlist = new ArrayList<>();
    ArrayList<Actor> actorsList = new ArrayList<>();
    mediatotest = new Media("TV1", "wild west", 2001, directorlist,
        actorsList ,23 );


    assertEquals((Integer) 23, mediatotest.getNumberOfTimesStreamed());
    assertNotEquals((Integer) 35, mediatotest.getNumberOfTimesStreamed());


  }

  @Test
  public void testHashCode() throws Exception{
    Name newDirectorName = new Name("John", "Nash");
    Director newDirector = new Director(newDirectorName);
    assertTrue(newDirector.hashCode() == newDirector20.hashCode());
  }


  @Test
  public void differentHashCode() {
    Name newDirectorName = new Name("John", "Nash");
    Director newDirector = new Director(newDirectorName);
    Name newDirectorName2 = new Name("Johny", "Nashy");
    Director newDirector2 = new Director(newDirectorName2);
    assertNotEquals(newDirector.hashCode(), newDirector2.hashCode());

  }

  @Test
  public void testToString() {
    ArrayList<Director> directorlist = new ArrayList<>();
    String first = "John";
    String last = "Nash";
    Name newDirectorName = new Name(first, last);
    Director newDirector = new Director(newDirectorName);
    directorlist.add(newDirector);
    ArrayList<Actor> actorsList = new ArrayList<>();
    String first1 = "Timmy";
    String last1 = "John";
    Name newActorName = new Name(first1, last1);
    Actor newActor = new Actor(newActorName);
    actorsList.add(newActor);

    mediatotest = new Media("TV1", "wild west", 2001, directorlist,
        actorsList ,23 );
    assertFalse(mediatotest.toString() == "AbstractMedia{alias='TV1', title='wild west', "
        + "releaseYear=2001, directors=[Director{name=Name{name='null'}}],"
        + " actors=[Actor{name=Name{name='null'}}], numberOfTimesStreamed=23}");

  }


  @Test
  public void testEquals() {

    Name newDirectorName = new Name("John", "Nash");
    Director newDirector = new Director(newDirectorName);
    Name newName = new Name("John", "Nash");
    assertTrue(newName.equals(newName));
    assertTrue(newDirector.equals(newDirector));

  }



}