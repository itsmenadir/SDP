import java.sql.Connection;
import java.util.Scanner;

public class CustomerFactory extends UserFactory {
    private Connection connection;
    private Scanner scanner;

    // Constructor to initialize connection and scanner
    public CustomerFactory(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;
    }

    @Override
    public User createUser() {
        return new Customer(connection, scanner);
    }
}
