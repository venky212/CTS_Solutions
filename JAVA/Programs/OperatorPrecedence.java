package Programs;

public class OperatorPrecedence {

	public static void main(String[] args) {
		//Following the BODMAS Rule:
		int op1 = 10 + 5 * 2;
		int op2 = (10 + 5) * 2;
        int op3 = 10 / 4 + 5 * 2;
        int op4 = 10 / (4 + 5) * 2;

        System.out.println("Operation Precedence (10 + 5 * 2): " + op1);
      //  Multiplication happens first: 5 * 2 = 10 → 10 + 10 = 20
        System.out.println("Operation Precedence ((10 + 5) * 2): " + op2);
     // Parentheses first: 10 + 5 = 15 → 15 * 2 = 30
        System.out.println("Operation Precedence (10 / 4 + 5 * 2): " + op3);
     // First: 10 / 4 = 2(integer division), 5 * 2 = 10 → 2 + 10 = 12
        System.out.println("Operation Precedence (10 / (4 + 5) * 2): " + op4);
     // Parentheses: 4 + 5 = 9 → 10 / 9 = 1 (integer division) → 1 * 2 = 2

	}

}
