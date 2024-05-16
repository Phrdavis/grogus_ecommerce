package br.univille.projeto_capivara_magica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.projeto_capivara_magica.entity.Usuario;



@Repository
public interface UsuarioRepository 
                extends JpaRepository<Usuario, Integer>{

    Usuario findByNome(String nome);

    Usuario findByEmail(String email);

    Usuario findById(long id);

    
    
}
