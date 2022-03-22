package ca.humber.college;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("start");
		Scanner scan = new Scanner(System.in);
		Calculator cal = new Calculator();
		
		boolean run = true;
		while (run) {
			System.out.println("input number1");
			double number1 = scan.nextDouble();
			System.out.println("input number2");
			double number2 = scan.nextDouble();
			System.out.println("operators : +,-,*,/");
                        System.out.println("if you type number2 as a 0 in division, it will ask you to type again. ");
			System.out.println("select and type your operator");
			
			String operator = scan.next();
			
			double answer = cal.calculate(number1,operator,number2);
			
			if (answer != Integer.MIN_VALUE) {
				System.out.println("input:"+ number1 + operator + number2);
				System.out.println("output:"+ answer);								
			} 
               
			run = cal.exitProgram(scan, run);
		
			
//			if(!cal.exitProgram(scan)) {
//				break;
//			}
			
			
			
		}
	
	}
}
