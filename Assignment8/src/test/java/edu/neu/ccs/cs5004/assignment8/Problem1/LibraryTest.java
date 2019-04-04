package edu.neu.ccs.cs5004.assignment8.Problem1;

import static org.junit.Assert.*;
import java.util.ArrayList;

import java.util.HashSet;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;


public class LibraryTest {

  AbstractMedia media1;
  AbstractMedia media11;
  AbstractMedia media2;
  AbstractMedia media22;
  AbstractMedia media3;
  AbstractMedia media4;
  AbstractMedia media5;
  AbstractMedia mediat;
  AbstractMedia workOfDirectors1;
  AbstractMedia workOfDirectors2;
  Library newLibrary1;
  Set<AbstractMedia> items;
  ArrayList<Director> directorlist2;
  ArrayList<Actor> actorsList;

  @Before
  public void setUp() throws Exception {
    items = new HashSet<>() ;
    newLibrary1 = new Library(items);
    directorlist2 = new ArrayList<>();
    actorsList = new ArrayList<>();
    mediat = new Media("TV1", "wild west", 2001, directorlist2,
        actorsList ,23 );





  }

  @Test
  public void getDirectorsWork() {
    Name newDirectorName3 = new Name("John", "Nash");
    Director newDirector3 = new Director(newDirectorName3);
    directorlist2.add(newDirector3);

    Name newDirectorName4 = new Name("Tim", "Nash");
    Director newDirector4 = new Director(newDirectorName4);
    directorlist2.add(newDirector4);

    Name newActorName11 = new Name("Timmy", "John");
    Actor newActor11 = new Actor(newActorName11);
    actorsList.add(newActor11);

    Name newActorName2 = new Name("Johnny", "John");
    Actor newActor2 = new Actor(newActorName2);
    actorsList.add(newActor2);

    Name newActorName22 = new Name("Timmy", "Tom");
    Actor newActor22 = new Actor(newActorName22);
    actorsList.add(newActor22);

    media1 = new Media("TV1", "wild west", 2001, directorlist2,
        actorsList ,23 );
    media2 = new Media("TV2", "wild west2", 2002, directorlist2,
        actorsList ,32 );


    items.add(media1);
    items.add(media2);


    ArrayList<AbstractMedia> workOfDirectorsList = new ArrayList<>();
    workOfDirectors1 = new Media("TV2", "wild west2", 2002, directorlist2,
        actorsList ,32 );
    workOfDirectors2 = new Media("TV1", "wild west", 2001, directorlist2,
        actorsList ,23 );

    workOfDirectorsList.add(workOfDirectors1);
    workOfDirectorsList.add(workOfDirectors2);


    assertEquals(workOfDirectorsList, newLibrary1.getDirectorsWork("John", "Nash"));



  }

  @Test(expected = AliasExistsException.class)
  public void addTVMovie() throws Exception {

    Library newLibrary1 = new Library(items);
    ArrayList<Director> directorlist2 = new ArrayList<>();

    Name newDirectorName3 = new Name("John", "Nash");
    Director newDirector3 = new Director(newDirectorName3);
    directorlist2.add(newDirector3);
    Name newDirectorName4 = new Name("Tim", "Nash");
    Director newDirector4 = new Director(newDirectorName4);
    directorlist2.add(newDirector4);


    ArrayList<Actor> actorsList = new ArrayList<>();

    Name newActorName11 = new Name("Timmy", "John");
    Actor newActor11 = new Actor(newActorName11);
    actorsList.add(newActor11);

    Name newActorName2 = new Name("Johnny", "John");
    Actor newActor2 = new Actor(newActorName2);
    actorsList.add(newActor2);

    Name newActorName22 = new Name("Timmy", "Tom");
    Actor newActor22 = new Actor(newActorName22);
    actorsList.add(newActor22);

    media1 = new Media("TV1", "wild west", 2001, directorlist2,
        actorsList ,23 );
    media2 = new Media("TV2", "wild west2", 2002, directorlist2,
        actorsList ,32 );
    media3 = new Media("TV3", "wild west3", 2003, directorlist2,
        actorsList ,43 );
    media4 = new Media("TV4", "wild west4", 2004, directorlist2,
        actorsList ,53 );

    items.add(media1);
    assertTrue(items.contains(media1));
    items.add(media2);
    assertTrue(items.contains(media2));
    items.add(media3);
    assertTrue(items.contains(media3));
    items.add(media4);
    assertTrue(items.contains(media4));


   media5 = new Media("TV1", "wild west", 2001, directorlist2,
       actorsList ,22 );

    newLibrary1.addTVMovie(media5);
    int length = items.size();
    assertTrue(5 == length );

    // Checking if exception works:

    newLibrary1.addTVMovie(media5);







  }

