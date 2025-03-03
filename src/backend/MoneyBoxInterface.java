package backend;
public interface MoneyBoxInterface {
    void setDenom(int slot, int quantity);
    Cash[] getDenominations();
    int[] getCashDenominations();
    Cash getCash(int denom);
    int getCashQuantity(int denom);
    int getTotal();
}