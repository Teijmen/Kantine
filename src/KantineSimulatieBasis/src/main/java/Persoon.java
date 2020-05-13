package KantineSimulatieBasis.src.main.java;

public class Persoon {
    private int BSN;
    private String voornaam;
    private String achternaam;
    private int geboortedatum;
    private char geslacht;

    public int getBSN() {
        return BSN;
    }

    public void setBSN(int BSN) {
        this.BSN = BSN;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public int getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(int geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

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

    public void setGeslacht(char geslacht) {
        if(geslacht == 'M' || geslacht == 'F') {
            this.geslacht = geslacht;
        } else {
            this.geslacht = 'O';
        }
    }
}
