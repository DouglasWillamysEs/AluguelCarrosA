package br.ufrpe.aluguelcarros.GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ControladorPerfil {

    @FXML
    private Label lbCPF;

    @FXML
    private Label lbEmail;

    @FXML
    private Label lbIdade;

    @FXML
    private Label lbNome;

    void setInfos(String nome, String cpf, String email, int idade) {
        lbNome.setText(nome);
        lbCPF.setText(cpf);
        lbEmail.setText(email);
        lbIdade.setText(String.valueOf(idade));
    }
}
