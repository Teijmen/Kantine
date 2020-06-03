package KantineSimulatieBasis.src.main.java;

import java.util.LinkedList;

public class KassaRij {

    private LinkedList<Dienblad> rij;

    /**
     * Constructor
     */
    public KassaRij() {
        rij = new LinkedList<>(); // nieuwe rij
    }

    /**
     * Persoon sluit achter in de rij aan
     *
     * @param klant
     */
    public void sluitAchteraan(Dienblad klant) {
        rij.add(klant);
    }

    /**
     * Indien er een rij bestaat, de eerste klant uit de rij verwijderen en retourneren. Als er
     * niemand in de rij staat geeft deze null terug.
     *
     * @return Eerste klant in de rij of null
     */
    public Dienblad eerstePersoonInRij() {
        if(erIsEenRij()){
            Dienblad eerstePersoon = rij.get(0); //eerste in de arrayList
            rij.remove(0);  //verwijder persoon uit de rij
            return eerstePersoon;
        }
        return null;
    }

    /**
     * Methode kijkt of er personen in de rij staan.
     *
     * @return Of er wel of geen rij bestaat
     */
    public boolean erIsEenRij() {
       if(rij.size() < 1){
           return false;
       }
       return true;
    }
}
