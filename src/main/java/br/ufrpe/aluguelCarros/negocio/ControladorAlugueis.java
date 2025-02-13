package br.ufrpe.aluguelCarros.negocio;

import br.ufrpe.aluguelCarros.dados.IRepositorioAlugueis;
import br.ufrpe.aluguelCarros.dados.RepositorioAlugueis;
import br.ufrpe.aluguelCarros.dados.RepositorioCarros;
import br.ufrpe.aluguelCarros.negocio.beans.Aluguel;
import br.ufrpe.aluguelCarros.negocio.beans.Carro;
import br.ufrpe.aluguelCarros.negocio.beans.Reserva;
import br.ufrpe.aluguelCarros.negocio.beans.Usuario;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


public class ControladorAlugueis {
    private RepositorioAlugueis repositorioAlugueis ;
    private RepositorioCarros repositorioCarros;
    private ControladorReservas controladorReservas;
    private ControladorUsuario controladorUsuario;
    private ControladorCarro controladorCarro;


    public ControladorAlugueis() {
        this.repositorioAlugueis = new RepositorioAlugueis();
        this.controladorReservas = new ControladorReservas();
        this.controladorUsuario = new ControladorUsuario();
        this.controladorCarro = new ControladorCarro();
    }

    public void alugarCarro(int idReserva, LocalDateTime dataInicio, LocalDateTime dataFim, boolean statusPagamento, double taxaAluguel) {

        if(idReserva != 0) {
            Reserva reserva = controladorReservas.procurarReserva(idReserva);
            String cpfUsuario = reserva.getCpf();

            Usuario usuario = controladorUsuario.buscarUsuario(cpfUsuario);

            if (usuario.getIdReservasAtivas().contains(idReserva)) {
                int idCarro = reserva.getIdCarro();
                Carro carro = controladorCarro.buscarCarro(idCarro);

                long dias = ChronoUnit.DAYS.between(dataInicio, dataFim);
                double preco = dias * carro.getPreco();

                repositorioAlugueis.adicionarAluguel(idCarro, cpfUsuario, dataInicio, dataFim, preco, taxaAluguel);

                int idAluguel = usuario.getIdAlugueisAtivos().size() + 1;
                usuario.addAluguelAtivo(idAluguel);
                usuario.removerReservaAtiva(idReserva);
            }
        }
    }

    public void pagarAluguel(int idAluguel) {

        if(idAluguel != 0) {
            Aluguel aluguel = repositorioAlugueis.buscarAluguel(idAluguel);
            String cpfAluguel = aluguel.getCpfAluguel();

            Usuario usuario = controladorUsuario.buscarUsuario(cpfAluguel);

            if(usuario.getIdAlugueisAtivos().contains(idAluguel)) {
                if(LocalDateTime.now().isAfter(aluguel.getDataFim())) {
                    long dias = ChronoUnit.DAYS.between(aluguel.getDataFim(), LocalDateTime.now());

                    Carro carro =  controladorCarro.buscarCarro(aluguel.getIdCarroAluguel());
                    double precoComMulta = aluguel.getPreco() * carro.getPreco() * aluguel.getTaxaAluguel() * dias;
                    aluguel.setPreco(precoComMulta);

                    aluguel.setStatusPagamento(true);
                    usuario.removerAluguelAtivo(idAluguel);
                }

                else if (LocalDateTime.now().isBefore(aluguel.getDataFim())) {
                    aluguel.setStatusPagamento(true);
                }
            }
        }
    }
}






