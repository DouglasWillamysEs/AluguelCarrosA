package br.ufrpe.aluguelcarros.GUI;

import br.ufrpe.aluguelcarros.negocio.ControladorCarro;
import br.ufrpe.aluguelcarros.negocio.beans.Carro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.DragEvent;



import java.util.ArrayList;

public class ControladorBusca {

    private ControladorCarro controladorCarro = ControladorCarro.getInstance();

    @FXML
    private ChoiceBox<String> cbHatchbacks; // Define o tipo de dados correto

    @FXML
    public void initialize() {
        carregarHatchbacks();
    }

    private void carregarHatchbacks() {
        ArrayList<String> hatchbacks = new ArrayList<>();
            ControladorCarro.getInstance().procurarModelo("hatchback");

        ObservableList<String> opcoes = FXCollections.observableArrayList(hatchbacks);
        cbHatchbacks.setItems(opcoes);
    }

    @FXML
    void hatchbacksSelecionado(DragEvent event) {

    }


}