  @Test
  public void countTimesStreamed() {

    Library newLibrary1 = new Library(items);

    ArrayList<Director> directorlist2 = new ArrayList<>();
    Name newDirectorName3 = new Name("John", "Nash");
    Director newDirector3 = new Director(newDirectorName3);
    directorlist2.add(newDirector3);
    Name newDirectorName4 = new Name("Tim", "Nash");
    Director newDirector4 = new Director(newDirectorName4);
    directorlist2.add(newDirector4);


    ArrayList<Actor> actorsList = new ArrayList<>();

    Name newActorName11 = new Name("Timmy", "John");
    Actor newActor11 = new Actor(newActorName11);
    actorsList.add(newActor11);

    Name newActorName2 = new Name("Johnny", "John");
    Actor newActor2 = new Actor(newActorName2);
    actorsList.add(newActor2);

    Name newActorName22 = new Name("Timmy", "Tom");
    Actor newActor22 = new Actor(newActorName22);
    actorsList.add(newActor22);

    media1 = new Media("TV1", "wild west", 2001, directorlist2,
        actorsList ,23 );
    media2 = new Media("TV2", "wild west2", 2002, directorlist2,
        actorsList ,32 );
    media3 = new Media("TV3", "wild west3", 2003, directorlist2,
        actorsList ,43 );
    media4 = new Media("TV4", "wild west4", 2004, directorlist2,
        actorsList ,53 );

    items.add(media1);
    items.add(media2);
    items.add(media3);
    items.add(media4);

    assertTrue((Integer)53 == newLibrary1.countTimesStreamed("TV4"));
    assertTrue((Integer)43 == newLibrary1.countTimesStreamed("TV3"));
    assertNotEquals((Integer) 322,  newLibrary1.countTimesStreamed("TV4"));


  }


  @Test
  public void increaseStreaming() {

    Set<AbstractMedia> items = new HashSet<>() ;
    Library newLibrary1 = new Library(items);

    ArrayList<Director> directorlist2 = new ArrayList<>();

    Name newDirectorName3 = new Name("John", "Nash");
    Director newDirector3 = new Director(newDirectorName3);
    directorlist2.add(newDirector3);

    Name newDirectorName4 = new Name("Tim", "Nash");
    Director newDirector4 = new Director(newDirectorName4);
    directorlist2.add(newDirector4);


    ArrayList<Actor> actorsList = new ArrayList<>();

    Name newActorName11 = new Name("Timmy", "John");
    Actor newActor11 = new Actor(newActorName11);
    actorsList.add(newActor11);

    Name newActorName2 = new Name("Johnny", "John");
    Actor newActor2 = new Actor(newActorName2);
    actorsList.add(newActor2);

    Name newActorName22 = new Name("Timmy", "Tom");
    Actor newActor22 = new Actor(newActorName22);
    actorsList.add(newActor22);

    media1 = new Media("TV1", "wild west", 2001, directorlist2,
        actorsList ,23 );
    media2 = new Media("TV2", "wild west2", 2002, directorlist2,
        actorsList ,32 );
    media3 = new Media("TV3", "wild west3", 2003, directorlist2,
        actorsList ,43 );
    media4 = new Media("TV4", "wild west4", 2004, directorlist2,
        actorsList ,53 );

    items.add(media1);
    items.add(media2);
    items.add(media3);
    items.add(media4);

    newLibrary1.increaseStreaming("TV4");
    assertEquals((Integer)54, newLibrary1.countTimesStreamed("TV4"));
    newLibrary1.increaseStreaming("TV4");
    assertEquals((Integer)55, newLibrary1.countTimesStreamed("TV4"));
    newLibrary1.increaseStreaming("TV1");
    assertEquals((Integer)24, newLibrary1.countTimesStreamed("TV1"));


  }


