public class Food extends Goods {

    private FoodType type;
    private int expirationYear;

    public Food(String brand, String countryOfOrigin, double price, double weight, String idCode, FoodType type, int expirationYear) {
        super(brand, countryOfOrigin, price, weight, idCode);
        this.type = type;
        this.expirationYear = expirationYear;
    }

    public Food(Food food) {
        super(food);
        this.type = food.getType();
        this.expirationYear = food.expirationYear;
    }

    public FoodType getType() {
        return type;
    }

    public int getExpirationYear() {
        return expirationYear;
    }

    @Override
    public String toString() {
        return super.toString() + " " +
                "type=" + type +
                ", expirationYear=" + expirationYear;
    }
}
