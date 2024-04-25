package br.univille.projeto_capivara_magica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.univille.projeto_capivara_magica.entity.Usuario;
import br.univille.projeto_capivara_magica.repository.UsuarioRepository;

@Service
public class UsuarioService {
    
    private UsuarioRepository usuarioRepository;
    
    @Autowired 
    private BCryptPasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> getUsuarios(){

        return usuarioRepository.findAll();

    }

    // public boolean autentication(String email, String password){

    //     Usuario usuario = usuarioRepository.findByEmail(email);
        
    //     if(usuario != null){

    //         return passwordEncoder.matches(password, usuario.getSenha());

    //     }


    // }

    public void addUsuario(Usuario usuario){

        usuarioRepository.save(usuario);

    }

}
