package com.example.projeto.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "perfis")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_perfil")
    private int idPerfil;
    private String nome;
    private String crm;
    private String nota;

    @OneToOne(mappedBy = "perfil")
    private Usuario usuario;

    //CONSTRUCTOR
    public Perfil(String nome, String crm) {
        this.nome = nome;
        this.crm = crm;
    }

    public Perfil() {
    }

    //GETTERS
    public int getIdPerfil() {
        return idPerfil;
    }

    public String getNome() {
        return nome;
    }

    public String getCrm() {
        return crm;
    }

    public String getNota() {
        return nota;
    }

    @JsonIgnore
    public Usuario getUsuario() {
        return usuario;
    }

    //SETTERS
    public void setIdPerfil(int id) {
        this.idPerfil = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    //OVERRIDE
    @Override
    public String toString() {
        return "Perfil{" +
                "idPerfil=" + idPerfil +
                ", nome='" + nome + '\'' +
                ", crm='" + crm + '\'' +
                ", nota='" + nota + '\'' +
                ", usuario=" + usuario +
                '}';
    }
}
