package br.univille.projeto_capivara_magica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.projeto_capivara_magica.entity.Tipo_Usuario;


@Repository
public interface TipoUsuarioRepository 
                extends JpaRepository<Tipo_Usuario, Integer>{

    Tipo_Usuario findByNome(String nome);
    
}
