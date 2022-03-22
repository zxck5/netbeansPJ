package ca.humber.college;
import java.util.Scanner;
public class Student {
    int id;
    String name;
    int numberCourses;
    
    public void addCourses() {
        numberCourses ++;
    }
    public void printInfo() {
        System.out.println("id:"+id +" ,"+ "name:"+name + " ," + "numberCourses:" + numberCourses);
    }
    
    
    public static void main(String[] args) {
        Student f_stu = new Student();
        Student s_stu = new Student();
        
        f_stu.id = 10;
        f_stu.name = "john";
        f_stu.numberCourses = 2;
        f_stu.printInfo();
        
        Scanner scan = new Scanner(System.in);
        
    }
}
