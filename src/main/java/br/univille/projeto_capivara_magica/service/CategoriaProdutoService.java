package br.univille.projeto_capivara_magica.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.univille.projeto_capivara_magica.entity.Categoria_Produto;
import br.univille.projeto_capivara_magica.repository.CategoriaProdutoRepository;

@Service
public class CategoriaProdutoService {

    private CategoriaProdutoRepository categoriaProdutoRepository;

    public CategoriaProdutoService(CategoriaProdutoRepository categoriaProdutoRepository) {
        this.categoriaProdutoRepository = categoriaProdutoRepository;
    }

    public List<Categoria_Produto> getCategoriasProduto(){

        return categoriaProdutoRepository.findAll();

    }

    public void addCategoriaProduto(Categoria_Produto categoria){

        categoriaProdutoRepository.save(categoria);

    }
    
}
