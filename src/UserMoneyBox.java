public class UserMoneyBox extends MoneyBox{

    /*
     * takes payment from the user
     * @param type the money paid by user
     */
    public void takePayment(int type) {

        this.setDenom(type, this.getCash(type).getQuantity() + 1);

    }

    /*
     * checks the money of the user
     * @param slot the slot of the item selected
     * @param quantity the quantity of item bought by the user
     */
    public boolean checkUserMoney(int price) {

        if (price > this.getTotal())
            return false;
        else if (this.getTotal() - price > this.getTotal())
            return false;

        return true;
    }

    /*
     * resets userMoney quantity for each denomination to 0
     */
    public void resetUserMoney() {

        for (int i = 0; i < 9; i++) {
            this.getCash(i).setQuantity(0);
        }
    }

}
