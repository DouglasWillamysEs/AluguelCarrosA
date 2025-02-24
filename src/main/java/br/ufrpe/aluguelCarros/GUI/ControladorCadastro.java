package br.ufrpe.aluguelcarros.GUI;

import br.ufrpe.aluguelcarros.negocio.ControladorUsuario;
import br.ufrpe.aluguelcarros.negocio.beans.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.paint.Color.GREEN;

public class ControladorCadastro {

    ControladorUsuario controladorUsuario = ControladorUsuario.getInstance();

    boolean cadastrado = false;
    private int btnApertado = 0;

    private String cpfUser;

    public String getCpfUser() {
        return cpfUser;
    }

    public void setCpfUser(String cpfUser) {
        this.cpfUser = cpfUser;
    }

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
    private Label aviso;

    @FXML
    private void radioUsuarioSelecionado() {
        txtChave.setVisible(false);
        radioAdmin.setSelected(false);
    }

    @FXML
    private void radioAdminSelecionado() {
        txtChave.setVisible(true);
        rbUsuario.setSelected(false);
    }

    @FXML
    void finalizarCadastro(ActionEvent event) {
        try {

            int erros = 0;
            String cpf = txtCPF.getText().replaceAll("[^0-9]", "");
            String chave = txtChave.getText();
            String email = txtEmail.getText().trim();
            String nome = txtNome.getText();
            String senha = txtSenha.getText();
            int idade = Integer.parseInt(txtIdade.getText());

            if (cpf.length() != 11) {
                aviso.setText("Erro: o CPF deve conter 11 números.");
                aviso.setVisible(true);
                erros = erros + 1;
            }
            else{
                aviso.setVisible(false);
            }

            if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
                aviso.setVisible(true);
                aviso.setText("Erro: o email deve seguir o formato usuario@dominio.com");
                erros = erros + 1;
            }

            if(senha.length() < 8)
            {
                aviso.setVisible(true);
                aviso.setText("Erro: o senha deve ter no mínimo 8 digitos.");
                erros = erros + 1;
            }

            if(erros == 0) {
                ControladorUsuario.getInstance().cadastrarUsuario(nome, cpf, idade, email, senha);
                Usuario usuario = ControladorUsuario.getInstance().buscarUsuario(cpf);

                aviso.setTextFill(GREEN);
                aviso.setVisible(true);
                aviso.setText("Cadastrado com sucesso!" + "\n\n Nome: " + nome + "\n Idade: " + idade + "\n Email: " + email);

                cadastrado = true;

                System.out.println(usuario.getNome());
                System.out.println(usuario.getIdade());
                System.out.println(usuario.getEmail());
                System.out.println(usuario.getSenha());

                ControladorUsuario.getInstance().setUsuarioLogado(usuario);

                botaoLogin.setText("Avançar");
                btnApertado = btnApertado + 1;

                if(btnApertado == 2) {
                    Stage stage = (Stage) txtNome.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/ufrpe/aluguelcarros/HomePage.fxml"));
                    Parent root = loader.load();
                    Scene novaCena = new Scene(root);
                    stage.setScene(novaCena);
                    stage.show();
                    cpfUser = cpf;
                }
            }

        } catch (NumberFormatException e) {
            aviso.setText("Erro: a idade deve ser preenchida com números.");
            aviso.setVisible(true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    String getCPF(){
        return txtCPF.getText();
    }


    public Button getBotaoLogin() {
        return botaoLogin;
    }

    public void setBotaoLogin(Button botaoLogin) {
        this.botaoLogin = botaoLogin;
    }
}
