package br.ufrpe.aluguelcarros.negocio;

import br.ufrpe.aluguelcarros.dados.IRepositorioReservas;
import br.ufrpe.aluguelcarros.dados.RepositorioReservas;
import br.ufrpe.aluguelcarros.dados.RepositorioUsuario;
import br.ufrpe.aluguelcarros.negocio.beans.Reserva;
import br.ufrpe.aluguelcarros.negocio.beans.Usuario;


import java.time.LocalDateTime;
import java.util.Scanner;

public class ControladorReservas {

    private ControladorUsuario controladorUsuario;
    private IRepositorioReservas repositorioReservas;
    private static ControladorReservas instance;


    public ControladorReservas() {
        repositorioReservas = RepositorioReservas.getInstance();
        controladorUsuario = ControladorUsuario.getInstance();
    }

    public static ControladorReservas getInstance() {
        if (instance == null) {
            synchronized (ControladorReservas.class) {
                if (instance == null) {
                    instance = new ControladorReservas();
                }
            }
        }
        return instance;
    }
    public Reserva procurarReserva(int idReserva) {
        if(idReserva != 0) {
            RepositorioReservas.getInstance().buscarReserva(idReserva);
        }
        return null;
    }

    public void cadastrarReserva(int idCarro, String cpf, LocalDateTime dataInicio) {

        if(cpf != null && !cpf.isEmpty()) {
            Usuario novoUsuario = ControladorUsuario.getInstance().buscarUsuario(cpf);

            if(novoUsuario.isCadastrado()) {
                RepositorioReservas.getInstance().criarReserva(idCarro, cpf, dataInicio);
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
