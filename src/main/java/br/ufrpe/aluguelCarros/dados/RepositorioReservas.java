package br.ufrpe.aluguelCarros.dados;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import br.ufrpe.aluguelCarros.negocio.ControladorCarro;
import br.ufrpe.aluguelCarros.negocio.ControladorUsuario;
import br.ufrpe.aluguelCarros.negocio.beans.Reserva;
import br.ufrpe.aluguelCarros.negocio.beans.Carro;
import br.ufrpe.aluguelCarros.negocio.beans.Usuario;
import br.ufrpe.aluguelCarros.negocio.ControladorCarro;

public class RepositorioReservas implements IRepositorioReservas {
    private ArrayList<Reserva> reservas;
    private ControladorCarro controladorCarro = new ControladorCarro();
    private ControladorUsuario controladorUsuario = new ControladorUsuario();

    public RepositorioReservas() {
        reservas = new ArrayList<>();
    }

    @Override
    public void criarReserva(int idCarro, String cpf, LocalDateTime dataInicio){

        if(cpf != null && !cpf.isEmpty() && idCarro != 0){

            Reserva novaReserva = new Reserva(idCarro, cpf, dataInicio);
            novaReserva.setIdReserva(reservas.size() + 1);
            this.reservas.add(novaReserva);

            Usuario novoUsuario = controladorUsuario.buscarUsuario(cpf);
            novoUsuario.addReservaAtiva(novaReserva.getIdReserva());
        }
    }

    @Override
    public Reserva buscarReserva(int idReserva){
        if (reservas == null) {
            return null;
        }

        for (Reserva reserva : reservas) {
            if (idReserva == reserva.getIdReserva()) {
                return reserva;
            }
        }
        return null;
    }

    @Override
    public void editarReserva(int idReserva, LocalDateTime dataInicio, LocalDateTime dataFim, double preco, boolean statusPagamento){
        Reserva novaReserva = buscarReserva(idReserva);
        novaReserva.setDataInicio(dataInicio);
        novaReserva.setDataFim(dataFim);
        novaReserva.setPreco(preco);
        novaReserva.setStatusPagamento(statusPagamento);
    }

    @Override
    public double simularAluguel(int idReserva, LocalDateTime dataInicio, LocalDateTime dataFim) {

        if (idReserva != 0) {
            Reserva novaReserva = buscarReserva(idReserva);
            int idCarro = novaReserva.getIdCarro();

            Carro novoCarro = controladorCarro.buscarCarro(idCarro);

            long dias = ChronoUnit.DAYS.between(dataInicio, dataFim);
            double precoSimulado = dias * novoCarro.getPreco();

            return precoSimulado;
        }
        return 0;
    }
}
