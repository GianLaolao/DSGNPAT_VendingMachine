package backend;

abstract class Vendo {
    //can hold item instances
    public static Item sellableItems[]; //hold available sellable items
    private Record sellableRecords[]; //store the recordds of sellable items

    //set the records of sellable items
    public void setRecords(Record[] records) {
        this.sellableRecords = records;
    }

    //retrieve the records of sellable items
    public Record[] getSellableRecords() {
        return sellableRecords; //returns the vending machine records
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

}
