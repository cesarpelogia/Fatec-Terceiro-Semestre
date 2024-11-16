package com.cervejaria.cerveja.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Cerveja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String nome;
    private double qnt;
    private double preco;

    public Cerveja() {
    }

    public Cerveja(long id, String marca, String nome, double qnt, double preco) {
        this.id = id;
        this.marca = marca;
        this.nome = nome;
        this.qnt = qnt;
        this.preco = preco;
    }

}
