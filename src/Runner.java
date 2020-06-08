import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Runner {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Scanner scanner = new Scanner(System.in);
        List<Customer> custList = new ArrayList<>();

        System.out.println("Hello,");
        System.out.println("need to to update things today");////

        while (true) {
            System.out.println("Would you like to make an account or login ?");
            System.out.println("Making an account please press 1 \nLogging in please press 2 ");
            int inputFirstQuestion = scanner.nextInt();
            scanner.nextLine();

            if (inputFirstQuestion == 1) {
                Customer customer = new Customer();
                System.out.println("Please enter your first name ?");
                String newFirstname = scanner.nextLine();
                System.out.println("Please enter your last name ?");
                String newlastName = scanner.nextLine();
                System.out.println("please make a username ?");
                String newUsername = scanner.nextLine();
                System.out.println("please enter a pin ? ");
                int newPin = scanner.nextInt();
                customer.setUserId(newUsername);
                customer.setPinNumber(newPin);
                customer.setFirstName(newFirstname);
                customer.setLastName(newlastName);
                scanner.nextLine();

                System.out.println("Which account would you like to make:\nPress 1 for Checking\nPress 2 for Savings\nPress 3 for both");
                int checkingOrSavingsAccount = scanner.nextInt();

                if (checkingOrSavingsAccount==1) {
                    CheckingAccount checkingAccount = new CheckingAccount();
                    System.out.println("What amount would you like to add?");
                    double startingCheckingAmount = scanner.nextDouble();
                    checkingAccount.setCurrentBalanceAmount(startingCheckingAmount);
                    customer.setCheckingAccount(checkingAccount);
                    custList.add(customer);
                    System.out.println("Thank you for making a new Checking account. ");

                } else if (checkingOrSavingsAccount==2) {
                    SavingsAccount savingsAccount = new SavingsAccount();
                    System.out.println("What amount would you like to add?");
                    double startingSavingAmount = scanner.nextDouble();
                    savingsAccount.setCurrentBalanceAmount(startingSavingAmount);
                    customer.setSavingsAccount(savingsAccount);
                    custList.add(customer);
                    System.out.println("Thank you for making a new Savings account. ");

                } else if(checkingOrSavingsAccount==3){
                    CheckingAccount checkingAccount1 = new CheckingAccount();
                    SavingsAccount savingsAccount1 = new SavingsAccount();
                    System.out.println("What amount would you like to add into your Checking account ");
                    double startingCheckingAmount= scanner.nextDouble();
                    System.out.println("What amount would you like to add into your Savings account");
                    double startingSavingsAmount = scanner.nextDouble();
                    checkingAccount1.setCurrentBalanceAmount(startingCheckingAmount);
                    savingsAccount1.setCurrentBalanceAmount(startingSavingsAmount);
                    customer.setCheckingAccount(checkingAccount1);
                    customer.setSavingsAccount(savingsAccount1);
                    custList.add(customer);
                    System.out.println("Thank you for making a new Savings and Checking account.");
                }
                else {
                    System.out.println("You have entered the wrong key.");
                    System.out.println("please try again");
                }

                try {
                    FileOutputStream file = new FileOutputStream("CustomerData.txt");
                    ObjectOutputStream outputStream = new ObjectOutputStream(file);
                    outputStream.writeObject(custList);
                    outputStream.flush();
                    outputStream.close();

                }
                catch (IOException notfound){
                    notfound.printStackTrace();
                }


            } else if (inputFirstQuestion == 2) {
                //Had to remove try and catch due to scoping issues.
                FileInputStream readData = new FileInputStream("CustomerData.txt");
                ObjectInputStream readStream = new ObjectInputStream(readData);

                ArrayList inputCustomer = (ArrayList<Customer>) readStream.readObject();
                readStream.close();
                System.out.println(inputCustomer.toString());

                System.out.println("Please enter username");
                String inputUsername = scanner.nextLine();
                System.out.println("Please enter 4 digit pin");
                int inputUserPin = scanner.nextInt();
                scanner.nextLine();
                for (int i=0;i<inputCustomer.size();i++) {
                      Customer cust = (Customer) inputCustomer.get(i);//need to understand this type of casting.
                      if (cust.getUserId().equals(inputUsername) && cust.getPinNumber() == inputUserPin) {
                        System.out.println("Hello,"+ cust.getFirstName()+" I have found you in the system.");
                        System.out.println("Which account would you like to access today.\nPress 1 for checking\nPress 2 savings");
                        int checkingOrSaving = scanner.nextInt();
                        scanner.nextLine();
                        if (checkingOrSaving == 1) {
                            System.out.println("What would like to do with your checking account today ?");
                            System.out.println("Press 1 for deposit\nPress 2 for withdrawal\nPress 3 to check balance");
                            int depositOrWithdrawalOrCheckbalance = scanner.nextInt();
                            if (depositOrWithdrawalOrCheckbalance == 1) {
                                System.out.println("How much money would you like to deposit ?");
                                double moneyDeposit = scanner.nextDouble();
                                cust.getCheckingAccount().deposit(moneyDeposit);
                                System.out.println("Your current balance is $" + cust.getCheckingAccount().getCurrentBalanceAmount());
                            } else if (depositOrWithdrawalOrCheckbalance == 2) {
                                System.out.println("How much money would you like to withdraw ?");
                                double moneyWithdraw = scanner.nextDouble();
                                cust.getCheckingAccount().withdrawal(moneyWithdraw);
                                System.out.println("Your current balance is $" + cust.getCheckingAccount().getCurrentBalanceAmount());
                            } else if (depositOrWithdrawalOrCheckbalance == 3) {
                                cust.getCheckingAccount().checkbalance();
                            }

                        } else if (checkingOrSaving==2){
                            System.out.println("What would like to do with your saving account today ?");
                            System.out.println("press 1 for deposit\npress 2 for withdrawal\npress 3 to check balance");
                            int depositOrWithdrawalOrCheckbalance2 = scanner.nextInt();
                            if (depositOrWithdrawalOrCheckbalance2 == 1){
                                System.out.println("How much money would you like to deposit ?");
                                double moneyDeposit = scanner.nextDouble();
                                cust.getSavingsAccount().deposit(moneyDeposit);
                                System.out.println("Your current balance is $" + cust.getSavingsAccount().getCurrentBalanceAmount());
                            }
                            else if(depositOrWithdrawalOrCheckbalance2 ==2 ){
                                System.out.println("How much money would you like to withdraw ?");
                                double moneyWithdraw = scanner.nextDouble();
                                cust.getSavingsAccount().withdrawal(moneyWithdraw);
                                System.out.println("Your current balance is $" + cust.getSavingsAccount().getCurrentBalanceAmount()) ;
                            }
                            else if(depositOrWithdrawalOrCheckbalance2==3){
                                cust.getSavingsAccount().checkbalance();
                            }
                        }
                        else {
                            System.out.println("Sorry, You have entered a wrong key. Please try again");
                        }
                    }
                }
            }
            else{

                System.out.println("Sorry you picked a wrong choice please try again");
            }

        }
    }
}

