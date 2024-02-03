package com.example.projeto.model.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "plantoes")
public class Plantao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plantao")
    private int idPlantao;
    private int valor;
    private String local;
    private String data;
    private String horaInicio;
    private String periodo;
    private String previsaoPagamento;

    @ManyToOne
    @JoinColumn(name = "id_usuarioDono")
    private Usuario usuarioDono;

    /*    @ManyToMany(mappedBy = "plantoesInteresse")
        private List<Usuario> usuariosInteressados;*/
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.DETACH})
    @JoinTable(
            name = "usuariosInteressados_plantoesVenda",
            joinColumns = @JoinColumn(name = "id_plantoesVenda"), inverseJoinColumns = @JoinColumn(name =
            "id_usuariosInteressados")
    )
    private List<Usuario> usuariosInteressados;

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

    public Usuario getUsuarioDono() {
        return usuarioDono;
    }

    public List<Usuario> getUsuariosInteressados() {
        return usuariosInteressados;
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

    public void setUsuarioDono(Usuario usuarioDono) {
        this.usuarioDono = usuarioDono;
    }

    public void setUsuariosInteressados(List<Usuario> usuariosInteressados) {
        this.usuariosInteressados = usuariosInteressados;
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
                ", usuarioDono=" + usuarioDono +
                ", usuariosInteressados=" + usuariosInteressados +
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
        if (usuarioDono.getIdUsuario() != plantao.usuarioDono.getIdUsuario()) {
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
        result = 31 * result + usuarioDono.hashCode();
        result = 31 * result + (usuariosInteressados != null ? usuariosInteressados.hashCode() : 0);
        return result;
    }
}
