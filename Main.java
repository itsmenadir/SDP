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
    }
}
