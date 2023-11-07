package model;

import java.util.Objects;

public class Carro {
    private String cor;
    private String marca;
    private String modelo;
    private Boolean ligado;
    private Integer velocidadeAtual;
    private Integer velocidadeMaxima;

    public Carro(String cor, String marca, String modelo) {
        this.cor = cor;
        this.marca = marca;
        this.modelo = modelo;
    }

    public Carro() {
        this.velocidadeAtual = 0;
        this.ligado = false;
        this.velocidadeMaxima = 200;
    }

    public Carro(Integer velocidadeMaxima) {
        this.velocidadeAtual = 0;
        this.ligado = false;
        this.velocidadeMaxima = velocidadeMaxima;
    }

    public void ligar() {
        this.ligado = true;
    }

    public void desligar() {
        this.ligado = false;
    }

    public void acelerar(Integer velocidade) {
        if(this.velocidadeMaxima <= velocidade + velocidadeAtual) {
            this.velocidadeAtual = this.velocidadeMaxima;
        } else {
            this.velocidadeAtual = velocidade + velocidadeAtual;
        }
    }

    public void frear(Integer velocidade) {
        if(this.velocidadeAtual-velocidade <= 0) {
            this.velocidadeAtual = 0;
        } else {
            this.velocidadeAtual = this.velocidadeAtual - velocidade;
        }
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Boolean getLigado() {
        return ligado;
    }

    public void setLigado(Boolean ligado) {
        this.ligado = ligado;
    }

    public Integer getVelocidadeAtual() {
        return velocidadeAtual;
    }

    public void setVelocidadeAtual(Integer velocidadeAtual) {
        this.velocidadeAtual = velocidadeAtual;
    }

    public Integer getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public void setVelocidadeMaxima(Integer velocidadeMaxima) {
        this.velocidadeMaxima = velocidadeMaxima;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Carro)) return false;
        Carro carro = (Carro) o;
        return Objects.equals(marca, carro.marca) && Objects.equals(modelo, carro.modelo);
    }
}
