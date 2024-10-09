import edu.fatec.lp2.exercicio1.Contatinho;
import edu.fatec.lp2.exercicio1.Mensagem;
import edu.fatec.lp2.exercicio1.MsgAudio;
import edu.fatec.lp2.exercicio1.MsgFoto;
import edu.fatec.lp2.exercicio1.MsgTexto;
import edu.fatec.lp2.exercicio1.Whatsapp;

public class App {
    public static void main(String[] args) throws Exception {
        Whatsapp whatsapp = new Whatsapp();
        
        // Criando alguns contatos
        Contatinho contato1 = new Contatinho("João", "99999-1111");
        Contatinho contato2 = new Contatinho("Maria", "99999-2222");

        // Adicionando os contatos ao Whatsapp
        whatsapp.adicionarContato(contato1);
        whatsapp.adicionarContato(contato2);

        // Enviando mensagens
        Mensagem texto = new MsgTexto(contato1, "Oi, tudo bem?", "10:00");
        whatsapp.enviarMensagem(texto);

        Mensagem audio = new MsgAudio(contato2, "Mensagem de áudio.", "10:30");
        whatsapp.enviarMensagem(audio);

        Mensagem foto = new MsgFoto(contato1, "Foto de férias.", "11:00");
        whatsapp.enviarMensagem(foto);
    }
}
