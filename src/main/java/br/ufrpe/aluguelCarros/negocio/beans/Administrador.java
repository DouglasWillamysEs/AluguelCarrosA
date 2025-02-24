package br.ufrpe.aluguelcarros.negocio.beans;
public class Administrador extends Usuario {

    private String chave;

    public Administrador(String nome, String cpf, int idade, String email, String senha) {
        super(nome, cpf, idade, email, senha);
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }
}


