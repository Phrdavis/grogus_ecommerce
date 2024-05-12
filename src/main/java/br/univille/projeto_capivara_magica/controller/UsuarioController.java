package br.univille.projeto_capivara_magica.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.univille.projeto_capivara_magica.entity.Usuario;
import br.univille.projeto_capivara_magica.entity.Tipo_Usuario;
import br.univille.projeto_capivara_magica.service.UsuarioService;


@RestController
@RequestMapping("api/v1/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {
    
    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @CrossOrigin
    @GetMapping
    public List<Usuario> getUsuarios(){

        return usuarioService.getUsuarios();

    }
    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<String> authenticate(@RequestBody Map<String, String> credentials){

        String email = credentials.get("email");
        String senha = credentials.get("senha");

        try{

            String token = usuarioService.authenticate(email, senha);
            return ResponseEntity.ok(token);

        }catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
        
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


    @CrossOrigin
    @PostMapping("/cadastrar")
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
