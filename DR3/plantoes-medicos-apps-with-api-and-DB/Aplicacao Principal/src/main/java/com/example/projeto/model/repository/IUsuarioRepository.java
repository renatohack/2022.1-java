package com.example.projeto.model.repository;

import com.example.projeto.model.domain.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends CrudRepository<Usuario, Integer> {

    @Query(value = "from Usuario u where u.email=:email and u.senha=:senha")
    public Usuario autenticacao(String email, String senha);

    @Query(value = "from Usuario u where u.email=:email")
    public Usuario emailExisteNoBanco(String email);

}
