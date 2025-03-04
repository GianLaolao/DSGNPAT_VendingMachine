package backend;
/*
 * An Item represents a vending machine item available for purchase. It contains 
 * the name of the item, its price, amount of calories, and quantity. 
 */

import java.util.ArrayList;

public interface Item {
    //initialize variables 
   

    /*
     * creates an Item object given the name of the item, its price, amount of calories, and quantity. 
     * @param name the name of the item 
     * @param price the price of the item 
     * @param calories the amount of calories of the item
     * @param quantity the quantity of the item
     */



    /*
     * sets the exact price for each item
     * @param price the price of the item 
     */

    public void setPrice(int price);


   


    /* 
     * returns the name of the chosen item 
     * @return the nume of the chosen item 
     */

    public String getName();
    /*
     * returns the price of the chosen item 
     * @return the price of the chosen item 
     */

    public int getPrice();

    /* 
     * returns the amount of calories of the chosen item 
     * @return the amount of calories of the chosen item 
     */

    public float getCalories();

    public String getPath();

    public ArrayList<Item> getStock();


}