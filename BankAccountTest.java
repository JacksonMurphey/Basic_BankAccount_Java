public class BankAccountTest {
    
    public static void main(String[] args) {
        BankAccount acct1 = new BankAccount();

        acct1.depositToChecking(100.00).depositToSaving(1000.00);
        acct1.withdrawFromChecking(105.00);
        acct1.getCheckingBalance();
        
        BankAccount.getTotalMoney();
        BankAccount.getTotalAccts();

    }
}
