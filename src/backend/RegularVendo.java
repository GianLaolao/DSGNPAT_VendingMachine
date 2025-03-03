package backend;
/*
 * A RegularVendo holds the eight (8) item slots available for purchase. 
 */

public class RegularVendo implements Vendo{

    //can hold item instances
    public static Item sellableItems[]; //hold available sellable items
    private Record sellableRecords[]; //store the recordds of sellable items
    private Item[] slotsItem = new Item[8]; //accepts ArrayList of Item

    @Override
    //set the records of sellable items
    public void setRecords(Record[] records) {
        this.sellableRecords = records;
    }

    @Override
    //retrieve the records of sellable items
    public Record[] getSellableRecords() {
        return sellableRecords; //returns the vending machine records
    }

    @Override
    /* 
     * returns the records of a specific item
     * @param item the item for which to retrieve the record
     * @return the record of the specified item
     */
    public Record getItemRecord(Item item) {

        for (Record r : sellableRecords) {
            if (r.getItem().equals(item))
                return r;
        }

        return null;
    }

    //set an item in a specific slot in the vending machine.
    public void setSlot(int slot, Item item) {
        slotsItem[slot] = item;
    }

    //retrieve the items stored in the vending machine slots.
    public Item[] getSlotsItem() {
        return slotsItem;
    }
}
