package br.ufrpe.aluguelcarros.negocio.beans;

import java.time.LocalDateTime;

public class Promocao {

    private String nome;
    private LocalDateTime comeco;
    private LocalDateTime terminio;
    private double taxa;
    private Boolean ativa;

    public Promocao(String nome, LocalDateTime comeco, LocalDateTime terminio, double taxa, boolean ativa) {
        this.nome = nome;
        this.comeco = comeco;
        this.terminio = terminio;
        this.taxa = taxa;
        this.ativa = false;
    }

    public Boolean getAtiva() {
        return ativa;
    }

    public void setAtiva(Boolean ativa) {
        this.ativa = ativa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



    public LocalDateTime getComeco() {
        return comeco;
    }

    public void setComeco(LocalDateTime comeco) {
        this.comeco = comeco;
    }

    public LocalDateTime getTerminio() {
        return terminio;
    }

    public void setTerminio(LocalDateTime terminio) {
        this.terminio = terminio;
    }
}
