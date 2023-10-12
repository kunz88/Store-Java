// Dopo aver ultimato Goods ho scelto di implementare un altra classe Astratta genitore dei beni elettronici
public abstract class Electronics extends Goods{

    //ho introdotto un nuovo attributo enum per distinguere i prodotti a batteria da quelli a corrente alternata.
    private PowerSupply powerSupply;

    public Electronics(String brand, String countryOfOrigin, double price, double weight, String idCode,PowerSupply powerSupply) {
        super(brand, countryOfOrigin, price, weight, idCode);
        this.powerSupply = powerSupply;
        super.setDiscount(0.1);// nei costruttori ho scelto di settare lo sconto al 10% così che tutte le subclassi possano avere lo stesso sconto
    }

    public Electronics(Electronics electronic) {
        super(electronic);
        this.powerSupply = electronic.getPowerSupply();
        super.setDiscount(0.1);
    }
    //getter di power supply
    public PowerSupply getPowerSupply() {
        return powerSupply;
    }

    //override del metodo toString cosi da aggiungere il nuovo attributo alle subclassi
    @Override
    public String toString() {
        return super.toString() + " " +
                "power supply=" + powerSupply
                ;
    }
}
