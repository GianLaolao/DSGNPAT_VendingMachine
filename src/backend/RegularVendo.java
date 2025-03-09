package backend;
/*
 * A RegularVendo holds the eight (8) item slots available for purchase. 
 */
public class RegularVendo extends Vendo{

     //accepts ArrayList of Item

    //set an item in a specific slot in the vending machine.
    public void setSlot(int slot, Item item) {
        getSlotsItem()[slot] = item;
    }

    public void addItem(int slot, int index) { 
        
        if (index != -1)
            setSlot(slot, Vendo.getSellableItems()[index]);
    }

    public void restockSellable(int quantity, int slot) {
        ((SellableItem)Vendo.sellableItems[slot]).addStock(quantity, Vendo.sellableItems[slot]);
    }

    public void dispenseItem(Item item) {
        item.getStock().remove(0);
        Record r = getItemRecord(item);
        r.setSoldAmount(1);
        r.setSold(r.getSold() + 1);
    }
}