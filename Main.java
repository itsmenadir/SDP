import java.util.*;
import java.sql.*;

class Main{

    private static final String username = "postgres";
    private static final String password = "Supoga80";

    private static final  String url = "jdbc:postgresql://localhost:5432/create";
    public static void main(String[] args) throws SQLException{

//        Login
        try(Scanner scanner = new Scanner(System.in);
            Connection connection = DriverManager.getConnection(url, username, password)) { Customer customer = new Customer(connection, scanner);
            customer.login(); // Log the customer in
            customer.validate(); // Validate and register the customer
            UserFactory courierFactory = new CourierFactory();
            User courier = courierFactory.createUser();
            courier.login(); // Output: Courier logged in.
            Menu menu = new Menu.MenuBuilder("Italian Restaurant")
                    .setDishes(Arrays.asList("Pasta", "Pizza", "Tiramisu"))
                    .setPrices(Arrays.asList(12.99, 15.99, 7.99))
                    .setAvailable(true)
                    .build();

            System.out.println(menu);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
