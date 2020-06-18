import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Runner {

    public static void main(String[] args)  {
        ArrayList<Customer> custList = new ArrayList<>();
        System.out.println("Hello,");
        System.out.println("working on mysql");
        System.out.println("worked on primary keys and foriegn keys");
        System.out.println("updated sql tables");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Would you like to make an account or login ?");
            System.out.println("Making an account please press 1 \nLogging in please press 2 ");
            int inputFirstQuestion = scanner.nextInt();
            scanner.nextLine();
            Runner runner = new Runner();
            if (inputFirstQuestion == 1) {
                runner.newCustomer(custList,scanner);
            } else if (inputFirstQuestion == 2) {
                runner.lookupAccount(scanner);
            }
            else{
                System.out.println("Sorry you picked a wrong choice please try again");
            }
        }
    }
    public void newCustomer(ArrayList custList, Scanner scanner) {
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
        accountMaking(scanner,customer,custList);
    }
    public void accountMaking(Scanner scanner,Customer customer,ArrayList custList) {
        System.out.println("Which account would you like to make:\nPress 1 for Checking\nPress 2 for Savings\nPress 3 for both");
        int checkingOrSavingsAccount = scanner.nextInt();
        if (checkingOrSavingsAccount == 1) {
            CheckingAccount checkingAccount = new CheckingAccount();
            checkingAccount.setCurrentBalanceAmount(amountAddChecking(scanner));
            customer.setCheckingAccount(checkingAccount);
            custList.add(customer);
            System.out.println("Thank you for making a new Checking account. ");

        } else if (checkingOrSavingsAccount == 2) {
            SavingsAccount savingsAccount = new SavingsAccount();
            savingsAccount.setCurrentBalanceAmount(amountAddSavings(scanner));
            customer.setSavingsAccount(savingsAccount);
            custList.add(customer);
            System.out.println("Thank you for making a new Savings account. ");

        } else if (checkingOrSavingsAccount == 3) {
            CheckingAccount checkingAccount1 = new CheckingAccount();
            SavingsAccount savingsAccount1 = new SavingsAccount();
            checkingAccount1.setCurrentBalanceAmount(amountAddChecking(scanner));
            savingsAccount1.setCurrentBalanceAmount(amountAddSavings(scanner));
            customer.setCheckingAccount(checkingAccount1);
            customer.setSavingsAccount(savingsAccount1);
            custList.add(customer);
            System.out.println("Thank you for making a new Savings and Checking account.");

        } else {
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
    }
    public double amountAddChecking(Scanner scanner){
        System.out.println("What amount would you like to add to your checking account?");
        double amount = scanner.nextDouble();
        return amount;
    }public double amountAddSavings(Scanner scanner){
        System.out.println("What amount would you like to add to your savings account?");
        double amount =scanner.nextDouble();
        return amount;
    }
    public void lookupAccount(Scanner scanner){
        ArrayList inputCustomer=null;
        try {
            FileInputStream readData = new FileInputStream("CustomerData.txt");
            ObjectInputStream readStream = new ObjectInputStream(readData);
            inputCustomer = (ArrayList<Customer>) readStream.readObject();
            readStream.close();
            // System.out.println(inputCustomer.toString());
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        System.out.println("Please enter username");
        String inputUsername = scanner.nextLine();
        System.out.println("Please enter 4 digit pin");
        int inputUserPin = scanner.nextInt();
        scanner.nextLine();
        for (int i=0;i<inputCustomer.size();i++) {
            Customer cust = (Customer) inputCustomer.get(i);//need to understand this type of casting.
            if (cust.getUserId().equals(inputUsername) && cust.getPinNumber() == inputUserPin) {
                System.out.println("Hello,"+ cust.getFirstName()+" I have found you in the system.");
                accountAccess(scanner,cust);
            }
        }
    }public double amountDeposit(Scanner scanner){
        System.out.println("How much money would you like to deposit ?");
        double moneyDeposit = scanner.nextDouble();
        return moneyDeposit;
    }public double amountWithdrwal(Scanner scanner) {
        System.out.println("How much money would you like to withdraw ?");
        double moneyWithdraw = scanner.nextDouble();
        return moneyWithdraw;
    }  public void accountAccess(Scanner scanner, Customer cust){
        System.out.println("Which account would you like to access today.\nPress 1 for checking\nPress 2 savings");
        int checkingOrSaving = scanner.nextInt();
        scanner.nextLine();
        if (checkingOrSaving == 1) {
            System.out.println("Press 1 for deposit\nPress 2 for withdrawal\nPress 3 to check balance");
            int depositOrWithdrawalOrCheckbalance = scanner.nextInt();
            if (depositOrWithdrawalOrCheckbalance == 1) {
                cust.getCheckingAccount().deposit(amountDeposit(scanner));
                System.out.println("Your current balance is $" + cust.getCheckingAccount().getCurrentBalanceAmount());
            } else if (depositOrWithdrawalOrCheckbalance == 2) {
                cust.getCheckingAccount().withdrawal(amountWithdrwal(scanner));
                System.out.println("Your current balance is $" + cust.getCheckingAccount().getCurrentBalanceAmount());
            } else if (depositOrWithdrawalOrCheckbalance == 3) {
                cust.getCheckingAccount().checkbalance();
            }
        } else if (checkingOrSaving==2){
            System.out.println("press 1 for deposit\npress 2 for withdrawal\npress 3 to check balance");
            int depositOrWithdrawalOrCheckbalance2 = scanner.nextInt();
            if (depositOrWithdrawalOrCheckbalance2 == 1){
                cust.getSavingsAccount().deposit(amountDeposit(scanner));
                System.out.println("Your current balance is $" + cust.getSavingsAccount().getCurrentBalanceAmount());
            }
            else if(depositOrWithdrawalOrCheckbalance2 ==2 ){
                cust.getSavingsAccount().withdrawal(amountWithdrwal(scanner));
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

