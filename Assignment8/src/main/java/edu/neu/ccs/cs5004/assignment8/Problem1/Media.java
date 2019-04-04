package edu.neu.ccs.cs5004.assignment8.Problem1;

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

  @Override
  public int compareTo(Object media) {
    return (this.getReleaseYear() < ((AbstractMedia)media).getReleaseYear() ? -1 :
        (this.getReleaseYear().equals(((AbstractMedia) media).getReleaseYear()) ? 0 : 1));

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
   * Returns the string representation of the object
   * @return String
   */

  @Override
  public String toString() {
    return "Media{" +
        "alias='" + alias + '\'' +
        ", title='" + title + '\'' +
        ", releaseYear=" + releaseYear +
        ", directors=" + directors +
        ", actors=" + actors +
        ", numberOfTimesStreamed=" + numberOfTimesStreamed +
        '}';
  }




}
