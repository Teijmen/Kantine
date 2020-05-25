package KantineSimulatieBasis.src.main.java;

public class Kantine {

    private Kassa kassa;
    private KassaRij kassarij;
    private KantineAanbod kantineAanbod;

    private double[] prijzen = new double[] {1.50, 2.10, 1.65, 1.65};
    private int[] hoeveelheid = new int[] {15, 5, 25};
    /**
     * Constructor
     */
    public Kantine() {
        kassarij = new KassaRij();
        kassa = new Kassa(kassarij);
    }

    /**
     * Deze methode voegt artikelen toe aan een dienblad en sluit vervolgens
     * achteraan in de rij
     * @param dienblad Een dienblad
     * @param artikelnamen Een array met alle artikelnamen
     */
    public void loopPakSluitAan(Dienblad dienblad, String[] artikelnamen) {

        kantineAanbod = new KantineAanbod(artikelnamen, prijzen, hoeveelheid);
        setKantineAanbod(kantineAanbod);

        for(int i = 0; i < artikelnamen.length-1; i++) {
            dienblad.voegToe(kantineAanbod.getArtikel(artikelnamen[i]));
        }
    }

    /**
     * Deze methode handelt de rij voor de kassa af.
     */
    public void verwerkRijVoorKassa() {
        while (kassarij.erIsEenRij()) {
            kassa.rekenAf(kassarij.eerstePersoonInRij());
        }
    }

    /**
     * Deze methode telt het geld uit de kassa
     *
     * @return hoeveelheid geld in kassa
     */
    public String getDagTotalen() {
        return "Aantal artikelen: " + kassa.aantalArtikelen() + " \n Hoeveelheid geld: " + kassa.hoeveelheidGeldInKassa();
    }

    /**
     * Deze methode geeft het aantal gepasseerde artikelen.
     *
     * @return het aantal gepasseerde artikelen
     */
    public int getAantalArtikelen() {
        return kassa.aantalArtikelen();
    }

    /**
     * Deze methode reset de bijgehouden telling van het aantal artikelen en "leegt" de inhoud van
     * de kassa.
     */
    public void resetKassa() {
       kassa.resetKassa();
    }

    public KantineAanbod getKantineAanbod() {
        return kantineAanbod;
    }

    public void setKantineAanbod(KantineAanbod kantineAanbod) {
        this.kantineAanbod = kantineAanbod;
    }
}
