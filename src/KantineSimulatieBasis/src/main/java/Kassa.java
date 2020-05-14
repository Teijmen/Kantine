package KantineSimulatieBasis.src.main.java;

import java.util.Iterator;

public class Kassa {

    private int aantalArtikelenKassa = 0;
    private double totaalBedragKassa = 0;

    /**
     * Constructor
     */
    public Kassa(KassaRij kassarij) {
       kassarij = new KassaRij();
    }

    /**
     * Vraag het aantal artikelen en de totaalprijs op. Tel deze gegevens op bij de controletotalen
     * die voor de kassa worden bijgehouden. De implementatie wordt later vervangen door een echte
     * betaling door de persoon.
     *
     * @param klant die moet afrekenen
     */
    public void rekenAf(Dienblad klant) {
        aantalArtikelenKassa += klant.getAantalArtikelen();
        totaalBedragKassa += klant.getTotaalPrijs();
    }

    /**
     * Geeft het aantal artikelen dat de kassa heeft gepasseerd, vanaf het moment dat de methode
     * resetWaarden is aangeroepen.
     *
     * @return aantal artikelen
     */
    public int aantalArtikelen() {
       return aantalArtikelenKassa;
    }

    /**
     * Geeft het totaalbedrag van alle artikelen die de kassa zijn gepasseerd, vanaf het moment dat
     * de methode resetKassa is aangeroepen.
     *
     * @return hoeveelheid geld in de kassa
     */
    public double hoeveelheidGeldInKassa() {
        return totaalBedragKassa;
    }

    /**
     * reset de waarden van het aantal gepasseerde artikelen en de totale hoeveelheid geld in de
     * kassa.
     */
    public void resetKassa() {
        totaalBedragKassa = 0;
        aantalArtikelenKassa = 0;
    }
}
