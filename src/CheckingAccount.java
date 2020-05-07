import java.util.Objects;

public class CheckingAccount {
    private double currentBalanceAmount;
    private double addOrMinusAmount;
    private double newBalance;

public void checkbalance(){
    System.out.println("Your current balance is " + currentBalanceAmount);
}

public double deposit(double comingInnAmount){
    newBalance = currentBalanceAmount + comingInnAmount;
    currentBalanceAmount = newBalance;
    return currentBalanceAmount;
}

public double withdrawal(double comingInnAmount){
    newBalance = currentBalanceAmount- comingInnAmount;
    currentBalanceAmount = newBalance;
    return currentBalanceAmount;
}

    public double getCurrentBalanceAmount() {
        return currentBalanceAmount;
    }

    public void setCurrentBalanceAmount(double currentBalanceAmount) {
        this.currentBalanceAmount = currentBalanceAmount;
    }

    public double getAddOrMinusAmount() {
        return addOrMinusAmount;
    }

    public void setAddOrMinusAmount(double addOrMinusAmount) {
        this.addOrMinusAmount = addOrMinusAmount;
    }

    public double getNewBalance() {
        return newBalance;
    }

    public void setNewBalance(double newBalance) {
        this.newBalance = newBalance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CheckingAccount that = (CheckingAccount) o;
        return Double.compare(that.currentBalanceAmount, currentBalanceAmount) == 0 &&
                Double.compare(that.addOrMinusAmount, addOrMinusAmount) == 0 &&
                Double.compare(that.newBalance, newBalance) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentBalanceAmount, addOrMinusAmount, newBalance);
    }

    @Override
    public String toString() {
        return "CheckingAccount{" +
                "currentBalanceAmount=" + currentBalanceAmount +
                ", addOrMinusAmount=" + addOrMinusAmount +
                ", newBalance=" + newBalance +
                '}';
    }
}
