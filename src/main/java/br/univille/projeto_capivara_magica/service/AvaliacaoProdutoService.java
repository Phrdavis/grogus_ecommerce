package br.univille.projeto_capivara_magica.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.univille.projeto_capivara_magica.entity.Avaliacao_Produto;
import br.univille.projeto_capivara_magica.repository.AvaliacaoProdutoRepository;

@Service
public class AvaliacaoProdutoService {
    
    private AvaliacaoProdutoRepository avaliacaoProdutoRepository;

    public AvaliacaoProdutoService(AvaliacaoProdutoRepository avaliacaoProdutoRepository) {
        this.avaliacaoProdutoRepository = avaliacaoProdutoRepository;
    }
    
    public List<Avaliacao_Produto> getAvaliacoes(){

        return avaliacaoProdutoRepository.findAll();

    }

    public void addAvaliacao(Avaliacao_Produto avaliacao){

        avaliacaoProdutoRepository.save(avaliacao);

    }

}
