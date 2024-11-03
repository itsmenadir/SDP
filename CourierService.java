import java.util.HashMap;
import java.util.Map;

// Класс для отслеживания статуса доставки
enum DeliveryStatus {
    ASSIGNED, IN_TRANSIT, DELIVERED;
}

// Курьер
class Courier {
    private int id;
    private String name;

    public Courier(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

// Класс расчета ETA
class BasicETACalculator implements ETACalculator {
    @Override
    public int calculateETA(String location) {
        // (в минутах)
        return location.equals("далеко") ? 30 : 10;
    }
}

// Сервис назначения курьеров
public class CourierService {
    private Map<Integer, DeliveryStatus> deliveryStatusMap = new HashMap<>();

    public Courier assignCourier() {
        Courier courier = new Courier(1, "Айбек");
        deliveryStatusMap.put(courier.getId(), DeliveryStatus.ASSIGNED);
        return courier;
    }

    public void updateStatus(Courier courier, DeliveryStatus status) {
        deliveryStatusMap.put(courier.getId(), status);
    }

    public DeliveryStatus getStatus(Courier courier) {
        return deliveryStatusMap.getOrDefault(courier.getId(), DeliveryStatus.ASSIGNED);
    }
}


