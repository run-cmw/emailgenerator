package edu.neu.ccs.cs5004.assignment7;

public class InvalidQuantityException extends Exception  {
/**
 * Exception that is thrown when attempting to create a new IStockItem with 0 or negative quantity.
 */
  public InvalidQuantityException() {
    super("Quantity for the item must be at least 1.");
  }
}