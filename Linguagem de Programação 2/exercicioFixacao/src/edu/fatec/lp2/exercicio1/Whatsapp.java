package edu.fatec.lp2.exercicio1;

import java.util.ArrayList;
import java.util.List;

public class Whatsapp {
    private List<Contatinho> contatos;
    private List<Mensagem> mensagens;

    // Construtor
    public Whatsapp() {
        this.contatos = new ArrayList<>();
        this.mensagens = new ArrayList<>();
    }

    // Método para adicionar contatos
    public void adicionarContato(Contatinho contato) {
        contatos.add(contato);
        System.out.println("Contato adicionado: " + contato.getNome());
    }

    // Método para enviar mensagens
    public void enviarMensagem(Mensagem mensagem) {
        mensagens.add(mensagem);
        mensagem.sendMessage(mensagem.getConteudo());
    }

    // Getters para acessar os contatos e mensagens
    public List<Contatinho> getContatos() {
        return contatos;
    }

    public List<Mensagem> getMensagens() {
        return mensagens;
    }

}
