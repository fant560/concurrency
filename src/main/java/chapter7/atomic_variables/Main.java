package chapter7.atomic_variables;

public class Main {

    public static void main(String[] args) {
        Account account = new Account();
        account.setBalance(1000);

        Company company = new Company(account);
        Thread companyThread = new Thread(company);

        Bank bank = new Bank(account);
        Thread bankThread = new Thread(bank);

        System.out.printf("Account: Initial Balance: %s\n", account.getBalance());
        companyThread.start();
        bankThread.start();

        try {
            companyThread.join();
            bankThread.join();
            System.out.printf("Account: Final Balance: %s\n", account.getBalance());
            System.out.printf("Account: Number of Operations: %d\n", account.getOperations().intValue());
            System.out.printf("Account: Accumulated commissions: %f\n", account.getComission().doubleValue());
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
