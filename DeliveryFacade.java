// Facade для управления доставкой с обновлением статуса и расчетом ETA
public class DeliveryFacade {
    private CourierService courierService;
    private TrackingService trackingService;
    private Notification notificationService;
    private ETACalculator etaCalculator;

    public DeliveryFacade(CourierService courierService, TrackingService trackingService, Notification notificationService, ETACalculator etaCalculator) {
        this.courierService = courierService;
        this.trackingService = trackingService;
        this.notificationService = notificationService;
        this.etaCalculator = etaCalculator;
    }

    public void startDelivery() {
        Courier courier = courierService.assignCourier();
        notificationService.send("Ваш заказ отправлен с курьером " + courier.getName());

        // Обновляем статус
        courierService.updateStatus(courier, DeliveryStatus.IN_TRANSIT);
        System.out.println("Статус доставки: " + courierService.getStatus(courier));

        // Получаем местоположение и ETA
        String location = trackingService.getCourierLocation(courier.getId());
        int eta = etaCalculator.calculateETA(location);
        System.out.println("Текущее местоположение: " + location);
        System.out.println("Примерное время прибытия: " + eta + " минут");

        notificationService.send("Ваш заказ в пути, прибытие через " + eta + " минут.");
    }

    public void completeDelivery(Courier courier) {
        courierService.updateStatus(courier, DeliveryStatus.DELIVERED);
        notificationService.send("Ваш заказ доставлен курьером " + courier.getName());
        System.out.println("Статус доставки: " + courierService.getStatus(courier));
    }
}