package Programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Programs.Student;
//public class InsertUpdate {


public class StudentDAO {
    private final String jdbcURL = "jdbc:mysql://localhost:3306/testdb";
    private final String username = "root";
    private final String password = "Venky@2004";

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(jdbcURL, username, password);
    }

    public void insertStudent(Student student) {
        String sql = "INSERT INTO students (id, name, email, age) VALUES (?, ?, ?, ?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, student.getId());
            pstmt.setString(2, student.getName());
            pstmt.setString(3, student.getEmail());
            pstmt.setInt(4, student.getAge());

            int rowsInserted = pstmt.executeUpdate();
            System.out.println(rowsInserted + " student(s) inserted.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        public void updateStudentEmail(int id, String newEmail) {
            String sql = "UPDATE students SET email = ? WHERE id = ?";

            try (Connection conn = connect();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, newEmail);
                pstmt.setInt(2, id);

                int rowsUpdated = pstmt.executeUpdate();
                System.out.println(rowsUpdated + " student(s) updated.");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    

    

	public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();

        Student newStudent = new Student(2, "Venky", "vemky@example.com", 30);
        dao.insertStudent(newStudent);

        dao.updateStudentEmail(2, "venky.new@example.com");


	}

}
