import java.util.Date;

public class Transaction {
  String cryptoCurrency;
  double exchangeRate;
  double quantity;
  Date transactionDate;
  TransactionType transactionType;

  public Transaction(String cryptoCurrency, double exchangeRate, double quantity, Date transactionDate,
      TransactionType transactionType) {
    this.cryptoCurrency = cryptoCurrency;
    this.exchangeRate = exchangeRate;
    this.quantity = quantity;
    this.transactionDate = transactionDate;
    this.transactionType = transactionType;
  }

  @Override
  public String toString() {
    return "{" +
        "cryptoCurrency: '" + cryptoCurrency + '\'' +
        ", exchangeRate: " + exchangeRate +
        ", quantity: " + quantity +
        ", transactionDate:" + transactionDate +
        ", transactionType: " + transactionType +
        '}';
  }
}