  @Test
  public void getMostStreamed() {
    Set<AbstractMedia> items = new HashSet<>() ;
    Library newLibrary1 = new Library(items);

    ArrayList<Director> directorlist2 = new ArrayList<>();

    Name newDirectorName3 = new Name("John", "Nash");
    Director newDirector3 = new Director(newDirectorName3);
    directorlist2.add(newDirector3);

    Name newDirectorName4 = new Name("Tim", "Nash");
    Director newDirector4 = new Director(newDirectorName4);
    directorlist2.add(newDirector4);


    ArrayList<Actor> actorsList = new ArrayList<>();

    Name newActorName11 = new Name("Timmy", "John");
    Actor newActor11 = new Actor(newActorName11);
    actorsList.add(newActor11);

    Name newActorName2 = new Name("Johnny", "John");
    Actor newActor2 = new Actor(newActorName2);
    actorsList.add(newActor2);

    Name newActorName22 = new Name("Timmy", "Tom");
    Actor newActor22 = new Actor(newActorName22);
    actorsList.add(newActor22);

    media1 = new Media("TV1", "wild west", 2001, directorlist2,
        actorsList ,23 );
    media2 = new Media("TV2", "wild west2", 2002, directorlist2,
        actorsList ,32 );
    media3 = new Media("TV3", "wild west3", 2003, directorlist2,
        actorsList ,43 );
    media4 = new Media("TV4", "wild west4", 2004, directorlist2,
        actorsList ,53 );

    items.add(media1);
    items.add(media2);
    items.add(media3);
    items.add(media4);

    assertSame(media4, newLibrary1.getMostStreamed());
    assertNotSame(media3, newLibrary1.getMostStreamed());

    media11 = new Media("TV1", "wild west4", 2010, directorlist2,
        actorsList ,23 );
    media22 = new Media("TV2", "wild west24", 2002, directorlist2,
        actorsList ,300 );
    items.add(media11);
    items.add(media22);

    assertSame(media22, newLibrary1.getMostStreamed());


  }

  @Test
  public void testHashCode() throws Exception{

    Name newDirectorName3 = new Name("John", "Nash");
    Director newDirector3 = new Director(newDirectorName3);
    directorlist2.add(newDirector3);

    Name newActorName11 = new Name("Timmy", "John");
    Actor newActor11 = new Actor(newActorName11);
    actorsList.add(newActor11);



    media1 = new Media("TV1", "wild west", 2001, directorlist2,
        actorsList ,23 );


    assertTrue(media1.hashCode() == mediat.hashCode());

  }

  @Test
  public void differentHashCode() {
    ArrayList<Director> directorlist2 = new ArrayList<>();
    Name newDirectorName3 = new Name("John", "Nash");
    Director newDirector3 = new Director(newDirectorName3);
    directorlist2.add(newDirector3);

    ArrayList<Actor> actorsList = new ArrayList<>();

    Name newActorName11 = new Name("Timmy", "John");
    Actor newActor11 = new Actor(newActorName11);
    actorsList.add(newActor11);



    media1 = new Media("TV1", "wild west", 2001, directorlist2,
        actorsList ,23 );
    media2 = new Media("TV2", "wild west2", 2002, directorlist2,
        actorsList ,32 );
    media3 = new Media("TV3", "wild west3", 2003, directorlist2,
        actorsList ,43 );
    media4 = new Media("TV4", "wild west4", 2004, directorlist2,
        actorsList ,53 );



    assertNotEquals(media1.hashCode(), media3.hashCode());
    assertNotEquals(media4.hashCode(), media2.hashCode());
  }



  @Test
  public void testEquals() {
    assertTrue(mediat.equals(mediat));


  }


  @Test
  public void testToString() {
    assertEquals("Media{alias='TV1', title='wild west', "
        + "releaseYear=2001, directors=[], actors=[], numberOfTimesStreamed=23}", mediat.toString());
  }
}