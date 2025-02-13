package br.ufrpe.aluguelCarros.negocio;

import br.ufrpe.aluguelCarros.dados.RepositorioCarros;
import br.ufrpe.aluguelCarros.negocio.beans.Carro;

public class ControladorCarro {

    private RepositorioCarros repositorioCarros;

    public ControladorCarro() {
        repositorioCarros = new RepositorioCarros();
    }

    public Carro buscarCarro(int id) {
        if(id != 0){
            repositorioCarros.procurarCarro(id);
        }
        return null;
    }
}
