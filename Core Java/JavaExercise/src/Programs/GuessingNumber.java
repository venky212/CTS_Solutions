package Programs;
import java.util.*;
public class GuessingNumber {

	public static void main(String[] args) {
		
		        int number = (int)(Math.random() * 100) + 1; // Random number from 1 to 100
		       // System.out.println(number);
		        Scanner input = new Scanner(System.in);
		        int guess = 0;

		       
		        System.out.println("Guess a number between 1 and 100:");

		        while (guess != number) {
		            guess = input.nextInt();

		            if (guess < number) {
		                System.out.println("Too low. Try again:");
		            } else if (guess > number) {
		                System.out.println("Too high. Try again:");
		            } else {
		                System.out.println("Its Correct");
		            }
		        }
	}

}
