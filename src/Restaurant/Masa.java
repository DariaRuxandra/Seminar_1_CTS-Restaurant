package Restaurant;

import Comanda.Comanda;

public class Masa {
    private int id;
    private static int nrMese = 1;
    private boolean isFree; //variabila ce imi spune daca masa este ocupata sau nu
    Comanda comanda;

    public Masa(boolean isFree, Comanda c) {
        this.id = nrMese;
        this.isFree = isFree;
        this.comanda = c;
        nrMese++;
    }

    public Masa(boolean isFree) {
        this.id = nrMese;
        this.isFree = isFree;
        nrMese++;
    }

    public int getId() {
        return id;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }
}
