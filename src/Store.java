import java.time.LocalDate;
import java.util.ArrayList;

// ho creato la classe 'store' dove  per implementare il magazzino del catalogo
public class Store {
    private static LocalDate date = LocalDate.now();
    private ArrayList<Goods> store;//ho creato un arraylist della classe generica 'Goods' cosi da poter aggiungere qualsiasi sua subclasse grazie al polimorfismo di java
    private int numGoods;// ho anche creato un contatore che tenesse conto dei prodotti presenti all'interno del magazzino
    private static int currentYear = date.getYear();// ho creato la variabile current year per controllare l'anno corrente
    //ho cercato nella documentazione come fare ad importare "LocalDate" per utilizzarlo all'interno di "Store"

    //Costruttori:

    //Costruttore default
    Store() {
        this.store = new ArrayList<>();
        numGoods = 0;
    }

    //Costruttori parametrici
    Store(ArrayList<Goods> store) {
        this.store = new ArrayList<>(store);
        numGoods = 0;
        for (int i = 0; i < store.size(); i++) {
            if (store.get(i) != null) {
                numGoods++;
            }
        }
    }

    Store(Store s) {
        this.store = new ArrayList<>(s.getStore());
        this.numGoods = s.getNumGoods();
    }


    // ho creato il metodo "addGood" per immettere in magazzino i prodotti,
    // ho tenuto conto del fatto che ogni prodotto deve avere un codice identificativo univoco,
    // quindi nessun prodotto sarà mai davvero uguale ad un altro ,inoltre ,per la subclasse "Food" ho tenuto conto della data di scadenza
    public boolean addGoods(Goods g) {
        if (g == null) {
            return false;
        } else if (store.contains(g)) {
            return false;
        } else if(g instanceof Food && ((Food) g).getExpirationYear() < currentYear){
            return false;
        } else {
            for (Goods good : store) {
                if (good.getIdCode().equals(g.getIdCode())) {
                    return false;
                }
            }
            this.store.add(g);
            numGoods++;
            return true;
        }
    }

    //get goods permette di prendere una copia del prodotto ,cosi da utilizzarla nel carrello senza rimuoverla dal magazzino durante l'aquisto
    public Goods getGoodsFromStore(Goods g) {
        if (store.contains(g)) {
            for (int i = 0; i < store.size(); i++) {
                if (store.get(i).equals(g)) {
                    return store.get(i);
                }
            }
        }
        return null;
    }

    //L'overload di get goods permette di prendere una copia del prodotto , utilizzando il codiceID univoco del prodotto
    public Goods getGoodsFromStore(String s) {

        for (int i = 0; i < store.size(); i++) {
            if (store.get(i).getIdCode().equals(s.toUpperCase().strip())) {// utilizzo i metodi delle stringhe ".toUppercase"
                // e ".strip" per evitare errori di inserimento dell'id
                return store.get(i);
            }
        }
        return null;
    }

    //"remove Goods" permetter di rimuovere un prodotto dal magazzino
    public Goods removeGoods(Goods g) {
        if (store.contains(g)) {
            for (int i = 0; i < store.size(); i++) {
                if (store.get(i).equals(g)) {
                    Goods removeG = store.get(i);
                    store.remove(i);
                    numGoods--;
                    return removeG;
                }
            }
        }
        return null;
    }

    // dopo aver finalizzato l'ordine,"sendOrder" permette di prelevare tutti i prodotti dal magazzino così da inviarli al cliente
    public boolean sendOrder(ArrayList<Goods> cart) {
        if (cart != null) {
            if (store.containsAll(cart)) {
                numGoods -= cart.size();
                return store.removeAll(cart);
            }
        }
        return false;
    }

    public ArrayList<Goods> getStore() {
        return store;
    }

    public int getNumGoods() {
        return numGoods;
    }

    public static LocalDate getDate() {
        return date;
    }

    public static int getCurrentYear() {
        return currentYear;
    }

    // ho deciso di modificare il toString del magazzino utilizzando prima il
    // metodo "stroreToString" così da organizzare meglio l'interfaccia visiva dell'Arraylist 'store'
    public String storeToString() {
        String s = "Catalogo prodotti: \n";
        for (Goods good : store) {
            s += good.toString() + "\n";
        }
        return s;
    }

    @Override
    public String toString() {
        return  "Data: " + date + "\n" +
                "Numero Prodotti in catalogo: " + numGoods + "\n" +
                storeToString();
    }
}
