package nadir.OrderStatus;

public class PreparingState implements OrderState{
    @Override
    public void next(Order order) {
        System.out.println("Заказ готовится.");
        order.setState(new InTransitState());
    }
}
