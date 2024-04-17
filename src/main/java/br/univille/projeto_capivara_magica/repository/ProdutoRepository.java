package br.univille.projeto_capivara_magica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.projeto_capivara_magica.entity.Produto;

@Repository
public interface ProdutoRepository 
                extends JpaRepository<Produto, Integer>{
    
}
