package com.cervejaria.cerveja.domain;

import java.util.List;

public class CervejaDTO {

    private long id;
    private String marca;
    private String nome;
    private double qnt;
    private double preco;

    public CervejaDTO() {
    }

    public CervejaDTO(long id, String marca, String nome, double qnt, double preco) {
        this.id = id;
        this.marca = marca;
        this.nome = nome;
        this.qnt = qnt;
        this.preco = preco;
    }

    // Getters e Setters
    public long getId() {
        return id;
    }

    public void setid(long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getQnt() {
        return qnt;
    }

    public void setQnt(double qnt) {
        this.qnt = qnt;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Long getMaiorId(List<CervejaDTO> cervejas){
        long id = 1;
        for (CervejaDTO c : cervejas){
            if(Long.valueOf(c.getId()).equals(id)){
                id++;
            }
        }
        return id;
    }

}
