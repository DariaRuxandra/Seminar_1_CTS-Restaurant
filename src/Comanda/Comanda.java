package Comanda;

public abstract class Comanda {
    private int id;
    private static int nrComenzi = 1;
    private float valoare;

    public Comanda(float valoare) {
        this.id = nrComenzi;
        this.valoare = valoare;
        nrComenzi++;
    }

    public float getValoare() {
        return valoare;
    }
}
