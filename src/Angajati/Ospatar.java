package Angajati;

import Comanda.Comanda;
import Restaurant.Masa;

import java.util.ArrayList;

public class Ospatar {
    private int id;
    private static int nrOspatari = 1;  //vreau ca fiecare ospatar creat sa aiba un ID unic
    private ArrayList<Comanda> listaComenzi;
    private ArrayList<Masa> listaMese;
    private ArrayList<Bucatar> listaBucatari;
    private ArrayList<Integer> meseAlocate;

    public Ospatar(ArrayList<Comanda> listaComenzi, ArrayList<Masa> listaMese, ArrayList<Bucatar> listaBucatari, ArrayList<Integer> meseAlocate) {
        this.id = nrOspatari;
        this.listaComenzi = listaComenzi;
        this.listaMese = listaMese;
        this.listaBucatari = listaBucatari;
        this.meseAlocate = meseAlocate;
        nrOspatari++;
    }

    public ArrayList<Integer> getMeseAlocate() {
        return meseAlocate;
    }

    public int getId() {
        return id;
    }

    public void adaugaComanda(Comanda c){
        listaComenzi.add(c);
    }

    public void adaugareMasaAlocata(int index){
        meseAlocate.add(index);
    }
    private void trimiteComandaLaBucatarie(){

    }
    private void actualizeazaMese(){

    }






}
