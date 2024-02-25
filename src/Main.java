import Angajati.Bucatar;
import Angajati.Ospatar;
import Comanda.ComandaDomiciliu;
import Restaurant.Masa;
import Restaurant.Meniu;
import Restaurant.Restaurant;

import java.util.*;

public class Main {
    static int nrMese = 7;
    static int nrOspatari = 2;
    static int nrBucatari = 2;
    static ArrayList<Masa> listaMese = new ArrayList<>();
    static ArrayList<Integer> meseDisponibile = new ArrayList<>();
    static ArrayList<Ospatar> listaOspatari = new ArrayList<>();
    static ArrayList<Bucatar> listaBucatari = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static HashMap<String, Float> optiuniMeniu = new HashMap<>();
    static Restaurant restaurant = new Restaurant(nrMese, nrBucatari, nrOspatari, listaMese, listaBucatari, listaOspatari);

    static Meniu meniu = new Meniu(optiuniMeniu);


    //aici fac verificari --> userul sa introduca un int, nu alte caractere
    public static int getUserInput(Scanner scanner){
        System.out.println("Your choice: ");
        try {
            int choice = scanner.nextInt();
            scanner.nextLine();
            return choice;
        }catch(InputMismatchException e){
            System.out.println("Invalid input. Please enter an integer.");
            scanner.nextLine();
            return getUserInput(scanner);
        }
    }

//    public static HashMap<String, Float> comanda(Scanner scanner){
//        HashMap<String, Float> comanda = null;
//        System.out.println("Alegeti o optiune din meniu: ");
//        String optiune = scanner.nextLine();
//        Float pret = optiuniMeniu.get(optiune);
//        float total = 0;
//        if(pret != null){
//            comanda.put(optiune, pret);
//            total+=pret;
//        }
//
//        return comanda;
//    }

    //functia asta trebuie utilizata atat pentru comenzi la domiciliu, cat si pentru comenzi in restaurant.
    //OPTIMIZARE!!!!!
    public static boolean finalulComenzii(Scanner scanner){
        boolean finalulComenzii = false;
        String continuareComanda = "a";   //variabila care ma ajuta sa verific daca utilizatorul introduce altceva decat ce vreau eu sa introduca, adica y sau n

        while(!continuareComanda.equals("n") && !continuareComanda.equals("y")){
            System.out.println("Mai doriti altceva? (y/n): ");
            continuareComanda = scanner.nextLine();

            if(continuareComanda.equals("n"))
                finalulComenzii = true;

            if(!continuareComanda.equals("n") || !continuareComanda.equals("y"))
                System.out.println("Introduceti una dintre optiunile: y sau n");
        }

        return finalulComenzii;
    }

    public static float comanda(Scanner scanner){
        boolean finalulComenzii = false;
        float total = 0;
        String optiune;
        while(!finalulComenzii){
            System.out.println("Alegeti o optiune din meniu: ");
            optiune = scanner.nextLine();
            System.out.println("Alegeti cantitatea: ");
            int cantitate = scanner.nextInt();
            scanner.nextLine();
            Float pret = optiuniMeniu.get(optiune);
            if(pret != null){
                total += pret*cantitate;
            }

            finalulComenzii = finalulComenzii(scanner);

        }
        return total;
    }

    public static void userInput(Scanner scanner){
        while(true){
            meniu.displayMenu();
            int choice = getUserInput(scanner);
            switch(choice){
                case 1:
                    System.out.println("Optiunea 1");
                    meniu.afisarePreparate(optiuniMeniu);
                    ArrayList<Integer> meseDisponibile = restaurant.afisareMeseDisponibile();
                    System.out.println("\n\nMesele disponibile sunt: " + meseDisponibile);
                    System.out.println("Alegeti o masa: ");
                    int masa = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Ati ocupat masa " + masa + "\n");
                    restaurant.ocupaMasa(masa);


                    //comanda mancare
                    float total = comanda(scanner);
                    System.out.println("Ati comandat in valoare de " + total + " RON");

                    break;
                case 2:
                    System.out.println("Delivery");
                    meniu.afisarePreparate(optiuniMeniu);
                    ComandaDomiciliu comandaDomiciliu = ComandaDomiciliu.delivery(scanner);
                    System.out.println("A fost livrata o comanda la adresa " + comandaDomiciliu.getDetaliiLivrare() + " cu valoarea " + comandaDomiciliu.getValoare() + " RON");
                    break;
                case 3:
                    System.out.println("Optiunea 3\n");
                    for(Masa m : listaMese)
                        System.out.println("Masa cu id-ul " + m.getId() + (m.isFree() ? " este libera" : " nu este libera"));
                    System.out.println("\n\n");
                    break;
                case 4:
                    System.out.println("Optiunea 4\n");
                    for(Ospatar o : listaOspatari){
                        System.out.println("Ospatarul " + o.getId() + " are mesele: " + o.getMeseAlocate());
                    }
                    break;
                case 5:
                    System.out.println("Optiunea 4");
                    break;
                case 6:
                    System.out.println("Ati parasit meniul.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }


    public static void main(String[] args) {

        restaurant.adaugareOspatari(nrOspatari);
        restaurant.alocareMeseOspatarilor(nrMese, nrOspatari, listaOspatari);
        restaurant.adaugareMese(nrMese);
        restaurant.adaugareBucatari(nrBucatari);

        optiuniMeniu.put("Paste", 40.0f);
        optiuniMeniu.put("Pizza", 35.0f);
        optiuniMeniu.put("Apa", 8.0f);
        optiuniMeniu.put("Cafea",15.0f);
        Meniu meniu = new Meniu(optiuniMeniu);

        userInput(scanner);
        scanner.close();
    }
}