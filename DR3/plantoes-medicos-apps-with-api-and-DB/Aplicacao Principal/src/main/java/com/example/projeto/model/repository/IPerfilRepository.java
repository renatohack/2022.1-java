package com.example.projeto.model.repository;

import com.example.projeto.model.domain.Perfil;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPerfilRepository extends CrudRepository<Perfil, Integer> {
}
