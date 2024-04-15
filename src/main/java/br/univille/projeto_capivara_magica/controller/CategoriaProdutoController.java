package br.univille.projeto_capivara_magica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.projeto_capivara_magica.entity.Categoria_Produto;
import br.univille.projeto_capivara_magica.service.CategoriaProdutoService;

@RestController
@RequestMapping("api/v1/categorias_produto")
public class CategoriaProdutoController {

    private CategoriaProdutoService categoriaProdutoService;
    
    public CategoriaProdutoController(CategoriaProdutoService categoriaProdutoService){
        this.categoriaProdutoService = categoriaProdutoService;
    }

    @GetMapping
    public void getCategoriasProduto(){

        categoriaProdutoService.getCategoriasProduto();

    }

    public record NewCategoriaProduto(

        String nome

    ){}

    @PostMapping
    public void addCategoriaProduto(@RequestBody NewCategoriaProduto newCategoriaProduto){

        Categoria_Produto categoria = new Categoria_Produto();
        categoria.setNome(newCategoriaProduto.nome);

        categoriaProdutoService.addCategoriaProduto(categoria);

    }

}
