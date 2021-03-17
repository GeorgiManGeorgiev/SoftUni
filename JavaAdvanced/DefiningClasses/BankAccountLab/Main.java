package C_JavaAdvanced.JavaAdv.DefiningClasses.BankAccountLab;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<Integer, BankAccount> bankAccounts = new HashMap<>();

        while (!"End".equals(input)) {

            String[] tokens = input.split("\\s+");

            String command = tokens[0];

            if ("Create".equals(command)) {
                BankAccount bankAccount = new BankAccount();
                bankAccounts.put(bankAccount.getId(), bankAccount);
            } else if ("Deposit".equals(command)) {
                int id = Integer.parseInt(tokens[1]);
                if (bankAccounts.containsKey(id)) {
                    BankAccount bankAccount = bankAccounts.get(id);
                    bankAccount.deposit(Double.parseDouble(tokens[2]));
                }else{
                    System.out.println("Account does not exist");
                }

            } else if ("SetInterest".equals(command)) {
                double newInterest = Double.parseDouble(tokens[1]);
                BankAccount.setInterestRate(newInterest);


            } else if ("GetInterest".equals(command)) {
                int id = Integer.parseInt(tokens[1]);
                if (bankAccounts.containsKey(id)) {
                BankAccount bankAccount = bankAccounts.get(id);
                System.out.printf("%.2f%n", bankAccount.getInterest(Integer.parseInt(tokens[2])));
            }else {
                    System.out.println("Account does not exist");
                }
            }

            input = scanner.nextLine();
        }
    }
}
