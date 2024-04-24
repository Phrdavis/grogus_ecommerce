package br.univille.projeto_capivara_magica.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.univille.projeto_capivara_magica.entity.Usuario;
import br.univille.projeto_capivara_magica.entity.Tipo_Usuario;
import br.univille.projeto_capivara_magica.service.UsuarioService;


@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {
    
    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> getUsuarios(){

        return usuarioService.getUsuarios();

    }

    @GetMapping("/teste")
    public List<Usuario> getIssoAi(){

        return usuarioService.getIssoAi();

    }

    public record UsuarioModel(
        String nome,
        int idade,
        String cpf,
        String email,
        String telefone,
        String senha,
        boolean ativo,
        Tipo_Usuario tipo
    ){};


    @PostMapping
    public void addUsuario(@RequestBody UsuarioModel request){

            Usuario usuario = new Usuario();
            usuario.setNome(request.nome);
            usuario.setCpf(request.cpf);
            usuario.setEmail(request.email);
            usuario.setTelefone(request.telefone);
            usuario.setSenha(request.senha);
            usuario.setIdade(request.idade);
            usuario.setAtivo(request.ativo); 
            usuario.setTipo(request.tipo);

            
            usuarioService.addUsuario(usuario);

    }
}
