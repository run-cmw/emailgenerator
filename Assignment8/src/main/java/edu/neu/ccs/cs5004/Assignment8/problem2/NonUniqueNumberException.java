package edu.neu.ccs.cs5004.Assignment8.problem2;

/**
 * This class creates a new exception and is thrown if a license number is already taken.
 */
public class NonUniqueNumberException extends Exception {
  public NonUniqueNumberException(String message) {super(message);}

}
