//Creo una nuova subclasse di goods per istanziare l'abbigliamento
public class Clothing extends Goods{

    //enum per la taglia
    private ClothingSize size;
    private String material;
    //enum per la tipologia
    private ClothingType type;

    //costruttori
    public Clothing(String brand, String countryOfOrigin, double price, double weight, String idCode, ClothingSize size, String material,ClothingType type) {
        super(brand, countryOfOrigin, price, weight, idCode);
        super.setDiscount(0.2);
        this.size = size;
        this.material = material;
        this.type = type;
    }

    public Clothing(Clothing clo) {
        super(clo);
        super.setDiscount(0.2);
        this.size = clo.getSize();
        this.material = clo.getMaterial();
        this.type = clo.getType();
    }

    //getter

    public ClothingSize getSize() {
        return size;
    }

    public String getMaterial() {
        return material;
    }

    public ClothingType getType() {
        return type;
    }

    @Override
    public String toString() {
        return super.toString() + " " +
                "size=" + size +
                ", material='" + material + '\'' +
                ", type=" + type
                ;
    }
}
