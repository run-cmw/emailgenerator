package edu.neu.ccs.cs5004.Assignment8.Problem1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class MediaTest {

  @Before
  public void setUp() throws Exception {
    ArrayList<Director> directorlist = new ArrayList<>();
    ArrayList<Actor> actorsList = new ArrayList<>();
    Media mediatotest = new Media("TV1", "wild west", 2001, directorlist,
                            actorsList ,23 );

  }

  @Test
  public void addNewDirector() {
    ArrayList<Director> directorlist = new ArrayList<>();
    String first = "John";
    String last = "Nash";
    Name newDirectorName = new Name(first, last);
    Director newDirector = new Director(newDirectorName);
    directorlist.add(newDirector);
    assertEquals(true, directorlist.size() == 1);
    String first1 = "Tim";
    String last1 = "Nash";
    Name newDirectorName1 = new Name(first1, last1);
    Director newDirector1 = new Director(newDirectorName);
    directorlist.add(newDirector1);
    assertEquals(true, directorlist.size() == 2);
    directorlist.remove(newDirector1);
    assertEquals(true, directorlist.size() == 1);
    directorlist.remove(newDirector);
    assertEquals(true, directorlist.size() == 0);

  }

  @Test
  public void addNewActor() {
    ArrayList<Actor> actorsList = new ArrayList<>();
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
//    actorsList.remove(newActor1);
//    assertEquals(true, actorsList.size() == 1);
//    actorsList.remove(newActor);
//    assertEquals(true, actorsList.size() == 0);



  }

  @Test
  public void getNumberOfTimesStreamed() {
    ArrayList<Director> directorlist = new ArrayList<>();
    ArrayList<Actor> actorsList = new ArrayList<>();
    Media mediatotest = new Media("TV1", "wild west", 2001, directorlist,
        actorsList ,23 );


    assertEquals((Integer) 23, mediatotest.getNumberOfTimesStreamed());
    assertNotEquals((Integer) 35, mediatotest.getNumberOfTimesStreamed());


  }

}