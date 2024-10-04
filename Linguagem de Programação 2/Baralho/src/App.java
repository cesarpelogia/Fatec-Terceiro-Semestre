import br.edu.baralho.models.Baralho;

public class App {

    public static void main(String[] args) {
        
        Baralho baralho = new Baralho();
        baralho.imprimirBaralho();

        baralho.embaralhar();

        baralho.imprimirBaralho();

        baralho.retirarUmCarta();

        baralho.imprimirBaralho();

        
    }
}
