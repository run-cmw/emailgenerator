package edu.neu.ccs.cs5004.Assignment8.Problem1;

import java.util.ArrayList;

/**
 * This is an abstract class for Media: AbstractMedia
 */
public abstract class AbstractMedia implements IMedia {
  protected String alias;
  protected String title;
  protected Integer releaseYear;
  protected ArrayList<Director> directors;
  protected ArrayList<Actor> actors;
  protected Integer numberOfTimesStreamed;

  /**
   * Constructor to create a Media object
   * @param alias of the media
   * @param title of the media
   * @param releaseYear of the media
   * @param directors of the media
   * @param actors of the media
   * @param numberOfTimesStreamed of media
   */
  public AbstractMedia(String alias, String title, Integer releaseYear,
      ArrayList<Director> directors,
      ArrayList<Actor> actors, Integer numberOfTimesStreamed) {
    this.alias = alias;
    this.title = title;
    this.releaseYear = releaseYear;
    this.directors = directors;
    this.actors = actors;
    this.numberOfTimesStreamed = numberOfTimesStreamed;
  }

  /**
   * Returns the alias of the media
   * @return alias
   */
  public String getAlias() {
    return alias;
  }

  /**
   * Returns the title of the media
   * @return title
   */
  public String getTitle() {
    return title;
  }

  /**
   * returns the release year
   * @return release year
   */
  public Integer getReleaseYear() {
    return releaseYear;
  }

  /**
   * Returns an arraylist of directors
   * @return Array list of directors
   */
  public ArrayList<Director> getDirectors() {
    return directors;
  }

  /**
   * Returns an arraylist of actors
   * @return actors array list
   */
  public ArrayList<Actor> getActors() {
    return actors;
  }



}
