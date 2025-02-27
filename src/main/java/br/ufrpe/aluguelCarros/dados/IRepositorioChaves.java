package br.ufrpe.aluguelcarros.dados;

public interface IRepositorioChaves {

    void atribuirChave(String chave);
    void removerChave(String chave);
    boolean existeChave(String chave);
}
