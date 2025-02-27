package br.ufrpe.aluguelcarros.dados;

import br.ufrpe.aluguelcarros.negocio.beans.Carro;

import java.util.ArrayList;

public interface IRepositorioCarros {

    void cadastrarCarro(String cor, String marca, String modelo, double preco, boolean statusPagamento);
    void removerCarro(int id);
    void editarCarro(int id, String cor, String marca, String modelo, double preco);
    Carro procurarCarro(int id);
    ArrayList<Carro> procurarModelo(String modelo);
    ArrayList<String> retornarMarcas();
    ArrayList<String> retornarCores();
    ArrayList<String> retornarModelos();

}
