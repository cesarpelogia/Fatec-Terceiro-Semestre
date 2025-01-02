import Baralho.Baralho;
import Baralho.BaralhoVazioException;

public class App {
    public static void main(String[] args) throws Exception {
        Baralho baralho = new Baralho();

        try{
            
        baralho.imprimirBaralho();

        baralho.embaralhar();

        baralho.imprimirBaralho();

        baralho.retirarUmaCarta();

        baralho.imprimirBaralho();

        } catch (BaralhoVazioException e){
            System.out.println("Err: " + e.getMessage());
        }
    }
}
