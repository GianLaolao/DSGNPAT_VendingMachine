package backend;
/*
 * A RegularVendo holds the eight (8) item slots available for purchase. 
 */
public class RegularVendo extends Vendo{

    private Item[] slotsItem = new Item[8]; //accepts ArrayList of Item

    //set an item in a specific slot in the vending machine.
    public void setSlot(int slot, Item item) {
        slotsItem[slot] = item;
    }

    //retrieve the items stored in the vending machine slots.
    public Item[] getSlotsItem() {
        return slotsItem;
    }
}
