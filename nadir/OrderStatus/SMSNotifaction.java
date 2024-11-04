package nadir.OrderStatus;

import java.util.Observable;

public class SMSNotifaction implements Observer{
    @Override
    public void update(Order Order) {
        System.out.println("SMS notifaction about order");
    }
}
