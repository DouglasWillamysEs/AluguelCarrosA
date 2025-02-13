package br.ufrpe.aluguelCarros.negocio.beans;


import java.util.ArrayList;

public class Usuario {
    private ArrayList<Integer> idReservasAtivas;
    private ArrayList<Integer> idAlugueisAtivos;

    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private int idade;
    private boolean cadastrado;

    public Usuario(String nome, String cpf, int idade, String email, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.email = email;
        this.senha = senha;
        this.cadastrado = false;
        this.idReservasAtivas = new ArrayList<>();
    }


    public void addReservaAtiva(int idReserva) {
        this.idReservasAtivas.add(idReserva);
    }

    public void removerReservaAtiva(int idReserva) {
        this.idReservasAtivas.remove(idReserva);
    }

    public void removerAluguelAtivo(int idAluguel) {
        this.idReservasAtivas.remove(idAluguel);
    }

    public void addAluguelAtivo(int idAluguel) {
        this.idReservasAtivas.add(idAluguel);
    }

    public boolean isCadastrado() {
        return cadastrado;
    }

    public void setCadastrado(boolean cadastrado) {
        this.cadastrado = cadastrado;
    }

    public ArrayList<Integer> getIdReservasAtivas() {
        return idReservasAtivas;
    }

    public void setIdReservasAtivas(ArrayList<Integer> idReservasAtivas) {
        this.idReservasAtivas = idReservasAtivas;
    }

    public ArrayList<Integer> getIdAlugueisAtivos() {
        return idAlugueisAtivos;
    }

    public void setIdAlugueisAtivos(ArrayList<Integer> idAlugueisAtivos) {
        this.idAlugueisAtivos = idAlugueisAtivos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}