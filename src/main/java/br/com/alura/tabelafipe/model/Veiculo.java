package br.com.alura.tabelafipe.model;

import java.time.LocalDate;

public class Veiculo {
    private Integer tipoVeiculo;
    private Double valor;
    private String marca;
    private String modelo;
    private LocalDate anoModelo;
    private String combustivel;
    private String codigoFipe;
    private String mesReferencia;
    private char siglaCombustivel;

    public Veiculo() {
    }

    public Veiculo(Integer tipoVeiculo, Double valor, String marca, String modelo, LocalDate anoModelo, String combustivel, String codigoFipe, String mesReferencia, char siglaCombustivel) {
        this.tipoVeiculo = tipoVeiculo;
        this.valor = valor;
        this.marca = marca;
        this.modelo = modelo;
        this.anoModelo = anoModelo;
        this.combustivel = combustivel;
        this.codigoFipe = codigoFipe;
        this.mesReferencia = mesReferencia;
        this.siglaCombustivel = siglaCombustivel;
    }

    public Integer getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(Integer tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
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

    public LocalDate getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(LocalDate anoModelo) {
        this.anoModelo = anoModelo;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public String getCodigoFipe() {
        return codigoFipe;
    }

    public void setCodigoFipe(String codigoFipe) {
        this.codigoFipe = codigoFipe;
    }

    public String getMesReferencia() {
        return mesReferencia;
    }

    public void setMesReferencia(String mesReferencia) {
        this.mesReferencia = mesReferencia;
    }

    public char getSiglaCombustivel() {
        return siglaCombustivel;
    }

    public void setSiglaCombustivel(char siglaCombustivel) {
        this.siglaCombustivel = siglaCombustivel;
    }

    @Override
    public String toString() {
        return "tipoVeiculo=" + tipoVeiculo +
                ", valor=" + valor +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anoModelo=" + anoModelo +
                ", combustivel='" + combustivel + '\'' +
                ", codigoFipe='" + codigoFipe + '\'' +
                ", mesReferencia='" + mesReferencia + '\'' +
                ", siglaCombustivel=" + siglaCombustivel +
                '}';
    }
}
