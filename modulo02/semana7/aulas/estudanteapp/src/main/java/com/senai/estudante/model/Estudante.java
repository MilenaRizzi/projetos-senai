package com.senai.estudante.model;

public class Estudante {
    
    private String matricula;

    private String nome;

    private String email;


    public Estudante() { }

    public Estudante(String matricula, String nome, String email) {
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
    }


    @Override
    public String toString() {
        return "Estudante [matricula=" + matricula + ", nome=" + nome + ", email=" + email + "]";
    }


    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    

}