package br.univille.projeto_capivara_magica.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.univille.projeto_capivara_magica.entity.Tipo_Produto;
import br.univille.projeto_capivara_magica.repository.TipoProdutoRepository;

@Service
public class TipoProdutoService {

    private TipoProdutoRepository tipoProdutoRepository;

    public TipoProdutoService(TipoProdutoRepository tipoProdutoRepository) {
        this.tipoProdutoRepository = tipoProdutoRepository;
    }

    public List<Tipo_Produto> getTiposProduto(){

        return tipoProdutoRepository.findAll();

    }

    public String addTipoProduto(Tipo_Produto tipoProduto){

        String tipo_nome = tipoProduto.getNome();

        Tipo_Produto tipo = tipoProdutoRepository.findByNome(tipo_nome);

        if(tipo == null){

            tipoProdutoRepository.save(tipoProduto);
            return "Tipo de Produto Criado com sucesso!";

        }else{
            
            throw new RuntimeException("Tipo de Produto já cadastrado");
        }

    }
    
}
