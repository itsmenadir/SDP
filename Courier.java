public class Courier implements User {
    @Override
    public void login() {
        System.out.println("Courier logged in.");
    }

    @Override
    public void logout() {
        System.out.println("Courier logged out.");
    }
}