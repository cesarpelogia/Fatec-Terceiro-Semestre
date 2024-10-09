package edu.fatec.lp2.exercicio1;


public class MsgFoto extends Mensagem {

    public MsgFoto(Contatinho destinatario, String conteudo, String horaEnvio) {
        super(destinatario, conteudo, horaEnvio);
    }

    @Override
    public MsgFoto sendMessage(String conteudo) {
        setConteudo(conteudo);
        System.out.println("Mensagem de foto enviada para: " + getDestinatario().getNome() + " Conteúdo: " + getConteudo());
        return this;
    }
}