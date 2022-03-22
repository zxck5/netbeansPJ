package ca.humber.college;

import java.util.Scanner;

public class Calculator {

    public double add(double number1, double number2) {
        return number1 + number2;
    }

    public double subtract(double number1, double number2) {
        return number1 - number2;
    }

    public double multiply(double number1, double number2) {
        return number1 * number2;
    }

    public double divide(double number1, double number2) {
        if (number2 != 0) {
            return number1 / number2;
        } else {
            System.out.println("denominator can't be 0");
            return Integer.MIN_VALUE;
        }
    }

    public double calculate(double number1, String operator, double number2) {
        switch (operator) {
            case "+":
                return add(number1, number2);
            case "-":
                return subtract(number1, number2);

            case "*":
                return multiply(number1, number2);

            case "/":
                return divide(number1, number2);

            default:
                System.out.println("error");
        }

        return Integer.MIN_VALUE;
    }

//	public Boolean exitProgram (Scanner scan) {
//		System.out.println("do you like to continue? Y/N");
//		String reply = scan.next();
//		if (reply.equalsIgnoreCase("y")) {
//			return true;
//		} else if (reply.equalsIgnoreCase("n")) {
//			return false;
//		} else {
//			System.out.println("please type again");
//			return exitProgram(scan);
//		}
//	}
    public boolean exitProgram(Scanner scan, boolean run) {
        while (true) {
            System.out.println("do you like to continue? Y/N");
            String reply = scan.next();
            if (reply.equalsIgnoreCase("y")) {
                return true;
            } else if (reply.equalsIgnoreCase("n")) {
               return false;
            } else {
                System.out.println("please type again");
                
            }
        }
    }

}
