package ca.humber.college;

public class Employee {
    int employeeId;
    String fn; // first name
    String ln; // last name
    
    public Employee (int id, String fn, String ln) {
        this.employeeId = id;
        this.fn = fn;
        this.ln = ln;
    }
    public String toString () {
        return "id = "+ this.employeeId + ", " + "name = "+ this.fn +" " + this.ln; 
    }
    public void printInfo() {
        System.out.println("id = "+ this.employeeId + ", " + "name = "+ this.fn +" " + this.ln);
    }
}
