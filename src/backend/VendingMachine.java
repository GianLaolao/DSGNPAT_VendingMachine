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
    private RegularVendo regular = new RegularVendo();
    private SpecialVendo special = new SpecialVendo();

    /*
     * puts an item into a speicific slot
     * @param slot the slot to the occupied 
     * @param index the index of the item to be added
     */
    public void addItem(int slot, int index) { 
        
        if (index != -1)
            regular.getSlotsItem()[slot] = RegularVendo.sellableItems[index];

    }

/* 
 * restocks or replaces item of the inventory or vending machine 
 * @param quantity the quantity of item to be restocked  
 * @param slot the slot to be occupied for restocking 
 */
    public void restockSellable(int quantity, int slot) {
    
        RegularVendo.sellableItems[slot].addStock(quantity, RegularVendo.sellableItems[slot]);
    }
    /* restock a non-sellable item in the special vending machine.
     * @param quantity the quantity of item to be restocked
     * @param slot the slot to be occupied for restocking
    */
    public void restockNonSellable (int quantity, int slot) {

        SpecialVendo.nonSellableItems[slot].addStock(quantity, SpecialVendo.nonSellableItems[slot]);

    }
    /* restock a created item in the special vending machine.
     * @param quantity the quantity of item to be restocked
     * @param slot the slot to be occupied for restocking
    */
    public boolean restockCreatedItems (int quantity, int slot) {

        return SpecialVendo.createdItems[slot].addStock(quantity, SpecialVendo.createdItems[slot]);
    }

    /*
    * sets item price
    * @param price the set price for the selected item
    * @param slot the slot of the item selected
    */
    public void setSellabeItemPrice(int price, int slot){

        RegularVendo.sellableItems[slot].setPrice(price);
    
    }
    /*
     * sets price for non-sellable item
     * @param price the set price for the selected item
     * @param slot the slot of the item selected
     */
    public void setNonSellabeItemPrice(int price, int slot){

        SpecialVendo.nonSellableItems[slot].setPrice(price);
    }
    /*
     * sets price for a created item in the special vending machine
     * @param price the set price for the selected item
     * @param slot the slot of the item selected
     */
    public void setCreatedItemPrice(int price, int slot){

        SpecialVendo.createdItems[slot].setPrice(price);
    }

    /*
     * Dispenses item from the vending machine.
     * @param item The item to be dispensed.
     */
    public void dispenseItem(Item item) {
        
        item.getStock().remove(0);
        Record r = regular.getItemRecord(item);
        r.setSoldAmount(1);
        r.setSold(r.getSold() + 1);
        
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
                totalSales += special.getNonSellRecords()[i].getSoldAmount();
            if (i < TOTAL_CREATED_ITEM)
                totalSales += special.getCreatedRecords()[i].getSoldAmount();
        }
        
        return totalSales;
    }

    /*
     * Processes an order from the vending machine.
     * @param order The list of items in the order.
     */
    public void getOrder(ArrayList<Item> order) {

        for (Item item : order) {
            item.getStock().remove(0);
            Record r = null;
            // Check if the item exists in the regular vending machine records.
            if (regular.getItemRecord(item) != null)
                r = regular.getItemRecord(item);
            // If not found in regular records, check in non-sellable items records of special vending machine.
            else if (special.getnonSellItemRecord(item) != null) 
                r = special.getnonSellItemRecord(item);
            // If not found in non-sellable items records, check in created items records of special vending machine.
            else if (special.getCreatedItemRecord(item) != null)
                r = special.getCreatedItemRecord(item);

            r.setSoldAmount(1);
            r.setSold(r.getSold() + 1);
        }

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
        return regular;
    }

    public SpecialVendo getSpecial() {
        return special;
    }

    
}
    




   
   
    
    
