package KantineSimulatieBasis.src.main.java;

public class Persoon {
    private int BSN;
    private String voornaam;
    private String achternaam;
    private int geboortedatum;
    private char geslacht;

    /**
     * Hier wordt de BSN ge-initialiseerd door de user.
     * @param BSN de door de user ingevoerde burger service nummer
     */
    public void setBSN(int BSN) {
        this.BSN = BSN;
    }
    /**
     * Hier wordt de door de user ingevoerde BSN teruggegeven
     * @return BSN van de user.
     */
    public int getBSN() {
        return BSN;
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
    public void setGeboortedatum(int geboortedatum) {
        this.geboortedatum = geboortedatum;
    }
    /**
     * Hier wordt de door de user ingevoerde geboortedatum teruggegeven
     * @return geboortedatum van de user.
     */
    public int getGeboortedatum() {
        return geboortedatum;
    }

    /**
     * Hier wordt het geslacht ge-initialiseerd door de user.
     * @param geslacht het door de user ingevoerde geslacht, als dit niet M of F is zal het worden weergegeven als O (onbekend)
     */
    public void setGeslacht(char geslacht) {
        if(geslacht == 'M' || geslacht == 'F') {
            this.geslacht = geslacht;
        } else {
            this.geslacht = 'O';
        }
    }
    /**
     * Hier wordt het door de user ingevoerde geslacht teruggegeven
     * @return geslacht van de user, als dit niet M (man) of F (vrouw) is, wordt Onbekend opgegeven
     */
    public char getGeslacht() {
        if(geslacht == 'M'){
            String geslacht = "Man";
        } if(geslacht == 'F'){
            String geslacht = "Vrouw";
        } if(geslacht == 'O'){
            String geslacht = "Onbekend";
        }
        return geslacht;
    }

}
