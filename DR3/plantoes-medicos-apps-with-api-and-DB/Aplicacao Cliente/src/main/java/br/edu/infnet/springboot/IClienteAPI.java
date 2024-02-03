package br.edu.infnet.springboot;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "plantoes", url = "http://localhost:8080/")
public interface IClienteAPI {
    
    @GetMapping("/api/consultaPlantoes")
    List<Plantao> consultaPlantoes();
    
    @PostMapping("/api/incluirUsuario")
    void salvar(Usuario usuario);
}
