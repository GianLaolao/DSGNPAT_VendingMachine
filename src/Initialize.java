
import java.io.*;
import java.util.*;

public class Initialize {

    //initialize an array of 'Item' objects from a given file path
    public Item[] initialize(String path) {

        Item[] items; // Declare an array to store the 'Item' objects.
        String name;
        int price;
        float calories;
        String icon;
        Scanner sc;
        File file = new File(path);
        try {
            sc = new Scanner(file); // Create a scanner to read the file.
        } catch (IOException e) {
            return null; // Return null if there is an exception while reading the file.
        }

        int n = sc.nextInt(); // Read the number of items from the file.
        sc.nextLine();
        items = new Item[n]; // Initialize the 'items' array with the size 'n'.

        for (int i = 0; i < n; i++) {
            // Read the name, price, calories, and icon for each item from the file.
            name = sc.nextLine();
            price = sc.nextInt();
            calories = sc.nextFloat();
            sc.nextLine();
            icon = sc.nextLine();

            // Create a new 'Item' object with the read data.
            Item a = new Item(name, price, calories,icon);
            // Add the newly created 'Item' object to the 'items' array.
            items[i] = a;
        }
        
        sc.close();

        return items; // Return the array of 'Item' objects.
    }

    //create an array of 'Record' objects from an array of 'Item' objects.
    public Record[] createRecord (Item[] items) {

        int n = items.length; // Get the length of the 'items' array.

        Record records[] = new Record[n]; // Initialize an array of 'Record' objects with size 'n'.


        for (int i = 0; i < n; i++) {
            // Create a new 'Record' object for each 'Item' in the 'items' array.
            Record newRec = new Record(items[i]);
            // Add the newly created 'Record' object to the 'records' array.
            records[i] = newRec;
        }
        
        return records; // Return the array of 'Record' objects.

    }

    // initialize an array of 'CreatedItem' objects with predefined ingredients.
    public CreatedItem[] initializeCreated () {

        //store the ingredients required for each 'CreatedItem'.
        HashMap<Item, Integer> ketIng = new HashMap<Item, Integer>();
        ketIng.put(SpecialVendo.nonSellableItems[0], 3);
        // Create a 'CreatedItem' object for 'Ketchup' with the given name, price, calories, and ingredients.
        CreatedItem ketchup = new CreatedItem("Ketchup", 5, 19, null, ketIng);

        HashMap<Item, Integer> mayoIng = new HashMap<Item, Integer>();
        mayoIng.put(SpecialVendo.sellableItems[8], 2);
        // Create a 'CreatedItem' object for 'Mayonnaise' with the given name, price, calories, and ingredients.
        CreatedItem mayo = new CreatedItem("Mayonnaise", 5, 94, null, mayoIng);

        // Create the 'Thousand Island' with 'Ketchup' and 'Mayonnaise' as ingredients.
        HashMap<Item, Integer> thouIslIng = new HashMap<Item, Integer>();
        thouIslIng.put(ketchup, 1);
        thouIslIng.put(mayo, 1);
        CreatedItem thouIsl = new CreatedItem("Thousand Island", 5, 59, null, thouIslIng);

        // Create an array of 'CreatedItem' objects with the predefined 'CreatedItem's.
        CreatedItem create[] = {ketchup, mayo, thouIsl};

        return create;
    }
}
