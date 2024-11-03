// Proxy для кэширования данных о местоположении
public class TrackingServiceProxy implements TrackingService {
    private RealTrackingService realTrackingService;
    private String cachedLocation;
    private int lastCourierId;

    public TrackingServiceProxy(RealTrackingService realTrackingService) {
        this.realTrackingService = realTrackingService;
    }

    @Override
    public String getCourierLocation(int courierId) {
        if (courierId != lastCourierId || cachedLocation == null) {
            cachedLocation = realTrackingService.getCourierLocation(courierId);
            lastCourierId = courierId;
        }
        return cachedLocation;
    }
}
