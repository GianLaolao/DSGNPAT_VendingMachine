abstract public class Calculate {
    MoneyBox vendoMoney;
    UserMoneyBox userMoney;

    public Calculate(MoneyBox vendoMoney, UserMoneyBox userMoney)
    {
        this.vendoMoney = vendoMoney;
        this.userMoney = userMoney;
    }

    abstract MoneyBox produceChange(int totalPrice);
    abstract int retrieveProfit();
}
