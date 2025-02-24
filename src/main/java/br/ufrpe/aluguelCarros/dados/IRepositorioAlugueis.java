package br.ufrpe.aluguelcarros.dados;

import br.ufrpe.aluguelcarros.negocio.beans.Aluguel;

import java.time.LocalDateTime;

public interface IRepositorioAlugueis {

    void adicionarAluguel(int idCarro, String cpf, LocalDateTime dataInicio, LocalDateTime dataFim, double preco, double taxaAluguel);
    void removerAluguel(int idAluguel);
    void editarAluguel(int idAluguel, LocalDateTime dataInicio, LocalDateTime dataFim, double preco, boolean statusPagamento);
    Aluguel buscarAluguel(int idAluguel);
}
