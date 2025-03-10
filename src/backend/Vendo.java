package backend;

abstract class Vendo {
   
    public static Item sellableItems[]; 
    private Record sellableRecords[]; 
    
    public static Item nonSellableItems[];
    private Record nonSellRecords[];
    
    public static CreatedItem createdItems[];
    private Record createdRecords[];
    
    private final int VENDING_MACHINE_SLOTS = 8; 
    private Item[] slotsItem = new Item[VENDING_MACHINE_SLOTS];


    public static Item[] getSellableItems() {
        return sellableItems;
    }

    public void setRecords(Record[] records) {
        this.sellableRecords = records;
    }

    public Record[] getSellableRecords() {
        return sellableRecords; 
    }

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

    public Item[] getSlotsItem() {
        return slotsItem;
    }

    public static Item[] getNonSellableItems() {
        return nonSellableItems;
    }
    public static CreatedItem[] getCreatedItems() {
        return createdItems;
    }

    //set records for non-sellable and created items
    public void setNonSellRecords(Record[] nonSellRecords) {
        this.nonSellRecords = nonSellRecords;
    }

    public void setCreatedRecords(Record[] createdRecords) {
        this.createdRecords = createdRecords;
    }

    //retrieve the records for non-sellable and created items.
    public Record[] getNonSellRecords() {
        return nonSellRecords;
    }

    //get the record of a specific non-sellable item.
    public Record getnonSellItemRecord(Item item) {

        for (Record r : nonSellRecords) {
            if (r.getItem().equals(item))
                return r; // Returns the record of the specified non-sellable item if found.
        }

        return null; // Returns null if the record for the non-sellable item is not found.

    }
    // retrieve the records for created items.
    public Record[] getCreatedRecords() {
        return createdRecords;
    }
    // get the record of a specific created item.
    public Record getCreatedItemRecord(Item item) {

        for (Record r : createdRecords) {
            if (r.getItem().equals(item))
                return r; // Returns the record of the specified created item if found.
        }

        return null; // Returns null if the record for the created item is not found.
    }

}
