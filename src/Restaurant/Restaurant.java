package Restaurant;

import Angajati.Bucatar;
import Angajati.Ospatar;

import java.util.ArrayList;

public class Restaurant {
    private int id;
    private static int nrRestaurante = 1;
    private int nrMese, nrBucatari, nrOspatari;
    ArrayList<Masa> listaMese;
    ArrayList<Bucatar> listaBucatari;
    ArrayList<Ospatar> listaOspatari;

    public Restaurant(int nrMese, int nrBucatari, int nrOspatari, ArrayList<Masa> listaMese, ArrayList<Bucatar> listaBucatari, ArrayList<Ospatar> listaOspatari) {
        this.id = nrRestaurante;
        this.nrMese = nrMese;
        this.nrBucatari = nrBucatari;
        this.nrOspatari = nrOspatari;
        this.listaMese = listaMese;
        this.listaBucatari = listaBucatari;
        this.listaOspatari = listaOspatari;
        nrRestaurante++;
    }

    //in functia aceasta, am vrut sa aloc dinamic mese ospatarilor, in functie de nr de mese si de ospatari. In cazul in care calculul nu da perfect, cum ar fi spre exemplu 6 mese / 2 ospatari = 3 mese per opatar, am calculat variabila meseRamase, si le aloc primului ospatar. Estimez ca, in medie, ar ramane o masa in plus unui ospatar
    public void alocareMeseOspatarilor(int nrMese, int nrOspatari, ArrayList<Ospatar> listaOspatari){
        //pe premisa ca, logic, mereu vor exista mai putini ospatari decat mese intr-un restaurant
        int indexMasa = 0;
        int nrDeMesePerOspatar = nrMese / nrOspatari;
        int meseRamase = nrMese % nrOspatari;
//        int nrClustere = nrMese / nrDeMesePerOspatar;
        for(int i=0;i<nrOspatari;i++){
            int nrAlocatDeMese = nrDeMesePerOspatar;

            if(meseRamase > 0){
                nrAlocatDeMese++;
                meseRamase--;
            }

            for(int j=0;j<nrAlocatDeMese;j++){
                listaOspatari.get(i).adaugareMasaAlocata(++indexMasa);
            }
        }
    }
    public void adaugareMese(int nrMese){
        for(int i=0;i<nrMese;i++){
            Masa m = new Masa(true);
            listaMese.add(m);
        }
    }

    public void adaugareBucatari(int nrBucatari){
        for(int i=0;i<nrBucatari;i++){
            Bucatar bucatar = new Bucatar(1, 0, new ArrayList<>());
            listaBucatari.add(bucatar);
        }
    }

    public void adaugareOspatari(int nrOspatari){
        for(int i=0;i<nrOspatari;i++){
            Ospatar ospatar = new Ospatar(new ArrayList<>(), new ArrayList<>(), listaBucatari, new ArrayList<>());
            listaOspatari.add(ospatar);
        }
    }

    public ArrayList<Integer> afisareMeseDisponibile(){
        ArrayList<Integer> meseDisponibile = new ArrayList<>();
        for(Masa masa : listaMese){
            if(masa.isFree())
                meseDisponibile.add(masa.getId());
        }
        return meseDisponibile;
    }

    //Asta ar merge mai bine sa fie in clasa OSPATAR, vezi cum rezolvi
    public void ocupaMasa(int id){
        listaMese.get(id-1).setFree(false);
    }
}
