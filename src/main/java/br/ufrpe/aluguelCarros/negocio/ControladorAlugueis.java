package br.ufrpe.aluguelcarros.negocio;

import br.ufrpe.aluguelcarros.dados.IRepositorioAlugueis;
import br.ufrpe.aluguelcarros.dados.RepositorioAlugueis;
import br.ufrpe.aluguelcarros.dados.RepositorioCarros;
import br.ufrpe.aluguelcarros.negocio.beans.Aluguel;
import br.ufrpe.aluguelcarros.negocio.beans.Carro;
import br.ufrpe.aluguelcarros.negocio.beans.Reserva;
import br.ufrpe.aluguelcarros.negocio.beans.Usuario;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


public class ControladorAlugueis {
    private RepositorioAlugueis repositorioAlugueis ;
    private RepositorioCarros repositorioCarros;
    private ControladorReservas controladorReservas;
    private ControladorUsuario controladorUsuario;
    private ControladorCarro controladorCarro;



    public ControladorAlugueis() {
        this.repositorioAlugueis = RepositorioAlugueis.getInstance();
        this.controladorReservas = ControladorReservas.getInstance();
        this.controladorUsuario = ControladorUsuario.getInstance();
        this.controladorCarro = ControladorCarro.getInstance();
    }

    public void alugarCarro(int idReserva, LocalDateTime dataInicio, LocalDateTime dataFim, boolean statusPagamento, double taxaAluguel) {

        if(idReserva != 0) {
            Reserva reserva = ControladorReservas.getInstance().procurarReserva(idReserva);
            if (reserva.getDataFim().isBefore(LocalDateTime.now())){
                String cpfUsuario = reserva.getCpf();
                Usuario usuario = ControladorUsuario.getInstance().buscarUsuario(cpfUsuario);

            if (usuario.getIdReservasAtivas().contains(idReserva)) {
                int idCarro = reserva.getIdCarro();
                Carro carro = ControladorCarro.getInstance().buscarCarro(idCarro);

                long dias = ChronoUnit.DAYS.between(dataInicio, dataFim);
                double preco = dias * carro.getPreco();

                RepositorioAlugueis.getInstance().adicionarAluguel(idCarro, cpfUsuario, dataInicio, dataFim, preco, taxaAluguel);

                int idAluguel = usuario.getIdAlugueisAtivos().size() + 1;
                usuario.addAluguelAtivo(idAluguel);
                usuario.removerReservaAtiva(idReserva);
            }
            }
        }
    }

    public void pagarAluguel(int idAluguel) {

        if(idAluguel != 0) {
            Aluguel aluguel = RepositorioAlugueis.getInstance().buscarAluguel(idAluguel);
            String cpfAluguel = aluguel.getCpfAluguel();

            Usuario usuario = ControladorUsuario.getInstance().buscarUsuario(cpfAluguel);

            if(usuario.getIdAlugueisAtivos().contains(idAluguel)) {
                if(LocalDateTime.now().isAfter(aluguel.getDataFim())) {
                    long dias = ChronoUnit.DAYS.between(aluguel.getDataFim(), LocalDateTime.now());

                    Carro carro =  ControladorCarro.getInstance().buscarCarro(aluguel.getIdCarroAluguel());
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










