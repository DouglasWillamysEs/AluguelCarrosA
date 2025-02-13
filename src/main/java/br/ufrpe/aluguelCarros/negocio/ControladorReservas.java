package br.ufrpe.aluguelCarros.negocio;

import br.ufrpe.aluguelCarros.dados.IRepositorioReservas;
import br.ufrpe.aluguelCarros.dados.RepositorioReservas;
import br.ufrpe.aluguelCarros.negocio.beans.Reserva;
import br.ufrpe.aluguelCarros.negocio.beans.Usuario;


import java.time.LocalDateTime;
import java.util.Scanner;

public class ControladorReservas {

    private ControladorUsuario controladorUsuario;
    private IRepositorioReservas repositorioReservas;

    public ControladorReservas() {
        repositorioReservas = new RepositorioReservas();
        controladorUsuario = new ControladorUsuario();
    }

    public Reserva procurarReserva(int idReserva) {
        if(idReserva != 0) {
            repositorioReservas.buscarReserva(idReserva);
        }
        return null;
    }

    public void cadastrarReserva(int idCarro, String cpf, LocalDateTime dataInicio) {

        if(cpf != null && !cpf.isEmpty()) {
            Usuario novoUsuario = controladorUsuario.buscarUsuario(cpf);

            if(novoUsuario.isCadastrado()) {
                repositorioReservas.criarReserva(idCarro, cpf, dataInicio);
            }
        }
    }
    public void alterarReserva(Reserva reserva) {

    }
    public void alterarReserva(Reserva reserva, int idReserva) {

    }
    public void excluirReserva(int idReserva) {

    }

}
