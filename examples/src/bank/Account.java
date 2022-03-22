
package bank;

import utilities.Converter;
import utilities.Currency;

public class Account {
    private static int currentNumber = 10001;
    private int accountNumber;
    private String name;
    private double balance;
    
    public Account(String name, double balance) {
        this.accountNumber = currentNumber;
        currentNumber++;
        this.name = name;
        this.balance = balance;
    }
    
    public void deposit(double amount){
        balance += amount;
    }
    
    public void withdraw(double amount){
        balance -= amount;
    }    
    
    // Add an overloaded withdraw method that accepts two parameters: amount and currency
    // It will convert the amount based on the currency and update the balance
    public void withdraw(double amount, Currency currency) {
        balance -= Converter.convert(amount, currency);
    }
    
    public void displayInfo() {
        System.out.println("Account number: " + accountNumber + ", balance: " + balance);
    }
}
