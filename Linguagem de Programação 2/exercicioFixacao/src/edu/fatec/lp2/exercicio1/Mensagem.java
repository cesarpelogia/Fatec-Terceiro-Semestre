package edu.fatec.lp2.exercicio1;

public abstract class Mensagem {
    private Contatinho destinatario;
    private String horaEnvio;
    private String conteudo;

    // Construtor
    public Mensagem(Contatinho destinatario, String conteudo, String horaEnvio) {
        this.destinatario = destinatario;
        this.conteudo = conteudo;
        this.horaEnvio = horaEnvio;
    }

    // Getters e Setters
    public Contatinho getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Contatinho destinatario) {
        this.destinatario = destinatario;
    }

    public String getHoraEnvio() {
        return horaEnvio;
    }

    public void setHoraEnvio(String horaEnvio) {
        this.horaEnvio = horaEnvio;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public abstract Mensagem sendMessage(String conteudo);
}
