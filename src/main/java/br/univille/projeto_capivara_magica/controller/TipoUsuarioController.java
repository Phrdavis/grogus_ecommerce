package br.univille.projeto_capivara_magica.controller;

import org.springframework.web.bind.annotation.GetMapping;
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
    public void getTiposUsuario() {

        tipoUsuarioService.getTiposUsuario();

    }

    public record NewTipoUsuario(

        String nome

    ) {
    }

    @PostMapping
    public void addTipoUsuario(@RequestBody NewTipoUsuario newTipoUsuario) {

        Tipo_Usuario tipoUsuario = new Tipo_Usuario();
        tipoUsuario.setNome(newTipoUsuario.nome);

        tipoUsuarioService.addTipoUsuario(tipoUsuario);

    }
    
}
