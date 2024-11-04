package nadir.OrderStatus;
import java.util.ArrayList;
import java.util.List;


class Order {
    private OrderState state;
    private List<Observer> observers;

    public Order() {
        this.state = new PendingState();
        this.observers = new ArrayList<>();
    }

    public void setState(OrderState state) {
        this.state = state;
        notifyObservers();
    }

    public void nextState() {
        state.next(this);
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}
