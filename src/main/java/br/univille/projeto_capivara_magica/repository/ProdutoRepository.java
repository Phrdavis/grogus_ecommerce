package br.univille.projeto_capivara_magica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.univille.projeto_capivara_magica.entity.Produto;

@Repository
public interface ProdutoRepository 
                extends JpaRepository<Produto, Integer>{

    @Query("SELECT p, AVG(ap.nota) AS NOTA " +
    "FROM Produto p " +
    "LEFT JOIN Avaliacao_Produto ap ON p.id = ap.produto.id " +
    "GROUP BY p.id")
    List<Produto> getAllProdutosNota();
    
}
