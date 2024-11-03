import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Customer implements User {
    private Connection connection;
    private Scanner scanner;

    // Constructor with parameters
    public Customer(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;
    }

    @Override
    public void login() {
        System.out.println("Customer registration.");
    }

    public void validate() throws SQLException {
        String sql = "INSERT INTO client(name, surname, email, password) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Enter your surname: ");
        String surname = scanner.nextLine();

        System.out.println("Enter your email: ");
        String email = scanner.nextLine();

        System.out.println("Enter your password: ");
        String password = scanner.nextLine();

        // Set the values in the SQL statement
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, surname);
        preparedStatement.setString(3, email);
        preparedStatement.setString(4, password);

        // Execute the SQL update
        preparedStatement.executeUpdate();
        System.out.println("You have registered!");
    }

    @Override
    public void logout() {
        System.out.println("Customer logged out.");
    }
}
