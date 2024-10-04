package br.edu.baralho.models;
public class Carta {
    private Valor valor;
    private Naipe naipe;

    public enum Valor {
        A, DOIS, TRES, QUATRO, CINCO, SEIS, SETE, OITO, NOVE, DEZ, J, Q, K, CORINGA;
    }
    
    public enum Naipe {
        OUROS, PAUS, ESPADAS, COPAS, CORINGA;
    }

    
    public Carta(Valor valor, Naipe naipe) {
        this.valor = valor;
        this.naipe = naipe;
    }

    public Valor getValor() {
        return valor;
    }

    public void setValor(Valor valor) {
        this.valor = valor;
    }

    public Naipe getNaipe() {
        return naipe;
    }

    public void setNaipe(Naipe naipe) {
        this.naipe = naipe;
    }

    @Override
    public String toString() {
        if (valor.name().equals("coringa")) {
            return valor.name();
        } else {
            return valor.name() + " de " + naipe.name();
        }
    }
}