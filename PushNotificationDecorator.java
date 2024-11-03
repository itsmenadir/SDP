// Декоратор для Push уведомлений
public class PushNotificationDecorator implements Notification {
    private Notification notification;

    public PushNotificationDecorator(Notification notification) {
        this.notification = notification;
    }

    @Override
    public void send(String message) {
        notification.send(message);
        System.out.println("Отправка Push уведомления: " + message);
    }
}   
