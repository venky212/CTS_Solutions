package Programs;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the String: ");
		String str=sc.nextLine();
		String s= str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		String empty="";
		for(int i=s.length()-1;i>=0;i--) {
			empty=empty+s.charAt(i);
		}
		System.out.println(s);
		System.out.println(empty);
		if(s.equals(empty))
		{
			System.out.println("It is a Palindrome");
		}
		else
		{
			System.out.println("Not a palindrome");
		}
		

	}

}
