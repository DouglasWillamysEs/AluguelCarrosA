package br.ufrpe.aluguelCarros.negocio.beans;


public class Carro {
    private String modelo;
    private String marca;
    private String cor;
    private double preco;
    private boolean disponivel;
    private int id;

    public Carro (int id, String cor, String marca, String modelo, double preco, boolean disponivel) {
        this.cor = cor;
        this.marca = marca;
        this.modelo = modelo;
        this.preco = preco;
        this.disponivel = disponivel;
        this.id = id;
    }

    //Getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void mostrarDetalhes() {
        System.out.println("Modelo: " + modelo);
        System.out.println("Marca: " + marca);
        System.out.println("Cor: " + cor);
        System.out.println("Preço: " + preco);
        System.out.println("Disponibilidade: " + disponivel);

    }



}



