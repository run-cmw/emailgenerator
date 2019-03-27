package java.edu.neu.ccs.cs5004.assignment7;

import java.util.ArrayList;

/**
 * This Abstract class represents receipts
 */
public class AbstractReceipt implements IReceipt{
  private int totalPrice;
  private ArrayList<StockItem> receivedItemsList;
  private ArrayList<StockItem> outOfStockList;
  private ArrayList<StockItem> removedItemsList;


  public AbstractReceipt(int totalPrice,
      ArrayList<StockItem> receivedItemsList,
      ArrayList<StockItem> outOfStockList,
      ArrayList<StockItem> removedItemsList) {
    this.totalPrice = totalPrice;
    this.receivedItemsList = receivedItemsList;
    this.outOfStockList = outOfStockList;
    this.removedItemsList = removedItemsList;
  }
}
