package Restaurant;

import java.util.HashMap;
import java.util.Map;

public class Meniu {
    private HashMap<String, Float> preparate;

    public Meniu(HashMap<String, Float> preparate) {
        this.preparate = preparate;
    }

    public void adaugaPreparat(String denumire, float pret){
        this.preparate.put(denumire,pret);
    }

    public HashMap<String, Float> getPreparate() {
        return preparate;
    }

    public void displayMenu(){
        System.out.println("\nWelcome to Restaurant Management System\n" +
                "1. Place an order at a table\n" +
                "2. Place a delivery order\n" +
                "3. View table status\n" +
                "4. View the status of the waiters\n" +
                "5. View kitchen status\n" +
                "6. Exit");
    }

    public static void afisarePreparate(HashMap<String, Float> optiuniMeniu){
        System.out.println("MENIU\n\n");
        for(Map.Entry<String, Float> entry : optiuniMeniu.entrySet())
            System.out.println("Denumire preparat: " + entry.getKey() + ", pret: " + entry.getValue() + " RON");

    }
}
