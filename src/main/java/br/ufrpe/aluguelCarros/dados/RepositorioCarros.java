package br.ufrpe.aluguelCarros.dados;

import java.util.ArrayList;
import br.ufrpe.aluguelCarros.negocio.beans.Carro;

public class RepositorioCarros implements IRepositorioCarros {
    private ArrayList<Carro> carros;

    public RepositorioCarros() {
        carros = new ArrayList<>();
    }

    @Override
    public void cadastrarCarro(int id, String cor, String marca, String modelo, double preco, boolean statusPagamento) {
        Carro novoCarro = new Carro(id, cor, marca, modelo, preco, statusPagamento);
        this.carros.add(novoCarro);
    }

    @Override
    public void removerCarro(int id) {
        for (Carro carro : carros) {
            if (carro.getId() == id) {
                carros.remove(carro);
            }
        }
    }

    @Override
    public void editarCarro(int id, String cor, String marca, String modelo, double preco) {
        Carro carro = procurarCarro(id);
        carro.setCor(cor);
        carro.setMarca(marca);
        carro.setModelo(modelo);
        carro.setPreco(preco);
    }

    @Override
    public Carro procurarCarro(int id) {
        if (carros == null) {
            return null;
        }

        for (Carro carro : carros) {
            if (carro.getId() == id) {
                return carro;
            }
        }
        return null;
    }
}
