package br.ufrpe.aluguelcarros.GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.time.LocalDate;

import static javafx.scene.paint.Color.GREEN;

public class ControladorPagamento {

    @FXML
    private Button btnConfirmar;

    @FXML
    private RadioButton radioCredito;

    @FXML
    private RadioButton radioDebito;

    @FXML
    private TextField txtCVV;

    @FXML
    private TextField txtNumeroCartao;

    @FXML
    private TextField txtVencimento;

    @FXML
    private Label txtAviso;

    @FXML
    void confirmarSelecionado(ActionEvent event) {

        String numeroCartao = txtNumeroCartao.getText().replaceAll("[^0-9]", "");
        String vencimento = txtVencimento.getText().replaceAll("[^0-9/]", "");
        String cVV = txtCVV.getText().replaceAll("[^0-9]", "");
        LocalDate dataAtual = LocalDate.now();
        int erros = 0;

        int anoAtual = dataAtual.getYear() % 100; // Pegando apenas os dois últimos dígitos do ano

        //Verificação do cartão
        if(numeroCartao.length() >= 13 && numeroCartao.length() <= 16 ) {

            if(vencimento.length() == 5) {
                int mesVencimento = Integer.parseInt(vencimento.substring(0, 2));
                int anoVencimento = Integer.parseInt(vencimento.substring(3, 5));

                if (vencimento.matches("\\d{2}/\\d{2}") ) {

                    if (anoVencimento > anoAtual || (anoVencimento == anoAtual && mesVencimento >= dataAtual.getMonthValue()))
                {
                    if(cVV != null && cVV.length() == 3){
                    txtAviso.setTextFill(GREEN);
                    txtAviso.setVisible(true);
                    txtAviso.setText("Cartão verificado!");
         }

                    else{
                        txtAviso.setVisible(true);
                        txtAviso.setText("Erro: o CVV deve ter 3 dígitos numéricos");
                    }
                }
                    else{
                        txtAviso.setVisible(true);
                        txtAviso.setText("Erro: cartão está vencido");
                    }
                }
            }
            else {
                txtAviso.setVisible(true);
                txtAviso.setText("Erro: o vencimento deve estar no formato MM/AA");
            }
        }
        else{
            txtAviso.setVisible(true);
            txtAviso.setText("Erro: o número deve ter 13-16 dígitos numéricos");
            erros++;
        }
        //Fim da verificação

    }

    @FXML
    void radioCreditoSelecionado(ActionEvent event) {
        radioDebito.setSelected(false);
    }

    @FXML
    void radioDebitoSelecionado(ActionEvent event) {
        radioDebito.setSelected(true);
        radioCredito.setSelected(false);
    }

}
