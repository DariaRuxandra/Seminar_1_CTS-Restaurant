package Comanda;

import java.util.Scanner;

public class ComandaDomiciliu extends Comanda{
    private String detaliiLivrare;

    public ComandaDomiciliu(float valoare, String detaliiLivrare) {
        super(valoare);
        this.detaliiLivrare = detaliiLivrare;
    }
    public String getDetaliiLivrare() {
        return detaliiLivrare;
    }

    public static ComandaDomiciliu delivery(Scanner scanner) {
        System.out.println("Introduceti adresa la care sa fie facuta livrarea: ");
        try {
            String detaliiLivrare = scanner.nextLine();
            //procesare comanda -> ca sa afli valoarea
            //cred ca trebuie sa fac o metoda de calculare total in clasa Ospatar
            ComandaDomiciliu comandaDomiciliu = new ComandaDomiciliu(10, detaliiLivrare);
            return comandaDomiciliu;
        } catch (Exception e) {
            System.out.println("A aparut o eroare. Incercati din nou!");
            scanner.nextLine(); // Consume the newline character
            return delivery(scanner);
        }
    }
}
