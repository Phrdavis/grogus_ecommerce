package br.univille.projeto_capivara_magica.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.univille.projeto_capivara_magica.entity.Usuario;
import br.univille.projeto_capivara_magica.repository.UsuarioRepository;

@Service
public class UsuarioService {
    
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> getUsuarios(){

        return usuarioRepository.findAll();

    }

    public List<Usuario> getIssoAi(){

        return usuarioRepository.findAllByIssoAi();

    }

    public void addUsuario(Usuario usuario){

        usuarioRepository.save(usuario);

    }

}
