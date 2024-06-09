import java.util.*;

public class ATM {
    float balance;
    final int PIN = 1234;
    int userID = 1;
    public static List<String> transactionHistory = new ArrayList<>();

    public void checkPin() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to SBI");
        System.out.println("Enter user ID : ");
        int userId = sc.nextInt();
        System.out.println("Enter PIN : ");
        int pinEntered = sc.nextInt();
        if (pinEntered == PIN && userId == userID) {
            menu();
        } else {
            System.out.println("Invalid PIN");
            checkPin();
        }
    }

    public void menu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose the operation you want to perform : ");
        System.out.println("1. Show transaction history");
        System.out.println("2. Withdraw money");
        System.out.println("3. Deposit the money");
        System.out.println("4. Transfer the money");
        System.out.println("5. Quit system");
        int n = sc.nextInt();
        switch(n){
            case 1 : showTransactionHistory();
                break;
            case 2 : withdrawal();
                break;
            case 3 : deposit();
                      break;
            case 4 : transfer();
                     break;
            case 5 : quit();
            default : System.out.println("Enter the valid option");
        }
    }

    public void withdrawal(){
        System.out.println("Enter the amount you want to withdrawal : ");
        Scanner sc = new Scanner(System.in);
        int withdrawal = sc.nextInt();
        balance = balance - withdrawal;
        System.out.println("Money withdrawn successfully");
        System.out.println("Current balance : Rs " + balance);
        transactionHistory.add("Withdrawn : Rs " + withdrawal);
        menu();
    }

        public void transfer(){
        Scanner sc = new Scanner(System.in);
            System.out.println("Enter the amount you want to transfer : ");
            int transferedAmount = sc.nextInt();
            if(transferedAmount > balance){
                System.out.println("Insuffienct Balance");
            }
            else{
                System.out.println("Enter the reciever's Account Number : ");
                int receiver = sc.nextInt();
                balance = balance - transferedAmount;
                System.out.println("Money successfully transfered!");
                System.out.println("Current balance : Rs " + balance);
                transactionHistory.add("Transfered Rs " + transferedAmount + " to the receiver with acount number " + receiver);
            }
            menu();
        }
    public void deposit(){
        System.out.println("Enter the amount you want to deposit : ");
        Scanner sc = new Scanner(System.in);
        int deposit = sc.nextInt();
        balance = balance + deposit;
        System.out.println("The amount of Rs " + deposit + " has been deposited to your bank account successfully");
        System.out.println("Current balance : Rs " + balance);
        transactionHistory.add("Deposit : Rs " + deposit);
        menu();
    }

    public void showTransactionHistory(){
            System.out.println("Transaction History : ");
        for (int i = 0; i < transactionHistory.size(); i++) {
            System.out.println(transactionHistory.get(i));
        }
        menu();
        }

    public void quit(){
        System.out.println("Session expired, Thank you!");
        checkPin();
        System.exit(0);

    }
}
