package br.univille.projeto_capivara_magica.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.projeto_capivara_magica.entity.Tipo_Usuario;
import br.univille.projeto_capivara_magica.service.TipoUsuarioService;

@RestController
@RequestMapping("api/v1/tipos_usuario")
public class TipoUsuarioController { 

    private TipoUsuarioService tipoUsuarioService;

    public TipoUsuarioController(TipoUsuarioService tipoUsuarioService) {
        this.tipoUsuarioService = tipoUsuarioService;
    }

    @GetMapping
    public List<Tipo_Usuario> getTiposUsuario() {

        return tipoUsuarioService.getTiposUsuario();

    }

    @GetMapping("/{nome}")
    public Tipo_Usuario getTiposUsuarioId(@PathVariable("nome") String nome) {

        return tipoUsuarioService.getTiposUsuarioNome(nome);

    }

    public record NewTipoUsuario(

        String nome

    ) {
    }

    @PostMapping
    public ResponseEntity<String> addTipoUsuario(@RequestBody NewTipoUsuario newTipoUsuario) {

        Tipo_Usuario tipoUsuario = new Tipo_Usuario();
        tipoUsuario.setNome(newTipoUsuario.nome);

        
        try{
            
            String respost = tipoUsuarioService.addTipoUsuario(tipoUsuario);
            return ResponseEntity.ok(respost);

        }catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.IM_USED).body(e.getMessage());
        }

    }
    
}
