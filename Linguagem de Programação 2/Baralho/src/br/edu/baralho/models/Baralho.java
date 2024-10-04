package br.edu.baralho.models;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baralho {
    private List<Carta> cartas;

    
    public Baralho() {
        cartas =  criarBaralho();
    }
    
    public List<Carta> criarBaralho() {
        List<Carta> cartas = new ArrayList<>();
        for (Carta.Naipe naipe : Carta.Naipe.values()) {
            if (naipe != Carta.Naipe.CORINGA) {
                for (Carta.Valor valor : Carta.Valor.values()) {
                    if (valor != Carta.Valor.CORINGA) {
                        Carta novaCarta = new Carta(valor, naipe);
                        cartas.add(novaCarta);
                    }
                }
            }
        }
        
        for (int i = 0; i < 4; i++) {
            cartas.add(new Carta(Carta.Valor.CORINGA, Carta.Naipe.CORINGA));
        }

        System.out.println("\n");
        return cartas;
    }
    
    
    public void embaralhar() {
        if (cartas.isEmpty()) {
            System.out.println("Não encontrei um baralho.");
            return;
        }
        
        Collections.shuffle(cartas);
        System.out.println("Embaralhado");
        System.out.println("\n");
    }
    
    public void retirarUmCarta(){
        System.out.println(cartas.get(0));
        cartas.remove(0);
        
    }
    
    public void imprimirBaralho() {
        for (int i = 0; i < cartas.size(); i++) {
            System.out.println(cartas.get(i).toString());
        }
        System.err.println(cartas.size());
        System.out.println("\n");
    }
    
    public List<Carta> getCartas() {
        return cartas;
    }
    
    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }
}