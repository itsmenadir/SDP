package nadir.OrderStatus;

public class InTransitState implements OrderState{
    @Override
    public void next(Order order) {
        System.out.println("Заказ в пути.");
        order.setState(new DeliveredState());
    }
}
