package edu.fatec.lp2.exercicio2;

import java.util.ArrayList;
import java.util.List;

public abstract class Supermercado {

    private String nome;
    private List<Produto> produtos;

    public Supermercado ( String nome){
        this.nome = nome;
        this.produtos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }



}
