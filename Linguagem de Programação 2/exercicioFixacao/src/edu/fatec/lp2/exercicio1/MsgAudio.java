package edu.fatec.lp2.exercicio1;

public class MsgAudio extends Mensagem {

    public MsgAudio(Contatinho destinatario, String conteudo, String horaEnvio) {
        super(destinatario, conteudo, horaEnvio);
    }

    @Override
    public MsgAudio sendMessage(String conteudo) {
        setConteudo(conteudo);
        System.out.println("Mensagem de áudio enviada para: " + getDestinatario().getNome() + " Conteúdo: " + getConteudo());
        return this; 
    }
}
