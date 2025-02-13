package br.ufrpe.aluguelCarros.negocio.beans;
import java.time.LocalDateTime;

public class Aluguel {

    private int idAluguel;
    private int idCarroAluguel;
    private double taxaAluguel;
    private double preco;
    boolean statusPagamento;
    private LocalDateTime dataAtual = LocalDateTime.now();
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private String cpfAluguel;



    public Aluguel(int idCarroAluguel, String cpfAluguel, LocalDateTime dataInicio, LocalDateTime dataFim, double preco, double taxaAluguel) {
        this.idCarroAluguel = idCarroAluguel;
        this.cpfAluguel = cpfAluguel;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.preco = preco;
        this.statusPagamento = false;
        this.taxaAluguel = taxaAluguel;
    }

    public double getTaxaAluguel() {
        return taxaAluguel;
    }

    public void setTaxaAluguel(double taxaAluguel) {
        this.taxaAluguel = taxaAluguel;
    }

    public int getIdCarroAluguel() {
        return idCarroAluguel;
    }

    public void setIdCarroAluguel(int idCarroAluguel) {
        this.idCarroAluguel = idCarroAluguel;
    }

    public String getCpfAluguel() {
        return cpfAluguel;
    }

    public void setCpfAluguel(String cpfAluguel) {
        this.cpfAluguel = cpfAluguel;
    }

    public int getIdAluguel() {
        return idAluguel;
    }

    public void setIdAluguel(int idAluguel) {
        this.idAluguel = idAluguel;
    }

    public LocalDateTime getDataAtual() {
        return dataAtual;
    }

    public void setDataAtual(LocalDateTime dataAtual) {
        this.dataAtual = dataAtual;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean isStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(boolean statusPagamento) {
        this.statusPagamento = statusPagamento;
    }
}
