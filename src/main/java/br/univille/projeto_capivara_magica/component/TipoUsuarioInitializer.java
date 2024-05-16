package br.univille.projeto_capivara_magica.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.univille.projeto_capivara_magica.entity.Tipo_Usuario;
import br.univille.projeto_capivara_magica.repository.TipoUsuarioRepository;

@Component
@Order(1)
public class TipoUsuarioInitializer implements CommandLineRunner{

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    @Override
    public void run(String... args) throws Exception{

        if(tipoUsuarioRepository.count() == 0){
            Tipo_Usuario tipoUsuario = new Tipo_Usuario();
            tipoUsuario.setNome("Administrador");
            tipoUsuarioRepository.save(tipoUsuario);

            Tipo_Usuario tipoUsuario2 = new Tipo_Usuario();
            tipoUsuario2.setNome("Cliente");
            tipoUsuarioRepository.save(tipoUsuario2);

            Tipo_Usuario tipoUsuario3 = new Tipo_Usuario();
            tipoUsuario3.setNome("Funcionario");
            tipoUsuarioRepository.save(tipoUsuario3);
        }

    }
    
}
