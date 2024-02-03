package com.example.projeto.model.service;

import com.example.projeto.model.domain.Perfil;
import com.example.projeto.model.domain.Plantao;
import com.example.projeto.model.domain.Usuario;
import com.example.projeto.model.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    public Usuario autenticacao(String email, String senha) {
        return usuarioRepository.autenticacao(email,senha);
    }

    public boolean emailExisteNoBanco(String email){
        Usuario usuario = usuarioRepository.emailExisteNoBanco(email);

        if(usuario != null){
            return true;
        }
        else{
            return false;
        }
    }

    public Usuario findUserById(int id){
        if (usuarioRepository.findById(id).isPresent()){
            return usuarioRepository.findById(id).get();
        }
        else {
            return null;
        }
    }

    public void salvarUsuarioNoBanco(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public void atualizarPerfilUsuario(Usuario usuario, Perfil perfil){
        usuario.setPerfil(perfil);
    }


    public void removerPlantao(Usuario usuario, Plantao plantao) {
        usuario.getPlantoesVenda().remove(plantao);
    }


    public void adicionarPlantaoVenda(Usuario usuarioBanco, Plantao plantao) {
            usuarioBanco.getPlantoesVenda().add(plantao);
            usuarioRepository.save(usuarioBanco);
    }

    public void removerPlantaoVenda(Usuario usuarioBanco, Plantao plantao) {
        usuarioBanco.getPlantoesVenda().remove(plantao);
        usuarioRepository.save(usuarioBanco);
    }
}
