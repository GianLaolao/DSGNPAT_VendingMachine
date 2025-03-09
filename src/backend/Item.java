package backend;
/*
 * An Item represents a vending machine item available for purchase. It contains 
 * the name of the item, its price, amount of calories, and quantity. 
 */

import java.util.ArrayList;

public interface Item {

    public void setPrice(int price);

    public String getName();

    public int getPrice();

    public float getCalories();

    public String getPath();

    public ArrayList<Item> getStock();


}