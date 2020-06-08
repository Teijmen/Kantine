package KantineSimulatieBasis.src.main.java;


public class Contant extends Betaalwijze {

    /**
     * Methode om betaling af te handelen
     */

    @Override
    public void betaal(double tebetalen) throws TeWeinigGeldException {
        if(tebetalen > saldo){
            throw new TeWeinigGeldException("Deze persoon heeft te weinig geld: ");
        }else{
            saldo -= tebetalen;
        }
    }
}
