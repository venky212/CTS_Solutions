package Programs;
import java.util.*;
import java.util.Scanner;

public class ArrayListExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> studentNames = new ArrayList<>();
        System.out.println("Enter student names (type 'done' to finish):");
             while (true) {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("done")) {
                break;
            }
            studentNames.add(name);
        }
            System.out.println("\nList of student names:");
        for (String student : studentNames) {
            System.out.println(student);
        }
        scanner.close();
    }
}
