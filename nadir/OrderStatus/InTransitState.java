package nadir.OrderStatus;

public class InTransitState implements OrderState{
    @Override
    public void next(Order order) {
        System.out.println("Order In Transit");
        order.setState(new DeliveredState());
    }
}
