// Базовый класс уведомлений
public class BasicNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Отправка базового уведомления: " + message);
    }
}
