package br.univille.projeto_capivara_magica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.projeto_capivara_magica.entity.Categoria_Produto;

@Repository
public interface CategoriaProdutoRepository 
                extends JpaRepository<Categoria_Produto, Long>{
    
    Categoria_Produto findByNome(String nome);
}
