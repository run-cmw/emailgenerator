package edu.neu.ccs.cs5004.assignment8.problem1;;

import java.util.ArrayList;

/**
 * This is an interface Media: IMedia
 */
public interface IMedia {

  /**
   * Returns the Alias of Media.
   * @return Alias
   */
  String getAlias();

  /**
   * Returns the title of media.
   * @return Media
   */
  String getTitle();

  /**
   * Returns the release year of media.
   * @return release year
   */

  Integer getReleaseYear();

  /**
   * Returns an array list of directors.
   * @return director Arraylist
   */
  ArrayList<Director> getDirectors();

  /**
   * Returns list of actors.
   * @return actor Array list
   */
  ArrayList<Actor> getActors();

  /**
   * Returns the number of times media was streamed.
   * @return number of times media was streamed
   */

  Integer getNumberOfTimesStreamed();








}
