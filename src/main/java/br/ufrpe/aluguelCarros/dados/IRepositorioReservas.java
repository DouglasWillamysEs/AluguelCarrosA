package br.ufrpe.aluguelCarros.dados;

import br.ufrpe.aluguelCarros.negocio.beans.Reserva;
import br.ufrpe.aluguelCarros.negocio.beans.Carro;
import br.ufrpe.aluguelCarros.negocio.beans.Usuario;

import java.time.LocalDateTime;

public interface IRepositorioReservas {

    void criarReserva(int idCarro, String cpf, LocalDateTime dataInicio);
    Reserva buscarReserva(int idReserva);
    void editarReserva(int idReserva, LocalDateTime dataInicio, LocalDateTime dataFim, double preco, boolean statusPagamento);
    double simularAluguel(int idReserva, LocalDateTime dataInicio, LocalDateTime dataFim);
}
