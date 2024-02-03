package com.example.projeto.model.repository;

import com.example.projeto.model.domain.Plantao;
import com.example.projeto.model.domain.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPlantaoRepository extends CrudRepository<Plantao, Integer> {

    @Query(value = "SELECT p FROM Plantao p WHERE p.usuarioDono.idUsuario=:id")
    List<Plantao> consultarPlantoesPorIdUsuario(int id);

    @Query(value = "SELECT p FROM Plantao p WHERE p.usuarioDono.idUsuario<>:id")
    List<Plantao> consultarPlantoesOutrosUsuarios(int id);


}
