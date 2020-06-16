package KantineSimulatieBasis.src.main.java;

public class Artikel {

    private String naam;    // naam van een Artikel
    private double prijs;   // prijs van een Artikel
    private double korting = 0; // korting bedrag van een Artikel

    /**
     * Constructor van Artikel
     * @param naam De naam van een artikel
     * @param prijs De prijs van een artikel
     */
    public Artikel(String naam, double prijs) {
        this.naam = naam;
        this.prijs = prijs;
    }

    public Artikel(String naam, double prijs, double korting) {
        this.naam = naam;
        this.prijs = prijs;
        if(korting == 0){
            this.korting = 0;
        }else {
            this.korting = korting;
        }
    }

    public Artikel() {

    }

    /**
     * Methode om de naam van een artikel op te vragen
     * @return De naam van het artikel
     */
    public String getNaam() {
        return naam;
    }

    /**
     * Methode om een artikel een naam te geven
     * @param naam De naam van het artikel
     */
    public void setNaam(String naam) {
        this.naam = naam;
    }

    /**
     * Methode om de prijs van een artikel op te vragen
     * @return De prijs van een artikel
     */
    public double getPrijs() {
        return prijs;
    }

    /**
     * Methode om een artikel een prijs te geven
     * @param prijs De prijs van een artikel
     */
    public void setPrijs(double prijs) {
        if(prijs <= 0){
            System.out.println("Incorrecte prijs");
        }else{
            this.prijs = prijs;
        }
    }

    public double getKorting() {
        return korting;
    }

    public void setKorting(double korting) {
        this.korting = korting;
    }

    @Override
    public String toString(){
        return getNaam() + " " + getPrijs();
    }
}
