
public class SpecialVendo extends RegularVendo{

    //hold non-sellable items an their records for special vending machine
    protected static Item nonSellableItems[];
    private Record nonSellRecords[];

    //hold created items and their records for special vending machine
    protected static CreatedItem createdItems[];
    private Record createdRecords[];

    //retrieve non-sellable and created items
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
