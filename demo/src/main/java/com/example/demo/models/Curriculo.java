package com.example.demo.models;
import jakarta.persistence.*;

@Entity
public class Curriculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int idade;
    private String formacao;
    private String experiencia;
    private String email;

    public String getEmail() {
        return email;
    }
    public String getExperiencia() {
        return experiencia;
    }
    public String getFormacao() {
        return formacao;
    }
    public Long getId() {
        return id;
    }
    public int getIdade() {
        return idade;
    }
    public String getNome() {
        return nome;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }
    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}

