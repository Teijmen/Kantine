package KantineSimulatieBasis.src.main.java;

public class KantineSimulatie_1 {

    private Kantine kantine;
    private Kassa kassa;
    private int[] totaalAantalOfzo;

    public static final int DAGEN = 7;

    private String[] artikelen = new String[] {"banaan", "appel", "koffie", "sap"};

    /**
     * Constructor
     */
    public KantineSimulatie_1() {
        kantine = new Kantine();
        kassa = kantine.getKassa();
    }

    /**
     * Deze methode simuleert een aantal dagen in het
     * verloop van de kantine
     *
     * @param dagen Het aantal dagen van de simulatie
     */

    public void simuleer(int dagen) {

        // herhaal voor elke dag
        for (int i = 0; i < dagen; i++) {

            // per dag nu even vast 10 + i personen naar binnen
            // laten gaan, wordt volgende week veranderd...

            // for lus voor personen
            for (int j = 0; j < 100; j++) {
                if(j < 89) {
                    Student student = new Student(4321, "Bé", "Die", null, 'F', 1234, "BITM");
                    Dienblad dienblad = new Dienblad(student);
                    kantine.loopPakSluitAan(dienblad, artikelen);
                } else if(j >= 89 && j < 99) {
                    Docent docent = new Docent(1939, "Geef", "Tien", null, 'F', "bedi", "BesteJavaProgrammeur");
                    Dienblad dienblad = new Dienblad(docent);
                    kantine.loopPakSluitAan(dienblad, artikelen);
                } else {
                    KantineMedewerker kantineMedewerker = new KantineMedewerker(1914, "AcHt", "iSOoKgOeD", null, 'F', 10, false);
                    Dienblad dienblad = new Dienblad(kantineMedewerker);
                    kantine.loopPakSluitAan(dienblad, artikelen);
                }
            }

            // verwerk rij voor de kassa
            kantine.verwerkRijVoorKassa();

            // toon dagtotalen (artikelen en geld in kassa)
            System.out.println(berekenDagOmzet(double[] omzet));

            // reset de kassa voor de volgende dag
            kassa.resetKassa();

        }
    }
    /**
     * Start een simulatie
     * Jo
     */

    public static void main(String[] args) {
        int dagen;

        if (args.length == 0) {
            dagen = DAGEN;
        } else {
            dagen = Integer.parseInt(args[0]);
        }
        KantineSimulatie_1 ks = new KantineSimulatie_1();
        ks.simuleer(dagen);
    }
}
