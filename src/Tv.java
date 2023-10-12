//prima subclasse di eletronics
public class Tv extends Electronics {

    //nuovo attributo screen size
    private int screenSize;

    //costruttori
    public Tv(String brand, String countryOfOrigin, double price, double weight, String idCode, PowerSupply powerSupply, int screenSize) {
        super(brand, countryOfOrigin, price, weight, idCode, powerSupply);
        this.screenSize = screenSize;
    }

    public Tv(Tv tv) {
        super(tv);
        this.screenSize = tv.getScreenSize();
    }

    public int getScreenSize() {
        return screenSize;
    }

    //override to string per aggiungere nuovo attributo
    @Override
    public String toString() {
        return super.toString() + " " +
                "screen size=" + screenSize;
    }
}
