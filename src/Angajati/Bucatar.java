package Angajati;

import Comanda.Comanda;

import java.util.ArrayList;

public class Bucatar {
    private int id;
    private static int nrBucatari = 1;
    private int experienta;
    private int nrComenzi;
    private ArrayList<Comanda> listaComenzi;

    public Bucatar(int experienta, int nrComenzi, ArrayList<Comanda> listaComenzi) {
        this.id = nrBucatari;
        this.experienta = experienta;
        this.nrComenzi = nrComenzi;
        this.listaComenzi = listaComenzi;
        nrBucatari++;
    }

    public int getExperienta() {
        return experienta;
    }

    public void setExperienta(int experienta) {
        this.experienta = experienta;
    }

    public int getNrComenzi() {
        return nrComenzi;
    }

    public void setNrComenzi(int nrComenzi) {
        this.nrComenzi = nrComenzi;
    }

    private void proceseazaComanda(){
        experienta += 1;
    }

}
