package Programs;
import java.util.*;
public class Factorial {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int Fact=1;
		System.out.println("Enter the number : ");
		int a=sc.nextInt();
		for(int i=1;i<=a;i++)
		{
			Fact=Fact*i;
		}
		System.out.println("The Factorial "+ a+" is " +Fact);

	}

}
