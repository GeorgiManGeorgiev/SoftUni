package C_JavaAdvanced.JavaAdv.DefiningClasses.BankAccountLab;

public class BankAccount {
    private static int idCounter = 1;
    private int id;
    private double balance;
    private static double interestRate = 0.02;


    public BankAccount() {
        this.id = idCounter;
        idCounter++;
        System.out.println("Account ID" + this.id + " created");
    }


    public static void setInterestRate(double interest) {
        interestRate = interest;
    }

    public double getInterest(int years) {

        return (this.balance * interestRate) * years;

    }

    public void deposit(double amount) {
        this.balance += amount;
        System.out.println("Deposited " + (int) amount + " to ID" + this.id);
    }

    public int getId() {
        return this.id;
    }
}
