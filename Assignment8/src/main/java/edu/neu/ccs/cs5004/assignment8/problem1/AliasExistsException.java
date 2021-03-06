package edu.neu.ccs.cs5004.assignment8.problem1;;

public class AliasExistsException extends Exception {

  /**
   * Constructs a new exception with given message as its detail message.
   * The cause is not initialized,
   * and may subsequently be initialized by a call to {@link #initCause}.
   */
  public AliasExistsException(String message) {
    super(message);
  }
}
