package nadir.OrderStatus;

public class Main {
    public static void main(String[] args) {
        Order order = new Order();
        order.addObserver(new SMSNotifaction());

        order.nextState();
        order.nextState();
        order.nextState();
        order.nextState();
    }
}