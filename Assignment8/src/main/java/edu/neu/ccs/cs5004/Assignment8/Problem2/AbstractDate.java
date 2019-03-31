package edu.neu.ccs.cs5004.Assignment8.Problem2;

/**
 * This abstract class implements IDate and represents a date.
 */
public class AbstractDate implements IDate {
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
  public AbstractDate(int day, int month, int year) {
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
}
