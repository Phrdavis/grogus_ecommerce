package br.univille.projeto_capivara_magica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.projeto_capivara_magica.entity.Tipo_Produto;

@Repository
public interface TipoProdutoRepository 
                extends JpaRepository<Tipo_Produto, Integer>{
    
}
