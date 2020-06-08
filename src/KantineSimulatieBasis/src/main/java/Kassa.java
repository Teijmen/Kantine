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

        Betaalwijze betaalwijze = klant.getKlant().getBetaalwijze(); // check de betaalwijze van de klant
        double teBetalen = 0; // totaal bedrag op dienblad
        int aantalProducten = 0;

        Iterator<Artikel> it = klant.getDienblad();
        while(it.hasNext()){
            Artikel a = it.next();
            teBetalen += a.getPrijs();
            aantalProducten++;
        }

        Persoon persoon = klant.getKlant(); // de klant

        // korting berekenen

        // check of het een docent is
        if(persoon instanceof Docent){
            Docent docent = (Docent) persoon; // cast naar docent

            //check of er een maximum is en onder het maximum blijft
            if(docent.heeftMaximum() && ((docent.geefKortingsPercentage()*teBetalen)/100 < docent.geefMaximum())){
                teBetalen -= (docent.geefKortingsPercentage()*teBetalen)/100; // haal korting van het te balen bedrag af
            }else{
                teBetalen -= docent.geefMaximum(); // haal maximale korting van het bedrag af
            }
        }

        // check of het een kantinemedewerker is
        else if(persoon instanceof KantineMedewerker){
            KantineMedewerker kantineMedewerker = (KantineMedewerker) persoon;
            teBetalen = (kantineMedewerker.geefKortingsPercentage()*teBetalen)/100;
        }

        // betalen

        try{
            betaalwijze.betaal(teBetalen);
            totaalBedragKassa += teBetalen; // tel het bedrag bij het totaal op
            aantalArtikelenKassa += aantalProducten; // tel het aantal producten van deze klant bij het totaal op
        }catch(TeWeinigGeldException e){
            System.out.println(e+ klant.getKlant().getVoornaam() + " " + klant.getKlant().getAchternaam());
        }
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
