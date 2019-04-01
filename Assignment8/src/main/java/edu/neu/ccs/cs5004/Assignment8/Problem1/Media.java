package edu.neu.ccs.cs5004.Assignment8.Problem1;

import java.util.ArrayList;

/**
 * Class Media
 */
public class Media extends AbstractMedia{

  /**
   * This is the Media class
   * @param alias of the media
   * @param title of the media
   * @param releaseYear of the media
   * @param directors of the media
   * @param actors of the media
   * @param numberOfTimesStreamed of the media
   */
  public Media(String alias, String title, Integer releaseYear,
      ArrayList<Director> directors,
      ArrayList<Actor> actors, Integer numberOfTimesStreamed) {
    super(alias, title, releaseYear, directors, actors, numberOfTimesStreamed);
  }


  /**
   * Method to add a new Director
   * @param first name of the director
   * @param last name of the director
   */
  public void addNewDirector(String first, String last){
    Name newDirectorName = new Name(first, last);
    Director newDirector = new Director(newDirectorName);
    directors.add(newDirector);

  }

  /**
   * Method to add a new actor
   * @param first name of the actor
   * @param last name of the actor
   */
  public void addNewActor(String first, String last){
    Name newActorName = new Name(first, last);
    Actor newActor = new Actor(newActorName);
    actors.add(newActor);

  }

  /**
   * Returns the number of times media was streamed
   * @return number of times media was streamed
   */
  public Integer getNumberOfTimesStreamed() {
    return numberOfTimesStreamed;
  }

  /**
   * counter to count the number of times streamed
   */
  public void increaseStreamCount(){
    this.numberOfTimesStreamed += 1;
  }





}
