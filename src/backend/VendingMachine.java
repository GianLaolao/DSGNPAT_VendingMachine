package backend;

import java.util.*;

/*
 * A VendingMachine represents the vending machine. It contains the regular vending machine, 
 * records, vending machine money, user money, and total sales. 
 */

public class VendingMachine {

    private MoneyBox vendoMoney = new MoneyBox();
    private UserMoneyBox userMoney = new UserMoneyBox();
    private MoneyCalc moneyCalc = new MoneyCalc(vendoMoney, userMoney);

    private RegularVendoFactory regularVendoFactory = new RegularVendoFactory();
    private SpecialVendoFactory specialVendoFactory = new SpecialVendoFactory();
    private Vendo regular = regularVendoFactory.getNewVendo();
    private Vendo special = specialVendoFactory.getNewVendo();

    /*
     * puts an item into a specific slot
     * @param slot the slot to be occupied 
     * @param index the index of the item to be added
     */
    public void addItem(int slot, int index) { 
        ((RegularVendo)regular).addItem(slot, index);
    }

/* 
 * restocks or replaces item of the inventory or vending machine 
 * @param quantity the quantity of item to be restocked  
 * @param slot the slot to be occupied for restocking 
 */
    public void restockSellable(int quantity, int slot) {
       ((RegularVendo)regular).restockSellable(quantity, slot);
    }
    /* restock a non-sellable item in the special vending machine.
     * @param quantity the quantity of item to be restocked
     * @param slot the slot to be occupied for restocking
    */
    public void restockNonSellable (int quantity, int slot) {
        ((SpecialVendo)special).restockNonSellable(quantity, slot);
    }
    /* restock a created item in the special vending machine.
     * @param quantity the quantity of item to be restocked
     * @param slot the slot to be occupied for restocking
    */
    public boolean restockCreatedItems (int quantity, int slot) {

        return ((SpecialVendo)special).restockCreatedItems(quantity, slot);
    }

    /*
    * sets item price
    * @param price the set price for the selected item
    * @param slot the slot of the item selected
    */
    public void setSellabeItemPrice(int price, int slot){
        Vendo.sellableItems[slot].setPrice(price);
    }
    /*
     * sets price for non-sellable item
     * @param price the set price for the selected item
     * @param slot the slot of the item selected
     */
    public void setNonSellabeItemPrice(int price, int slot){

        ((SpecialVendo)special).setNonSellableItemPrice(price, slot);
    }
    /*
     * sets price for a created item in the special vending machine
     * @param price the set price for the selected item
     * @param slot the slot of the item selected
     */
    public void setCreatedItemPrice(int price, int slot){

        ((SpecialVendo)special).setCreatedItemPrice(price, slot);
    }

    /*
     * Dispenses item from the vending machine.
     * @param item The item to be dispensed.
     */
    public void dispenseItem(Item item) {
      ((RegularVendo)regular).dispenseItem(item);
    }
    //calculate and retrieve the total sales for all items in the vending machine.
    public int getTotalSales() {

        final int TOTAL_SELLABLE_ITEM = 10;
        final int TOTAL_NON_SELLABLE_ITEM = 8;
        final int TOTAL_CREATED_ITEM = 3;
        int totalSales = 0;
        for (int i = 0; i < TOTAL_SELLABLE_ITEM; i++) {
            totalSales += regular.getSellableRecords()[i].getSoldAmount();
            if (i < TOTAL_NON_SELLABLE_ITEM)
                totalSales += ((SpecialVendo)special).getNonSellRecords()[i].getSoldAmount();
            if (i < TOTAL_CREATED_ITEM)
                totalSales += ((SpecialVendo)special).getCreatedRecords()[i].getSoldAmount();
        }
        
        return totalSales;
    }

    /*
     * Processes an order from the vending machine.
     * @param order The list of items in the order.
     */
    public void getOrder(ArrayList<Item> order) {
        ((SpecialVendo)special).getOrder(order);
    }

    public MoneyCalc getMoneyCalc() {
        return moneyCalc;
    }
    public MoneyBox getVendoMoney(){
        return vendoMoney;
    }

    public UserMoneyBox getUserMoney(){
        return userMoney;
    }

    public RegularVendo getRegular() {
        return (RegularVendo)regular;
    }

    public SpecialVendo getSpecial() {
        return (SpecialVendo)special;
    }

    
}
    




   
   
    
    
