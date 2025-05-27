package Programs;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
public class JdbcExample {

	public static void main(String[] args) {
		 String jdbcURL = "jdbc:mysql://localhost:3306/testdb";
	        String username = "root";
	        String password = "Venky@2004";
	        Connection connection = null;
	        try {
	          	  Class.forName("com.mysql.cj.jdbc.Driver");
	            connection = DriverManager.getConnection(jdbcURL, username, password);

	      	            Statement statement = connection.createStatement();

	        
	            String sql = "SELECT id, name, email FROM users";
	            ResultSet result = statement.executeQuery(sql);

	      
	            while (result.next()) {
	                int id = result.getInt("id");
	                String name = result.getString("name");
	                String email = result.getString("email");

	                System.out.printf("ID: %d, Name: %s, Email: %s%n", id, name, email);
	            }

	          
	            result.close();
	            statement.close();

	        } catch (ClassNotFoundException e) {
	            System.out.println("JDBC Driver not found.");
	            e.printStackTrace();
	        } catch (SQLException e) {
	            System.out.println("Database connection error.");
	            e.printStackTrace();
	        } finally {
	            
	            try {
	                if (connection != null) connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }

	}

}
