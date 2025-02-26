package backend;
/*
 * An Item represents a vending machine item available for purchase. It contains 
 * the name of the item, its price, amount of calories, and quantity. 
 */

import java.util.ArrayList;

public class Item {
    //initialize variables 
    private String name;
    private int price;
    private float calories;
    private String path;
    protected ArrayList<Item> stock = new ArrayList<>();

    /*
     * creates an Item object given the name of the item, its price, amount of calories, and quantity. 
     * @param name the name of the item 
     * @param price the price of the item 
     * @param calories the amount of calories of the item
     * @param quantity the quantity of the item
     */

    public Item (String name, int price, float calories, String path) {
        this.name = name;
        this.price = price;
        this.calories = calories;
        this.path = path;
    }

    /*
     * sets the exact price for each item
     * @param price the price of the item 
     */

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


}