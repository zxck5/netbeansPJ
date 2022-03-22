package ca.humber.bank;

import ca.humber.utilities.Converter;
import ca.humber.utilities.Currency;

public class Bank {

    public static void main(String[] args) {
        // Creating account objects and manipulating them
        Converter.setRateUsd(0.7);
        Converter.setRateEuro(0.6);
        
        Account acc1 = new Account("Jill", 200);
        Account acc2 = new Account("Jack", 300);
        
        Converter.setRateUsd(0.75);
        
        acc1.deposit(100);
        acc2.withdraw(50);
        acc1.withdraw(100, Currency.USD);
        
        acc1.displayInfo();
        acc2.displayInfo();
    }
    
}
