package com.example.projeto.controller;


import com.example.projeto.model.domain.Perfil;
import com.example.projeto.model.domain.Plantao;
import com.example.projeto.model.domain.Usuario;
import com.example.projeto.model.repository.IPlantaoRepository;
import com.example.projeto.model.repository.IUsuarioRepository;
import com.example.projeto.model.service.PlantaoService;
import com.example.projeto.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PlantaoAPIController {

    @Autowired
    PlantaoService plantaoService;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    private IPlantaoRepository plantaoRepository;


    @GetMapping("/api/consultaPlantoes")
    public List<Plantao> consultarMeusPlantoesCadastrados() {
        List<Plantao> listPlantoes = (List<Plantao>) plantaoRepository.findAll();

        return listPlantoes;
    }

    @PostMapping("/api/incluirUsuario")
    public void incluirUsuario(@RequestBody Usuario usuario){
        usuarioService.salvarUsuarioNoBanco(usuario);
    }
}
