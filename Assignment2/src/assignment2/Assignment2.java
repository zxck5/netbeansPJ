package assignment2;

import java.util.Scanner;

public class Assignment2 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String start;
//		In each set the player is asked to enter a number from 1 to 9 to test multiplication skills
//		or to press ‘E’ to exit the game.
        System.out.println("enter a number 1 to 9");
        while (!(start = scan.next()).equalsIgnoreCase("e")) {
            int grade = 0;

            int n = Integer.parseInt(start);
//			The application checks if the number entered is indeed between 1 and 9
//			and if not displays a message inviting the player to try again.
            if (n >= 1 && n <= 9) {
                int i = 0;
                while (i <= 10) {
                    System.out.println("current grade:" + grade);
//					For each question the maximum score is 5 points if answered correctly
                    int maxScore = 5;
//					Upon receiving a number in a proper range the application starts displaying multiplication questions
//					with that number being multiplied by 0,1,2,…,10. 
                    System.out.println(n + " x " + i + " = " + "?");
//					At any point the player can press ‘E’ to exit current set
                    if ((start = scan.next()).equalsIgnoreCase("e")) {
                        break;
                    }
                    int answer = Integer.parseInt(start);
                    if (answer == n * i) {
                        System.out.println("correct");
                        grade += maxScore;

                    } else {
//		For each question if an incorrect result is entered the application prompts the player to try again.
//	    The player can choose to try again or bypass. The application provides up to 4 replay attempts to answer the same question. 
                        maxScore--;
//						If not, each replay attempt lowers the score by 1 point.
                        System.out.println("1.try again");
                        System.out.println("2.bypass");
                        int select = scan.nextInt();
                        if (select == 1) {
                            for (int k = 0; k < 4; k++) {
                                System.out.println(n + " x " + i + " = " + "?");
                                System.out.println("press E --> bypass");
                                String bypass = scan.next();
                                if (bypass.equalsIgnoreCase("e")) {
                                    maxScore = 0;
                                    break;
                                }
                                answer = Integer.parseInt(bypass);
                                if (answer == n * i) {
                                    System.out.println("correct!");
//									System.out.println("maxScore"+maxScore);
                                    break;
                                } else {
                                    System.out.println("wrong");
                                    maxScore--;
                                }
                            }
                            grade += maxScore;
                        }
                    }
                    i++;
                }
            } else {
                System.out.println("try again");
                continue;
            }
            System.out.println("your grade : " + grade + "/" + 55);
            System.out.println("enter a number 1 to 9");
        }

    }
}
