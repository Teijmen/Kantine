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
    public void rekenAf(Dienblad klant){

        Betaalwijze betaalwijze = klant.getKlant().getBetaalwijze(); // check de betaalwijze van de klant
        double teBetalen = 0; // totaal bedrag op dienblad
        double kortingDoorDagAanbieding = 0;
        int aantalProducten = 0;

        Iterator<Artikel> it = klant.getDienblad();
        while(it.hasNext()){
            Artikel a = it.next();
            teBetalen += a.getPrijs();
            if(a.getKorting() > 0){
                teBetalen -= a.getKorting();
                kortingDoorDagAanbieding += a.getKorting();
            }
            aantalProducten++;
        }

        Persoon persoon = klant.getKlant(); // de klant

        // korting berekenen

        if(persoon instanceof KortingskaartHouder){
            KortingskaartHouder klantMetKorting = (KortingskaartHouder) persoon; // casten

            if(klantMetKorting.heeftMaximum()){
                if((klantMetKorting.geefKortingsPercentage()*teBetalen)/100 < klantMetKorting.geefMaximum()){
                    teBetalen -= (klantMetKorting.geefKortingsPercentage()*teBetalen)/100 + kortingDoorDagAanbieding; // haal korting van het bedrag af
                }else{
                    teBetalen -= klantMetKorting.geefMaximum() + kortingDoorDagAanbieding; // haal max van het bedrag af
                }
            }else{
                teBetalen -= (klantMetKorting.geefKortingsPercentage()*teBetalen)/100 + kortingDoorDagAanbieding; // haal korting van het bedrag af
            }
        }

        // betalen

        try{
            betaalwijze.betaal(teBetalen);
            totaalBedragKassa += teBetalen; // tel het bedrag bij het totaal op
            aantalArtikelenKassa += aantalProducten; // tel het aantal producten van deze klant bij het totaal op
        }catch(TeWeinigGeldException e){
            System.out.println(e + klant.getKlant().getVoornaam() + " " + klant.getKlant().getAchternaam());
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
