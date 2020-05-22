package KantineSimulatieBasis.src.main.java;

import java.util.Stack;
import java.util.Iterator;

public class Dienblad {

    private Stack<Artikel> artikelen; //alle artikelen op een Dienblad
    private Persoon klant;  //de klant

    /**
     * Constructor van Dienblad zonder parameters
     */
    public Dienblad() {
        artikelen = new Stack<>(); // nieuwe Stack van artikelen
    }

    /**
     * Constructor van Dienblad met parameters
     * @param klant De klant met een dienblad
     */
    public Dienblad(Persoon klant){
        this.klant = klant;
    }

    /**
     * Methode om klant op te vragen
     *
     * @return De klant van het type Persoon
     */
    public Persoon getKlant() {
        return klant;
    }

    /**
     * Methode om een klant aan te maken
     *
     * @param klant Een klant van het type Persoon
     */
    public void setKlant(Persoon klant) {
        this.klant = klant;
    }

    /**
     * Methode om artikel aan dienblad toe te voegen
     *
     * @param artikel Een artikel van de klasse Artikel
     */
    public void voegToe(Artikel artikel) {
        artikelen.push(artikel);
    }

    /**
     * Methode om aantal artikelen op dienblad te tellen
     *
     * @return Het aantal artikelen
     */
    public int getAantalArtikelen() {
        return artikelen.size();
    }

    /**
     * Methode om de totaalprijs van de artikelen op dienblad uit te rekenen
     *
     * @return De totaalprijs
     */
    public double getTotaalPrijs() {
        double totalPrice = 0;
        for(Artikel a : artikelen){
             totalPrice += a.getPrijs();
        }
        return totalPrice;
    }

    public Iterator<Artikel> getDienblad(){

        Iterator<Artikel> it = artikelen.iterator();
        return it;
    }

}

