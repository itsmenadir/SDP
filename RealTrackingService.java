// Основной класс отслеживания
public class RealTrackingService implements TrackingService {
    @Override
    public String getCourierLocation(int courierId) {
        // Реальный запрос к местоположению курьера
        return "Курьер находится на улице Абая, Алматы";
    }
}

