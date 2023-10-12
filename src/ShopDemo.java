/*Gestione di un Negozio Online
• Descrizione del problema:
Un negozio online desidera gestire il catalogo dei prodotti disponibili e i relativi
ordini effettuati dai clienti. I prodotti possono essere di diversi tipi, come
abbigliamento, elettronica e alimentari. Il negozio desidera che tu implementi una
soluzione orientata agli oggetti utilizzando l'incapsulamento e l'ereditarietà per
gestire i prodotti e gli ordini. Per tutti i prodotti deve essere possibile calcolare un
prezzo scontato che varia in base alla tipologia di prodotto:
• Per l’abbigliamento deve applicare uno sconto del 20% al prezzo del prodotto;
• Per l’elettronica deve applicare uno sconto del 10% al prezzo del prodotto;
• Per gli alimentari non applica alcuno sconto.
Inoltre, deve essere possibile gestire gli ordini, all’interno dei quali sono presenti i
prodotti. Per ogni ordine deve essere possibile aggiungere prodotti, rimuovere
prodotti, calcolare il totale dell’ordine, comprensivo di sconto ove previsto, e vedere
quali prodotti sono presenti all’interno dell’ordine.
Ricorda:
1. Scrivi il codice nel modo più pulito e leggibile possibile, utilizzando i principi
della programmazione orientata agli oggetti.
2. Se possibile, commenta il tuo codice in modo appropriato per spiegare le scelte
che hai fatto e il funzionamento del programma.
3. Assicurati di utilizzare nomi significativi per le variabili e i metodi, e di formattare
correttamente il codice secondo le convenzioni di scrittura di Java.
4. È preferibile l’utilizzo del System.out solo all’interno del main.*/


public class ShopDemo {
    public static void main(String[] args) {
        //Creo tutte le istanze dei prodotti da immagazzinare e catalogare

        Tv ob1 = new Tv("Sony", "Japan", 120, 80, "ID745", PowerSupply.AC, 700);
        Phone ob2 = new Phone("Apple", "US", 600, 200, "ID345", PowerSupply.BATTERY, 130, true);
        Phone ob3 = new Phone("Apple", "US", 600, 200, "ID346", PowerSupply.BATTERY, 130, true);
        Phone ob4 = new Phone("Apple", "US", 600, 200, "ID347", PowerSupply.BATTERY, 130, true);
        Clothing ob5 = new Clothing("Nike", "Cina", 50, 20, "ID456", ClothingSize.XS, "Cotton", ClothingType.JEANS);
        Clothing ob6 = new Clothing("Nike", "Cina", 50, 20, "ID457", ClothingSize.XS, "Cotton", ClothingType.JEANS);
        Clothing ob7 = new Clothing("Nike", "Cina", 50, 20, "ID458", ClothingSize.XS, "Cotton", ClothingType.JEANS);
        Clothing ob8 = new Clothing("Nike", "Cina", 50, 20, "ID459", ClothingSize.XS, "Cotton", ClothingType.JEANS);
        Food ob9 = new Food("Nestle", "Olanda", 10, 200, "ID256", FoodType.PIZZA, 2023);
        Food ob10 = new Food("Danone", "Italia", 9, 100, "ID257", FoodType.PASTA, 2025);
        Food ob11 = new Food("Nestle", "Belgio", 10, 200, "ID258", FoodType.CAKE, 2023);
        Food ob12 = new Food("Danone", "Malta", 11, 250, "ID259", FoodType.PIZZA, 2024);
        Food ob13 = new Food("Danone", "Austria", 13, 254, "ID259", FoodType.CAKE, 2025);
        Food ob14 = new Food("Danone", "Italia", 10, 254, "ID260", FoodType.CAKE, 2020);

        //Creo il magazzino
        Store storage = new Store();

        //Inserisco tutti i prodotti in magazzino
        storage.addGoods(ob1);
        storage.addGoods(ob2);
        storage.addGoods(ob3);
        storage.addGoods(ob4);
        storage.addGoods(ob5);
        storage.addGoods(ob6);
        storage.addGoods(ob7);
        storage.addGoods(ob8);
        storage.addGoods(ob9);
        storage.addGoods(ob10);
        storage.addGoods(ob11);
        storage.addGoods(ob12);

        //Requisito indispensabile per essere aggiunti in magazzino è avere
        //un codice univoco diverso da quelli già presenti nel catalogo ,questo rende tutti gli oggetti  introducibili in magazzino differenti.
        //Ho scelto comunque di usare gli Arraylist invece dei Set per scegliere io l'unico criterio di differenziazione tra oggetti e fare io i controlli.
        storage.addGoods(ob13);//impossibile inserire ob13 perché l'oggetto ha la stessa id di ob12

        // Nel caso della subclasse food ho scelto di inserire la data di scadenza per evitare di inserire un oggetto scaduto in magazzino
        storage.addGoods(ob14);// impossibile inserire ob14 perchè scaduto


        //Stampo il catalogo dello shop
        System.out.println();
        System.out.println("****Stampo catalogo shop****");
        System.out.println();
        System.out.println(storage);

        //Creo un nuovo ordine
        System.out.println();
        System.out.println("****Creo nuovo ordine e lo stampo****");
        System.out.println();
        Order firstOrder = new Order();
        firstOrder.addProduct(storage.getGoodsFromStore("ID256"));
        firstOrder.addProduct(storage.getGoodsFromStore("ID257"));
        firstOrder.addProduct(storage.getGoodsFromStore("ID458"));
        // rimuovo un elemento dal carrello utilizzando l'id (overload metodo removeProduct)
        firstOrder.removeProduct("ID256");

        // aggiungo un altro prodotto
        firstOrder.addProduct(storage.getGoodsFromStore(ob1));

        //mando a scermo il carrello
        System.out.println(firstOrder);


        //ordine andato a buon fine prelevo tutti i prodotti dal magazzino

        if (storage.sendOrder(firstOrder.getShoppingCart())) {
            System.out.println();
            System.out.println("****Ordine inviato****");
            System.out.println();
            //Svuoto il carrello
            firstOrder.clearShoppingCart();
            System.out.println(firstOrder);
        } else {
            System.out.println();
            System.out.println("****Ordine rifiutato****");
            System.out.println();
        }


        //Ristampo il catalogo aggiornato
        System.out.println();
        System.out.println("Stampo catalogo shop aggiornato: ");
        System.out.println();
        System.out.println("****Stampo catalogo shop****");
        System.out.println(storage);

        //Creo un nuovo ordine
        System.out.println();
        System.out.println("****Creo nuovo ordine e lo stampo****");
        System.out.println();
        Order secondOrder = new Order();

        // sbaglio a digitare l'ID per verificare il funzionamento di "getGoodsFromStore"
        secondOrder.addProduct(storage.getGoodsFromStore(" id259 "));
        System.out.println(secondOrder);

        // decido di non finalizzare l'ordine e rimuovo la merce dal carrello
        secondOrder.clearShoppingCart();
        System.out.println();
        System.out.println(secondOrder);

        //Stampo il catalogo dello shop
        System.out.println();
        System.out.println("****catalogo shop****");
        System.out.println();
        System.out.println(storage);


    }

}
