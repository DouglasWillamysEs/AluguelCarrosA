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
        return instance;
    }

    public Carro buscarCarro(int id) {
        if(id != 0){
            RepositorioCarros.getInstance().procurarCarro(id);
        }
        return null;
    }

    public ArrayList<Carro> procurarModelo(String modelo) {
        if(modelo != null){
            RepositorioCarros.getInstance().procurarModelo(modelo);
        }
    return null;
    }
}
