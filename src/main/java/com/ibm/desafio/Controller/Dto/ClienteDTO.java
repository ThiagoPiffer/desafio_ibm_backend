package com.ibm.desafio.Controller.Dto;

public class ClienteDTO {
    private Long id;
    private String nome;
    private int idade;
    private String email;
    private String numero_Conta;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumero_Conta() {
        return numero_Conta;
    }

    public void setNumero_Conta(String numero_Conta) {
        this.numero_Conta = numero_Conta;
    }
}
