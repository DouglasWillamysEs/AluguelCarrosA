package br.ufrpe.aluguelcarros.negocio;

import br.ufrpe.aluguelcarros.negocio.beans.Usuario;
import br.ufrpe.aluguelcarros.dados.RepositorioUsuario;

public class ControladorUsuario {

    private RepositorioUsuario repositorioUsuario;
    private Usuario usuarioLogado;
    private static ControladorUsuario instance;

    private ControladorUsuario() {
        this.repositorioUsuario = RepositorioUsuario.getInstance();
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }
    public static ControladorUsuario getInstance() {
        if (instance == null) {
            synchronized (ControladorUsuario.class) {
                if (instance == null) {
                    instance = new ControladorUsuario();
                }
            }
        }
        return instance;
    }

    public void cadastrarUsuario(String nome, String cpf, int idade, String email, String senha) {
        if(nome != null && cpf != null && email != null && senha != null){
            if(idade >= 18){
                RepositorioUsuario.getInstance().cadastrarContaUser(nome, cpf, idade, email, senha);
            }
        }
    }

    public void logarUser(String cpf, String senha) {

    }

    public void removerUsuario(String cpf) {
        if(cpf != null && !cpf.isEmpty()){
            RepositorioUsuario.getInstance().removerConta(cpf);
        }
    }

    public Usuario buscarUsuario(String cpf) {
        if(cpf != null && !cpf.isEmpty()){
            return RepositorioUsuario.getInstance().procurarConta(cpf);
        }
        return null;
    }

    public void cadastrarAdmin(String nome, String cpf, int idade, String email, String senha, String chave){
        if(RepositorioUsuario.getInstance().procurarConta(cpf) == null){
            if(chave != null && !chave.isEmpty()){

                if(RepositorioUsuario.getInstance().procurarConta(cpf) == null){

                    if(RepositorioUsuario.getInstance().procurarChave(chave) == chave){
                        RepositorioUsuario.getInstance().cadastrarContaAdmin(nome, cpf, idade, email, senha, chave);
                    }
                }

            }
        }
    }

    public void atribuirChave(String chave){
        if(RepositorioUsuario.getInstance().procurarChave(chave) == null){
            RepositorioUsuario.getInstance().atribuirChave(chave);
        }
    }

    public void RemoverChaveC(String chave) {
        if(RepositorioUsuario.getInstance().procurarChave(chave) != null){
            RepositorioUsuario.getInstance().removerChave(chave);
        }
    }
}
