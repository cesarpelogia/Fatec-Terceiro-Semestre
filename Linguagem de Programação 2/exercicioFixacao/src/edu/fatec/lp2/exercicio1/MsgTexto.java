package edu.fatec.lp2.exercicio1;

public class MsgTexto extends Mensagem{

    public MsgTexto(Contatinho destinatario, String conteudo, String horaEnvio) {
        super(destinatario, conteudo, horaEnvio);
    }

    @Override
    public MsgTexto sendMessage(String conteudo) {
        setConteudo(conteudo);
        System.out.println("Mensagem de texto enviada para: " + getDestinatario().getNome() + " Conteúdo: " + getConteudo());
        return this;
    }
}
