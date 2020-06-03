package KantineSimulatieBasis.src.main.java;

public class Kantine {

    private Kassa kassa;
    private KassaRij kassarij;
    private KantineAanbod kantineAanbod;

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
        for(int i = 0; i < artikelnamen.length; i++) {
            dienblad.voegToe(kantineAanbod.getArtikel(artikelnamen[i]));
            kassarij.sluitAchteraan(dienblad);
            //System.out.println(kantineAanbod.getArtikel(artikelnamen[i]) + " toegevoegd aan dienblad");
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

    public KantineAanbod getKantineAanbod() {
        return kantineAanbod;
    }

    public void setKantineAanbod(KantineAanbod kantineAanbod) {
        this.kantineAanbod = kantineAanbod;
    }

    public String getDagTotalen(){
        return "Bedrag: " + kassa.hoeveelheidGeldInKassa() + ". Aantal producten: " + kassa.aantalArtikelen();
    }

    public Kassa getKassa() {
        return kassa;
    }

    public void setKassa(Kassa kassa) {
        this.kassa = kassa;
    }
}
