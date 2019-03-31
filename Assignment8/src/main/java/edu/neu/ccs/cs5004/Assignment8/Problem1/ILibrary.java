package edu.neu.ccs.cs5004.Assignment8.Problem1;

import java.util.ArrayList;

/**
 * This is an interface ILibrary
 */
public interface ILibrary {

  /**
   * Returns an Array of Directors work
   * @param firstName of the Director
   * @param lastName of the Director
   * @return Array of directors work
   */
  ArrayList<AbstractMedia> getDirectorsWork(String firstName, String lastName);

  /**
   * Add a new media
   * @param newMedia type
   * @throws AliasExistsException if the newMedia to be added is already present
   */
  void addTVMovie(AbstractMedia newMedia) throws AliasExistsException;

  /**
   * Counts number of streams
   * @param alias of media
   * @return number of streams
   */
  Integer countTimesStreamed(String alias);

  /**
   * Increase the amount of streams
   * @param alias of media
   */
  void increaseStreaming(String alias);

  /**
   * Returns the most streamed media
   * @return most streamed media
   */
  AbstractMedia getMostStreamed();





}
