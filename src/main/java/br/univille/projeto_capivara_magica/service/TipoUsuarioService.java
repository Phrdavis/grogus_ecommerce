package br.univille.projeto_capivara_magica.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.univille.projeto_capivara_magica.entity.Tipo_Usuario;
import br.univille.projeto_capivara_magica.repository.TipoUsuarioRepository;

@Service
public class TipoUsuarioService {
    
    private TipoUsuarioRepository tipoUsuarioRepository;

    public TipoUsuarioService(TipoUsuarioRepository tipoUsuarioRepository) {
        this.tipoUsuarioRepository = tipoUsuarioRepository;
    }

    public List<Tipo_Usuario> getTiposUsuario(){

        return tipoUsuarioRepository.findAll();

    }

    public Tipo_Usuario getTiposUsuarioNome(String nome){

        return tipoUsuarioRepository.findByNome(nome);

    }

    public String addTipoUsuario(Tipo_Usuario tipoUsuario){

        String tipo_nome = tipoUsuario.getNome();

        Tipo_Usuario tipo = tipoUsuarioRepository.findByNome(tipo_nome);

        if(tipo == null){

            tipoUsuarioRepository.save(tipoUsuario);
            return "Tipo de Usuario Criado com sucesso!";

        }else{
            
            throw new RuntimeException("Tipo de Usuario já cadastrado");
        }

    }

}
