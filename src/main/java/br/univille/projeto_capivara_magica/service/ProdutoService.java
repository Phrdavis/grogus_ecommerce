package br.univille.projeto_capivara_magica.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.univille.projeto_capivara_magica.entity.Produto;
import br.univille.projeto_capivara_magica.repository.ProdutoRepository;

@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;
    
    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> getProdutos(){

        return produtoRepository.findAll();

    }

    public void addProduto(Produto produto){

        produtoRepository.save(produto);

    }
    
}
