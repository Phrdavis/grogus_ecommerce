package br.univille.projeto_capivara_magica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.univille.projeto_capivara_magica.entity.Carrinho;
import br.univille.projeto_capivara_magica.entity.Produto;
import br.univille.projeto_capivara_magica.entity.Usuario;

@Repository
public interface CarrinhoRepository
        extends JpaRepository<Carrinho, Integer> {

    Carrinho findById(long id);

    List<Carrinho> findByUsuario(Usuario usuario);

    @Query("SELECT c FROM Carrinho c WHERE c.usuario = :usuario AND c.produto = :produto")
    Carrinho findByUsuarioProduto(Usuario usuario, Produto produto);

}
