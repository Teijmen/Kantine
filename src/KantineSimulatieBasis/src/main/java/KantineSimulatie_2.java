package KantineSimulatieBasis.src.main.java;

import java.util.*;

import static KantineSimulatieBasis.src.main.java.Administratie.*;

public class KantineSimulatie_2 {

    // kantine
    private Kantine kantine;

    // kassa
    private Kassa kassa;

    // kantineaanbod
    private KantineAanbod kantineAanbod;

    // random generator
    private Random random;

    // aantal artikelen
    private static final int AANTAL_ARTIKELEN = 4;

    // artikelen
    private static final String[] artikelnamen =
            new String[] {"Koffie", "Broodje pindakaas", "Broodje kaas", "Appelsap"};

    // prijzen
    private static double[] artikelprijzen = new double[] {1.50, 2.10, 1.65, 1.65};

    //aantal producten per dag

    int[] aantalProducten;

    //omzet per dag
    double[] omzet;

    // minimum en maximum aantal artikelen per soort
    private static final int MIN_ARTIKELEN_PER_SOORT = 10;
    private static final int MAX_ARTIKELEN_PER_SOORT = 20;

    // minimum en maximum aantal personen per dag
    private static final int MIN_PERSONEN_PER_DAG = 50;
    private static final int MAX_PERSONEN_PER_DAG = 100;

    // minimum en maximum artikelen per persoon
    private static final int MIN_ARTIKELEN_PER_PERSOON = 1;
    private static final int MAX_ARTIKELEN_PER_PERSOON = 4;

    /**
     * Constructor
     *
     */
    public KantineSimulatie_2() {
        kantine = new Kantine();
        kassa = kantine.getKassa();
        random = new Random();

        int[] hoeveelheden =
                getRandomArray(AANTAL_ARTIKELEN, MIN_ARTIKELEN_PER_SOORT, MAX_ARTIKELEN_PER_SOORT);

        aantalProducten = new int[10]; // aantalProducten per dag
        omzet = new double[10];        // omzet per dag

        kantineAanbod = new KantineAanbod(artikelnamen, artikelprijzen, hoeveelheden);
        kantine.setKantineAanbod(kantineAanbod);
    }

    /**
     * Methode om een array van random getallen liggend tussen min en max van de gegeven lengte te
     * genereren
     *
     * @param lengte
     * @param min
     * @param max
     * @return De array met random getallen
     */
    private int[] getRandomArray(int lengte, int min, int max) {
        int[] temp = new int[lengte];
        for (int i = 0; i < lengte; i++) {
            temp[i] = getRandomValue(min, max);
        }

        return temp;
    }

    /**
     * Methode om een random getal tussen min(incl) en max(incl) te genereren.
     *
     * @param min
     * @param max
     * @return Een random getal
     */
    private int getRandomValue(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    /**
     * Methode om op basis van een array van indexen voor de array artikelnamen de bijhorende array
     * van artikelnamen te maken
     *
     * @param indexen
     * @return De array met artikelnamen
     */
    private String[] geefArtikelNamen(int[] indexen) {
        String[] artikelen = new String[indexen.length];

        for (int i = 0; i < indexen.length; i++) {
            artikelen[i] = artikelnamen[indexen[i]];

        }
        return artikelen;
    }

    /**
     * Deze methode simuleert een aantal dagen
     * in het verloop van de kantine
     *
     * @param dagen
     */
    public void simuleer(int dagen) {
        // for lus voor dagen
        for(int i = 0; i < dagen; i++) {

            // bedenk hoeveel personen vandaag binnen lopen
            int aantalpersonen = getRandomValue(MIN_PERSONEN_PER_DAG, MAX_PERSONEN_PER_DAG);

            Persoon klant; // de klant
            Dienblad dienblad; // dienblad van de klant

            // laat de personen maar komen...
            for (int j = 0; j < aantalpersonen; j++) {

                int randomCustomer = random.nextInt(100);  // random getal

                // maak nieuwe klant
                if(randomCustomer < 89) {
                    klant = new Student(4321, "Bé", "Die", new Datum(1, 2, 2000), 'F', 1234, "BITM");
                } else if(randomCustomer >= 89 && randomCustomer < 99) {
                    klant = new Docent(1939, "Geef", "Tien", new Datum(1, 2, 2000), 'F', "bedi", "BesteJavaProgrammeur");
                } else {
                    klant = new KantineMedewerker(1914, "AcHt", "iSOoKgOeD", new Datum(1, 2, 2000), 'F', 10, false);
                }

                // check wat voor soort klant
                if(klant.toString().equals("student")){
                    dienblad = new Dienblad(klant);
                }else if (klant.toString().equals("docent")){
                    dienblad = new Dienblad(klant);
                }else{
                    dienblad = new Dienblad(klant);
                }

                // aantal artikelen dat de klant pakt
                int aantalartikelen = getRandomValue(MIN_ARTIKELEN_PER_PERSOON, MAX_ARTIKELEN_PER_PERSOON);

                // genereer de "artikelnummers", dit zijn indexen
                // van de artikelnamen
                int[] tepakken = getRandomArray(
                    aantalartikelen, 0, artikelnamen.length-1);

                // vind de artikelnamen op basis van
                // de indexen hierboven
                String[] artikelen = geefArtikelNamen(tepakken);

                // loop de kantine binnen, pak de gewenste
                // artikelen, sluit aan
                kantine.loopPakSluitAan(dienblad, artikelen);
            }



            // verwerk rij voor de kassa
            kantine.verwerkRijVoorKassa();

            // voeg het totaal aantal producten over de dag
            // toe aan aantalProducten
            aantalProducten[i] = kantine.getKassa().aantalArtikelen();

            // voeg dagomzet toe aan omzet
            omzet[i] = kantine.getKassa().hoeveelheidGeldInKassa();

            // druk de dagtotalen af en hoeveel personen binnen
            // zijn gekomen
            System.out.println("Dag " + i + ": " + kantine.getDagTotalen() + ". Aantal personen: " + aantalpersonen);

            // reset de kassa voor de volgende dag
            kassa.resetKassa();
        }

        //print gemiddelden via administratie
        System.out.println("Gemiddeld aantal producten over de gehele simulatie: " + berekenGemiddeldAantal(aantalProducten));
        System.out.println("Gemiddelde omzet over de gehele simulatie: " + berekenGemiddeldeOmzet(omzet));
        System.out.println("Gemiddelde omzet per dag over de gehele simulatie: " + Arrays.toString(berekenDagOmzet(omzet)));

    }

    public static void main(String[] args) {
        int dagen;

        if (args.length == 0) {
            dagen = 10;
        } else {
            dagen = Integer.parseInt(args[0]);
        }
        KantineSimulatie_2 ks = new KantineSimulatie_2();
        ks.simuleer(dagen);
    }
}
