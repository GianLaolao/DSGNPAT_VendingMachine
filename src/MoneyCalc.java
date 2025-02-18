

public class MoneyCalc {

    private MoneyBox vendoMoney = new MoneyBox();
    private MoneyBox userMoney = new MoneyBox();

/* 
 * takes payment from the user 
 * @param type the money paid by user 
 */
    public void takePayment(int type) {

        userMoney.setDenom(type, userMoney.getCash(type).getQuantity() + 1);

    }

/*
 * checks the money of the user 
 * @param slot the slot of the item selected
 * @param quantity the quantity of item bought by the user
 */
    public boolean checkUserMoney(int price) {

        if (price > userMoney.getTotal())
            return false;
        else if (userMoney.getTotal() - price > vendoMoney.getTotal()) 
            return false;

        return true;
    }

/* 
 * produces money change for the user 
 * @param totalPrice the total price of the item ordered
 */
    public MoneyBox produceChange(int totalPrice) {

        MoneyBox changeBox = new MoneyBox(); 
        int change = 0;

        change = userMoney.getTotal() - totalPrice;

        if(change > vendoMoney.getTotal()) {
            return null;
        }

        for (int i = 0; i < 9; i++) {
            vendoMoney.setDenom(i, vendoMoney.getCash(i).getQuantity() + userMoney.getDenominations()[i].getQuantity());
        }

        if (vendoMoney.getCash(8).getQuantity() != 0){
            int amount = change / 1000;
            if ((change / 1000 != 0) && amount > vendoMoney.getCash(8).getQuantity()) {
                change -= vendoMoney.getCash(8).getQuantity() * 100;
                changeBox.setDenom(8, vendoMoney.getCash(8).getQuantity());
                vendoMoney.setDenom(8, 0);
            }
            else if (change / 1000 != 0) {
                change -= amount * 1000;
                vendoMoney.setDenom(8, vendoMoney.getCash(8).getQuantity() - amount);
                changeBox.setDenom(8, amount);
            }
        }
        if (vendoMoney.getCash(7).getQuantity() != 0){
            int amount = change / 500;
            if ((change / 500 != 0) && amount > vendoMoney.getCash(7).getQuantity()) {
                change -= vendoMoney.getCash(7).getQuantity() * 50;
                changeBox.setDenom(7,vendoMoney.getCash(7).getQuantity());
                vendoMoney.setDenom(7,0);
            }
            else if (change /500 != 0) {
                change -= amount * 500;
                vendoMoney.setDenom(7, vendoMoney.getCash(7).getQuantity() - amount);
                changeBox.setDenom(7,amount);
            }
        }

         if (vendoMoney.getCash(6).getQuantity() != 0){
            int amount = change / 200;
            if ((change / 200 != 0) && amount > vendoMoney.getCash(6).getQuantity()) {
                change -= vendoMoney.getCash(6).getQuantity() * 50;
                changeBox.setDenom(6,vendoMoney.getCash(6).getQuantity());
                vendoMoney.setDenom(6,0);
            }
            else if (change /200 != 0) {
                change -= amount * 200;
                vendoMoney.setDenom(6, vendoMoney.getCash(6).getQuantity() - amount);
                changeBox.setDenom(6,amount);
            }
        }
         if (vendoMoney.getCash(5).getQuantity() != 0){
            int amount = change / 100;
            if ((change / 100 != 0) && amount > vendoMoney.getCash(5).getQuantity()) {
                change -= vendoMoney.getCash(5).getQuantity() * 100;
                changeBox.setDenom(5,vendoMoney.getCash(5).getQuantity());
                vendoMoney.setDenom(5, 0);
            }
            else if (change / 100 != 0) {
                change -= amount * 100;
                vendoMoney.setDenom(5, vendoMoney.getCash(5).getQuantity() - amount);
                changeBox.setDenom(5, amount);
            }
        }

        if (vendoMoney.getCash(4).getQuantity() != 0){
            int amount = change / 50;
            if ((change / 50 != 0) && amount > vendoMoney.getCash(4).getQuantity()) {
                change -= vendoMoney.getCash(4).getQuantity() * 50;
                changeBox.setDenom(4, vendoMoney.getCash(4).getQuantity());
                vendoMoney.setDenom(4, 0);
            }
            else if (change /50 != 0) {
                change -= amount * 50;
                vendoMoney.setDenom(4, vendoMoney.getCash(4).getQuantity() - amount);
                changeBox.setDenom(4, amount);
            }
        }
        if (vendoMoney.getCash(3).getQuantity() != 0){
            int amount = change / 20;
            if ((change / 20 != 0) && amount > vendoMoney.getCash(3).getQuantity()) {
                change -= vendoMoney.getCash(3).getQuantity() * 20;
                changeBox.setDenom(3, vendoMoney.getCash(3).getQuantity());
                vendoMoney.setDenom(3, 0);
            }
            else if (change / 20 != 0){
                change -= amount * 20;
                vendoMoney.setDenom(3, vendoMoney.getCash(3).getQuantity() - amount);
                changeBox.setDenom(3, amount);
            }
        }
        if (vendoMoney.getCash(2).getQuantity() != 0){
            int amount = change / 10;
            if ((change / 10 != 0) && amount > vendoMoney.getCash(2).getQuantity()) {
                change -= vendoMoney.getCash(2).getQuantity() * 10;
                changeBox.setDenom(2, vendoMoney.getCash(2).getQuantity());
                vendoMoney.setDenom(2, 0);
            }
            else if (change / 10 != 0){
                change -= amount * 10;
                vendoMoney.setDenom(2, vendoMoney.getCash(2).getQuantity() - amount);
                changeBox.setDenom(2, amount);
            }
        }
        if (vendoMoney.getCash(1).getQuantity() != 0){
            int amount = change / 5;
            if ((change / 5 != 0) && amount > vendoMoney.getCash(1).getQuantity()) {
                change -= vendoMoney.getCash(1).getQuantity() * 5;
                changeBox.setDenom(1, vendoMoney.getCash(1).getQuantity());
                vendoMoney.setDenom(1,0);
            }
            else if (change / 5 != 0){
                change -= amount * 5;
                vendoMoney.setDenom(1, vendoMoney.getCash(1).getQuantity() - amount);
                changeBox.setDenom(1, amount);
            }

        }
        if (vendoMoney.getCash(0).getQuantity() != 0){
            int amount = change / 1;
            if ((change / 1 != 0) && amount > vendoMoney.getCash(0).getQuantity()) {
                change -= vendoMoney.getCash(0).getQuantity();
                vendoMoney.setDenom(0, 0);
                changeBox.setDenom(0, amount);
            }
            else if (change / 1 != 0){
                change -= amount;
                vendoMoney.setDenom(0, vendoMoney.getCash(0).getQuantity() - amount);
                changeBox.setDenom(0, amount);
            }
        }


        if (change != 0)
            return null;
        else {
            resetUserMoney();

            return changeBox;
        }
    }

/*
* resets userMoney quantity for each denomination to 0
*/
    public void resetUserMoney() {

        for (int i = 0; i < 9; i++) {
            userMoney.getCash(i).setQuantity(0);
        }
    }

    
/* 
 * retrieves profit for the vending machine  
 */
    public int retrieveProfit() {

        int profit;

        profit = vendoMoney.getTotal();

        for (int i = 0; i < 9; i++) {
            vendoMoney.getCash(i).setQuantity(0);
        }

        return profit;
    }

    public MoneyBox getVendoMoney() {
        return vendoMoney; //returns the available vending machine money
    }
    public MoneyBox getUserMoney() {
        return userMoney; //returns the money of the user 
    }
}
