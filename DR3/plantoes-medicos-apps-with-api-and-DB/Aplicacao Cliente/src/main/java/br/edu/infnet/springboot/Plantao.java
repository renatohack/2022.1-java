package br.edu.infnet.springboot;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Plantao {

    @JsonProperty
    private int idPlantao;
    @JsonProperty
    private int valor;
    @JsonProperty
    private String local;
    @JsonProperty
    private String data;
    @JsonProperty
    private String horaInicio;
    @JsonProperty
    private String periodo;
    @JsonProperty
    private String previsaoPagamento;


    //CONSTRUCTOR
    public Plantao(int valor, String local, String data, String horaInicio, String periodo, String previsaoPagamento) {
        this.valor = valor;
        this.local = local;
        this.data = data;
        this.horaInicio = horaInicio;
        this.periodo = periodo;
        this.previsaoPagamento = previsaoPagamento;
    }

    public Plantao() {
    }


    //GETTERS
    public int getIdPlantao() {
        return idPlantao;
    }

    public int getValor() {
        return valor;
    }

    public String getLocal() {
        return local;
    }

    public String getData() {
        return data;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public String getPeriodo() {
        return periodo;
    }

    public String getPrevisaoPagamento() {
        return previsaoPagamento;
    }

    //SETTERS
    public void setIdPlantao(int idPlantao) {
        this.idPlantao = idPlantao;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public void setPrevisaoPagamento(String previsaoPagamento) {
        this.previsaoPagamento = previsaoPagamento;
    }


    //OVERRIDE
    @Override
    public String toString() {
        return "Plantao{" +
                "idPlantao=" + idPlantao +
                ", valor=" + valor +
                ", local='" + local + '\'' +
                ", data=" + data +
                ", horaInicio=" + horaInicio +
                ", periodo='" + periodo + '\'' +
                ", previsaoPagamento='" + previsaoPagamento + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Plantao plantao = (Plantao) o;

        if (idPlantao != plantao.idPlantao) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = idPlantao;
        result = 31 * result + valor;
        result = 31 * result + local.hashCode();
        result = 31 * result + data.hashCode();
        result = 31 * result + horaInicio.hashCode();
        result = 31 * result + periodo.hashCode();
        result = 31 * result + previsaoPagamento.hashCode();

        return result;
    }
}
