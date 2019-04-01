package edu.neu.ccs.cs5004.Assignment8.Problem2;

/**
 * This class extends AbstractDate and represents a date.
 */
public class Date extends AbstractDate {

  /**
   * Construct a date with the given day, month, and year.
   *
   * @param day - date's day
   * @param month - date's month
   * @param year - date's year
   */
  public Date(int day, int month, int year) {
    super(day, month, year);
  }

  /**
   * Indicates whether some other object is "equal to" this one.
   *
   * @param obj the reference object with which to compare.
   * @return {@code true} if this object is the same as the obj argument; {@code false} otherwise.
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


  @Override
  public String toString() {
    return this.getMonth() + "/" + this.getDay() + "/" + this.getYear();
  }
}
