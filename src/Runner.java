import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//good or bad practice sout statements in main class or original methods.
//how to have arraylist validate just a few variables not all.
//why is not remembering the amount values associated with the customer.

public class Runner {
    public static void main(String[] args) {


        SavingsAccount savingsAccount = new SavingsAccount();
        Scanner scanner = new Scanner(System.in);
        List<Customer> custList = new ArrayList<>();

        System.out.println("Hello,");

        while (true) {
            System.out.println("Would you like to make an account or login ?");
            System.out.println("Making an account please press 1 \nLogging in please press 2 ");
            int inputFirstQuestion = scanner.nextInt();
            scanner.nextLine();

            if (inputFirstQuestion == 1) {
                Customer customer = new Customer();
               // System.out.println("Please enter your first name ?");//ask faraz
               // String newFirstname = scanner.nextLine();//ask faraz
               // System.out.println("Please enter your last name ?");//ask faraz
               // String newlastName = scanner.nextLine();//ask faraz
                System.out.println("please make a username ?");
                String newUsername = scanner.nextLine();
                System.out.println("please enter a pin ? ");
                int newPin = scanner.nextInt();
                customer.setUserId(newUsername);
                customer.setPinNumber(newPin);
                //customer.setFirstName(newFirstname);
                //customer.setLastName(newlastName);
                scanner.nextLine();

                System.out.println("which account would you like to make:\nchecking\nsavings");
                String checkingOrSavingsAccount = scanner.nextLine();
                CheckingAccount checkingAccount = new CheckingAccount();

                if(checkingOrSavingsAccount.equalsIgnoreCase("checking")){
                    System.out.println("what amount would you like to add?");
                    double startingCheckingAmount = scanner.nextDouble();
                    checkingAccount.setCurrentBalanceAmount(startingCheckingAmount);
                }
                else if(checkingOrSavingsAccount.equalsIgnoreCase("savings")){
                    System.out.println("what amount would you like to add?");
                    double startingSavingAmount = scanner.nextDouble();
                    checkingAccount.setCurrentBalanceAmount(startingSavingAmount);
                }
                else{
                    System.out.println("you have entered the wrong key.");
                }
                custList.add(customer);
                System.out.println(Arrays.toString(custList.toArray()));////
            }
            else if (inputFirstQuestion == 2) {
                Customer tempCust = new Customer();
                System.out.println("Please enter username");
                String inputUsername = scanner.nextLine();
                System.out.println("Please enter 4 digit pin");
                int inputUserPin = scanner.nextInt();
                scanner.nextLine();
                tempCust.setUserId(inputUsername);
                tempCust.setPinNumber(inputUserPin);
                if (custList.contains(tempCust)){
                    System.out.println("hello, I have found you in the system");
                    System.out.println("which account would you like to access today.\nPress 1 for checking\nPress 2 savings ?");
                    int checkingOrSaving = scanner.nextInt();
                    scanner.nextLine();
                    //CheckingAccount checkingAccount = new CheckingAccount();
                    if(checkingOrSaving==1){
                        CheckingAccount checkingAccountCust1 =new CheckingAccount();
                        tempCust.setCheckingAccount(checkingAccountCust1);
                        System.out.println("what would like to do with your checking account today ?");
                        System.out.println("press 1 for deposit\npress 2 for withdrawal\npress 3 to check balance");
                        int depositOrWithdrawalOrCheckbalance = scanner.nextInt();
                        if (depositOrWithdrawalOrCheckbalance == 1){
                            System.out.println("How much money would you like to deposit ?");
                            double moneyDeposit = scanner.nextDouble();
                            //tempCust.checkingAccount.deposit(moneyDeposit);
                            checkingAccountCust1.deposit(depositOrWithdrawalOrCheckbalance);
                            tempCust.setCheckingAccount(checkingAccountCust1);
                            //System.out.println("Your current balance is $" + tempCust.checkingAccount.getCurrentBalanceAmount());
                            System.out.println("Your current balance is $" + checkingAccountCust1.getCurrentBalanceAmount());
                        }
//                        else if(depositOrWithdrawalOrCheckbalance ==2 ){
//                            System.out.println("How much money would you like to withdraw ?");
//                            double moneyWithdraw = scanner.nextDouble();
//                            tempCust.checkingAccount.withdrawal(moneyWithdraw);
//                            System.out.println("Your current balance is $" + tempCust.checkingAccount.getCurrentBalanceAmount()) ;
//                        }
//                        else if(depositOrWithdrawalOrCheckbalance==3){
//                           tempCust.checkingAccount.checkbalance();
//                           // System.out.println("Your current balance is $" + tempCust.checkingAccount.getCurrentBalanceAmount());
//
//                        }

//                    }else if (checkingOrSaving==2){
//                        System.out.println("what would like to do with your saving account today ?");
//                        System.out.println("press 1 for deposit\npress 2 for withdrawal\npress 3 to check balance");
//                        int depositOrWithdrawalOrCheckbalance2 = scanner.nextInt();
//                        if (depositOrWithdrawalOrCheckbalance2 == 1){
//                            System.out.println("How much money would you like to deposit ?");
//                            double moneyDeposit = scanner.nextDouble();
//                            tempCust.savingsAccount.deposit(moneyDeposit);
//                            System.out.println("Your current balance is $" + tempCust.savingsAccount.getCurrentBalanceAmount());
//                        }
//                        else if(depositOrWithdrawalOrCheckbalance2 ==2 ){
//                            System.out.println("How much money would you like to withdraw ?");
//                            double moneyWithdraw = scanner.nextDouble();
//                            tempCust.savingsAccount.withdrawal(moneyWithdraw);
//                            System.out.println("Your current balance is $" + tempCust.savingsAccount.getCurrentBalanceAmount()) ;
//                        }
//                        else if(depositOrWithdrawalOrCheckbalance2==3){
//                            tempCust.savingsAccount.checkbalance();
//                            // System.out.println("Your current balance is $" + tempCust.checkingAccount.getCurrentBalanceAmount());
//
//                        }
                    }

                }

                else{
                    System.out.println("sorry you don't exist");
                }


            }
            else{
                System.out.println("Sorry you picked a wrong choice please try again");
            }

            }



        }


    }
