package edu.neu.css.cs5004;

/**
 * This interface contains all functinality that the CSV Processor supports.
 */
public interface ICSVProcessor {
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
   * "Owner: firstName lastName, Additional Insured: [firstName lastName, firstName lastName, ...]
   * "
   *
   * @return string representation of the object
   */
  String toString();
}
