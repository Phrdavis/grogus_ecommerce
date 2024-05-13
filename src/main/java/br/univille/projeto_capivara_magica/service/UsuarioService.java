package br.univille.projeto_capivara_magica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projeto_capivara_magica.component.JwtUtils;
import br.univille.projeto_capivara_magica.entity.Usuario;
import br.univille.projeto_capivara_magica.repository.UsuarioRepository;

@Service
public class UsuarioService {
    
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private JwtUtils jwtUtils;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> getUsuarios(){

        return usuarioRepository.findAll();

    }

    public void addUsuario(Usuario usuario){

        usuarioRepository.save(usuario);

    }

    public String authenticate(String email, String password){

        Usuario usuario = usuarioRepository.findByEmail(email);
        long id = usuario.getId();
        
        if(usuario != null && usuario.getSenha().equals(password)){
            return jwtUtils.generateJwtToken(email, id); 
        }else{
            throw new RuntimeException("E-mail e senha informados não conferem");
        }

    }

    public String updateUsuario(Usuario usuario){

        long id = usuario.getId();
        Usuario usuarioDB = usuarioRepository.findById(id);

        if(usuarioDB != null){
            usuarioDB.setNome(usuario.getNome());
            usuarioDB.setEmail(usuario.getEmail());
            usuarioDB.setSenha(usuario.getSenha());
            usuarioDB.setTipo(usuario.getTipo());
            usuarioRepository.save(usuarioDB);
            return "Usuário atualizado com sucesso";
        }else{
            return "Usuário não encontrado";
        }

    }

}
