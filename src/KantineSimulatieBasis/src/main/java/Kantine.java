package KantineSimulatieBasis.src.main.java;

public class Kantine {

    private Kassa kassa;
    private KassaRij kassarij;

    /**
     * Constructor
     */
    public Kantine() {
        kassarij = new KassaRij();
        kassa = new Kassa(kassarij);
    }

    /**
     * In deze methode wordt een Persoon en Dienblad gemaakt en aan elkaar gekoppeld. Maak twee
     * Artikelen aan en plaats deze op het dienblad. Tenslotte sluit de Persoon zich aan bij de rij
     * voor de kassa.
     */
    public void loopPakSluitAan() {
        // method body omitted
        Datum datum= new Datum(10, 10, 2002);
        Persoon persoon = new Persoon(123456, "Rick", "Johanens", datum, 'M');
        Dienblad dienblad = new Dienblad(persoon);
        Artikel artikel1 = new Artikel("banaan", 0.69f);
        Artikel artikel2 = new Artikel("Aubergine", 0.99f);
        dienblad.voegToe(artikel1);
        dienblad.voegToe(artikel2);
        kassarij.sluitAchteraan(dienblad);
    }

    /**
     * Deze methode handelt de rij voor de kassa af.
     */
    public void verwerkRijVoorKassa() {
        while (kassarij.erIsEenRij()) {
            Dienblad eerste = kassarij.eerstePersoonInRij();
            kassa.rekenAf(eerste);
        }
    }

    /**
     * Deze methode telt het geld uit de kassa
     *
     * @return hoeveelheid geld in kassa
     */
    public double hoeveelheidGeldInKassa() {
        // method body omitted
        // voor week 2
    }

    /**
     * Deze methode geeft het aantal gepasseerde artikelen.
     *
     * @return het aantal gepasseerde artikelen
     */
    public int aantalArtikelen() {
        // method body omitted
    }

    /**
     * Deze methode reset de bijgehouden telling van het aantal artikelen en "leegt" de inhoud van
     * de kassa.
     */
    public void resetKassa() {
        // method body omitted
    }
}
