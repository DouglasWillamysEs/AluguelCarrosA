package br.ufrpe.aluguelCarros.dados;

import br.ufrpe.aluguelCarros.negocio.beans.Carro;

public interface IRepositorioCarros {

    void cadastrarCarro(int id, String cor, String marca, String modelo, double preco, boolean statusPagamento);
    void removerCarro(int id);
    void editarCarro(int id, String cor, String marca, String modelo, double preco);
    Carro procurarCarro(int id);
}
