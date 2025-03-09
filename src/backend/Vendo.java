package backend;

abstract class Vendo {
    //can hold item instances
    public static Item sellableItems[]; //hold available sellable items
    private Record sellableRecords[]; //store the recordds of sellable items
    private Item[] slotsItem = new Item[8];

    //hold non-sellable items an their records for special vending machine
    public static Item nonSellableItems[];
    private Record nonSellRecords[];

    //hold created items and their records for special vending machine
    public static CreatedItem createdItems[];
    private Record createdRecords[];


    public static Item[] getSellableItems() {
        return this.sellableItems;
    }

    public void setRecords(Record[] records) {
        this.sellableRecords = records;
    }

    public Record[] getSellableRecords() {
        return this.sellableRecords; 
    }

    /*
     * returns the records of a specific item
     * @param item the item for which to retrieve the record
     * @return the record of the specified item
     */
    public Record getItemRecord(Item item) {

        for (Record r : this.sellableRecords) {
            if (r.getItem().equals(item))
                return r;
        }

        return null;
    }

    public Item[] getSlotsItem() {
        return this.slotsItem;
    }

    public static Item[] getNonSellableItems() {
        return this.nonSellableItems;
    }
    public static CreatedItem[] getCreatedItems() {
        return this.createdItems;
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
        return this.nonSellRecords;
    }

    //get the record of a specific non-sellable item.
    public Record getnonSellItemRecord(Item item) {

        for (Record r : this.nonSellRecords) {
            if (r.getItem().equals(item))
                return r; // Returns the record of the specified non-sellable item if found.
        }

        return null; // Returns null if the record for the non-sellable item is not found.

    }
    // retrieve the records for created items.
    public Record[] getCreatedRecords() {
        return this.createdRecords;
    }
    // get the record of a specific created item.
    public Record getCreatedItemRecord(Item item) {

        for (Record r : this.createdRecords) {
            if (r.getItem().equals(item))
                return r; // Returns the record of the specified created item if found.
        }

        return null; // Returns null if the record for the created item is not found.
    }

}
