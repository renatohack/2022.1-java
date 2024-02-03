package com.example.projeto.model.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int idUsuario;
    private String email;
    private String senha;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_perfil")
    private Perfil perfil;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuarioDono")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Plantao> plantoesVenda;

/*    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.DETACH})
    @JoinTable(
            name = "usuariosInteressados_plantoesVenda",
            joinColumns = @JoinColumn(name = "id_usuariosInteressados"), inverseJoinColumns = @JoinColumn(name =
            "id_plantoesVenda")
    )
    private List<Plantao> plantoesInteresse;*/

    @ManyToMany(mappedBy = "usuariosInteressados")
    private List<Plantao> plantoesInteresse;


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

    public Perfil getPerfil() {
        return perfil;
    }

    @JsonIgnore
    public List<Plantao> getPlantoesVenda() {
        return plantoesVenda;
    }

    @JsonIgnore
    public List<Plantao> getPlantoesInteresse() {
        return plantoesInteresse;
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

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public void setPlantoesVenda(List<Plantao> plantoesVenda) {
        this.plantoesVenda = plantoesVenda;
    }

    public void setPlantoesInteresse(List<Plantao> plantoesInteresse) {
        this.plantoesInteresse = plantoesInteresse;
    }


    //OVERRIDE
    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", perfil=" + perfil +
                ", plantoesVenda=" + plantoesVenda +
                ", plantoesInteresse=" + plantoesInteresse +
                '}';
    }
}
