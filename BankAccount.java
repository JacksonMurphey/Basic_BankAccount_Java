import java.util.Random;



public class BankAccount {
    public static int numberOfAccts = 0;
    private double checkingBalance;
    private double savingsBalance;
    private double defaultSavings = 0;
    private double defaultChecking = 0;
    public static long totalMoney = 0;
    private static double fee = 5.00;
    private String acctNumber;

    // constructors 
    public BankAccount(){
        checkingBalance = defaultChecking;
        savingsBalance = defaultSavings;
        acctNumber = accountNumCreator();
        System.out.println("Your account number is: " + this.acctNumber);
        numberOfAccts++;
    }
    // public BankAccount(double checkingBalance){
    //     this.checkingBalance = checkingBalance;
    //     this.savingsBalance = defaultSavings;
    //     numberOfAccts++;
    //     totalMoney += (long)this.checkingBalance;
    // }
    // public BankAccount(double checkingBalance, double savingsBalance){
    //     this.checkingBalance = checkingBalance;
    //     this.savingsBalance = savingsBalance;
    //     numberOfAccts++;
    //     totalMoney += (long)this.checkingBalance;
    //     totalMoney += (long)this.savingsBalance;
    // }

    // getters 
    public BankAccount getCheckingBalance(){
        System.out.println("Your checking balance is: " + this.checkingBalance);
        return this;
    }
    public BankAccount getSavingBalance(){
        System.out.println("Your saving's balance is: " + this.savingsBalance);
        return this;
    }
    
    // deposit setters 
    public BankAccount depositToChecking(double depositAmount){
        this.checkingBalance += depositAmount;
        totalMoney += (long)depositAmount;
        return this;
    }
    public BankAccount depositToSaving(double depositAmount){
        this.savingsBalance += depositAmount;
        totalMoney += (long)depositAmount;
        return this;
    }

    // withdraw setters 
    public BankAccount withdrawFromChecking(double withdrawAmount){
        if(this.checkingBalance >= withdrawAmount){
            this.checkingBalance -= withdrawAmount;
            totalMoney -= (long)withdrawAmount;
        } else {
            this.checkingBalance -= (long)fee; 
            System.out.println("Insufficient funds. Charging $5.00 fee."); 
            totalMoney -= (long)fee;
        }
        return this;
    } 
    public BankAccount withdrawFromSaving(double withdrawAmount){
        if(this.savingsBalance >= withdrawAmount){
            this.savingsBalance -= withdrawAmount;
            totalMoney -= withdrawAmount;
        } else {
            this.checkingBalance -= (long)fee; 
            System.out.println("Insufficient funds. Charging $5.00 fee."); 
            totalMoney -= (long)fee;
        }
        return this;
    }

    public static void getTotalMoney(){
        System.out.println("The total money in all accounts: " + totalMoney);
    }
    public static int getTotalAccts(){
        System.out.println("There are curently " + numberOfAccts + " accounts in the system.");
        return numberOfAccts;
    }

    private static String accountNumCreator(){
        Random randomGen = new Random();
        String acct = "";
        for (int i = 0; i<10; i++){
            acct += randomGen.nextInt(10);
        }

        return acct;
    }
}
