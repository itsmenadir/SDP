public class CourierFactory extends UserFactory {
    @Override
    public User createUser() {
        return new Courier();
    }
}