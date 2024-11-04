package nadir.OrderStatus;

public class PendingState implements OrderState {
    @Override
    public void next(Order order) {
        System.out.println("Order has been accepted");
        order.setState(new PreparingState());
    }

}
