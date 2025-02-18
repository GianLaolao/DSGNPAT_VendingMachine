# Burger Vending Machine

The MCO for CCPROG3. 

A simulation for a custom item Vending Machine, in which Burgers are the main item for this custom vending machine.
The Vending Machine has 3 modes, Regular Vending Machine, Special Vending Machine and Maintenance Mode.

## Maintenance Mode

### Description
The mode to initialize and/or edit the contents in the vending machine, restocking of the **Money Box**, and slotting items in the Regular vending machine.
Items in the vending machine are categorized as **Sellable** and **Non-Sellable**.
**Sellable Items** are items that can be sold individually. These are the items that can be slotted in the Regular Vending Machine
**Non-Sellable Items** are items that cannot be sold individually. These items are only available in the Special Vending Machine but cannot be bought individually. 

Each item can be restocked up to a maximum of 10.

### Sellable Items Tab
Click the arrow up and arrow down buttons to adjust stock quantity. Then click the "Restock" button to update the stock.
The price can be edited by changing the price in the text box, then click "Set Price" button to update price. 

### Non-Sellable Items Tab
---To be updated---

### Vending Settings
---To be updated---

### Collect Money
---To be updated---


### Print Records
---To be updated---




## Regular Vending Machine

### Description
Works like a normal vending machine that dispenses individual items.
The Left Panel shows the buttons with the image and name of the items, and below it, is the price and the current stock.
The Right Panel has a screen that shows the transaction, Total counter that shows the total price of the order, Nine (9) buttons for each available currency that is used to input the user payment and a screen to show the total payment amount. Dispense button to confirm transaction, and Cancel button to cancel transaction.

### Operation
To dispense an item, click a button to select the desired item. The selected item, its price and its calories will be shown on the screen panel. Use the payment buttons to input payment. Then click Dispense to complete the transaction. A Transaction record will be displayed if the transaction is successful, showing the transaction summary. A Change window will also be shown to show the change amount if any. 

If the machine does not have any available change, an error will be displayed and the transaction will be cancelled returning the amount inputted by the user.

## Special Vending Machine

### Description
A Vending Machine that allows the user to create a custom Burger.
The Left Panel shows different items in each category that the user may choose from. The item name, price and current stock of the item is also displayed. 
The user can use the Special Vending Machine as a Regular Vending machine where it allows the user to dispense an individual item that is considered as **Sellable**. However if the user only chose a **Non-sellable** item, the transaction will be cancelled as "Non-sellable" items need to at least have a Bun and a Patty.

### Operation
To get a custom Burger, click and choose an item on the panel. Only one item per category is allowed, except for Add-ons that allow a maximum of Six (6) items. The summary of the choices will be displayed on the screen showing the individual price of the order. Total price will be displayed on the panel below the screen. Use the payment buttons to input payment. Then click Dispense to complete the transaction.  A Change window will also be shown to show the change amount if any. The vending machine will process the order (process will be shown on the screen) and will display a Burger window showing the order summary that also shows the total calories of the order.
