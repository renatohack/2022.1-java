package com.example.projeto.model.service;

import com.example.projeto.model.domain.Plantao;
import com.example.projeto.model.domain.Usuario;
import com.example.projeto.model.repository.IPlantaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlantaoService {

    @Autowired
    private IPlantaoRepository plantaoRepository;

    public void salvarPlantao(Plantao plantao) {
        plantaoRepository.save(plantao);
    }

    public List<Plantao> consultarPlantoesPorIdUsuario(int id) {
        List<Plantao> plantoes = plantaoRepository.consultarPlantoesPorIdUsuario(id);
        return plantoes;
    }

    public Plantao consultaPlantaoPorId(int id){

        if (plantaoRepository.findById(id).isPresent()){
            return plantaoRepository.findById(id).get();
        }
        else {
            return null;
        }
    }

    public void excluirPlantao(Plantao plantao) {
        plantaoRepository.delete(plantao);
    }

    public List<Plantao> consultarPlantoes() {
        return (List<Plantao>) plantaoRepository.findAll();
    }


    public List<Plantao> consultarPlantoesOutrosUsuarios(int idUsuarioModel) {

        return plantaoRepository.consultarPlantoesOutrosUsuarios(idUsuarioModel);

    }

    public List<Plantao> consultarPlantoesNaoTenhoInteresse(Usuario usuarioBanco){

        List<Plantao> plantoesTotais = plantaoRepository.consultarPlantoesOutrosUsuarios(usuarioBanco.getIdUsuario());

        List<Plantao> plantoesJaTenhoInteresse = usuarioBanco.getPlantoesInteresse();

        for (Plantao plantao : plantoesJaTenhoInteresse) {
            plantoesTotais.remove(plantao);
        }

        return plantoesTotais;
    }

}
