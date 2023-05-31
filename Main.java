import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
  static List<Transaction> transactions = new ArrayList<>(); // Static list to store transactions

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in); // Create a Scanner object to read user input
    while (true) {
      System.out.println("1. Add new transaction");
      System.out.println("2. Load transaction history");
      System.out.println("Enter your choice:");
      int choice = scanner.nextInt(); // Read user's choice
      scanner.nextLine(); // Consume newline left-over

      switch (choice) {
        case 1:
          System.out.println("Enter CryptoCurrency:");
          String cryptoCurrency = scanner.nextLine(); // Read the cryptocurrency name from the user
          System.out.println("Enter ExchangeRate:");
          double exchangeRate = scanner.nextDouble(); // Read the exchange rate from the user
          System.out.println("Enter Quantity:");
          double quantity = scanner.nextDouble(); // Read the quantity from the user
          scanner.nextLine(); // Consume newline left-over
          System.out.println("Enter TransactionType (1. Debit, 2. Credit):");
          int typeChoice = scanner.nextInt(); // Read the transaction type choice from the user
          TransactionType transactionType = (typeChoice == 1) ? TransactionType.Debit : TransactionType.Credit; // Determine
                                                                                                                // the
                                                                                                                // transaction
                                                                                                                // type
                                                                                                                // based
                                                                                                                // on
                                                                                                                // the
                                                                                                                // choice
          Transaction transaction = new Transaction(cryptoCurrency, exchangeRate, quantity, new Date(),
              transactionType); // Create a new Transaction object
          if (TransactionValidator.isValidTransaction(transaction)) { // Validate the transaction
            transactions.add(transaction); // Add the valid transaction to the transactions list
            System.out.println("----------");
            System.out.println("Transaction added successfully.");
            System.out.println("----------");
          } else {
            System.out.println("----------");
            System.out.println("Please enter correct data.");
            System.out.println("----------");
          }
          break;
        case 2:
          double totalDebit = 0, totalCredit = 0;
          for (int i = 0; i < transactions.size(); i++) { // Iterate over the transactions list
            Transaction t = transactions.get(i);
            System.out.println("----------");
            System.out.println((i + 1) + ". " + t.toString()); // Print the string representation of each transaction

            if (t.transactionType == TransactionType.Debit) {
              totalDebit += t.quantity; // Calculate the total debit amount
            } else {
              totalCredit += t.quantity; // Calculate the total credit amount
            }
          }
          System.out.println("----------");
          System.out.println("Total Debit: " + totalDebit); // Print the total debit amount
          System.out.println("Total Credit: " + totalCredit); // Print the total credit amount
          System.out.println("----------");
          break;
      }
    }
  }
}
