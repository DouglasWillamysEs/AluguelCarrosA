package br.ufrpe.aluguelCarros.negocio;

import br.ufrpe.aluguelCarros.negocio.beans.Usuario;
import br.ufrpe.aluguelCarros.dados.RepositorioUsuario;

public class ControladorUsuario {

    private RepositorioUsuario repositorioUsuario;


    public ControladorUsuario() {
        repositorioUsuario = new RepositorioUsuario();
    }

    public void cadastrarUsuario(String nome, String cpf, int idade, String email, String senha) {
        if(nome != null && cpf != null && email != null && senha != null){
            if(idade >= 18){
                repositorioUsuario.cadastrarContaUser(nome, cpf, idade, email, senha);
            }
        }
    }

    public void logarUser(String cpf, String senha) {

    }

    public void removerUsuario(String cpf) {
        if(cpf != null && !cpf.isEmpty()){
            repositorioUsuario.removerConta(cpf);
        }
    }

    public Usuario buscarUsuario(String cpf) {
        if(cpf != null && !cpf.isEmpty()){
            return repositorioUsuario.procurarConta(cpf);
        }
        return null;
    }

    public void cadastrarAdmin(String nome, String cpf, int idade, String email, String senha, String chave){
        if(repositorioUsuario.procurarConta(cpf) == null){
            if(chave != null && !chave.isEmpty()){

                if(repositorioUsuario.procurarConta(cpf) == null){

                    if(repositorioUsuario.procurarChave(chave) == chave){
                        repositorioUsuario.cadastrarContaAdmin(nome, cpf, idade, email, senha, chave);
                    }
                }

            }
        }
    }

    public void atribuirChave(String chave){
        if(repositorioUsuario.procurarChave(chave) == null){
            repositorioUsuario.atribuirChave(chave);
        }
    }

    public void RemoverChaveC(String chave) {
        if(repositorioUsuario.procurarChave(chave) != null){
            repositorioUsuario.removerChave(chave);
        }
    }
}
