package br.edu.infnet.springboot;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

public class Usuario implements Serializable {

    @JsonProperty
    private int idUsuario;
    @JsonProperty
    private String email;
    @JsonProperty
    private String senha;


    //CONSTRUCTOR
    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public Usuario() {
    }

    //GETTERS
    public int getIdUsuario() {
        return idUsuario;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }


    //SETTERS
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    //OVERRIDE
    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
