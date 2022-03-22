package workplace;

import java.util.Scanner;

public class Workplace {
    

    public static void main(String[] args) {
        // Read a list of employees info in the following format:
        // id hourlyRate hours
        // id2 hourlyRate2 hours2
        // ...
        // end
        // create Employee objects find the largest pay
        
        Scanner scanner = new Scanner(System.in);
        double largest = 0;
        String input;// = scanner.next();
        
        // if input is not "end" execute the loop
        while (!(input = scanner.next()).equals("end")) {
            // Convert input to int - id
            int id = Integer.parseInt(input);
            // Read the rest of the line
            double hourlyRate = scanner.nextDouble();
            int hours = scanner.nextInt();
            
            // Create Employee object
            Employee emp = new Employee(id, hourlyRate, hours);
            
            // Compare the pay to the largest value so far
            double currentPay = emp.getHourlyRate() * emp.getHours();
            if ( currentPay > largest )
                largest = currentPay;
            
            // Read next token
          //  input = scanner.next();
        }
        
        System.out.println("Largest pay is " + largest);
    }
    
}
