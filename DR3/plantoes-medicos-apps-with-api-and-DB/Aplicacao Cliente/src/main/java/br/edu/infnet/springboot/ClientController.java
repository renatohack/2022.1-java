package br.edu.infnet.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ClientController {

    @Autowired
    IClienteAPI clienteAPI;

    @RequestMapping("/")
    public String telaPrincipal(Model model){

        List<Plantao> plantoes = clienteAPI.consultaPlantoes();
        model.addAttribute("listaPlantoes", plantoes);
        return "/index";
    }

}
