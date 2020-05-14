package KantineSimulatieBasis.src.main.java;

import KantineSimulatieBasis.src.main.java.Artikel;
import KantineSimulatieBasis.src.main.java.Persoon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Dienblad {

    private ArrayList<Artikel> artikelen;
    private Persoon klant;

    /**
     * Constructor
     */
    public Dienblad() {
        // method body omitted
        artikelen = new ArrayList<Artikel>();
    }

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
        artikelen.add(artikel);
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
}

