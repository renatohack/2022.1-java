package com.example.projeto.controller;

import com.example.projeto.model.domain.Perfil;
import com.example.projeto.model.domain.Plantao;
import com.example.projeto.model.domain.Usuario;
import com.example.projeto.model.service.PlantaoService;
import com.example.projeto.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.List;

@SessionAttributes({"user", "msgSucesso", "msgErro"})
@Controller
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;
    @Autowired
    PlantaoService plantaoService;


    //CADASTRO DE USUÁRIO
    @RequestMapping("/usuario/cadastrar/cadastroUsuario")
    public String cadastrarUsuario() {
        return "/usuario/cadastrar/cadastroUsuario";
    }

    @RequestMapping("/usuario/cadastrar/cadastrar_usuario")
    public String telaCadastro(Model model, Usuario novoUsuario, Perfil perfil) {
        usuarioService.atualizarPerfilUsuario(novoUsuario, perfil);
        usuarioService.salvarUsuarioNoBanco(novoUsuario);
        model.addAttribute("novoUsuario", novoUsuario);
        return "/usuario/cadastrar/cadastroUsuarioSucesso";
    }


    //PÁGINA PRINCIPAL
    @RequestMapping("/usuario/autenticado/mainPage")
    public String mainPage(ModelMap model) {
        return "/usuario/autenticado/mainPage";
    }

}
