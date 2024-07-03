package br.univille.projeto_capivara_magica.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.univille.projeto_capivara_magica.entity.Usuario;
import br.univille.projeto_capivara_magica.service.UsuarioService;

@RestController
@RequestMapping("api/v1/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @CrossOrigin
    @GetMapping
    public List<Usuario> getUsuarios() {

        return usuarioService.getUsuarios();

    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Usuario getUsuarioId(@PathVariable("id") long id) {

        return usuarioService.getUsuariosId(id);

    }

    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<String> authenticate(@RequestBody Map<String, String> credentials) {

        String email = credentials.get("email");
        String senha = credentials.get("senha");

        try {

            String token = usuarioService.authenticate(email, senha);
            return ResponseEntity.ok(token);

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }

    }

    @CrossOrigin
    @PostMapping("/cadastrar")
    public ResponseEntity<String> addUsuario(@RequestBody Usuario request) {

        try {

            String response = usuarioService.addUsuario(request);
            return ResponseEntity.ok(response);

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(e.getMessage());
        }

    }

    @CrossOrigin
    @PutMapping("/atualizar")
    public ResponseEntity<String> updateUsuario(@RequestBody Usuario request) {

        try {

            String response = usuarioService.updateUsuario(request);
            return ResponseEntity.ok(response);

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(e.getMessage());
        }

    }

}
