package edu.neu.css.cs5004;

import java.util.List;

/**
 * This interface contains all functinality that the CSV Processor supports.
 */
public interface ICsvProcessor {
  /**
   * Return ArrayList of header titles.
   *
   * @return ArrayList of header titles
   */
  List<String> getHeaderArrayList();

  /**
   * Return ArrayList of ArrayLists of member information.
   *
   * @return ArrayList of ArrayLists of member information
   */
  List<List<String>> getMemberInfoArrayList();

  /**
   * Indicates whether some other object is "equal to" this one.
   *
   * @param obj - the reference object with which to compare
   * @return {@code true} if this object is the same as the obj argument and {@code false} otherwise
   */
  boolean equals(Object obj);

  /**
   * Returns a hash code value for the object.
   *
   * @return hash code value for the object
   */
  int hashCode();

  /**
   * Returns a string representation of the object.
   * Format -
   * "Header titles: [header_title, header_title, header_title,...]
   *  Member data: [[member1_info, member1_info, member1_info],
   *               [member2_info, member1_info, member1_info], ...]"
   *
   * @return string representation of the object
   */
  String toString();
}
