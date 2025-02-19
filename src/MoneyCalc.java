

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

        // adding cash to the money box
        for (int i = 0; i < 9; i++) {
            vendoMoney.setDenom(i, vendoMoney.getCash(i).getQuantity() + userMoney.getDenominations()[i].getQuantity());
        }

        int[] cashDenominations = vendoMoney.getCashDenominations();
        for (int i = 8; i >= 0; i-- )
        {
            int currentDenomination = cashDenominations[i];
            if (vendoMoney.getCash(i).getQuantity() != 0){
                int amount = change / currentDenomination;
                if ((change / currentDenomination != 0) && amount > vendoMoney.getCash(i).getQuantity()) {
                    change -= vendoMoney.getCash(i).getQuantity() * 100;
                    changeBox.setDenom(i, vendoMoney.getCash(i).getQuantity());
                    vendoMoney.setDenom(i, 0);
                }
                else if (change / currentDenomination != 0) {
                    change -= amount * currentDenomination;
                    vendoMoney.setDenom(i, vendoMoney.getCash(i).getQuantity() - amount);
                    changeBox.setDenom(i, amount);
                }
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
