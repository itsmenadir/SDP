package nadir.OrderStatus;

public class DeliveredState implements OrderState{
    @Override
    public void next(Order order) {
        System.out.println("Order is delivered");
    }
}
