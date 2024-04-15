package br.univille.projeto_capivara_magica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.univille.projeto_capivara_magica.entity.Usuario;

@Repository
public interface UsuarioRepository 
                extends JpaRepository<Usuario, Integer>{

    @Query(value ="SELECT * FROM usuario WHERE TIPO_ID = 1", nativeQuery = true)
    List<Usuario> findAllByIssoAi();
    
}
