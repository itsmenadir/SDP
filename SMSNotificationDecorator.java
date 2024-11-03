// Декоратор для SMS уведомлений
public class SMSNotificationDecorator implements Notification {
    private Notification notification;

    public SMSNotificationDecorator(Notification notification) {
        this.notification = notification;
    }

    @Override
    public void send(String message) {
        notification.send(message);
        System.out.println("Отправка SMS уведомления: " + message);
    }
}

