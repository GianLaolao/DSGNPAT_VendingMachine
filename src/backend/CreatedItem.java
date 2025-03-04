package backend;

import java.util.*;

public class CreatedItem implements Item{
    
    public String name;
    public int price;
    public float calories;
    public String path;
    public ArrayList<Item> stock = new ArrayList<>();

    private Map<Item, Integer> ingredients;

    /* initialize created item
     * @param name the item name
     * @param price the item price
     * @param calories the number of calories per item
     * @param path the image path
     * @param ingredients the ingredients map
    */
    public CreatedItem(String name, int price, float calories, String path, HashMap<Item, Integer> ingredients) {

        this.name = name;
        this.price = price; 
        this.calories = calories; 
        this.path = path;
        this.ingredients = ingredients;
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

    public Map<Item, Integer> getIngredients() {
        return ingredients;
    }

    /* checks if there is enough stock of ingredients to create item in desired quantity
     * @param quantity the number of items
     */
    private boolean checkStock (int quantity) {

        for (HashMap.Entry<Item, Integer> x : ingredients.entrySet()) {
            Item one = x.getKey(); //item instance of the ingredient
            int num = x.getValue(); //amount of ingredient needed
            // For each ingredient, check if its stock size is sufficient for creating 'num' instances of the item.
            if (one.getStock().size() < num*quantity) 
                return false; // If any ingredient has insufficient stock, return false.

        }

       return true; // If all ingredients have sufficient stock, return true.

    }

    /* adds stock of the item created by the user
     * @param quantity the number of items
     */
    public boolean addStock(int quantity, CreatedItem item) {
        // Check if there is enough stock of all ingredients to create the desired quantity of the item.
        if (checkStock(quantity)) {
            for (int i = 0; i < quantity; i++) {
                for (HashMap.Entry<Item, Integer> x : ingredients.entrySet()) {
                    Item one = x.getKey();
                    int num = x.getValue();
                    // Remove 'num' instances of each ingredient from their respective stock.
                    for (int j = 0; j < num; j++) {
                        one.getStock().remove(0);
                    }
                }
                // Add the created item to the stock.
                stock.add(item);
            }
        }
        else
            // If there is not enough stock of any ingredient, return false and don't add the created item to the stock.
            return false;
        // If the item is successfully created and added to the stock, return true.
        return true;
    }
}
