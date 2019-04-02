package edu.neu.ccs.cs5004.Assignment8.Problem1;

import java.util.ArrayList;
import java.util.Objects;

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

  /**
   * Returns if the objects are the same
   * @param obj reference to compare
   * @return true if the object is same as the object being passed as param, false otherwise
   */

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof AbstractMedia)) {
      return false;
    }
    AbstractMedia that = (AbstractMedia) obj;
    return getAlias().equals(that.getAlias()) &&
        getTitle().equals(that.getTitle()) &&
        getReleaseYear().equals(that.getReleaseYear()) &&
        getDirectors().equals(that.getDirectors()) &&
        getActors().equals(that.getActors()) &&
        getNumberOfTimesStreamed().equals(that.getNumberOfTimesStreamed());
  }

  /**
   * returns the hashcode value for the object
   * @return hashcode
   */
  @Override
  public int hashCode() {
    return Objects.hash(getAlias(), getTitle(), getReleaseYear(), getDirectors(), getActors(),
        getNumberOfTimesStreamed());
  }

  /**
   * Returns string representation of the object
   * @return String representation of the object
   */
  @Override
  public String toString() {
    return "AbstractMedia{" +
        "alias='" + alias + '\'' +
        ", title='" + title + '\'' +
        ", releaseYear=" + releaseYear +
        ", directors=" + directors +
        ", actors=" + actors +
        ", numberOfTimesStreamed=" + numberOfTimesStreamed +
        '}';
  }
}
