package br.ufrpe.aluguelcarros.GUI;

import br.ufrpe.aluguelcarros.negocio.ControladorUsuario;
import br.ufrpe.aluguelcarros.negocio.beans.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class ControladorHomePage {

    ControladorUsuario controladorUsuario = ControladorUsuario.getInstance();

    @FXML
    private Button btnAcessarPerfil;

    @FXML
    private Button btnBusca;

    @FXML
    void acessarPerfil(ActionEvent event) throws IOException {

        Stage stage = (Stage) btnAcessarPerfil.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/ufrpe/aluguelcarros/Perfil.fxml"));
        Parent root = loader.load();
        Scene novaCena = new Scene(root);
        stage.setScene(novaCena);
        stage.show();

        ControladorPerfil controladorPerfil = (ControladorPerfil) loader.getController();
        controladorPerfil.setInfos(ControladorUsuario.getInstance().getUsuarioLogado().getNome(), ControladorUsuario.getInstance().getUsuarioLogado().getCpf(), ControladorUsuario.getInstance().getUsuarioLogado().getEmail(), ControladorUsuario.getInstance().getUsuarioLogado().getIdade());

    }

    @FXML
    void buscarCarros(ActionEvent event) throws IOException {

        Stage stage = (Stage) btnBusca.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/ufrpe/aluguelcarros/TelaBusca.fxml"));
        Parent root = loader.load();
        Scene novaCena = new Scene(root);
        stage.setScene(novaCena);
        stage.show();
    }

}
