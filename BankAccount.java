package banktransactionsystem;
import java.util.Scanner;

//password : 123456
public class BankAccount {

    private String name;
    private String type;
    private String ID;
    private int password;
    private double depositAmount;
    private double withdrawAmount;
    private double currentBalance;

    Scanner sc = new Scanner(System.in);

    public void welcome() throws InterruptedException {
        
        System.out.println("------ Welcome to Pure Bank! ------");
        Thread.sleep(2000);

        System.out.println("\nEnter Your Password : ");
        password = sc.nextInt();

        if (password == 123456) {
            Thread.sleep(2000);
            System.out.println("\n-------- Account Details ----------");
            
            System.out.println("FULL NAME       : " + name);
            System.out.println("ACCOUNT TYPE    : " + type);
            System.out.println("PERSONAL ID     : " + ID);
            System.out.println("BANK BALANCE    : " + currentBalance + " $");

            Thread.sleep(2000);
            System.out.println("\n-----------------------------------");
            
            System.out.println("Deposit : Press 1\nWithdraw : Press 2");

            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();

            if (option == 1) {
                System.out.println("\n-----------------------------------");
                System.out.println("Enter Amount : ");
                
                double amount = sc.nextDouble();
                deposit(amount);
                
            } else if (option == 2) {
                System.out.println("\n-----------------------------------");
                System.out.println("Enter Amount : ");
                
                double amount = sc.nextDouble();
                withdraw(amount);
                
            }
        } else {
            goodBye();
        }

    }

    public BankAccount(String name, String type, String ID, double deposit, double withdraw) throws InterruptedException {

        this.name = name;
        this.type = type;
        this.ID = ID;
        this.depositAmount = deposit;
        this.withdrawAmount = withdraw;
        this.currentBalance += deposit;
        welcome();

    }

    public void deposit(double amount) throws InterruptedException {
        this.depositAmount = amount;
        Thread.sleep(2000); 
        
        System.out.println("\n-----------------------------------");
        System.out.println("Deposit Amount : " + depositAmount +" $");
        
        currentBalance += depositAmount;
        System.out.printf("Current Balance : %.2f $", currentBalance);
        
        System.out.println("\n\n-----------------------------------");
        System.out.println("Thank You for being with us!");
    }

    public void withdraw(double amount) throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("\n-----------------------------------");
        System.out.println("Withdrawal Amount : " + amount +" $");
        
        currentBalance -= amount;
        System.out.printf("Current Balance : %.2f $", currentBalance);
        
        System.out.println("\n\n-----------------------------------");
        System.out.println("Thank You for being with us!");
    }

    public void goodBye() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("\n-----------------------------------");
        System.out.println("Something went wrong!");
        
        Thread.sleep(3000);
        System.out.println("Your transaction has been declined.");
        
        Thread.sleep(3000);
        System.out.println("Do you want to try again ? (yes/no)");
        Scanner sc = new Scanner(System.in);
        String option = sc.nextLine();

        if (option.equalsIgnoreCase("YES")) {
            welcome();
        } else {
            Thread.sleep(3000);
            System.out.println("\n-----------------------------------");
            System.out.println("Thank You for being with us!");
        }

    }

}
