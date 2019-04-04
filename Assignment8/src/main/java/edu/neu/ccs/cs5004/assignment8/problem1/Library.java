package edu.neu.ccs.cs5004.assignment8.problem1;;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/**
 * This class represents a media Library. It also implements ILibrary.
 */
public class Library implements ILibrary{
  private Set<AbstractMedia> items;

  /**
   * Constructor a Library object as a Set of items.
   * @param items items to be added in the library
   */
  public Library(Set<AbstractMedia> items) {
    this.items = items;
  }

  /**
   * Returns an ArrayList containing work of Directors given their first and Last names.
   * @param firstName of director
   * @param lastName of director
   * @return ArrayList of directors
   */
  public ArrayList<AbstractMedia> getDirectorsWork(String firstName, String lastName) {
    ArrayList<AbstractMedia> WorkOfDirectors = new ArrayList<>();
    Iterator<AbstractMedia> mediaLibrary = this.items.iterator();

    while (mediaLibrary.hasNext()){
      AbstractMedia cur = mediaLibrary.next();

      for(Director director : cur.getDirectors()){
        if (director.name.getfirstName().equals(firstName) && director.name.getlastName().equals(lastName)){
          WorkOfDirectors.add(cur);
        }
      }

    }
    Collections.sort(WorkOfDirectors, Collections.<AbstractMedia>reverseOrder());

    return WorkOfDirectors;
  }

  /**
   * Add a new movie or TV series to the media library.
   * @param newMedia to be added
   * @throws AliasExistsException if alias already in use
   */
  public void addTVMovie(AbstractMedia newMedia) throws AliasExistsException {

    Iterator<AbstractMedia> mediaLibrary = this.items.iterator();

    while(mediaLibrary.hasNext()) {
      AbstractMedia cur = mediaLibrary.next();

      if (cur.getAlias().equals(newMedia.getAlias())) {
        throw new AliasExistsException("Alias exists in the library");
      }

    }
    this.items.add(newMedia);
  }

  /**
   * Returns the number of times Media has been Streamed.
   * @param alias to find the number of times the media has been streamed
   * @return Integer
   */
  public Integer countTimesStreamed(String alias) {
    Iterator<AbstractMedia> medialibrary = this.items.iterator();
    Integer count = 0;

    while (medialibrary.hasNext()) {
      AbstractMedia current = medialibrary.next();
      if (current.getAlias().equals(alias)) {
        count = current.getNumberOfTimesStreamed();
      }
    }

    return count;

  }


  /**
   * Keep track of the streaming requests given its alias by keeping a counter.
   * @param alias of the media
   */

  public void increaseStreaming(String alias) {
    Iterator<AbstractMedia> medialibrary = this.items.iterator();

    while(medialibrary.hasNext()) {
      AbstractMedia current = medialibrary.next();
      if (current.getAlias().equals(alias)) {
        current.numberOfTimesStreamed++;
      }
    }
  }

  /**
   * Method to get the most Streamed media.
   * @return most streamed media
   */

  public AbstractMedia getMostStreamed() {
    Iterator<AbstractMedia> medialibrary = this.items.iterator();
    AbstractMedia mostStreamedMedia = null;
    Integer streamcounter = 0;

    while(medialibrary.hasNext()) {
      AbstractMedia current = medialibrary.next();
      if (current.getNumberOfTimesStreamed() >= streamcounter) {
        mostStreamedMedia = current;
        streamcounter = current.getNumberOfTimesStreamed();
      }
    }
    return mostStreamedMedia;
  }


  /**
   * HashCode method.
   * @return int
   */
  @Override
  public int hashCode() {
    return Objects.hash(items);
  }

  /**
   * To string method.
   * @return String representation of the object.
   */
  @Override
  public String toString() {
    return "Library{"
        + "items=" + items + '}';
  }
}
