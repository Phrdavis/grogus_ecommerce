package br.univille.projeto_capivara_magica.component;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.univille.projeto_capivara_magica.entity.Tipo_Usuario;
import br.univille.projeto_capivara_magica.entity.Usuario;
import br.univille.projeto_capivara_magica.repository.TipoUsuarioRepository;
import br.univille.projeto_capivara_magica.repository.UsuarioRepository;

@Component
@Order(5)
public class UsuarioInitializer implements CommandLineRunner{

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void run(String... args) throws Exception{

        if(usuarioRepository.count() == 0){

            Tipo_Usuario admin = tipoUsuarioRepository.findByNome("Administrador");

            Usuario usuario = new Usuario();
            usuario.setNome("Admin");
            usuario.setDataNascimento(LocalDate.parse("2000-01-01"));
            usuario.setCpf("12345678900");
            usuario.setEmail("admin@hotmail.com");
            usuario.setTelefone("47999999999");
            usuario.setSenha("Admin123@");
            usuario.setAtivo(true);
            usuario.setTipo(admin);
            usuarioRepository.save(usuario);
        }

    }
    
}
