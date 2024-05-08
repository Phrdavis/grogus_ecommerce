package br.univille.projeto_capivara_magica.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.projeto_capivara_magica.entity.Avaliacao_Produto;
import br.univille.projeto_capivara_magica.entity.Produto;
import br.univille.projeto_capivara_magica.service.AvaliacaoProdutoService;

@RestController
@RequestMapping("api/v1/avaliacoes")
public class AvaliacaoProdutoController {
    
    private AvaliacaoProdutoService avaliacaoProdutoService;

    public AvaliacaoProdutoController(AvaliacaoProdutoService avaliacaoProdutoService) {
        this.avaliacaoProdutoService = avaliacaoProdutoService;
    }

    @GetMapping
    public List<Avaliacao_Produto> getAvaliacoes(){

        return avaliacaoProdutoService.getAvaliacoes();

    }
    
    public record NewAvaliacao(

        String comentario,
        Produto produto,
        float nota

    ){}

    @PostMapping
    public void addAvaliacao(@RequestBody NewAvaliacao newAvaliacao){

        Avaliacao_Produto avaliacao = new Avaliacao_Produto();
        avaliacao.setComentario(newAvaliacao.comentario);
        avaliacao.setProduto(newAvaliacao.produto);
        avaliacao.setNota(newAvaliacao.nota);

        avaliacaoProdutoService.addAvaliacao(avaliacao);

    }
}
