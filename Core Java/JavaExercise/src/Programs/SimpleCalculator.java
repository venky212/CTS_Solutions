package Programs;
import java.util.*;

public class SimpleCalculator {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Input1 : ");
		double a=sc.nextDouble();
		System.out.println("Enter the input2 : ");
		double b=sc.nextDouble();
		System.out.println("Enter the Operation (+,-,*,/,%): ");
		char Operation=sc.next().charAt(0);
		if(Operation=='+')
		{
			System.out.println("Result= " +(a+b));
		}
		else if(Operation =='-')
		{
			System.out.println("Result= " +(a-b));
		}
		else if(Operation =='*')
		{
			System.out.println("Result= " +(a*b));
		}
		else if(Operation =='/')
		{
			if(b!=0)
			{
			System.out.println("Result= " +(a/b));
			}
			else
			{
				System.out.println("Cannot divided by zero");
			}
		}
		else if(Operation =='%')
		{
			System.out.println("Result= " +(a%b));
		}
		else
		{
			System.out.println("You have entered the invalid operator" );
		}
		

	}

}
