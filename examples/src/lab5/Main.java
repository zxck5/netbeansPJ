package Lab5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		Student stdntArr [] = new Student[20];
		int total = 0;
		int idx = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		StringTokenizer st = new StringTokenizer(br.readLine());
		while (!(input = st.nextToken()).equalsIgnoreCase("end") && idx < 20) {
			
			stdntArr[idx] = new Student(Integer.parseInt(input),st.nextToken(),st.nextToken(),Integer.parseInt(st.nextToken()));
			total += stdntArr[idx].getGrade();
			idx ++;

			st = new StringTokenizer(br.readLine());
		}
		if (idx != 0) {
			System.out.println("average without function:"+total/idx);			
		} else {
			System.out.println("the course is empty");
		}
                System.out.println("average by using function: " + findAveragePrice(stdntArr));
                
	}
        public static double findAveragePrice(Student arr[]) {
		double total = 0;
		for (int i = 0; i < arr.length; i ++) {
			if (arr[0] == null) return 0;
			if (arr[i] == null) {
				return total/i;
			}
			total += arr[i].getGrade();
		}
		return total/arr.length;
	}
}
