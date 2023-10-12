import java.util.ArrayList;

// ho creato la classe 'Order' per progettare le istanze degli ordini
//è simile alla classe 'Store' in molti metodi, anche se conserva delle differenze sostanziali negli scopi,per questo ho
// deciso di creare una classe differente invece di una subclass di 'Store'

public class Order {

    //Ho creato un Arraylist "shoppingCart" da utilizzare per contenere i prodotti
    private ArrayList<Goods> shoppingCart;
    private int numGoods; // tiene il conto del numero dei prodotti presenti nel carrello
    private double totalBill; // tiene il conto del saldo totale del carrello
    private double totalDiscount; // tiene il conto del saldo totale dello sconto

    private static int numOrder = 0;// attributo statico di "Order",identifica il numero di ordini istanziati


    //costruttore
    public Order() {
        this.shoppingCart = new ArrayList<>();
        this.totalBill = 0;
        this.totalDiscount = 0;
        this.numGoods = 0;
        numOrder++;
    }

    //metodo che permette di aggiungere un prodotto nel carrello,essendo tutti i prodotti diversi per via dell'IDcode
    //non può aggiungere due volte lo stesso prodotto
    public boolean addProduct(Goods product) {
        if (product == null) {
            return false;
        } else if (shoppingCart.contains(product)) {
            return false;
        } else {
            shoppingCart.add(product);
            totalBill += product.discountedPrice();
            totalDiscount += product.discountValue();
            numGoods++;
            return true;
        }
    }

    //metodo che rimuove un prodotto dal carrello
    public Goods removeProduct(Goods product) {
        if (shoppingCart.contains(product)) {
            for (int i = 0; i < shoppingCart.size(); i++) {
                if (shoppingCart.get(i).equals(product)) {
                    Goods removeG = shoppingCart.get(i);
                    shoppingCart.remove(i);
                    totalBill -= product.discountedPrice();
                    totalDiscount -= product.discountValue();
                    numGoods--;
                    return removeG;
                }
            }
        }
        return null;
    }
    public Goods removeProduct(String s) {
            for (int i = 0; i < shoppingCart.size(); i++) {
                if (shoppingCart.get(i).getIdCode().equals(s.toUpperCase().strip())) {
                    Goods removeG = shoppingCart.get(i);
                    shoppingCart.remove(i);
                    totalBill -= removeG.discountedPrice();
                    totalDiscount -= removeG.discountValue();
                    numGoods--;
                    return removeG;
                }
            }
        return null;
    }

    //metodo che svuota tutto il carrello
    public boolean clearShoppingCart() {
        if (shoppingCart.size() > 0) {
            shoppingCart.clear();
            totalBill = 0;
            totalDiscount = 0;
            numGoods = 0;
            return true;
        }
        return false;
    }

    public ArrayList<Goods> getShoppingCart() {
        return shoppingCart;
    }

    public int getNumGoods() {
        return numGoods;
    }

    public double getTotalBill() {
        return totalBill;
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }

    // come per "Store" ho scelto di modificare la struttura della stringa dell'Arraylist
    private String cartToString() {
        String s = "Carrello prodotti: \n";
        for (Goods good : shoppingCart) {
            s += good.toString() + "\n";
        }
        return s;
    }

    @Override
    public String toString() {
        return cartToString() +
                "\nOrdine numero: " + numOrder +
                "\nNumero prodotti: " + numGoods +
                "\nSconto: " + totalDiscount +
                "\nTotale: " + totalBill;
    }
}
