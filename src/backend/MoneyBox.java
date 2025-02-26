package backend;
public class MoneyBox implements MoneyBoxInterface {
    //declaration of denominations
     
    private Cash[] denominations = new Cash[9];

    public MoneyBox() {

        Cash onePeso = new Cash(1);
        Cash fivePeso = new Cash(5);
        Cash tenPeso = new Cash(10);
        Cash twentyPeso = new Cash(20);
        Cash fiftyPeso = new Cash(50);
        Cash hundredPeso = new Cash(100);
        Cash twoHundredPeso = new Cash(200);
        Cash fiveHundredPeso = new Cash(500);
        Cash thousandPeso = new Cash(1000);

        denominations[0] = onePeso;
        denominations[1] = fivePeso;
        denominations[2] = tenPeso;
        denominations[3] = twentyPeso;
        denominations[4] = fiftyPeso;
        denominations[5] = hundredPeso;
        denominations[6] = twoHundredPeso;
        denominations[7] = fiveHundredPeso;
        denominations[8] = thousandPeso;
    }   
/*
 * sets the quantity on a specific denomination
 * @param quantity the quantity to be added
 */
    @Override
    public void setDenom(int slot, int quantity) {
        
        denominations[slot].setQuantity(quantity);
    }
/*
 * returns the object of a specific denomination
 */
    @Override
    public Cash[] getDenominations() {
        return denominations;
    }

    @Override
    public int[] getCashDenominations(){
        int[] cashDenominations = new int[denominations.length];
        for (int i = 0; i < denominations.length; i++)
        {
            cashDenominations[i] = denominations[i].getValue();
        }
        return cashDenominations;
    }

    @Override
    public Cash getCash(int denom) {
        return denominations[denom];
    }

    @Override
    public int getCashQuantity(int denom){
        return denominations[denom].getQuantity();
    }
/*
 * returns the total amount of money in the money box
 */
    @Override
    public int getTotal(){

        int total = 0;

        for (int i = 0; i < 9; i++) {
            total += denominations[i].getTotal();
        }

        return total;
    }
}
