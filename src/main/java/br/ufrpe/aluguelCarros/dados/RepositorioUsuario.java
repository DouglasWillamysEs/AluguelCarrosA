package br.ufrpe.aluguelCarros.dados;

import br.ufrpe.aluguelCarros.negocio.beans.Administrador;
import br.ufrpe.aluguelCarros.negocio.beans.Usuario;
import java.util.ArrayList;

public class RepositorioUsuario implements GerenciaConta, IRepositorioChaves{

    private ArrayList<Usuario> usuarios;
    public ArrayList<Administrador> admins;
    public ArrayList<String> chaves;

    public RepositorioUsuario(){
        this.usuarios = new ArrayList();
        this.admins = new ArrayList<>();
        this.chaves = new ArrayList<>();
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public void cadastrarContaUser(String nome, String cpf, int idade, String email, String senha){
        Usuario novoUsuario = new Usuario(nome, cpf, idade, email, senha);
        novoUsuario.setCadastrado(true);
        this.usuarios.add(novoUsuario);
    }

    @Override
    public void cadastrarContaAdmin(String nome, String cpf, int idade, String email, String senha, String chave){
        Administrador novoAdmin = new Administrador(nome, cpf, idade, email, senha);
        novoAdmin.setCadastrado(true);
        this.admins.add(novoAdmin);
    }

    @Override
    public void realizarLogin(String email, String senha){


    }


    @Override
    public void removerConta(String cpf){
        for(Usuario usuario : usuarios){
            if(usuario.getCpf().equals(cpf)){
                this.usuarios.remove(usuario);
            }
        }
    }

    @Override
    public Usuario procurarConta(String cpf){
        if (usuarios == null) {
            return null;
        }


        for (Usuario usuario : usuarios) {
            if (usuario.getCpf().equals(cpf)) {
                return usuario;
            }
        }
        return null;
    }

    @Override
    public void atribuirChave(String chave){
        this.chaves.add(chave);
    }

    @Override
    public void removerChave(String chave){
        this.chaves.remove(chave);
    }

    @Override
    public String procurarChave(String chave){
        for (String chaveI : chaves) {
            if (chaveI.equals(chave)) {
                return chave;
            }
        }
        return null;
    }
}
