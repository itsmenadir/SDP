import java.util.List;

public class Menu {
    private String restaurantName;
    private List<String> dishes;
    private List<Double> prices;
    private boolean isAvailable;

    private Menu(MenuBuilder builder) {
        this.restaurantName = builder.restaurantName;
        this.dishes = builder.dishes;
        this.prices = builder.prices;
        this.isAvailable = builder.isAvailable;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "restaurantName='" + restaurantName + '\'' +
                ", dishes=" + dishes +
                ", prices=" + prices +
                ", isAvailable=" + isAvailable +
                '}';
    }

    public static class MenuBuilder {
        private String restaurantName;
        private List<String> dishes;
        private List<Double> prices;
        private boolean isAvailable;

        public MenuBuilder(String restaurantName) {
            this.restaurantName = restaurantName;
        }

        public MenuBuilder setDishes(List<String> dishes) {
            this.dishes = dishes;
            return this;
        }

        public MenuBuilder setPrices(List<Double> prices) {
            this.prices = prices;
            return this;
        }

        public MenuBuilder setAvailable(boolean isAvailable) {
            this.isAvailable = isAvailable;
            return this;
        }

        public Menu build() {
            return new Menu(this);
        }
    }
}

