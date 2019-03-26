package java.edu.neu.ccs.cs5004.assignment7;
/**
 * Exception that is thrown when attempting to purchase a stock item when there is not
 * enough of that item to purchase.
 */
public class NotEnoughItemsInStockException extends Exception {
  /**
   * Constructor.
   */
  public NotEnoughItemsInStockException() {
    super("Not enough items in stock to purchase desired amount.");
  }
}
