package ca.humber.college;
import java.util.Scanner;

public class Lab01 {
    public static void main(String[] args) {
        System.out.println("-----lab01-----");
        Scanner scan = new Scanner(System.in);
        System.out.println("type your id, firstname and last name in order");
        Employee em = new Employee(scan.nextInt(),scan.next(),scan.next());
        // toString()
        System.out.println(em);
        // printInfo()
        em.printInfo();
        
    }

}
