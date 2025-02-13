package br.ufrpe.aluguelCarros.dados;

import br.ufrpe.aluguelCarros.negocio.ControladorCarro;
import br.ufrpe.aluguelCarros.negocio.ControladorReservas;
import br.ufrpe.aluguelCarros.negocio.beans.Aluguel;
import br.ufrpe.aluguelCarros.negocio.beans.Carro;
import br.ufrpe.aluguelCarros.negocio.beans.Reserva;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class RepositorioAlugueis implements IRepositorioAlugueis {
    private ArrayList<Aluguel> alugueis;
    private ControladorCarro controladorCarro;

    public RepositorioAlugueis() {
        alugueis = new ArrayList<>();
    }

    @Override
    public void adicionarAluguel(int idCarro, String cpf, LocalDateTime dataInicio, LocalDateTime dataFim, double preco, double taxaAluguel) {

        Carro novoCarro = controladorCarro.buscarCarro(idCarro);
        novoCarro.setDisponivel(false);

        Aluguel aluguel = new Aluguel(idCarro, cpf, dataInicio, dataFim, preco, taxaAluguel);
        aluguel.setIdAluguel(alugueis.size() + 1);
        alugueis.add(aluguel);
    }

    @Override
    public void removerAluguel(int idAluguel) {
        for (Aluguel aluguel : alugueis) {
            if (aluguel.getIdAluguel() == idAluguel) {
                alugueis.remove(aluguel);
            }
        }
    }

    @Override
    public void editarAluguel(int idAluguel, LocalDateTime dataInicio, LocalDateTime dataFim, double preco, boolean statusPagamento){
        Aluguel aluguel = buscarAluguel(idAluguel);

        aluguel.setDataInicio(dataInicio);
        aluguel.setDataFim(dataFim);
        aluguel.setPreco(preco);
        aluguel.setStatusPagamento(statusPagamento);
    }

    @Override
    public Aluguel buscarAluguel(int idAluguel){
        if (alugueis == null) {
            return null;
        }

        for (Aluguel aluguel : alugueis) {
            if (aluguel.getIdAluguel() == idAluguel) {
                return aluguel;
            }
        }
        return null;
    }

}
