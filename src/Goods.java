
//Per prima cosa ho creato una classe astratta 'Goods' da estendere a i beni da utilizzare nello shop
public abstract class Goods {

    //membri della classe

    //attributi
    private String brand;
    private String countryOfOrigin;
    private String idCode;
    private double price;
    private double discount;
    private double weight;


    //costruttori
    public Goods(String brand,String countryOfOrigin, double price, double weight,String idCode){
        this.brand = brand;
        this.countryOfOrigin = countryOfOrigin;
        if(price <= 0){this.price=100;}
        else{this.price = price;}
        this.idCode = idCode;
        this.weight = weight;
        this.discount = 0;
    }
    public Goods(Goods goods){
        this.price = goods.getPrice();
        this.brand = goods.getBrand();
        this.countryOfOrigin = goods.getCountryOfOrigin();
        this.weight = goods.getWeight();
        this.idCode = goods.getIdCode();
        this.discount = 0;
    }

    //metodi

    //metodo che ritorna il valore dello sconto da applicare
    public final double discountValue(){

        double discountValue = this.price * discount;
        if(discount == 0){return 0.0;}
        return discountValue;
    }

    //metodo a cui è applicato il precedente e che ritorna il prezzo finale
    public final double discountedPrice(){
        double discountedPrice = this.price - discountValue();
        return discountedPrice;

    }

    //override di equals che determina l'uguaglianza di due beni in base a parametri a mia scelta
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!(obj instanceof Goods)) return false;
        Goods goods = (Goods) obj;
        return brand.equals(goods.brand) && countryOfOrigin.equals(goods.countryOfOrigin)  && idCode.equals(goods.idCode) && weight == goods.weight;
    }
    //override di to string che riformatta la stringa che rappresenta la descrizione di un bene
    @Override
    public String toString() {
        return  this.getClass().getSimpleName() + ": " +
                "brand='" + brand + '\'' +
                ", country of origin='" + countryOfOrigin + '\'' +
                ", idCode='" + idCode + '\'' +
                ", price=" + price + "$" +
                ", discounted price=" + discountedPrice() + "$" +
                ", discount=" + discount * 100 + "%" +
                ", weight=" + weight + "g";
    }

    //getter e setter per modificare eventualmente un attributo dell'istanza
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getDiscount() {
        return discount;
    }
    public double getWeight() {
        return weight;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }
}
