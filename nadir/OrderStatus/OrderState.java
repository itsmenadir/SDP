package nadir.OrderStatus;

public interface OrderState {
    void next(Order order);
}
