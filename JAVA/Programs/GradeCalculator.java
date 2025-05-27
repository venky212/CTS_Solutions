package Programs;
import java. util.*;
public class GradeCalculator {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the Mark = ");
		int n=s.nextInt();
		if(n<=100 && n>=90)
		{
			System.out.println("The grade = A ");
		}
		else if(n<=89 && n>=80)
			{
				System.out.println("The grade = B ");
			}
		else if(n<=79 && n>=70)
		{
			System.out.println("The grade = C ");
		}
		else if(n<=69 && n>=60)
		{
			System.out.println("The grade = D ");
		}
		else
		{
			System.out.println("The grade = F ");
		}
	}

}
