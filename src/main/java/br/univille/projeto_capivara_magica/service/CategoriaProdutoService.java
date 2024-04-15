package br.univille.projeto_capivara_magica.service;

import org.springframework.stereotype.Service;

import br.univille.projeto_capivara_magica.entity.Categoria_Produto;
import br.univille.projeto_capivara_magica.repository.CategoriaProdutoRepository;

@Service
public class CategoriaProdutoService {

    private CategoriaProdutoRepository categoriaProdutoRepository;

    public CategoriaProdutoService(CategoriaProdutoRepository categoriaProdutoRepository) {
        this.categoriaProdutoRepository = categoriaProdutoRepository;
    }

    public void getCategoriasProduto(){

        categoriaProdutoRepository.findAll();

    }

    public void addCategoriaProduto(Categoria_Produto categoria){

        categoriaProdutoRepository.save(categoria);

    }
    
}
