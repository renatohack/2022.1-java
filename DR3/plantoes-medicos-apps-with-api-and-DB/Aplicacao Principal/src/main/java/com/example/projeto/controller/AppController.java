package com.example.projeto.controller;

import com.example.projeto.model.domain.Perfil;
import com.example.projeto.model.domain.Usuario;
import com.example.projeto.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes({"user", "msgSucesso", "msgErro"})
@Controller
public class AppController {

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping("/")
    public String telaInicial(){
        return "/aplicacao/index";
    }

    @RequestMapping("/login")
    public String telaLogin(){
        return "/aplicacao/login";
    }

    @RequestMapping("/validate_login")
    public String validarLogin(ModelMap model, @RequestParam String email, @RequestParam String senha) {

        Usuario usuario = null;

        if (usuarioService.emailExisteNoBanco(email)){
            usuario = usuarioService.autenticacao(email, senha);
        }
        else{
            model.addAttribute("mensagemErro", "O email ainda não é cadastrado.");
            return "/aplicacao/login";
        }

        if (usuario != null) {
            model.put("user", usuario);
            String mensagemSucesso = "Bem vindo, " + usuario.getPerfil().getNome() + "!";
            model.put("msgSucesso", mensagemSucesso);
            return "redirect:/usuario/autenticado/mainPage";
        }
        else {
            model.addAttribute("mensagemErro", "Usuário/senha inválidos.");
            return "/aplicacao/login";
        }
    }

    /*@RequestMapping("/cadastrarUsuario")
    public String telaCadastro(Model model){
        return "redirect:/usuario/cadastrar/cadastroUsuario";
    }*/

    @RequestMapping("/logout")
    public String telaLogout(){
        return "redirect:/";
    }



}
