package edu.neu.ccs.cs5004.Assignment8.problem2;

public interface IDate {

  /**
   * Return the day.
   *
   * @return the day
   */
  int getDay();

  /**
   * Return the month.
   *
   * @return the month
   */
  int getMonth();

  /**
   * Return the year.
   *
   * @return the year
   */
  int getYear();

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
   * Format - "month/day/year"
   *
   * @return string representation of the object
   */
  String toString();
}
