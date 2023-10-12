//seconda subclasse di elettronics
public class Phone extends Electronics {


    private int screenSize;
    private boolean touchscreen;

    public Phone(String brand, String countryOfOrigin, double price, double weight, String idCode, PowerSupply powerSupply, int screenSize, boolean touchscreen) {
        super(brand, countryOfOrigin, price, weight, idCode, powerSupply);
        this.screenSize = screenSize;
        this.touchscreen = touchscreen;
    }

    public Phone(Phone phone) {
        super(phone);
        this.screenSize = phone.getScreenSize();
        this.touchscreen = phone.touchscreen;
    }

    public int getScreenSize() {
        return screenSize;
    }

    @Override
    public String toString() {
        return super.toString() + " " +
                "screen size=" + screenSize + " " +
                "Touchscreen=" + touchscreen;
    }
}