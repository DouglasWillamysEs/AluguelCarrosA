package br.ufrpe.aluguelcarros.GUI;

import br.ufrpe.aluguelcarros.negocio.ControladorCarro;
import br.ufrpe.aluguelcarros.negocio.beans.Carro;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControladorBusca implements Initializable {

    @FXML
    private ChoiceBox<String> cbMarca;

    @FXML
    private ChoiceBox<String> cbModelo;

    @FXML
    private ChoiceBox<String> txtCor;

    @FXML
    private ListView<Carro> lvListView;

    @FXML
    void cbMarca(MouseEvent event) {
    }

    @FXML
    private void onMouse(MouseEvent event) {
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ControladorCarro.getInstance().CadastrarCarroC("Azul", "Chevrolet", "Prisma", 120, true);
        ControladorCarro.getInstance().CadastrarCarroC("Amarelo", "Chevrolet", "Onix", 80, true);
        ControladorCarro.getInstance().CadastrarCarroC("Vermelho", "Fiat", "Uno", 60, true);

        cbMarca.getItems().clear();
        cbModelo.getItems().clear();
        txtCor.getItems().clear();
        lvListView.getItems().clear();

        ArrayList<String> marcas = ControladorCarro.getInstance().retornarMarcasCarros();
        ArrayList<String> modelos = ControladorCarro.getInstance().retornarModeloCarros();
        ArrayList<String> cores = ControladorCarro.getInstance().retornarCorCarros();

        cbMarca.getItems().add("Todas");
        cbMarca.getItems().addAll(marcas);
        cbModelo.getItems().add("Todos");
        cbModelo.getItems().addAll(modelos);
        txtCor.getItems().add("Todas");
        txtCor.getItems().addAll(cores);

        cbMarca.setValue("Todas");
        cbModelo.setValue("Todos");
        txtCor.setValue("Todas");

        atualizarListView();

        cbMarca.setOnAction(event -> atualizarListView());
        cbModelo.setOnAction(event -> atualizarListView());
        txtCor.setOnAction(event -> atualizarListView());

        lvListView.setOnMouseClicked(event -> {
            Carro itemSelecionado = lvListView.getSelectionModel().getSelectedItem();
            if (itemSelecionado != null) {
                tratarItemSelecionado(itemSelecionado);
            }
        });

        lvListView.setCellFactory(new Callback<>() {
            @Override
            public javafx.scene.control.ListCell<Carro> call(javafx.scene.control.ListView<Carro> param) {
                return new javafx.scene.control.ListCell<>() {
                    @Override
                    protected void updateItem(Carro item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            setText(item.getMarca() + " " + item.getModelo() + " (" + item.getCor() + ")");
                        } else {
                            setText(null);
                        }
                    }
                };
            }
        });
    }

    private void atualizarListView() {
        String marcaSelecionada = cbMarca.getValue();
        String modeloSelecionado = cbModelo.getValue();
        String corSelecionada = txtCor.getValue();

        ArrayList<Carro> todosCarros = ControladorCarro.getInstance().retornarTodosCarros(); // Obtém todos os carros
        ArrayList<Carro> carrosFiltrados = new ArrayList<>();

        for (Carro carro : todosCarros) {
            boolean marcaOk = marcaSelecionada.equals("Todas") || carro.getMarca().equals(marcaSelecionada);
            boolean modeloOk = modeloSelecionado.equals("Todos") || carro.getModelo().equals(modeloSelecionado);
            boolean corOk = corSelecionada.equals("Todas") || carro.getCor().equals(corSelecionada);

            if (marcaOk && modeloOk && corOk) {
                carrosFiltrados.add(carro);
            }
        }

        lvListView.getItems().setAll(carrosFiltrados);
    }

    private void tratarItemSelecionado(Carro carroSelecionado) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/ufrpe/aluguelcarros/AluguelAgora.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Aluguel Agora");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
