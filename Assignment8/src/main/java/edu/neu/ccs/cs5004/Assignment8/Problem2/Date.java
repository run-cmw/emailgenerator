package edu.neu.ccs.cs5004.Assignment8.Problem2;

import java.util.Objects;

/**
 * This class implements IDate and represents a date.
 */
public class Date implements IDate {
  private int day;
  private int month;
  private int year;

  /**
   * Construct a date with the given day, month, and year.
   *
   * @param day - date's day
   * @param month - date's month
   * @param year - date's year
   */
  public Date(int day, int month, int year) {
    this.day = day;
    this.month = month;
    this.year = year;
  }

  /**
   * Return the day.
   *
   * @return the day
   */
  public int getDay() {
    return day;
  }

  /**
   * Return the month.
   *
   * @return the month
   */
  public int getMonth() {
    return month;
  }

  /**
   * Return the year.
   *
   * @return the year
   */
  public int getYear() {
    return year;
  }

  /**
   * Indicates whether some other object is "equal to" this one.
   *
   * @param obj - the reference object with which to compare
   * @return {@code true} if this object is the same as the obj argument and {@code false} otherwise
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Date)) {
      return false;
    }
    Date other = (Date) obj;
    return this.getDay() == other.getDay()
        && this.getMonth() == other.getMonth()
        && this.getYear() == other.getYear();
  }

  /**
   * Returns a hash code value for the object.
   *
   * @return hash code value for the object
   */
  @Override
  public int hashCode() {
    return Objects.hash(day, month, year);
  }

  /**
   * Returns a string representation of the object.
   * Format - "month/day/year"
   *
   * @return string representation of the object
   */

  @Override
  public String toString() {
    return this.getMonth() + "/" + this.getDay() + "/" + this.getYear();
  }
}
