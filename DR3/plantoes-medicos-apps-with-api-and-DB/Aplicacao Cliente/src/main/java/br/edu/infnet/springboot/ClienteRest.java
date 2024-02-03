package br.edu.infnet.springboot;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClienteRest {
    
    @Autowired
    IClienteAPI clienteAPI;
    
    @GetMapping("/plantoes")
    public List<Plantao> consultaPlantoes() {
        return clienteAPI.consultaPlantoes();
    }

    @PostMapping("/cadastrarUsuario")
    public void incluir(@RequestParam String email, @RequestParam String senha) {
        clienteAPI.salvar(new Usuario(email, senha));
    }
}