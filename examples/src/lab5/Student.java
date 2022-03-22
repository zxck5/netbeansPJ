package Lab5;

public class Student {
	private int studentID;
	private String firstName;
	private String lastName;
	private int grade;
	
	
	public Student (int id, String fn, String ln, int grade) {
		this.studentID = id;
		this.firstName = fn;
		this.lastName = ln;
		this.grade = grade;
	}
	
	
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
