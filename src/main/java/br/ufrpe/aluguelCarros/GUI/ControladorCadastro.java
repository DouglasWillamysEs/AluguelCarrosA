package br.ufrpe.aluguelCarros.GUI;

import br.ufrpe.aluguelCarros.negocio.ControladorUsuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class ControladorCadastro {

    ControladorUsuario controladorUsuario = new ControladorUsuario();

    @FXML
    private Button botaoLogin;

    @FXML
    private RadioButton radioAdmin;

    @FXML
    private RadioButton rbUsuario;

    @FXML
    private TextField txtCPF;

    @FXML
    private TextField txtChave;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtIdade;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtSenha;

    @FXML
    void finalizarCadastro(ActionEvent event) {
        String cpf = txtCPF.getText();
        String chave = txtChave.getText();
        String email = txtEmail.getText();
        String nome = txtNome.getText();
        String senha = txtSenha.getText();
        int idade = Integer.parseInt(txtIdade.getText());
        controladorUsuario.cadastrarUsuario(nome, cpf, idade, email, senha);

    }

    @FXML
    private void radioAdminSelecionado() {
        txtChave.setVisible(true);
    }

    @FXML
    private void radioUsuarioSelecionado() {
        txtChave.setVisible(false);
    }

}
