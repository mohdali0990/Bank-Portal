import java.util.Objects;

public class SavingsAccount implements Accounts {

 private double currentBalanceAmount;
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
  SavingsAccount that = (SavingsAccount) o;
  return Double.compare(that.currentBalanceAmount, currentBalanceAmount) == 0 &&
          Double.compare(that.newBalance, newBalance) == 0;
 }

 @Override
 public int hashCode() {
  return Objects.hash(currentBalanceAmount, newBalance);
 }

 @Override
 public String toString() {
  return "SavingsAccount{" +
          "currentBalanceAmount=" + currentBalanceAmount +
          ", newBalance=" + newBalance +
          '}';
 }


}

