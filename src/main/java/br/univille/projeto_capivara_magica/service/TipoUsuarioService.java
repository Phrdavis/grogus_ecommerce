package br.univille.projeto_capivara_magica.service;

import org.springframework.stereotype.Service;

import br.univille.projeto_capivara_magica.entity.Tipo_Usuario;
import br.univille.projeto_capivara_magica.repository.TipoUsuarioRepository;

@Service
public class TipoUsuarioService {
    
    private TipoUsuarioRepository tipoUsuarioRepository;

    public TipoUsuarioService(TipoUsuarioRepository tipoUsuarioRepository) {
        this.tipoUsuarioRepository = tipoUsuarioRepository;
    }

    public void getTiposUsuario(){

        tipoUsuarioRepository.findAll();

    }

    public void addTipoUsuario(Tipo_Usuario tipoUsuario){

        tipoUsuarioRepository.save(tipoUsuario);

    }

}
