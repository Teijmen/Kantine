package KantineSimulatieBasis.src.main.java;

public class Docent extends Persoon implements KortingskaartHouder {
    private String letterCode;
    private String afdeling;

    public Docent(int bsn, String voornaam, String achternaam, Datum geboortedatum, char geslacht, String letterCode, String afdeling) {
        super(bsn, voornaam, achternaam, geboortedatum, geslacht);
        this.letterCode = letterCode;
        this.afdeling = afdeling;
    }

    public Docent() {


    }

    public String getLetterCode() {
        return letterCode;
    }

    public void setLetterCode(String letterCode) {
        this.letterCode = letterCode;
    }

    public String getAfdeling() {
        return afdeling;
    }

    public void setAfdeling(String afdeling) {
        this.afdeling = afdeling;
    }

    @Override
    public String toString(){//overriding the toString() method
        return "docent";
    }

    /**
     * Methode om kortingspercentage op te vragen
     */
    @Override
    public double geefKortingsPercentage(){
        return 25;
    }


    /**
     * Methode om op te vragen of er maximum per keer aan de korting zit
     */
    @Override
    public boolean heeftMaximum(){
        return true;
    }


    /**
     * Methode om het maximum kortingsbedrag op te vragen
     */
    @Override
    public double geefMaximum(){
        return 1;
    }

}
