package br.ufrpe.aluguelcarros.negocio;

import br.ufrpe.aluguelcarros.dados.RepositorioCarros;
import br.ufrpe.aluguelcarros.negocio.beans.Carro;

import java.util.ArrayList;

public class ControladorCarro {

    private RepositorioCarros repositorioCarros;
    private static ControladorCarro instance;

    public ControladorCarro() {
        repositorioCarros = RepositorioCarros.getInstance();
    }

    public static ControladorCarro getInstance() {
        if (instance == null) {
            instance = new ControladorCarro();  // Inicializa a instância na primeira chamada
        }
        return instance;
    }

    public void CadastrarCarroC(String cor, String marca, String modelo, double preco, boolean disponivel) {
        RepositorioCarros.getInstance().cadastrarCarro(cor, marca, modelo, preco, disponivel);
    }

    public Carro buscarCarro(int id) {
        if(id != 0){
           return RepositorioCarros.getInstance().procurarCarro(id);
        }
        return null;
    }

    public ArrayList<Carro> retornarTodosCarros() {
        return RepositorioCarros.getInstance().retornarTodosOsCarros();
    }

    public ArrayList<Carro> procurarModelo(String modelo) {
        if(modelo != null){
            RepositorioCarros.getInstance().procurarModelo(modelo);
        }
    return null;
    }

    public ArrayList<String> retornarMarcasCarros(){
        return RepositorioCarros.getInstance().retornarMarcas();
    }

    public ArrayList<String> retornarModeloCarros(){
        return RepositorioCarros.getInstance().retornarModelos();
    }

    public ArrayList<String> retornarCorCarros(){
        return RepositorioCarros.getInstance().retornarCores();
    }


}

