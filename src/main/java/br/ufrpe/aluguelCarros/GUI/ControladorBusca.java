package br.ufrpe.aluguelcarros.GUI;

import br.ufrpe.aluguelcarros.negocio.ControladorCarro;
import br.ufrpe.aluguelcarros.negocio.beans.Aluguel;
import br.ufrpe.aluguelcarros.negocio.beans.Carro;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class ControladorBusca {


    @FXML
    private ChoiceBox<String> cbMarca;

    @FXML
    private ChoiceBox<String> cbModelo;

    @FXML
    private CheckBox checkMaiorPreco;

    @FXML
    private CheckBox checkMenorPreco;

    @FXML
    private ChoiceBox<String> txtCor;

    @FXML
    private ListView<String> lvListView;

    @FXML
    void cbMarca(MouseEvent event) {

    }

    @FXML
    void maiorPrecoSelecionado(ActionEvent event) {
        checkMenorPreco.setSelected(false);
    }

    @FXML
    void menorPrecoSelecionado(ActionEvent event) {
        checkMaiorPreco.setSelected(false);
    }

    @FXML
    private ListView<String> listViewCarros;

    @FXML
    public void initialize() {

        ControladorCarro.getInstance().CadastrarCarroC("Azuil", "Chevrolet", "Prisma", 38, true);
        ControladorCarro.getInstance().CadastrarCarroC("Amerilo", "bom dia", "Prisma", 38, true);

        // Adicionando itens nas ChoiceBoxes
        cbMarca.getItems().addAll(ControladorCarro.getInstance().retornarMarcasCarros());
        cbModelo.getItems().addAll(ControladorCarro.getInstance().retornarModeloCarros());
        txtCor.getItems().addAll(ControladorCarro.getInstance().retornarCorCarros());

        // Definindo um valor padrão (opcional)
        cbMarca.setValue("Marca");
        cbModelo.setValue("Modelo");
        txtCor.setValue("Cor");
    }


}

