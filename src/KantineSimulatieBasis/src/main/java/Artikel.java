package KantineSimulatieBasis.src.main.java;

public class Artikel {

    private String naam;    //naam van een Artikel
    private float prijs;      //prijs van een Artikel

    /**
     * Constructor van Artikel
     * @param naam De naam van een artikel
     * @param prijs De prijs van een artikel
     */
    public Artikel(String naam, float prijs) {
        this.naam = naam;
        if(prijs <= 0){
            System.out.println("Incorrecte prijs");
        }else{
            this.prijs = prijs;
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
    public float getPrijs() {
        return prijs;
    }

    /**
     * Methode om een artikel een prijs te geven
     * @param prijs De prijs van een artikel
     */
    public void setPrijs(float prijs) {
        if(prijs <= 0){
            System.out.println("Incorrecte prijs");
        }else{
            this.prijs = prijs;
        }
    }

    @Override
    public String toString(){
        return getNaam() + " " + getPrijs();
    }
}
