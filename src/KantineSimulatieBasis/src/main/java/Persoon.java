package KantineSimulatieBasis.src.main.java;

public class Persoon {
    private Int BSN;
    private String Voornaam;
    private String Achternaam;
    private Date Geboortedatum;
    private Char Geslacht;

    public Int getBSN() {
        return BSN;
    }

    public void setBSN(Int BSN) {
        this.BSN = BSN;
    }

    public String getVoornaam() {
        return Voornaam;
    }

    public void setVoornaam(String voornaam) {
        Voornaam = voornaam;
    }

    public String getAchternaam() {
        return Achternaam;
    }

    public void setAchternaam(String achternaam) {
        Achternaam = achternaam;
    }

    public Date getGeboortedatum() {
        return Geboortedatum;
    }

    public void setGeboortedatum(Date geboortedatum) {
        Geboortedatum = geboortedatum;
    }

    public Char getGeslacht() {
        return Geslacht;
    }

    public void setGeslacht(Char geslacht) {
        Geslacht = geslacht;
    }
}
