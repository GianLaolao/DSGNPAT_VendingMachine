package backend;

import java.util.ArrayList;

public class SpecialVendo extends Vendo {

    
    //retrieve non-sellable and created items
   public void restockNonSellable(int quantity, int slot) {
       ((NonSellableItem)nonSellableItems[slot]).addStock(quantity, nonSellableItems[slot]);
   }

   public boolean restockCreatedItems(int quantity, int slot) {
       return createdItems[slot].addStock(quantity, createdItems[slot]);
   }

    public void setNonSellableItemPrice(int price, int slot) {
         nonSellableItems[slot].setPrice(price);
    }

    public void setCreatedItemPrice(int price, int slot) {
        createdItems[slot].setPrice(price);
    }

    public void getOrder(ArrayList<Item> order) {
        for (Item item : order) {
            item.getStock().remove(0);
            Record r = null;
            // Check if the item exists in the regular vending machine records.
            if (getItemRecord(item) != null)
                r = getItemRecord(item);
            // If not found in regular records, check in non-sellable items records of special vending machine.
            else if (getnonSellItemRecord(item) != null) 
                r = getnonSellItemRecord(item);
            // If not found in non-sellable items records, check in created items records of special vending machine.
            else if (getCreatedItemRecord(item) != null)
                r = getCreatedItemRecord(item);

            r.setSoldAmount(1);
            r.setSold(r.getSold() + 1);
        }
    }
}
