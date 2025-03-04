package backend;

import java.util.ArrayList;

public class NonSellableItem implements Item {
    
    public String name;
    public int price;
    public float calories;
    public String path;
    public ArrayList<Item> stock = new ArrayList<>();

    public NonSellableItem (String name, int price, float calories, String path) {
        this.name = name;
        this.price = price;
        this.calories = calories;
        this.path = path;
    }

    public void setPrice(int price) {
        this.price = price;
    } 


    public void addStock (int quantity, Item item) {

        for (int i = 0; i < quantity; i++) {
            stock.add(item);
        }
        
    }


    /* 
     * returns the name of the chosen item 
     * @return the nume of the chosen item 
     */

    public String getName() {
        return name;
    }

    /*
     * returns the price of the chosen item 
     * @return the price of the chosen item 
     */

    public int getPrice() {
        return price;
    }

    /* 
     * returns the amount of calories of the chosen item 
     * @return the amount of calories of the chosen item 
     */

    public float getCalories() {
        return calories;
    }

    public String getPath() {
        return path;
    }

    public ArrayList<Item> getStock() {
        return stock;
    }

    public void consumeItem() {
        stock.remove(0);
    }
}
