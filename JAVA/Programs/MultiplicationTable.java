package Programs;
import java.util.*;
public class MultiplicationTable {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
	
		System.out.println("Enter the Multiplication Number: ");
		int a=sc.nextInt();
		for(int i=1;i<=10;i++)
		{
			System.out.println(i+"*"+a+"="+(a*i));
		}
		

	}

}
