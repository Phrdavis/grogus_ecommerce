package br.univille.projeto_capivara_magica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.projeto_capivara_magica.entity.Fornecedor;

@Repository
public interface FornecedorRepository 
                extends JpaRepository<Fornecedor, Long>{
    
    Fornecedor findByNome(String nome);
}
