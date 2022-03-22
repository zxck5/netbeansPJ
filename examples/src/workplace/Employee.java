package workplace;

public class Employee {
    private int id;
    private double hourlyRate;
    private int hours;
    
    public Employee(int id, double hourlyRate, int hours) {
        this.id = id;
        this.hourlyRate = hourlyRate;
        this.hours = hours;
    }
    
    public int getId(){
        return id;
    }
    
    public int getHours() {
        return hours;
    } 
    
    public double getHourlyRate(){
        return hourlyRate;
    }
    
    public void setHours(int hours) {
        this.hours = hours;
    }
    
    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}
