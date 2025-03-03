package backend;


public class MoneyCalc extends Calculate{

    MoneyCalc(MoneyBox vendoMoney, UserMoneyBox userMoney)
    {
        super(vendoMoney, userMoney);
    }
/* 
 * produces money change for the user 
 * @param totalPrice the total price of the item ordered
 */
    @Override
    public MoneyBox produceChange(int totalPrice) {

        MoneyBox changeBox = new MoneyBox(); 
        int change = 0;

        change = userMoney.getTotal() - totalPrice;

        if(change > vendoMoney.getTotal()) {
            return null;
        }

        // adding cash to the money box
        for (int i = 0; i < 9; i++) {
            vendoMoney.setDenom(i, vendoMoney.getCashQuantity(i) + userMoney.getCashQuantity(i));
        }

        int[] cashDenominations = vendoMoney.getCashDenominations();
        for (int i = 8; i >= 0; i-- )
        {
            int currentDenomination = cashDenominations[i];
            int currentCashQuantity = vendoMoney.getCashQuantity(i);
            if (vendoMoney.getCash(i).getQuantity() != 0){
                int amount = change / currentDenomination;
                if ((change / currentDenomination != 0) && amount > currentCashQuantity) {
                    change -= currentCashQuantity * 100;
                    changeBox.setDenom(i, currentCashQuantity);
                    vendoMoney.setDenom(i, 0);
                }
                else if (change / currentDenomination != 0) {
                    change -= amount * currentDenomination;
                    vendoMoney.setDenom(i, currentCashQuantity - amount);
                    changeBox.setDenom(i, amount);
                }
            }
        }

        if (change != 0)
            return null;
        else {
            userMoney.resetUserMoney();

            return changeBox;
        }
    }

    /*
     * retrieves profit for the vending machine
     */
    @Override
    public int retrieveProfit() {

        int profit;

        profit = vendoMoney.getTotal();

        for (int i = 0; i < 9; i++) {
            userMoney.getCash(i).setQuantity(0);
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
