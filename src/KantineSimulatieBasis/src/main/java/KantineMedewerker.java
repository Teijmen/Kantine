package KantineSimulatieBasis.src.main.java;

public class KantineMedewerker extends Persoon {
    private int medewerkersNummer;
    private boolean magAchterKassaStaan;

    public KantineMedewerker(int bsn, String voornaam, String achternaam, Datum geboortedatum, char geslacht, int medewerkersNummer, boolean magAchterKassaStaan) {
        super(bsn, voornaam, achternaam, geboortedatum, geslacht);
        this.medewerkersNummer = medewerkersNummer;
        this.magAchterKassaStaan = magAchterKassaStaan;
    }

    public KantineMedewerker() {

    }

    public int getMedewerkersNummer() {
        return medewerkersNummer;
    }

    public void setMedewerkersNummer(int medewerkersNummer) {
        this.medewerkersNummer = medewerkersNummer;
    }

    public boolean magAchterKassaStaan() {
        return magAchterKassaStaan;
    }

    public void setMagAchterKassaStaan(boolean magAchterKassaStaan) {
        this.magAchterKassaStaan = magAchterKassaStaan;
    }

    @Override
    public String toString(){//overriding the toString() method
        return "kantineMedewerker";
    }
}
