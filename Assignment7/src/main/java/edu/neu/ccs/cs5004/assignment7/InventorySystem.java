package edu.neu.ccs.cs5004.assignment7;

import java.util.ArrayList;

/**
 * This class represents  the inventory system
 */
public class InventorySystem implements IInventorySystem {

  private ArrayList<IStockItem> groceryStock;
  private ArrayList<IStockItem> householdStock;

  public InventorySystem() {
    groceryStock = new ArrayList<IStockItem>();
    householdStock = new ArrayList<IStockItem>();
  }

  /**
   * Checks if there are enough items in stock
   *
   * @param item items in stock
   * @param quantity of items in stock
   * @return true if there are enough items, false otherwise
   */

  @Override
  public Boolean enoughItemsInStock(IStockItem item, int quantity) {
    if (item.getQuantity() >= quantity) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Reduce the amount of stock given items and quantity of items
   *
   * @param item to be reduced from stock
   * @param quantity of items to be reduced from stock
   * @throws NotEnoughItemsInStockException thrown if enough items are not in stock
   */
  @Override
  public void reduceStockItem(IStockItem item, int quantity) throws NotEnoughItemsInStockException {
    if (enoughItemsInStock(item, quantity)) {
      item.reduceQuantity(quantity);
    } else {
      throw new NotEnoughItemsInStockException();
    }
  }

  /**
   * Add a new item
   *
   * @param item item added
   */
  @Override
  public void addNewItem(IStockItem item) {
// Remove comment after reading: made helper method isGrocery since this code is repeated several times in the class
//    Class grocery = AbstractGrocery.class;
//    Boolean isGrocery = grocery.isInstance(item.getProduct());
// Also, not sure if this is the best way to do this since there will be more StockItems
// added (e.g. electronics, toys, etc.). But that's something to keep in mind for future assignments.
    if (isGrocery(item.getProduct())) {
      groceryStock.add(item);
    } else {
      householdStock.add(item);
    }
  }

  /**
   * Returns the total retail value
   *
   * @return total retail value
   */
  @Override
  public int getTotalRetailValue() {
    int value = 0;
    int grocerySize = this.groceryStock.size();
    int householdSize = this.householdStock.size();

    // Iterating through groceryStock list and adding all prices.
    for (int i = 0; i < grocerySize; i++) {
      value += this.groceryStock.get(i).getProduct().getPrice();
    }
    // Iterating through householdStock list and adding all prices.
    for (int i = 0; i < householdSize; i++) {
      value += this.householdStock.get(i).getProduct().getPrice();
    }
    return value;
  }

  /**
   * Returns a list of Grocery stock
   *
   * @return grocery items in stock
   */
  @Override
  public ArrayList<IStockItem> getGroceryStock() {
    return this.groceryStock;
  }

  /**
   * Returns a list of Household stock
   *
   * @return household items in stock
   */
  @Override
  public ArrayList<IStockItem> getHouseholdStock() {
    return this.householdStock;
  }

  /**
   * Gathers all items in the cart and prepares for pickup.
   *
   * @param cart - The shopping cart filled with the order that the customer has placed.
   * @return - A shopping cart
   */
  @Override
  public IShoppingCart fulfillOrder(IShoppingCart cart) {
    IStockItem substitute;
    int shoppingCartSize = cart.size();

    for (int i = 0; i < shoppingCartSize; i++) {
      if (!enoughItemsInStock(i)) {
        substituteCartProduct();
      }
      else {
        // CHANGE method below!! Remove original item from cart not from stock. ShoppingCart needs remove method.
        reduceStockItem(i);
      }
    }

    return cart;
  }

  /**
   * Private method to substitute shopping cart product with equivalent item under the following
   * four conditions: same type of product, similar price, similar weight, and sufficient quantity.
   *
   * @throws NotEnoughItemsInStockException if there is not a sufficient quantity of an item
   */
  private void substituteCartProduct() throws NotEnoughItemsInStockException {
    IShoppingCart cart;
    IProducts substitute = ; // get cart item type then just start iterating through applicable list for subs?

    for (int i = 0; i < cart.size(); i++) {
      if(isSameType(substitute) && isSimilarPrice(substitute) && isSimilarWeight(substitute) && enoughItemsInStock(substitute)) {
        cart.addProduct(substitute);
      }
    }
  }

  /**
   * Private method to find the StockItem that maps to a product.
   * @param product - The product that the StockItem should map to.
   * @return IStockItem that maps to the given product.
   */
  public IStockItem findStockItem(IProducts product) {
// Remove comment after reading: made helper method isGrocery since this code is repeated several times in the class
//    Class grocery = AbstractGrocery.class;
//    Boolean isGrocery = grocery.isInstance(product);
    int size;
    ArrayList<IStockItem> list;
    IStockItem item = null;

    if (isGrocery(product)) {
      size = this.groceryStock.size();
      list = this.groceryStock;
    } else {
      size = this.householdStock.size();
      list = this.householdStock;
    }
    for (int i = 0; i < size; i++) {
      IProducts currentProduct = list.get(i).getProduct();
      if (currentProduct == product) {
         item = list.get(i);
      }
    }
    return item;
  }

  /**
   * Private method to return whether the given product is a grocery stock item.
   *
   * @return true if a product is a grocery product and false otherwise
   */
  private boolean isGrocery(IProducts product) {
    Class grocery = AbstractGrocery.class;
    return (grocery.isInstance(product));
  }

  /**
   * Private method to return whether the substitute product is the same specific type of product as the original product.
   *
   * @return true if substitute product is the same type as original product and false otherwise
   */
  private boolean isSameType(IProducts substitute, IProducts original) {
    return (substitute.getClass().equals(original.getClass()));
  }

  /**
   * Private method to return whether the substitute product is the same price or cheaper than the original product.
   *
   * @return true if substitute product is a similar price as original product and false otherwise
   */
  private boolean isSimilarPrice(IProducts substitute, IProducts original) {
    return (substitute.getPrice() <= original.getPrice());
  }

  /**
   * Private method to return whether the substitute product is the same weight or more than the original product.
   *
   * @param substitute - product to substitute original item in ShoppingCart
   * @return true if substitute product is a similar weight as original product and false otherwise
   */
  private boolean isSimilarWeight(IProducts substitute, IProducts original) {
    if (isGrocery(substitute)) {
      return (((AbstractGrocery)substitute).getWeight() >= ((AbstractGrocery)original).getWeight());
    } else {
      // If not a grocery item, weight does not matter and therefore should not impact substitution.
      return true;
    }
  }

  /**
   * Processes the order by removing products that the customer is not old enough to
   * purchase and returning a receipt summarizing the purchase.
   * @param cart - The shopping cart filled with the order that the customer has placed.
   * @param customer - The customer that the shopping cart belongs to
   * @param outOfStockList - A list of items that were out of stock.
   * @return - Receipt summarizing the order.
   * @throws NotEnoughItemsInStockException - Exception that is thrown if there are not enough items
   * in stock for the customer to obtain that quantity.
   */
  @Override
  public IReceipt processOrder(IShoppingCart cart, ICustomer customer,
      ArrayList<IProducts> outOfStockList) throws NotEnoughItemsInStockException {
    ArrayList<IProducts> cartList = cart.getShoppingCartProductsList();
    ArrayList<IProducts> removedProducts = this.removeItemsFromCart(cart, customer);
    IReceipt receipt = new Receipt(cartList, outOfStockList, removedProducts);
    return receipt;
  }


  /**
   * Helper method that removes items from the cart that the customer does not meet
   * the minimum age requirement and adds them to a removedProducts list.
   * @param cart - The customer's shopping cart.
   * @param customer - The owner of the shopping cart.
   * @return ArrayList of products that were removed from the cart.
   * @throws NotEnoughItemsInStockException - Exception that is thrown if there are not enough items
   * in stock for the customer to obtain that quantity.
   */
  private ArrayList<IProducts> removeItemsFromCart(IShoppingCart cart, ICustomer customer)
      throws NotEnoughItemsInStockException {
    ArrayList<IProducts> cartList = cart.getShoppingCartProductsList();
    ArrayList<IProducts> removedProducts = new ArrayList<IProducts>();

    for (int i = 0; i < cartList.size(); i++) {
      IProducts currentProduct = cartList.get(i);
      if (!this.isMinimumAge(customer, currentProduct)) {
        // If customer is not the minimum age for the product, adding it to the remove list
        // and removing the product from the cartList.
        removedProducts.add(currentProduct);
        cart.removeProduct(currentProduct);
      } else {
        // Reducing the amount of the stock item.
        IStockItem removedProduct = this.findStockItem(currentProduct);
        this.reduceStockItem(removedProduct, 1);
      }
    }
    return removedProducts;
  }

  /**
  * Private method to return whether customer meets product's minumum age requirement.
  *
  * @return true if customer is minumum age and false otherwise
  */
  private boolean isMinimumAge(ICustomer customer, IProducts product) {
    return (customer.getAge() >= product.getMinAge());
  }
}