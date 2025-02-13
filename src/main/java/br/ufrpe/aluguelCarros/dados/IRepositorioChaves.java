package br.ufrpe.aluguelCarros.dados;

public interface IRepositorioChaves {

    void atribuirChave(String chave);
    void removerChave(String chave);
    String procurarChave(String chave);
}
