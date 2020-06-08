package KantineSimulatieBasis.src.main.java;

public class Persoon {

    private int bsn;
    private String voornaam;
    private String achternaam;
    private Datum geboortedatum;
    private char geslacht;
    private Betaalwijze betaalwijze;

    /**
     * Constructor van Persoon
     * @param bsn Bsn nummer van persoon
     * @param voornaam De voornaam
     * @param achternaam De achternaam
     * @param geboortedatum De geboortedatum
     * @param geslacht Het geslacht
     */
    public Persoon(int bsn, String voornaam, String achternaam, Datum geboortedatum, char geslacht) {
        this.bsn = bsn;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.geboortedatum = geboortedatum;

        if(isCorrectGeslacht(geslacht)) {
            this.geslacht = geslacht;
        }
    }

    /**
     * Constructor van Persoon zonder parameters
     */
    public Persoon() {
        this.geboortedatum = null;
        this.geslacht = 'O'; //wanneer geslacht niet correct is, geeft 'O' van onbekend
    }

    /**
     * Hier wordt de BSN ge-initialiseerd door de user.
     * @param bsn de door de user ingevoerde burger service nummer
     */
    public void setBSN(int bsn) {
        this.bsn = bsn;
    }

    /**
     * Hier wordt de door de user ingevoerde BSN teruggegeven
     * @return BSN van de user.
     */
    public int getBSN() {
        return bsn;
    }

    /**
     * Hier wordt de voornaam ge-initialiseerd door de user.
     * @param voornaam de door de user ingevoerde waarde
     */
    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    /**
     * Hier wordt de door de user ingevoerde voornaam teruggegeven
     * @return voornaam van de user.
     */
    public String getVoornaam() {
        return voornaam;
    }

    /**
     * Hier wordt de achternaam ge-initialiseerd door de user.
     * @param achternaam de door de user ingevoerde waarde
     */
    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    /**
     * Hier wordt de door de user ingevoerde achternaam teruggegeven
     * @return achternaam van de user.
     */
    public String getAchternaam() {
        return achternaam;
    }

    /**
     * Hier wordt de geboortedatum ge-initialiseerd door de user.
     * @param geboortedatum de door de user ingevoerde geboortedatum.
     */
    public void setGeboortedatum(Datum geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    /**
     * Hier wordt de door de user ingevoerde geboortedatum teruggegeven
     * @return geboortedatum van de user.
     */
    public String getGeboortedatum() {
        return this.geboortedatum.getDatumAsString();
    }

    /**
     * Hier wordt het geslacht ge-initialiseerd door de user.
     * @param geslacht het door de user ingevoerde geslacht, als dit niet M of F is zal het worden weergegeven als O (onbekend)
     */
    public void setGeslacht(char geslacht) {

        if(isCorrectGeslacht(geslacht)){
            this.geslacht = geslacht;
        }else{
            //incorrect geslacht
            System.out.println("Geslacht kan alleen 'M' of 'F' zijn");
        }

    }

    /**
     * Hier wordt het door de user ingevoerde geslacht teruggegeven
     * @return geslacht van de user, als dit niet M (man) of F (vrouw) is, wordt Onbekend opgegeven
     */
    public String getGeslacht() {

        String s = String.valueOf(geslacht);

        if(s.equals("M")){
            return "Man";
        } else if(s.equals("F")){
            return "Vrouw";
        } else{
            return "Onbekend";
        }
    }

    public boolean isCorrectGeslacht(char geslacht){
        String letter = String.valueOf(geslacht); //char to string

        // check of string 'M' of 'F' is
        if(letter.equals("M") || letter.equals("F")){
            return true;
        }else{
            //incorrect geslacht
            return false;
        }
    }

    public Betaalwijze getBetaalwijze() {
        return betaalwijze;
    }

    public void setBetaalwijze(Betaalwijze betaalwijze) {
        this.betaalwijze = betaalwijze;
    }

    @Override
    public String toString(){
        return getVoornaam() + " " + getAchternaam() + "  " + getBSN() + " " + getGeboortedatum() + " " + getGeslacht();
    }
}
