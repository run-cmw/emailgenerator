package edu.neu.ccs.cs5004.Assignment8.Problem1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;

public class LibraryTest {


  AbstractMedia media1;
  AbstractMedia media2;
  AbstractMedia media3;
  AbstractMedia media4;



  @Before
  public void setUp() throws Exception {


  }

  @Test
  public void getDirectorsWork() {
    Set<AbstractMedia> items = new HashSet<AbstractMedia>();
    ArrayList<AbstractMedia> directorWorkList = new ArrayList<>();


    media1 = new Media("TV1", "DrugLords", 2012, directorlist, actorlist, 20)
    media2 = new Media("MOVIE1", "DrugLords", 2012, directorlist, actorlist, 35);
    media3 = new Media("TV2", "DrugLords", 2012, directorlist, actorlist, 25);
    media4 = new Media("MOVIE2", "DrugLords", 2012, directorlist, actorlist, 10);

    directorWorkList.add(0, media1);

    items.add(media1);
    items.add(media2);
    items.add(media3);
    items.add(media4);

  }

  @Test
  public void addTVMovie() {
  }

  @Test
  public void countTimesStreamed() {
  }

  @Test
  public void increaseStreaming() {
  }

  @Test
  public void getMostStreamed() {
  }
}