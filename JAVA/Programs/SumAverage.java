package Programs;
import java.util.*;
public class SumAverage {
public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of elements: ");
	    int size = sc.nextInt();
	    int[] numbers = new int[size];
	    int add =0;
	    System.out.println("Enter " + size + " integers:");
	        for (int i = 0; i < size; i++) {
	            numbers[i] = sc.nextInt();
	            add=add+numbers[i];
	        }
	       
	        System.out.println("Addition of number = "+add);
	        int average = add/size;
	        
	        System.out.println("avaerage of numbers = "+average);

	        
	    }
	}
	


