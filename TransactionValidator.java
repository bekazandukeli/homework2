public class TransactionValidator {
  public static boolean isValidTransaction(Transaction transaction) {
    return transaction.cryptoCurrency != null && !transaction.cryptoCurrency.isEmpty()
        && transaction.quantity > 0
        && transaction.exchangeRate > 0
        && transaction.transactionDate != null
        && transaction.transactionType != null;
  }
}
