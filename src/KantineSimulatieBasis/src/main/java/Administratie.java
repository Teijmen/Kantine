package KantineSimulatieBasis.src.main.java;

public class Administratie {

    private static final int DAYS_IN_WEEK = 7;

    private Administratie(){

    }


    /**
     * Deze methode berekent van de int array aantal de gemiddelde waarde
     *
     * @param aantal
     * @return het gemiddelde
     */


    public static double berekenGemiddeldAantal(int[] aantal) {
        double total = 0;
        double average = 0;

        if(aantal.length == 0){
            return 0;
        }

        for(int i=0; i<aantal.length; i++){
            total += aantal[i];
        }
        average = total/aantal.length;

        return average;
    }

    /**
     * Deze methode berekent van de double array omzet de gemiddelde waarde
     *
     * @param omzet
     * @return het gemiddelde
     */

    public static double berekenGemiddeldeOmzet(double[] omzet) {
        double total = 0;
        double average = 0;

        if(omzet.length == 0){
            return 0;
        }

        for(int i=0; i<omzet.length; i++){
            total += omzet[i];
        }
        average = total/omzet.length;

        return average;
    }

    /**
     * Methode om dagomzet uit te rekenen
     *
     * @param omzet
     * @return array (7 elementen) met dagomzetten
     */


    public static double[] berekenDagOmzet(double[] omzet) {
        double[] temp = new double[DAYS_IN_WEEK];
        for (int i = 0; i < DAYS_IN_WEEK; i++) {

            int j = 0;
            while ( (i + DAYS_IN_WEEK * j) < omzet.length) {
                temp[i] += omzet[i + DAYS_IN_WEEK * j];
                j++;
            }
        }
        return temp;
    }

}
