package br.ufrpe.aluguelcarros.dados;

import java.util.ArrayList;

import br.ufrpe.aluguelcarros.negocio.ControladorCarro;
import br.ufrpe.aluguelcarros.negocio.beans.Carro;

public class RepositorioCarros implements IRepositorioCarros {
    private ArrayList<Carro> carros;

    private static RepositorioCarros instance;

    public RepositorioCarros() {
        carros = new ArrayList<>();
    }

    public static RepositorioCarros getInstance() {
        if (instance == null) {
            instance = new RepositorioCarros();
        }
        return instance;
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

    @Override
    public ArrayList<Carro> procurarModelo(String modelo){
        ArrayList<Carro> resultado = new ArrayList<>();

        for (Carro carro : carros) {
            if (carro.getModelo().equalsIgnoreCase(modelo)) {
                resultado.add(carro);
            }
        }
        return resultado;
    }
}
