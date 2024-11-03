<<<<<<< HEAD
public class Main {
    public static void main(String[] args) {

        CourierService courierService = new CourierService();
        RealTrackingService realTrackingService = new RealTrackingService();
        TrackingService trackingServiceProxy = new TrackingServiceProxy(realTrackingService);
        ETACalculator etaCalculator = new BasicETACalculator();

        Notification basicNotification = new BasicNotification();
        Notification smsNotification = new SMSNotificationDecorator(basicNotification);
        Notification pushNotification = new PushNotificationDecorator(smsNotification);

        DeliveryFacade deliveryFacade = new DeliveryFacade(courierService, trackingServiceProxy, pushNotification, etaCalculator);

        deliveryFacade.startDelivery();

        Courier courier = courierService.assignCourier();  // Назначаем того же курьера для завершения
        deliveryFacade.completeDelivery(courier);
=======
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
>>>>>>> 5ad72380ac2a81a9fb408f87b010c81d0531cd82
    }
}
