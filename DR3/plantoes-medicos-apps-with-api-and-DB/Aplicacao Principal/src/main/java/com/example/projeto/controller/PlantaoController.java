package com.example.projeto.controller;

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
public class PlantaoController {


    @Autowired
    UsuarioService usuarioService;
    @Autowired
    PlantaoService plantaoService;

    //CADASTRO DE PLANTÃO
    @RequestMapping("/usuario/autenticado/telaCadastroPlantao")
    public String telaCadastroPlantao() {
        return "/usuario/autenticado/telaCadastroPlantao";
    }

    @RequestMapping("/usuario/autenticado/cadastrarPlantao")
    public String cadastrarPlantao(ModelMap model,
                                   @ModelAttribute("user") Usuario usuarioModel,
                                   Plantao plantao) {

        int idUsuarioModel = usuarioModel.getIdUsuario();
        Usuario usuarioBanco = usuarioService.findUserById(idUsuarioModel);

        if (usuarioBanco != null) {
            usuarioService.adicionarPlantaoVenda(usuarioBanco, plantao);
            model.put("msgSucesso", "Plantão cadastrado com sucesso!");
        }
        else {
            model.put("msgErro", "Erro ao incluir plantão. UserID não encontrada.");
        }

        return "redirect:/usuario/autenticado/telaMeusPlantoesCadastrados";
    }

    //CONSULTA DE MEUS PLANTOES
    @RequestMapping("/usuario/autenticado/telaMeusPlantoesCadastrados")
    public String consultarMeusPlantoesCadastrados(Model model,
                                                   @ModelAttribute("user") Usuario usuarioModel) {
        int idUsuarioModel = usuarioModel.getIdUsuario();
        Usuario usuarioBanco = usuarioService.findUserById(idUsuarioModel);

        List<Plantao> listaPlantoes = new ArrayList<>();

        if (usuarioBanco != null) {
            int idUsuarioBanco = usuarioBanco.getIdUsuario();
            listaPlantoes = plantaoService.consultarPlantoesPorIdUsuario(idUsuarioBanco);
        }

        model.addAttribute("listaPlantoes", listaPlantoes);

        return "/usuario/autenticado/telaMeusPlantoesCadastrados";
    }

    //EXCLUSÃO DE PLANTÃO
    @RequestMapping("/usuario/autenticado/excluirMeuPlantao")
    public String excluir(ModelMap model, @RequestParam int idPlantao,
                          @ModelAttribute("user") Usuario usuarioModel) {

        Plantao plantao = plantaoService.consultaPlantaoPorId(idPlantao);
        int idUsuarioModel = usuarioModel.getIdUsuario();
        Usuario usuarioBanco = usuarioService.findUserById(idUsuarioModel);

        if (plantao != null && usuarioBanco != null) {
            usuarioBanco.getPlantoesVenda().remove(plantao);
            usuarioService.salvarUsuarioNoBanco(usuarioBanco);
            plantaoService.excluirPlantao(plantao);
            model.put("msgSucesso", "Plantão excluído com sucesso!");
        }

        return "redirect:/usuario/autenticado/telaMeusPlantoesCadastrados";
    }

    //ALTERAR PLANTAO
    @RequestMapping("/usuario/autenticado/telaAlterarMeuPlantao")
    public String telaAlterarPlantao(ModelMap model, @RequestParam int idPlantao) {

        Plantao plantao = plantaoService.consultaPlantaoPorId(idPlantao);
        if (plantao != null) {
            model.addAttribute(plantao);
            return "/usuario/autenticado/telaAlterarMeuPlantao";
        }
        else {
            model.put("msgErro", "Erro ao incluir plantão. UserID não encontrada.");
            return "redirect:/usuario/autenticado/meusPlantoesCadastrados";
        }

    }

    @RequestMapping("/usuario/autenticado/salvarAlteracaoPlantao")
    public String alterarPlantao(ModelMap model,
                                 @ModelAttribute("user") Usuario usuarioModel,
                                 Plantao plantaoNovo,
                                 @RequestParam int idPlantao) {

        Plantao plantaoAntigo = plantaoService.consultaPlantaoPorId(idPlantao);

        plantaoNovo.setUsuarioDono(plantaoAntigo.getUsuarioDono());
        plantaoNovo.setUsuariosInteressados(plantaoAntigo.getUsuariosInteressados());

        plantaoService.salvarPlantao(plantaoNovo);
        model.put("msgSucesso", "Plantão alterado com sucesso!");

        return "redirect:/usuario/autenticado/telaMeusPlantoesCadastrados";
    }


    //TELA COMPRAR PLANTAO
    @RequestMapping("/usuario/autenticado/telaComprarPlantao")
    public String telaComprarPlantao(Model model,
                                     @ModelAttribute("user") Usuario usuarioModel){

        int idUsuarioModel = usuarioModel.getIdUsuario();
        Usuario usuarioBanco = usuarioService.findUserById(idUsuarioModel);
        List<Plantao> plantoes = plantaoService.consultarPlantoesNaoTenhoInteresse(usuarioBanco);
        model.addAttribute("listaPlantoes", plantoes);

        return "/usuario/autenticado/telaComprarPlantao";
    }

    @RequestMapping("/usuario/autenticado/seInteressarPorPlantao")
    public String seInteressarPlantao(ModelMap model,
                                      @ModelAttribute("user") Usuario usuarioModel,
                                      @RequestParam int idPlantao){

        Plantao plantao = plantaoService.consultaPlantaoPorId(idPlantao);
        int idUsuarioModel = usuarioModel.getIdUsuario();
        Usuario usuarioBanco = usuarioService.findUserById(idUsuarioModel);

        plantao.getUsuariosInteressados().add(usuarioBanco);
        plantaoService.salvarPlantao(plantao);

        model.put("msgSucesso", "Plantão de interesse adicionado com sucesso!");
        return "redirect:/usuario/autenticado/telaComprarPlantao";
    }


    //TELA MEUS PLANOS INTERESSE
    @RequestMapping("/usuario/autenticado/telaMeusPlantoesInteresse")
    public String telaMeusPlantoesInteresse(ModelMap model,
                                            @ModelAttribute("user") Usuario usuarioModel){

        int idUsuarioModel = usuarioModel.getIdUsuario();
        Usuario usuarioBanco = usuarioService.findUserById(idUsuarioModel);
        List<Plantao> plantoesInteresse = usuarioBanco.getPlantoesInteresse();

        model.addAttribute("listaPlantoes", plantoesInteresse);
        return "/usuario/autenticado/telaMeusPlantoesInteresse";
    }

    //DESINSTERESSAR DE PLANTAO
    @RequestMapping("/usuario/autenticado/desinteressarDoPlantao")
    public String desinteressarPlantao(ModelMap model,
                                       @ModelAttribute("user") Usuario usuarioModel,
                                       @RequestParam int idPlantao){

        Plantao plantao = plantaoService.consultaPlantaoPorId(idPlantao);
        int idUsuarioModel = usuarioModel.getIdUsuario();
        Usuario usuarioBanco = usuarioService.findUserById(idUsuarioModel);

        if (plantao != null && usuarioBanco != null) {
            plantao.getUsuariosInteressados().remove(usuarioBanco);
            plantaoService.salvarPlantao(plantao);

            model.put("msgSucesso", "Plantão de interesse excluído com sucesso!");
        }

        return "redirect:/usuario/autenticado/telaMeusPlantoesInteresse";
    }
}
