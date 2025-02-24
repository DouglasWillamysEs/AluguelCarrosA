package br.ufrpe.aluguelcarros.dados;

import br.ufrpe.aluguelcarros.negocio.beans.Usuario;

public interface GerenciaConta {

    void cadastrarContaUser(String nome, String cpf, int idade, String email, String senha);
    void cadastrarContaAdmin(String nome, String cpf, int idade, String email, String senha, String chave);
    void realizarLogin(String email, String senha);
    void removerConta(String cpf);
    Usuario procurarConta(String cpf);

}
