package br.ufrpe.aluguelcarros.dados;

import java.util.ArrayList;

import br.ufrpe.aluguelcarros.negocio.ControladorCarro;
import br.ufrpe.aluguelcarros.negocio.beans.Carro;

public class RepositorioCarros implements IRepositorioCarros {
    private ArrayList<Carro> carros;
    private ArrayList<String> marcas;

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
    public void cadastrarCarro(String cor, String marca, String modelo, double preco, boolean disponivel) {
        Carro novoCarro = new Carro(cor, marca, modelo, preco, disponivel);
        novoCarro.setId(carros.size() + 1);
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
        for (Carro carro : carros) {
            if (carro.getId() == id) {
                return carro;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Carro> procurarModelo(String modelo) {
        ArrayList<Carro> resultado = new ArrayList<>();

        for (Carro carro : carros) {
            if (carro.getModelo().equalsIgnoreCase(modelo)) {
                resultado.add(carro);
            }
        }
        return resultado;
    }

    @Override
    public ArrayList<Carro> retornarTodosOsCarros(){
        return carros;
    }

    @Override
    public ArrayList<String> retornarCores() {
        ArrayList<String> cores = new ArrayList<>();
        for (Carro carro : carros) {
            if (!cores.contains(carro.getCor())) {
                cores.add(carro.getCor());
            }
        }
        return cores;
    }

    @Override
    public ArrayList<String> retornarMarcas() {
        ArrayList<String> marcas = new ArrayList<>();
        for (Carro carro : carros) {
            if (!marcas.contains(carro.getMarca())) {
                marcas.add(carro.getMarca());
            }
        }
        return marcas;
    }

    @Override
    public ArrayList<String> retornarModelos() {
        ArrayList<String> modelos = new ArrayList<>();
        for (Carro carro : carros) {
            if (!modelos.contains(carro.getModelo())) {
                modelos.add(carro.getModelo());
            }
        }
        return modelos;
    }
}

